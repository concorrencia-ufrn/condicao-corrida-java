public class Counter {

    protected long count = 0;

    public long getNext(){
        return count++;
    }

    public synchronized long getNextExclusive(){
        return count++;
    }

}

