import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionThread extends Thread {

    private boolean exclusive;
    private List<Integer> elements;
    private int id;


    public CollectionThread(int id, List<Integer> elements, boolean exclusive) {
        this.id = id;
        this.exclusive = exclusive;
        this.elements = elements;

    }

    public void run() {
        for (int i = 0; i < 30000; i++) {
            try {

                if (exclusive) {
                    addElementExclusive(i);
                } else {
                    addElement(i);

                }

                //sleep(1);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    private void addElementExclusive(int i) {

        synchronized (elements) {
            addElement(i);
        }
    }
    private void addElement(int i) {

        if (!elements.contains(i)) {
            elements.add( i);
        }

    }
}



