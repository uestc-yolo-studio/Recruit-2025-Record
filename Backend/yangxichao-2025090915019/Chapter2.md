# 章节二

## 2.1 链表

### 代码1 Node类

 ```java
 package YOLO;
 
 public class Node {
     private int val;
     private Node next;
 
     public Node() {
     }
 
     public Node(int val, Node next) {
         this.val = val;
         this.next = next;
     }
 
     public int getVal() {
         return val;
     }
 
     public void setVal(int val) {
         this.val = val;
     }
 
     public Node getNext() {
         return next;
     }
 
     public void setNext(Node next) {
         this.next = next;
     }
 
 }
 
 ```

### 代码2 MyLinkList类

``` java
package YOLO;

public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
    }

    public MyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(int value){
        Node node = new Node(value,null);
        if(size == 0){
            head = node;
        } else {
            Node last = head;
            while(last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(node);
        }
        size ++ ;
    }
    public void insert(int index, int value){
        if(index < 0 || index > size){
            return ;
        }
        Node insertPlace = head;
        Node node = new Node(value,null);
        for (int i = 0; i < index; i++) {
            insertPlace = insertPlace.getNext();
        }
        node.setNext(insertPlace.getNext());
        insertPlace.setNext(node);
        size ++ ;
    }
    public int get(int index){
        if(index < 0 || index > size){
            return -1;
        }
        Node findIdx = head;
        for (int i = 0; i < index; i++) {
            findIdx = findIdx.getNext();
        }
        return findIdx.getVal();
    }
    public void remove(int index){
        if(index < 0 || index > size){
            return ;
        }
        Node removeIdx = head;
        Node recordLastTwo;
        for (int i = 0; i < index - 1; i++) {
            removeIdx = removeIdx.getNext();
        }
        removeIdx.setNext(removeIdx.getNext().getNext());
        size -- ;
    }
    public int size(){
        return size;
    }
}

```

### 代码3 测试类

```java
package YOLO;

import java.util.Scanner;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null,0);
        list.add(1);
        list.add(2);
        list.remove(1);
        list.add(5);
        list.insert(0,10);
        list.add(6);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.size());
    }
}

```

### reverse()

```java
public void reverse(){
        Node node = head;
        Node frontNode = null;
        while(node != null){
            Node nextNode = node.getNext();
            node.setNext(frontNode);
            frontNode = node;
            node = nextNode;
        }
        head = frontNode;
    }
```

###### 思路：

将每个节点的next指向它的上一个节点，由于当前节点只有只有它下一个节点的信息，所以要保存他的上一个节点。但是将next指向上一个节点后它无法找到下一个节点，所以还要保存它的下一个节点。最后将head指向reverse之前的最后一个节点即可。

### 遇到的问题

#### 1.编译不通过，提示空指针异常

#### 仔细检查发现node可能是null,此时不能在调用``node.getNext()``,所以报错，最后在每个操作之前都检查此时链表是否为空和索引index是否超过了链表大小，问题得以解决

#### 2.提示在get()方法中`findIdx`可能为空

#### 发现在reverse()中最后没有将head指向最后一个节点，此时head仍然指向reverse之前的头节点。加上`head = frontNode` 后运行成功



## 2.2 栈和队列

#### 用`LinkedList`实现栈

```java
package YOLO.MyStack;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.push(10);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.isEmpty());

    }
    public void push(int value){
        list.addLast(value);
    }
    public int pop(){
        return list.removeLast();
    }
    public int peek(){
        return list.getLast();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}

```

#### 用``LinkedList``实现队列

```java
package YOLO.MyQueue;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.peek());
        queue.enqueue(5);
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.isEmpty());

    }
    public void enqueue(int value){
        list.addLast(value);
    }
    public int dequeue(){
        return list.removeFirst();
    }
    public int peek(){
        return list.getFirst();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}

```

#### 魔法互换

- 用栈模拟队列
	- 准备两个栈，设为栈 A 和栈 B。
	- 当要向队列中添加元素（入队）时，将元素压入栈 A。
	- 当要从队列中取出元素（出队）时，如果栈 B 不为空，直接从栈 B 弹出栈顶元素；如果栈 B 为空，就将栈 A 中的所有元素依次弹出并压入栈 B，然后再从栈 B 弹出栈顶元素。
- 用队列模拟栈
	- 准备一个队列。
	- 当要向栈中添加元素（入栈）时，将元素入队。
	- 当要从栈中取出元素（出栈）时，假设队列的长度为 n，将队列中前 n - 1 个元素依次出队并重新入队，此时队列的队首元素就是原本的队尾元素（相当于栈顶元素），将这个元素出队。

#### 追本溯源

- 栈的现成实现
	- Java 中提供了`java.util.Stack`类，它继承自`Vector`类，基于动态数组实现。通过`push`方法压栈，`pop`方法弹栈，`peek`方法获取栈顶元素等。
- 队列的现成实现
	- Java 中常用的队列实现有`java.util.LinkedList`（它实现了`Queue`接口），基于链表实现；还有`java.util.concurrent`包下的`ArrayBlockingQueue`（基于数组，有界）、`LinkedBlockingQueue`（基于链表，可选有界）等。
- 异同与优劣
	- 相同点：核心功能（栈的压栈、弹栈；队列的入队、出队等）是一致的。
	- 不同点与优劣
		- Java 官方实现经过了严格的测试和优化，在线程安全（部分队列实现是线程安全的，如`ArrayBlockingQueue`）、性能、异常处理等方面更完善。例如`Stack`类虽然是线程安全的（因为继承自`Vector`，`Vector`的方法是同步的），但在单线程环境下可能性能不如自定义的非同步栈；而自定义的栈、队列可能更灵活，能根据具体需求定制，但在通用性和健壮性上不如官方实现。

## 2.3 二叉树

### 核心特点

对于每个节点最多有两个子节点

### 代码

```java
package YOLO.BinaryTree;

class TreeNode {
    int val;
    TreeNode left,right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public int getVal(){
        return val;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public TreeNode getLeft(){
        return left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public TreeNode getRight(){
        return right;
    }
}

public class BinaryTreeTraversal {

    // 构建一个样本智慧核心
    public static TreeNode buildSampleTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        return node1;
    }

    // 前序遍历(核心->左分支->右分支)
    public static void preorder(TreeNode node){
        if(node == null) return;
        System.out.print(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    // 中序遍历(左分支->核心->右分支)
    public static void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.val);
        inorder(node.right);
    }
    // 后序遍历(左分支->右分支->核心)
    public static void postorder(TreeNode node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val);
    }

    // 魔法测试
    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        System.out.print("前序探知:");
        preorder(root);// 预期输出:124536
        System.out.println();

        System.out.print("中序探知:");
        inorder(root);//预期输出:425136
        System.out.println();

        System.out.print("后序探知:");
        postorder(root);// 预期输出:452631

    }

}
```



