package doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinekedList list = new DoublyLinekedList();
        list.createNode(5);
        list.insertValue(4, 8);
        list.insertValue(5, 1);
        list.insertValue(6, 1);


        list.printAll();

       list.removeDups();

        list.printAll();
    }

}
