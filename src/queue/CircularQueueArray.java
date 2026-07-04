package queue;

public class CircularQueueArray {
    private int[] array ;
    private int topOf;
    private   int beginning;

    public CircularQueueArray(int size){
        this.array = new int[size];
        this.beginning = -1;
        this.topOf = -1;
    }

    public boolean isEmpty(){
        return topOf == -1 || array == null ;
    }
    public boolean isFull(){
        return (topOf == array.length -1 && beginning == 0) || (topOf +1 == beginning);
    }

    public void enqueue(int value){
        if (isFull()){
            System.out.println("the queue is full ");
        } else if (isEmpty()) {
            beginning = 0 ;
            array[++topOf] = value;
        }
        else{
            if (topOf == array.length - 1){
                topOf = 0;
            }
            else
                topOf++;
            array[topOf] = value;
        }

    }

    public int dequeue(){
        if (isEmpty()){
            return  -1;
        }
        else {
            var result  = array[beginning];
            array[beginning] = 0;
            if (beginning == topOf){
                beginning = topOf = -1;
            } else if (beginning+1 == array.length) {
                beginning = 0;
            }
            else {
                beginning++;
            }
            return result;
        }
    }

    public int peek(){
        if (isEmpty()){
            return  -1;
        }
        return array[beginning];
    }

    public void  delete (){
        array = null;
    }
}
