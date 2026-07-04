package recurtion;

import java.util.Arrays;

public class Fibonannci {
    public static void main(String[] args) {

        System.out.println(decimalTOBinary(2));
        System.out.println(Arrays.toString(new int[]{5,5,6}));
    }

    public static int fibo(int n){
        if (n == 1 || n == 0 )
            return n;
        System.out.println(n);
        return fibo(n-1) + fibo(n-2);
    }

    public static int sumOfDicemal(int i){
        if (i == 0){
            return i;
        }
        return i%10 + sumOfDicemal(i/10);

    }

    public static int gcd(int a , int b){
        if ( b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static int  decimalTOBinary(int d){

        if (d == 1 || d == 0){
            return d;
        }
        return d % 2 + 10*decimalTOBinary(d/2);
    }

    public static int power(int sub,int sup){
        if (sup == 1) {
            return sub;
        }
        return sub * power(sub,sup-1);
    }

    public static int[] reverse(int arrray[]){
        for (int i = 0; i < arrray.length; i++) {
            int other = arrray[arrray.length-1-i];
            var temp = arrray[i];
            arrray[i] = arrray[other];
            arrray[other] = temp;
        }
        return arrray;
    }
}
