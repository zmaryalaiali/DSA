package doublycicularlinnedlist;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.createNode(5);
        list.insert(1, 6);
        list.insert(9, 9);
        list.insert(9, 11);
        list.insert(9, 12);
        list.print();

        list.deleteAll();
        list.print();

    }
}
