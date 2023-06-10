import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("This repo contains data structures with FreeCodeCamp for mid term, bro code for final.");

        // Stack
        // LAST IN FIRST OUT

        // uses of stacks:
        // 1. undo/redo features in text editors
        // 2. back/forward features in web browsers
        // 3. moving b ack/forward through navigation history
        // 4. backtracking algorithms
        // 5. call stack (function calls)

        Stack<String> stack = new Stack<>();

        stack.push("bottom");
        stack.push("middle");
        stack.push("top");

        stack.pop();
        // System.out.println(stack.empty());

        // System.out.println(stack.peek()); // it looks the last element
        // System.out.println(stack.size());

        // System.out.println(stack.pop()); // it removes and returns the last element
        // System.out.println(stack.size());

        // System.out.println(stack.search("middle")); // 1
        // System.out.println(stack.search("top"));    // -1

        /* **************** */
        // Queue
        // FIRST IN FIRST OUT
        // A collection designed for holding elements prior to processing Linear data structure

        // add = enqueue = offer
        // remove = dequeue = poll

        // 1. Keyboard buffer
        // 2. Printer queue
        // 3. Used in Linkedlist, PriorityQueue, BFS and Binary Search Tree
        Queue<String> queue = new LinkedList<>(); // queue class is abstract class

        queue.offer("bottom");
        queue.offer("middle");
        queue.offer("top");

        // System.out.println(queue);

        // System.out.println(queue.peek()); // it looks the first element
        // System.out.println(queue.size());

        // System.out.println(queue.poll()); // it removes and returns the first element
        // System.out.println(queue.size());

        // Priority Queue = A FIFO data structure that serves elements with the highest priorities first before elements with lower priority

        Queue<Double> queuee = new PriorityQueue<>(Collections.reverseOrder());

        queuee.offer(3.0);
        queuee.offer(2.5);
        queuee.offer(4.0);
        queuee.offer(1.5);
        queuee.offer(2.0);

        // while(!queuee.isEmpty())
           // System.out.println(queuee.poll()); // 1.5-2-2.5-3-4 when Collections.reverseOrder() it reverses

        // LinkedList
        // Stores nodes i 2 parts (data + address)
        // Nodes are in non-consecutive memory locations. Elements are linked using pointers

        // Advantages
        // Dynamic Data Structure (allocates needed memory at runtime)
        // Insertion and Deletion of elements (no index [i])
        // No/Low memory wastage

        // Disadvantages
        // Greater memory usage (extra pointer)
        // No random access of elements
        // Accessing/Searching elements is more time-consuming. O(n)

        // Uses
        // Implementation of Stacks and Queues
        // GPS Navigation
        // Music Player


        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("F");

        linkedList.add(4,"E");

        // System.out.println(linkedList);

        // Dynamic Array
        // Stores elements in consecutive memory locations
        // Elements can be accessed using indices
        // my own class :D

        DynamicArray dynamicArray = new DynamicArray();

        //System.out.println(dynamicArray);

        dynamicArray.add("s");
        //System.out.println(dynamicArray);

        // Linear Search O(n) : Iterate through a collection one element at a time
        // Disadvantages
        // Slow for large data sets

        // Advantages
        // Fast for searches of small to medium data sets
        // Does not need to sorted
        // Useful for data structures that do not have random access (LinkedList)

        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int index = linearSearch(array, 1);
        //System.out.println(index);

        // Binary Search : O(log n) : Divide and conquer

        int[] binArray = new int[100];
        int target = 42;

        for(int i = 0; i < binArray.length; i++) binArray[i] = i;

        int binIndex = binarySearch(binArray, target);
        System.out.println(binIndex);

        // interpolation search : O(log log n) : Divide and conquer
        // improvement over binary search best used fo "uniformly" distributed data sets where a value might be based on calculated probe results. if probe is incorrect,
        // search are is narrowed, and a new probe is calculated
        // average case: O(log(log(n)))
        // worst case: O(n)

        int [] interArray = {1,2,3,4,5,6,7,8,9,4000,10000};
        int interIndex = interpolationSearch(interArray, 4000);
        System.out.println(interIndex);

        // Bubble Sort O(n^2) : Compare adjacent elements and swap them if they are out of order
        int[] bubArray = {12,11,10,9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(bubArray);
        System.out.println(Arrays.toString(bubArray));

        // Selection Sort : O(n^2) : Find the smallest element using a linear scan and move it to the front (swapping it with the front element).
        // Then, find the second smallest and move it, again doing a linear scan. Continue doing this until all the elements are in place

        int[] selectArray = {8, 2, 4, 1, 3, 5, 7, 6};

        selectionSort(selectArray);
        System.out.println(Arrays.toString(selectArray));

        // Insertion Sort : O(n^2) : Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.

        int[] insertArray = {8, 2, 4, 1, 3, 5, 7, 6};
        insertSort(insertArray);
        System.out.println(Arrays.toString(insertArray));

        // recursion vs iteration
        // recursion is a method that calls itself
        // iteration is a loop
        // recursion more readable, easier to understand, more memory, slower
        // iteration less readable, harder to understand, less memory, faster

        // Merge Sort: O(n log n) : Divide and conquer O(n) space
        // Merge sort is a divide and conquer algorithm that was invented by John von Neumann in 1945.

        int[] mergeArray = {8, 2, 4, 1, 3, 5, 7, 6};

        mergeSort(mergeArray);
        System.out.println(Arrays.toString(mergeArray));

        // Quick Sort: O(n log n) : Divide and conquer O(log n) space

        int [] quickArray = {8, 2, 4, 1, 3, 5, 7, 6};

        quickSort(quickArray ,0 ,quickArray.length - 1);
        System.out.println(Arrays.toString(quickArray));

        // Hashtable: O(1) : Hashing is a technique that is used to uniquely identify a specific object from a group of similar objects.
        // hashing : takes a key and computes an integer. In a Hashtable, we use the hash % capacity to calculate an index number

        // bucket: an indexed storage location for one or more Entries
        // can store multiple Entries in case of a collision (linked similarly a LinkedList

        // collision: hash function generates the same index for more than one key
        // less collisions: more efficiency

        // runtime complexity: Best case: O(1) : Worst case: O(n)

        Hashtable<Integer, String> table = new Hashtable<>(10);
        table.put(100, "Spongebob");
        table.put(123, "Patrick");
        table.put(321, "Sandy");
        table.put(555, "Squidward");
        table.put(777, "Gary");

        for(Integer key : table.keySet())
            System.out.println("Hashcode : "+ key.hashCode() + "\tKey : " + table.get(key) + "\tvalue : " + table.get(key));

        // Adjacency Matrix: O(1): A matrix of 0s and 1s that represents a graph, 2D Array
        // runtime complexity to check an Edge: o(1)
        // space complexity: o(v^2)

        Graph graph = new Graph(5);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.printGraph();
        System.out.println(graph.checkEdge(0,0));

        // Adjacency List: An array/list of linked lists that represents a graph
        // Each LinkedList has a unique node at the head
        // All adjacent neighbours to that node are added to that node's linked list

        // runtime complexity to check an Edge: o(v)
        // space complexity: o(v + e)

        GraphAdjacencyList graphList = new GraphAdjacencyList();

        graphList.addNode(new Node('A'));
        graphList.addNode(new Node('B'));
        graphList.addNode(new Node('C'));
        graphList.addNode(new Node('D'));
        graphList.addNode(new Node('E'));

        graphList.addEdge(0, 1);
        graphList.addEdge(1, 2);
        graphList.addEdge(1, 4);
        graphList.addEdge(2, 3);
        graphList.addEdge(2, 4);
        graphList.addEdge(4, 0);
        graphList.addEdge(4, 2);
        graphList.addEdge(4, 2);

        graphList.print();
        System.out.println(graphList.checkEdge(0,0));

        // Depth First Search: O(V + E) :
        // Traverses a graph in a depthward motion and uses a stack to remember to get the next vertex to start a search, when a dead end occurs in any iteration.
        // 1. pick a route
        // 2. Keep going until you reach a dead end or a previously visited node
        // 3. Backtrack to the last node that has an unvisited neighbour and repeat step 1 and 2 until all nodes are visited
        // graph.depthFirstSearch(1);

        // Breadth First Search: O(V + E) :
        graph.breadthFirstSearch(0);

        // Tree : a non-linear data structure where nodes are organized in a hierarchical structure
        // Binary Tree: a tree where each node has at most 2 children
        // Binary Search Tree: a binary tree where the left child is less than the parent and the right child is greater than the parent

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new BinaryNode(5));
        tree.insert(new BinaryNode(1));
        tree.insert(new BinaryNode(9));
        tree.insert(new BinaryNode(2));
        tree.insert(new BinaryNode(7));
        tree.insert(new BinaryNode(3));
        tree.insert(new BinaryNode(6));
        tree.insert(new BinaryNode(4));
        tree.insert(new BinaryNode(8));

        tree.display();

        tree.remove(4);

        tree.display();

        tree.PREORDERtraverseTree();
    }
    private static void quickSort(int [] array, int start, int end) {
        if(end <= start) return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start -1 ;

        for(int j = start; j <= end - 1; j++) {
            if(array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
    private static void mergeSort(int [] array) {
        int length = array.length;
        if(length < 2) return; // base case

        int middle = length / 2;
        int [] left = new int[middle];
        int [] right = new int[length - middle];

        int i = 0;
        int j = 0;

        for(;i < length; i++) {
            if(i < middle) left[i] = array[i];
            else right[j++] = array[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    private static void merge(int [] left, int [] right, int [] result) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, l = 0, r = 0;

        // check the conditions for merging
        while(l < leftSize && r < rightSize) {

            if(left[l] < right[r])
                result[i++] = left[l++];

            else
                result[i++] = right[r++];

        }

        while(l < leftSize)
            result[i++] = left[l++];

        while(r < rightSize)
            result[i++] = right[r++];

    }

    private static void insertSort(int [] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;

        }
    }
    private static void selectionSort(int [] array){
        for(int i = 0; i < array.length - 1;i++) {
            int minIDX = i;

            for(int j = i + 1; j < array.length; j++) {

                if(array[j] < array[minIDX])
                    minIDX = j;

            }

            int temp = array[i];
            array[i] = array[minIDX];
            array[minIDX] = temp;
        }
    }
    private static void bubbleSort(int[] bubArray) {
        for(int i = 0; i < bubArray.length - 1; i++){
            for(int j = 1; j < bubArray.length - i; j++){
                if(bubArray[j] < bubArray[j -1]){
                    int temp = bubArray[j];
                    bubArray[j] = bubArray[j - 1];
                    bubArray[j - 1] = temp;
                }
            }
        }
    }

    private static int interpolationSearch(int[] interArray, int target) {
        int high = interArray.length - 1;
        int low  = 0;
        while(target >= interArray[low] && target <= interArray[high] && low <= high){
            int probe = low + (high - low) * (target - interArray[low]) / (interArray[high] - interArray[low]);

            if(interArray[probe] == target) return probe;
            if(interArray[probe] < target) low = probe + 1;
            else high = probe - 1;
        }

        return -1;
    }

    private static int linearSearch(int[] array, int target){
        for(int i = 0; i < array.length; i++)
            if(array[i] == target) return i;
        return -1;
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        while(array[middle] != target && left <= right) {
            if(target < array[middle]) right = middle - 1;
            else left = middle + 1;
            middle = (left + right) / 2;
        }

        if(array[middle] == target) return middle;
        else return -1;
    }
}