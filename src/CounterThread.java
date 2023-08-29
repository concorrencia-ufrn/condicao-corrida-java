public class CounterThread extends Thread{

    private boolean exclusive;
    private Counter c;
    private int id;

    public CounterThread(int id, Counter c,boolean exclusive){
        this.c = c;
        this.id = id;
        this.exclusive = exclusive;
    }

    public void run(){

        long number = -1;

        for(int i=0; i<10000;i++) {
            try {
                if (exclusive){

                    number = c.getNextExclusive();
                }
                else{
                    number = c.getNext();
                }

                System.out.println(id + ";" + number);
                sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}


