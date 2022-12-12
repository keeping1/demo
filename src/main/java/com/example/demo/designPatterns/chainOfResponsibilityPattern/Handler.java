package com.example.demo.designPatterns.chainOfResponsibilityPattern;

/**
 * @author wangkg
 * @Date 2021/8/10 17:58
 */
public abstract class Handler<T> {
    protected Handler next;

    public void next(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);
    static class Builder<T>{
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler handler){

            if (this.head == null){
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;

            return this;
        }
        public Handler<T> build(){
            return this.head;
        }
    }
}
