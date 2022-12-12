package com.example.demo.designPatterns.observerPattern;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author wangkg
 * @Date 2021/6/5 17:09
 */
public class BellEventTest {

    private final static ExecutorService executor = new ThreadPoolExecutor(
            16,
            32,
            1L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2000), (r, executor) -> {
        try {
            executor.getQueue().put(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
  /*  public static void main(String[] args) {
        //铃（事件源）
        BellEventSource bell = new BellEventSource();
        //注册监听器（老师）
        bell.addPersonListener(new TeachEventListener());
        //注册监听器（学生）
        bell.addPersonListener(new StuEventListener());
        //打上课铃声
        bell.ring(true);
        System.out.println("------------");
        //打下课铃声
        bell.ring(false);
    }
*/

    public static void main(String[] args) {
        System.out.println("主线程开始===");
        CompletableFuture.runAsync(()->{
            System.out.println("线程1开始===");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1结束===");
        },executor);
        CompletableFuture.runAsync(()->{
            System.out.println("线程2开始===");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2结束===");
        },executor);
        CompletableFuture.runAsync(()->{
            System.out.println("线程3开始===");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3结束===");
        },executor);

        System.out.println("主线程结束===");
    }
}

/**
 * 铃声事件类：用于封装事件源及一些与事件相关的参数
 */
class RingEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    /**
     * true表示上课铃声,false表示下课铃声
     */
    private boolean sound;
    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }
    public void setSound(boolean sound) {
        this.sound = sound;
    }
    public boolean getSound() {
        return this.sound;
    }
}

/**
 * 目标类：事件源，铃
 */
class BellEventSource {
    /**
     * 监听器容器
     */
    private List<BellEventListener> listener;
    public BellEventSource() {
        listener = new ArrayList<>();
    }
    /**
     * 给事件源绑定监听器
     */
    public void addPersonListener(BellEventListener ren) {
        listener.add(ren);
    }

    /**
     * 事件触发器：敲钟，当铃声sound的值发生变化时，触发事件。
     * @param sound
     */
    public void ring(boolean sound) {
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响！");
        RingEvent event = new RingEvent(this, sound);
        //通知注册在该事件源上的所有监听器
        notifies(event);
    }

    /**
     * 当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
     * @param e
     */
    protected void notifies(RingEvent e) {
        BellEventListener ren = null;
        for (BellEventListener bellEventListener : listener) {
            ren = bellEventListener;
            ren.heardBell(e);
        }
    }
}

/**
 * 抽象观察者类：铃声事件监听器
 */
interface BellEventListener extends EventListener {
    /**
     * 事件处理方法，听到铃声
     * @param e
     */
     void heardBell(RingEvent e);
}

/**
 * 具体观察者类：老师事件监听器
 */
class TeachEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}

/**
 * 具体观察者类：学生事件监听器
 */
class StuEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}