package doublycicularlinnedlist;

public class CircularDoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public Node createNode(int value) {
        Node node = new Node();
        node.value = value;
        node.next = node;
        node.prev = node;
        head = tail = node;
        size = 1;
        return head;

    }

    public void insert(int location, int value) {
        if (location == 1) {
            Node node = new Node();
            node.value = value;
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            head = node;
            size++;
        } else if (location >= size) {
            Node node = new Node();
            node.value = value;
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            tail = node;
            size++;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            Node node = new Node();
            node.value = value;
            node.prev = tempNode;
            node.next = tempNode.next.next;
            tempNode.next = node;
            size++;
        }
    }

    public void print() {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                tempNode = tempNode.next;
                if (i != size - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        } else {
            System.out.println("not found list");
        }
    }

    public void reverseList() {
        if (head != null) {
            Node tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                tempNode = tempNode.prev;
                if (i != size - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        } else {
            System.out.println("not found list");
        }
    }

    public int find(int index) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
        }
        throw new IllegalArgumentException("not found value");
    }

    public void delete(int index) {
        if (head != null) {
            if (index == 1) {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            } else if (index >= size) {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            } else {
                Node tempNode = head;
                for (int i = 0; i < index - 1; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next.next.prev = tempNode;
                tempNode.next = tempNode.next.next;
                size--;
            }

        }
    }


    public void deleteAll(){
        head.prev = tail.prev = null;
        head = tail = null;
        size = 0 ;
    }

}