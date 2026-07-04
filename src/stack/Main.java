package stack;

public class Main {
    public static void main(String[] args) {
        var stack = new StackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.delete();



    }
}
