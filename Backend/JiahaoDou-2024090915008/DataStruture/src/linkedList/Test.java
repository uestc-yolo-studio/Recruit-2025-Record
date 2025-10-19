package linkedList;

public class Test {
    public static void main(String[] args) {
        //创建链表
        MyLinkedList list=new MyLinkedList();

        //添加元素
        list.add(1);
        list.add(2);
        list.add(3);

        //指定索引插入元素
        list.insert(1, 4);
        System.out.println(list.get(1));

        //删除指定索引元素
        list.remove(1);
        System.out.println(list.get(1));

        //得到链表长度
        System.out.println(list.size());

        list.reverse();
        Node current = list.head;
        while (current != null) {
            System.out.print(current.value + "-->");
            current=current.next;
        }
         System.out.print("null");
    }

}
