package circularlinkedlist;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList  = new CircularLinkedList();
        circularLinkedList.createCircularLinkedList(5);
        circularLinkedList.insert(0,4);
        circularLinkedList.insert(1,6);
        circularLinkedList.insert(1,6);
        circularLinkedList.insert(1,6);

        circularLinkedList.printAll();

        circularLinkedList.delete(5);

        System.out.println();
        circularLinkedList.printAll();
        circularLinkedList.deleteAll();
        circularLinkedList.printAll();




    }
}
