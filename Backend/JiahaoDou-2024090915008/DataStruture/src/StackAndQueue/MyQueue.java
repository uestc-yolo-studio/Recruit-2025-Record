package StackAndQueue;

import java.util.LinkedList;

public class MyQueue {
    public LinkedList<Integer> list;

    public MyQueue() {
        this.list = new LinkedList<>();
    }

    public void enqueue(int value) {
        list.add(value);
    }

    public int dequeue() {
        //与栈正好相反，先进先出，所以此时队头是first指向的元素
        return list.removeFirst();
    }

    public int peek() {
        //只查看，不弹出
        return list.getFirst();
    }

    public boolean isEmpty() {
        //链表为空即队列为空
        return list.isEmpty();
    }
}
