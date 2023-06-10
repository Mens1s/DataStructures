package MidTermWorks.Union.PriorityQueue;

import java.util.*;

public class PQueue <T extends Comparable<T> > {
    // the number of elements currently inside the heap
    private int heapSize = 0;
    //yhe internal capacity of the heap
    private int heapCapacity = 0;
    // a dynamic list to track the elements inside the heap
    private List<T> heap = null;
    // this map keeps track of the possible indices a particular node value is found in the heap.
    // having this mapping lets us have O ( log (n) ) removals and  O(1) element containment check at the cost of some additional space and minor overhead
    private Map<T, TreeSet<Integer> > map = new HashMap<>();
    // construct and initially empty priority queue
    public PQueue() {
        this(1);
    }
    // construct a priority queue with an initial capacity
    public PQueue(int size) {
        heap = new ArrayList<>(size);
    }
    public PQueue (T[] elems) {
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<>( heapCapacity );

        // place all element in heap
        for( int i = 0; i < heapSize ; i++) {
            mapAdd(elems[i], i);
            heap.add(elems[i]);
        }

        // heapify process, O(n)
        for (int i = Math.max(0, (heapSize/2)-1); i >= 0; i--) sink(i);
    }
    // priority queue construction, O(n log (n) )
    public PQueue (Collection<T> elems) {
        this(elems.size());
        for( T elem : elems ) add(elem);
    }
    // returns is empty
    public boolean isEmpty(){
        return heapSize == 0;
    }
    // clears everything inside the heap, O(n)
    public void clear() {
        for (int i = 0; i < heapCapacity; i++)
            heap.set(i, null);
        heapSize = 0;
        map.clear();
    }
    // return size of the heap
    public int size(){
        return heapSize;
    }
    // returns the value of the element with the lowest priority queue. If the priority queue
    // is empty null is returned
    public T peek(){
        if (isEmpty()) return null;
        return heap.get(0);
    }
    // removes the root of the heap, O( log (n) )
    public T poll(){
        return removeAt(0);
    }
    // test if an element is in heap, O(1)
    public boolean contains(T elem) {
        if (elem == null) return false;
        return map.containsKey(elem);
    }
    // adds an element to the priority queue, the element must not be null, O( log(n) )
    public void add(T elem) {
        if ( elem == null) throw new IllegalArgumentException();
        if (heapSize < heapCapacity ) heap.set(heapSize, elem);
        else {
            heap.add(elem);
            heapCapacity++;
        }

        mapAdd(elem, heapSize);

        swim(heapSize);
        heapSize++;
    }
    // Tests if the value of node i < = node j
    // this method assumes i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    // bottom up node swim, O( log ( N ) )
    private void swim(int k) {
        // grab the index of the next parent node WRT to k
        int parent = (k-1) / 2;

        // keep swimming while we have not reached the
        // root and while we are less than our parent.

        while(k > 0 && less(k, parent)){
            // exchange k with parent
            swap(parent, k );
            k = parent;
            // grab the index of the next parent node WRT to k
            parent = (k-1) / 2;
        }
    }

    // top down node sink, O( log(n) )
    private void sink(int k){
        while( true ) {
            int left = 2 * k + 1; // left node
            int right = 2 * k + 2; // right node
            int smallest = left; // assume left is the smallest node of the two children

            // find which is smaller left or right
            // if right is smaller set smallest to be right
            if (right < heapSize && less(right, left) ) smallest = right;

            //  stop if we are outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(k, smallest)) break;

            // move down the tree following the smallest node
            swap(smallest, k);
            k = smallest;
        }
    }
    // swap two nodes O(1)
    private void swap(int i, int j) {
        T j_elem = heap.get(j);
        T i_elem = heap.get(i);

        heap.set(i, j_elem);
        heap.set(j, i_elem);

        mapSwap(i_elem, j_elem, i, j);
    }
    // removes a particular element in the heap, O( log(n) )
    public boolean remove(T elem) {
        if(elem == null) return false;
        Integer index = mapGet(elem);
        if(index != null) removeAt(index);
        return index != null;
    }
    // removes a node at particular index, O( log (n) )
    private T removeAt(int i) {
        if (isEmpty()) return null;

        heapSize--;
        T removed_data = heap.get(i);
        swap(i, heapSize);

        // obliterate the value
        heap.set(heapSize, null);
        mapRemove(removed_data, heapSize);

        // removed last element
        if (i == heapSize) return removed_data;

        T elem = heap.get(i);

        // try sinking element
        sink(i);

        // if sinking did not work try swimming
        if( heap.get(i).equals(elem) ) swim(i);

        return removed_data;
    }

    // recursively checks if this heap is a min heap
    // this method is just for testing purposes to make sure the heap invariant is still being maintained.
    // Called this method with k=0 to start at the root
    public boolean isMinHeap(int k) {
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if ( left < heapSize && !less(k, left) ) return false;
        if( right < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }
    // add a node value and its index to the map
    private void mapAdd(T value, int index) {
        TreeSet <Integer> set = map.get(value);
        // new value bing inserted in map
        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
        }else set.add(index);
    }
    // removes the index at a given value, O( log(n) )
    private void mapRemove(T value, int index) {
        TreeSet <Integer> set = map.get(value);
        set.remove(index);
        if(set.size() == 0) map.remove(value);
    }
    // extract an index pos for the given value
    private Integer mapGet(T value) {
        TreeSet< Integer > set = map.get(value);
        if (set != null) return set.last();
        return null;
    }
    // exchange the index of two nodes internally within the map
    private void mapSwap(T val1, T val2, int val1Idx, int val2Idx) {
        Set <Integer> set1 = map.get(val1);
        Set <Integer> set2 = map.get(val2);

        set1.remove(val1Idx);
        set2.remove(val2Idx);

        set1.add(val2Idx);
        set2.add(val1Idx);
    }
}
