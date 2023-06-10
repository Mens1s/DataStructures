<h1>What is a Priority Queue?</h1>
<p>
A priority queue is ana Abstract Data Type that operates similar to a normal queue except
that each element has a certain priority. The priority of the elements in the priority
queue determine the order in which elements are removed from the PQ.
</p>

<p>
Note : Priority queues only sports comparable data, meaning the data inserted into the priority
queue must be able to be ordered in some way either from least to greatest or greatest to least.
This is so that we are able to assign relative priorities to each element.
</p>

<li>poll => removes the highest priority element</li>
<li>poll rest => removes the highest priority element unless no element behind</li>

<h2> What is a Heap? </h2>
<p>A heap is a tree based DS that satisfies the heap invariant (also called heap property): </p>
<p>If A is a parent node of B then A is ordered with respect to B for all nodes A, B in the heap</p>
<p>kısacası abicim heap olmak için tree özelliklerini sağla bir de üstüne belli bir sıralama bağıntısına uy oksun!</p>

<h2>When and where is a PQ used?</h2>
<ul>
<li>Used in certain implementations of Dijikstra's Shortest Path algorithm.</li>
<li>Anytime you need the dynamically fetch the 'next best' or 'next worst' element.</li>
<li>Used in Huffman coding (which is often used for lossless data compression).</li>
<li>Best First Search (BFS) algorithm such as A* use PQs to continuously grab the next
most promising node.</li>
<li>Used by Minimum Spanning Tree (MST) algorithms.</li>
</ul>

<h3>Complexity:</h3>
<ul>
    <li>Binary Heap construction O(n)</li>
    <li>Polling O(log(n))</li>
    <li>Peeking O(1)</li>
    <li>Adding O(log(n))</li>
    <li>Naive Removing O(n)</li>
    <li>Advanced removing with help from a hash table O(log(n)) </li>
    <li>Naive contains O(n)</li>
    <li>Contains check with help of a hash table O(1)</li>
</ul>

 