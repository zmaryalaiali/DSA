package singleLinkedList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        LinkedList list = new LinkedList();
//        list.insert(1,0);
//        list.insert(2,1);
//        list.insert(3,2);
//        list.insert(4,0);
//        list.insert(5,4);
//        System.out.println(list.size);
//        list.traversing();

        long startTime = System.currentTimeMillis();
        long pauseTime = 15000;
        sleepMilli(1000);
        sleepMilli(pauseTime);
        System.out.println((System.currentTimeMillis()-pauseTime)-startTime);


    }

    private static void sleepMilli(long l){
        try {
            Thread.sleep(l);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
