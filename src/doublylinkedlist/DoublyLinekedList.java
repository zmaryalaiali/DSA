package doublylinkedlist;

import java.util.HashSet;

/**
 *
 */
public class DoublyLinekedList {
    Node head;
    Node tai;
    int size;

    public Node createNode(int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        node.prev = null;
        head = tai = node;
        size = 1;
        return head;
    }

    public void insertValue(int value, int location) {
        if (head != null) {
            if (location == 0) {
                Node node = new Node();
                node.value = value;
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;
                size++;
            } else if (location >= size) {
                Node node = new Node();
                node.value = value;
                node.next = null;
                node.prev = tai;
                tai.next = node;
                tai = node;
                size++;
            } else {
                Node node = new Node();
                node.value = value;
                Node tempNode = head;
                int tempIndex = 0;
                while (tempNode != null) {
                    if (tempIndex == location-1) {
                        break;
                    }
                    tempNode = tempNode.next;
                    tempIndex++;
                }
                node.next = tempNode.next;
                node.prev = tempNode;
                node.next.prev = node;
                tempNode.next = node;
                size++;
            }
        }
    }

    public void printAll(){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            tempNode = tempNode.next;
            if (i != size -1){
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public void reversePrint(){
        Node tempNode = tai;
        while (tempNode.prev != null){
            System.out.print(tempNode.value);
            tempNode = tempNode.prev;
                System.out.print("->");

        }
        System.out.print(tempNode.value);
        System.out.println();
    }

    public int search(int searchValue){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.value == searchValue){
              return  tempNode.value;
            }
            tempNode =  tempNode.next;
        }
        throw new IllegalArgumentException("not found value ");
    }

    public void deleteNode (int index){
        if (index == 1){
            if (size  == index){
                head = tai = null;
            }
            else {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        else if (index >= size){
            tai = tai.prev;
            tai.next = null;
            size--;
        }
        else{
            Node tempNode = head;
            for (int i = 0; i < index -1  ; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next.next.prev = tempNode;
            tempNode.next = tempNode.next.next;
          size--;
        }
    }

    public void deleteAll(){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = tai = null;
        size = 0;
    }

    public void removeDups() {
        if (head == null) return;

        HashSet<Integer> set = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (set.contains(current.value)) {
                // Remove current node
                Node prevNode = current.prev;
                Node nextNode = current.next;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                } else {
                    // Removing head
                    head = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                size--;
            }
            else {
                set.add(current.value);
            }

            current = current.next;
        }
    }

}
