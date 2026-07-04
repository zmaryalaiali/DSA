package stack;

import singleLinkedList.LinkedList;

public class StackLinkedList {
    LinkedList list;
    public StackLinkedList(){
        list = new LinkedList();
    }

    public boolean isEmpty(){
        return list.head == null;
    }
    public void push(int value){
        list.insert(value,0);
    }

    public int pop(){
        var result = -1;
        if (!isEmpty()){
             result = list.head.value;
             list.head = list.head.next;
             list.size--;
             return result;
        }
        return result;
    }

    public int peek(){
        return list.size != 0 ? list.head.value : -1;
    }

    public void delete (){
        list.size = 0;
        list.head = null;
    }
}
