<h1>What is a Queue?</h1>
<p>A queue is a linear data structures which models real world queues by having
two primary operations, namely enqueue and dequeue.</p>

<p>Enqueue = add element to last = adding = offering </p>
<p>Dequeue = remove element from front = polling </p>

<h3>When and where is a Queue used? </h3>
<li>Any waiting line models a queue, for example a lineup at a movie theatre.</li>
<li>Can be used to efficiently keep track of the x most recently added elements.</li>
<li>Web server request management where you want fires come first serve.</li>
<li>Breadth first search (BFS) graph traversal.</li>

<ul>Complexity:
    <li>Pushing O(1)</li>
    <li>Popping O(1)</li>
    <li>Peeking O(1)</li>
    <li>Contains O(n)</li>
    <li>Removal O(n)</li>
    <li>is Empty O(1)</li>
</ul>

<h2> What is BFS [ Breadth First Search ] ? </h2>
    
    // Let Q be a Queue
    Q.enqueue(starting _node)
    starting_node.visited = true
    
    While Q is not empty Do
        node = Q.dequeue()
        for neigbour in neighbours(node):
            if neighbour has not been visited: 
                neighbour.visited = true
                Q.enqueue(neighbour)