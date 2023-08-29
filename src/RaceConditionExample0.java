import java.util.ArrayList;
import java.util.List;

public class RaceConditionExample0 {

    public static void main(String[] args) {

        Counter counter = new Counter();

        long beginTime = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 30; i++ ){

            CounterThread ct = new CounterThread(i,counter,false);
            ct.start();
            threads.add(ct);
        }



        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        long endTime = System.currentTimeMillis();

        //System.out.println("Execution Time = "+ (endTime-beginTime) +" ms");

    }
}
