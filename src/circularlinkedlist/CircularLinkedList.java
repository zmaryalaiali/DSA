package circularlinkedlist;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;

    public Node createCircularLinkedList(int value) {
        Node node = new Node();
        node.value = value;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int index, int value) {

        Node node = new Node();
        node.value = value;

        if (index == 0) {
            node.next = head;
            head = node;
            tail.next = head;
            size++;
            System.out.println("value inserted in if value of "+value);
        } else if (index >= size) {
            tail.next = node;
            node.next = head;
            tail = node;
            tail.next = head;
            size++;
            System.out.println("value inserted in else if value of "+value);

        }
        else {
            Node tempNode = head;
            int tempIndex = 0;

            while (tempIndex < index - 1) {
                tempNode = tempNode.next;
                tempIndex++;
            }

            node.next = tempNode.next;
            tempNode.next = node;
            size++;

            System.out.println("value inserted in else value of " + value);
        }

    }

    public void printAll(){
        if (head != null){
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                tempNode = tempNode.next;
                if (i != size - 1){
                    System.out.print("->");
                }
            }
            return;
        }
        System.out.println("No cicular linked List exists ");

    }

    public boolean search(int value){
        if (head != null){
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (value == tempNode.value){
                    System.out.println(tempNode.value);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node Not found  ");
        return false;

    }

    public void delete (int location ){
        if (location == 0){
            head = head.next;
            tail = head;
            size--;
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head){
                head = tail = null;
                size--;
            }
            tempNode.next = head;
            tail.next = tempNode;
            size--;
        }
        else{
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteAll(){
        if (head != null){
            head = tail = null;
            size = 0 ;
        }
    }
}
