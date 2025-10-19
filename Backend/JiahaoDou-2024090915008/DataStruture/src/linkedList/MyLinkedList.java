package linkedList;

public class MyLinkedList {
    public Node head;
    public int size;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
        } else {
            //尾插法
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > this.size) {
            System.out.println("index out of range");
            return;
        }
        Node node = new Node(value);
        if (index == 0) {
            //不管是索引为0的位置有无节点，均可采用头插的逻辑
            node.next = head;
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = node;
            node.next = temp;
        }
        this.size++;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("index out of range");
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("index out of range");
            return;
        }
        if (index == 0 && this.size ==1) {
            head = null;
        } else{
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        this.size--;
    }

    public int size(){
        return this.size;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }
        //三指针法
        Node pre = null;
        Node current = head;
        Node next = null;
        while (current != null){
            next = current.next; //暂存下一个节点，防止丢失

            current.next = pre;//反转当前两节点

            //更新pre和current
            pre = current;
            current = next;
        }
            head=pre;
    }

}
