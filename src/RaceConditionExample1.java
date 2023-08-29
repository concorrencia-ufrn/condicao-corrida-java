import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class RaceConditionExample1 {

    public static void main(String[] args) {


        List<Thread> threads = new ArrayList<Thread>();

        List<Integer> elements = new ArrayList<Integer>();

        long beginTime = System.currentTimeMillis();


        for (int i = 0; i < 100; i++ ){

            CollectionThread thread = new CollectionThread(i,elements,false);
            thread.start();
            threads.add(thread);
        }


        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        for(Integer n:elements){
            System.out.println(n);
        }


        long endTime = System.currentTimeMillis();

      //  System.out.println("Execution Time = "+ (endTime-beginTime) +" ms");




    }
}
