package MidTermWorks.Union.LinkedLists;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoublyLinkedList <T> implements Iterable<T> {

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;


    private class Node <T> {
        T data;
        Node <T> prev, next;
        public Node(T data, Node <T> prev, Node <T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override public String toString(){
            return data.toString();
        }
    }
    // empty this linked list, O(n)
    public void clear() {
        /*
        Node temp = new Node();
        while(this.head != null) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
        */
        Node <T> trav = head;
        while(trav != null) {
            Node <T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }
    // return the size of this linked list
    public int size() {
        return size;
    }
    // is this linked list empty?
    public boolean isEmpty(){
        return size == 0;
    }
    // add an element to the tail of the linked list, O(1)
    public void add(T elem){
        addLast(elem);
    }
    // add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem ,null, null);
        }else{
            head = head.prev = new Node<T>(elem, null, head);
            // head = head.prev
        }
        ++size;
    }
    // add a node to the tail of the linked list, O(1)
    public void addLast(T elem){
        if(isEmpty()) addFirst(elem);
        else tail = tail.next = new Node<>(elem, tail, null);
        ++size;
    }
    // check the value of the first node if it exists, O(1)
    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }
    // check the value of the last node if it exists, O(1)
    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }
    // remove the first value at the head of the linked list, O(1)
    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");

        // extract data
        T data = head.data;
        head = head.next;

        --size;

        if(isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }
    // remove the last value at the tail of the linked list, O(1)
    public T removeLast() {

        if(isEmpty()) throw new RuntimeException("Empty List");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if(isEmpty()) head = null;
        else tail.next = null;

        return data;
    }
    // removed an arbitrary node from the linked list, O(1)
    private T remove(Node <T> node){
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        // clean memory
        node.data = null;
        node = node.prev = node.next = null;

        --size;
        return data;
    }
    // remove a node at a particular index, O(n)
    public T removeAt(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Node<T> trav;

        if(index < size / 2)
            for(i = 0, trav = head; i != index; i++)
                trav = trav.next;
        else
            for(i = size - 1, trav = tail; i != index; i--)
                trav = trav.prev;

        return remove(trav);
    }
    // remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        Node <T> trav = head;

        if(obj == null){
            for(trav = head; trav != null; trav = trav.next) {
                if (trav.data == null ) {
                    remove(trav);
                    return true;
                }
            }
        }else{
            for(trav = head; trav != null; trav = trav.next) {
                if ( obj.equals(trav.data) ) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }
    // find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node <T> trav = head;

        if(obj == null)
            for(; trav != null; trav = trav.next, index++)
                if (trav.data == null )
                    return index;
        else
            for(; trav != null; trav = trav.next, index++)
                if ( obj.equals(trav.data) )
                    return index;
        return -1;
    }
    // check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;
            @Override public boolean hasNext(){
                return trav != null;
            }
            @Override public T next(){
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
