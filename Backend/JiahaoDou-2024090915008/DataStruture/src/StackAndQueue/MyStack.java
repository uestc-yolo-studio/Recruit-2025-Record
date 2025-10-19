package StackAndQueue;

import java.util.LinkedList;

public class MyStack {
    public LinkedList<Integer> list;

    public MyStack() {
        this.list = new LinkedList<>();
    }


    public void push(int value) {
        list.add(value);   //java8中的LinkedList添加元素是尾插
    }

    public int pop() {
        /**
         * 由于LinkedList是双向链表，add方法是向尾部添加
         * 为了满足后进先出的特性，此时尾部的元素相当于是栈顶元素
         * 所以直接删除尾部元素，即栈顶元素
         */
        return list.removeLast();
    }

    public int peek() {
        //只查看，不弹出
        return list.getLast();
    }

    public boolean isEmpty() {
        //链表为空即栈为空
        return list.isEmpty();
    }
}
