package com.example.demo.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.example.demo.designPatterns.monitor.User;
import com.example.demo.rabbitmq.Produce;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangkg
 * @Date 2021/6/25 15:20
 */
@Component
public class CanalClient {

    public static void main(String[] args) throws JsonProcessingException {
        EntityUser user = new EntityUser();
        user.setName("22");
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(user);
        System.out.println("输出"+result);
    }



    @Autowired
    private Produce produce;

    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    @Test
    public void sendMq() throws JsonProcessingException {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("111", "111");
        produce.sendMessage2(stringStringHashMap);
    }

    @PostConstruct
    public void readBinlog() {
        executor.submit(new PositionAddConsumer(produce));
    }

    @Slf4j
    @AllArgsConstructor
    static class PositionAddConsumer implements Runnable {

        private Produce produce;

        @Override
        public void run() {
            doRead(produce);
        }
    }

    public static void doRead(Produce produce) {
        // 创建链接
        String ip = AddressUtils.getHostIp();
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(ip,
                11111), "example", "", "");
        int batchSize = 1000;
        int emptyCount = 0;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            int totalEntryCount = 1200;
            while (emptyCount < totalEntryCount) {
                Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                System.out.println("===获取的数据：" + message.toString());
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    emptyCount++;
                    System.out.println("empty count : " + emptyCount);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    emptyCount = 0;
                    List<CanalEntry.Entry> entries = message.getEntries();

                    printEntry(entries,produce);
                }
                connector.ack(batchId); // 提交确认
            }
            System.out.println("empty too many times, exit");
        } catch (Exception e) {
            //connector.rollback(batchId); // 处理失败, 回滚数据
        } finally {
            System.out.println("===注销===");
            connector.disconnect();
        }
    }


    private static void printEntry(List<CanalEntry.Entry> entrys,Produce produce) throws JsonProcessingException {
        for (CanalEntry.Entry entry : entrys) {
            produce.sendMessage1(entry);
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
            }

            CanalEntry.EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));
            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                System.out.println("打印数据：" + rowData.toString());
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    System.out.println("-------> before");
                    printColumn(rowData.getBeforeColumnsList());
                    System.out.println("-------> after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private static void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }


}
