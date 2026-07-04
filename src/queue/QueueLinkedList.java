package queue;

import singleLinkedList.LinkedList;

public class QueueLinkedList {

    LinkedList list ;
    public QueueLinkedList(){
        list = new LinkedList();
    }

    public boolean isEmpty(){
        return list.head == null;
    }
    public void enqueue(int value){
        list.insert(value,list.size);
    }

    public int dequeue(){
       if (isEmpty()){
           return -1;
       }
       var value = list.head.value;
       list.head = list.head.next;
       list.size++;
       return value;
    }

    public int peek(){
        return isEmpty()? -1 : list.head.value;
    }

    public void delete (){
        list.head = null;
    }
}
