package singleLinkedList;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public LinkedList() {
        this.head = new Node();
    }

    public void insert(int value, int location) {
        Node node = new Node();
        node.value = value;
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            size++;
            return;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;

        }  else {
            Node tempNode = head;
            int tempValue = 0;
            while (tempValue < location -1){
                tempNode = tempNode.next;
                tempValue ++;
            }
            Node newNode = tempNode.next;
            tempNode.next = node;
            node.next = newNode;
        }
        size++;}

    // traversing singlyLinkedList
    public void traversing(){
        if (size == 0){
            System.out.println("nothing to print");
        }
        else {
        Node tempNode = head;
        while (tempNode.next != null){
            System.out.print(tempNode.value);
                System.out.print("->");  // this is legacy way to print
            tempNode = tempNode.next;
        }
            System.out.println(tempNode.value);

            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                System.out.print("->");// this is  good way to print
                tempNode = tempNode.next;
            }
        }
    }
    }
