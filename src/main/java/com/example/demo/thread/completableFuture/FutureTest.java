package com.example.demo.thread.completableFuture;

import org.aspectj.weaver.ast.Var;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author wangkg
 * @Date 2021/9/6 12:30
 */
public class FutureTest {


    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

    }

    public Map<String, String> queryAll(String orderCode) throws ExecutionException, InterruptedException {
        String seriaNo = UUID.randomUUID().toString();
        CompletableFuture<Map<String, String>> mapCompletableFuture = new CompletableFuture<>();
        Request request = new Request();
        request.order = orderCode;
        request.mapCompletableFuture = mapCompletableFuture;
        request.seriaNo = seriaNo;
        linkedBlockingQueue.add(request);
        return mapCompletableFuture.get();
    }



    public void init() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
                    int size = linkedBlockingQueue.size();
                    if (size == 0) {
                        return;
                    }
                    ArrayList<Request> requests = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        Request request = linkedBlockingQueue.poll();
                        requests.add(request);
                    }

                    List<Map<String, String>> map = new ArrayList<>() ;
                    for (Request request : requests) {
                        String seriaNo = request.seriaNo;
                        for (Map<String, String> stringStringMap : map) {
                            if (stringStringMap.get("seriaNo").equals(seriaNo)){
                                request.mapCompletableFuture.complete(stringStringMap);
                            }
                        }
                    }
                },
                0, 10, TimeUnit.MILLISECONDS
        );



    }
}


class Request {
    String order;
    String seriaNo;
    CompletableFuture<Map<String, String>> mapCompletableFuture;
}