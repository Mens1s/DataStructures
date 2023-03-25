package Array;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
@SuppressWarnings("unchecked")
public class DynamicArray <T> implements Iterable<T> {
    public static void main(String[] args) {
        DynamicArray<Integer> test = new DynamicArray<Integer>();
        test.add(10);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        Iterator<Integer> iterotor = test.iterator();

        while(iterotor.hasNext()){
            System.out.println(iterotor);
            iterotor.next();
        }
    }
    private T [] arr;
    private int len = 0;        // length user thinks array is
    private int capacity = 0;   // actual array size

    public DynamicArray(){ this(16); };
    public DynamicArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){return len;}
    public boolean isEmpty(){return size() == 0;}

    public T get(int index){return arr[index];}
    public void set(int index, T elem){ arr[index] = elem; }
    public void clear(){
        for(int i = 0; i < capacity; i++)
            arr[i] = null;
        len = 0;
    }
    public void add(T elem) {
        // time to resize!
        if( len + 1 >= capacity){
            if ( capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for(int i = 0; i < len ; i++)
                new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[len++] = elem;
    }
    public T removeAt(int rm_index){
        if(rm_index >= len || rm_index < 0) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[len-1];

        for(int i = 0, j = 0; i < len; i++, j++){
            if(i == rm_index) j--;
            else new_arr[j] = arr[i];
        }

        arr = new_arr;
        capacity = --len;
        return data;
    }
    public boolean remove(Object obj) {
        for(int i = 0; i < len; i++){
            if(arr[i].equals(obj)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }
    public int indexOf(Object obj){
        for(int i = 0; i < len ; i++)
            if(arr[i].equals(obj))
                return i;
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>(){
            int index = 0;
            public boolean hasNext() {return index < len; }
            public T next(){return arr[index++];}
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
