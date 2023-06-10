package MidTermWorks.Union.Stack;

import java.util.Iterator;

public class Stack <T> implements Iterable <T>{
    
    private java.util.LinkedList <T> list = new java.util.LinkedList<>();

    // create an empty stack
    public Stack(){}
    // create a stack with an initial element
    public Stack(T firstElem){
        push(firstElem);
    }
    // return the number of elements in the stack
    public int size() {
        return list.size();
    }
    // check if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }
    // push an element on the stack
    public void push(T e){
        list.addLast(e);
    }
    // pop an element off the stack
    public T pop(){
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.removeLast();
    }
    // peek the top of the stack without removing an element
    public T peek() {
        if( isEmpty() ) throw new java.util.EmptyStackException();
        return list.peek();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
