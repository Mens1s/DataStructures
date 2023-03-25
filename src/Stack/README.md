<h1>What is a Stack?</h1>
<p>A stack is a one-ended linear data structure which models a real world stack by having
two primary operations, namely push and pop.</p>
<h3 style="color : darkred">Last in first out! </h3>

<h3>When and where is a Stack used? </h3>
<li>Used by undo mechanisms in text editors.</li>
<li>Used in compiler syntax checking for matching brackets and braces.</li>
<li>Can be used to model a pile of books or plates.</li>
<li>Used behind the scenes to support recursion by keeping track of previous function calls.</li>
<li>Can be used to do a Depth First Search (DFS) on a graph.</li>

<ul>Complexity:
    <li>Pushing O(1)</li>
    <li>Popping O(1)</li>
    <li>Peeking O(1)</li>
    <li>Searching O(n)</li>
    <li>Size O(1)</li>
</ul>

<h2> What is DFS [ Depth First Search ] </h2>

<p>
Depth-first search is an algorithm for traversing or searching tree or graph data structures.
The algorithm starts at the root node (selecting some arbitrary node as the root node in the
case of a graph) and explores as far as possible along each branch before backtracking. 
</p>

<p>
So the basic idea is to start from the root or any arbitrary node and mark the node and move to the adjacent unmarked node and continue this loop until there is no unmarked adjacent node. Then backtrack and check for other unmarked nodes and traverse them. Finally, print the nodes in the path.
</p>
    
    class Graph {
    private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];
 
    // Constructor
    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
 
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
 
    // Driver's Code
    public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        // Function call
        g.DFS(2);
    }
}