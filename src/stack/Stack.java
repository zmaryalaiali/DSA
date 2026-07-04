package stack;

public class Stack {
    int[] array;
    int topOfArray;
    public Stack(int size){
        this.array = new int[size];
        topOfArray = -1;
    }

    public boolean isEmpty(){
        return topOfArray == -1;
    }

    public boolean isFull(){
        return array.length-1 == topOfArray;
    }

    public void push(int value){
        if (!isFull()){
            array[topOfArray+1] = value;
            topOfArray++;
        }
        else{
            System.out.println("the Stack is full !");
        }
    }

    public int pop() {
    return isEmpty()? -1 : array[topOfArray--];
    }
    public int peek(){
        return isEmpty()? -1:array[topOfArray];
    }
    public void delete(){
        topOfArray = -1;
        array = null;
    }

}
