package array;

public class SingletDimentionArray {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(0,4);
        array.insert(1,8);
        array.insert(5,5);
        array.insert(0,4);


    }
}

class Array{
    int arra[];

    public Array(int lenght) {
        arra = new int[lenght];
        for (int i = 0; i <lenght ; i++) {
            arra[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int value){
       try {
           if (arra[location] == Integer.MIN_VALUE){
               arra[location] = value;
               System.out.println("successfully added");
           }
           else {
               System.out.println("already ocurpyde");
           }
       }catch (ArrayIndexOutOfBoundsException e){
           System.out.println("invalid index");
       }
    }
}