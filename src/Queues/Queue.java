package Queues;

import java.util.Iterator;

public class Queue <T> implements Iterable <T> {

    private java.util.LinkedList <T> list = new java.util.LinkedList<>();

    public Queue() {}
    public Queue(T firstElem) {
        offer(firstElem);
    }
    // return size
    public int size() {
        return list.size();
    }
    // is empty or not
    public boolean isEmpty() {
        return size() != 0;
    }
    // peek the element at the front of the queue
    public T peek() {
        if ( isEmpty() ) throw new RuntimeException("Queue is empty");
        return list.peekFirst();
    }
    // poll an element from the front of the queue
    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }
    // add an element to the back of the queue
    public void offer(T elem) {
        list.addLast(elem);
    }
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
