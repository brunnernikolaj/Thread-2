package deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lars Mortensen
 */
public class ResourceContainer {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();
    List<String> words = new ArrayList();
    final Condition wordsLocked  = lock1.newCondition();

    boolean wordsAvailable = true;
    List<Integer> numbers = new ArrayList();
    final Condition numbersLocked  = lock1.newCondition();

    public List<String> getResourceWords() {
        lock1.lock();
        try {
            
            return words;        
        } finally {
            lock1.unlock();
        }
    }

    public void releaseResourceWords(){
        lock1.unlock();
    }

    public List<Integer> getResourceNumbers() {
        lock2.lock();
        try {
            return numbers;
        } finally {
            lock2.unlock();
        }
    }

    public void releaseResourceNumbers() {
        lock2.unlock();
    }

}
