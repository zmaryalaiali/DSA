package queue;

public class QueueArray {
   private int[] array ;
   private int topOf;
  private   int beginning;

    public QueueArray(int size){
        this.array = new int[size];
        this.beginning = -1;
        this.topOf = -1;
    }

    public boolean isEmpty(){
        return topOf == -1 ;
    }
    public boolean isFull(){
        return topOf == array.length -1;
    }

    public void enqueue(int value){
        if (isFull()){
            System.out.println("the queue is full ");
        } else if (isEmpty()) {
            beginning = 0 ;
            array[++topOf] = value;
        }
        else{
            array[++topOf] = value;
        }

    }

    public int dequeue(){
       if (isEmpty()){
           return  -1;
       }
      else {
          var result  = array[beginning];
          beginning++;
           if (beginning > topOf){
               beginning = topOf = -1;
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
