package queue;

public class ThreeInOne {

    int[] sizes;
    int [] values;
    int numberStack = 3;
    int capacity;

    public ThreeInOne(int size){
        capacity = size;
        sizes = new int[size];
        values = new int[size * numberStack];
    }


    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0 ;
    }
    public boolean isFull(int stackNum){
        return sizes[stackNum] == capacity;
    }

    public int topIndex(int stackNum){
        int stack = sizes[stackNum];
        int offset =  values[stack * stackNum];
        return  offset + stack-1;
    }


}
