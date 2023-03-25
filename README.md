<p style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:"Calibri",sans-serif;'><strong><span style="font-size:19px;line-height:107%;">Data Structure</span></strong></p>
<ul style="list-style-type: disc;">
    <li>What is Data Structure?<ol style="list-style-type: circle;">
            <li>A data structure (DS) is a way of organizing data so that it can be used effectively.</li>
        </ol>
    </li>
</ul>
<p style='margin-top:0in;margin-right:0in;margin-bottom:0in;margin-left:1.0in;line-height:107%;font-size:15px;font-family:"Calibri",sans-serif;'>&nbsp;</p>
<ul style="list-style-type: disc;">
    <li>Why?<ol style="list-style-type: circle;">
            <li>Creating fast and powerful algorithms.</li>
            <li>Manage and organize data.</li>
            <li>Code cleaner and easier to understand.</li>
        </ol>
    </li>
</ul>
<p style='margin-top:0in;margin-right:0in;margin-bottom:0in;margin-left:1.0in;line-height:107%;font-size:15px;font-family:"Calibri",sans-serif;'>&nbsp;</p>
<ul style="list-style-type: disc;">
    <li>Abstract Data Type (ADT)<ol style="list-style-type: circle;">
            <li>An ADT is an abstraction of a data structure which provides only the interface to which a data structure must adhere to.</li>
            <li>The interface does not give any specific details about how something should be implemented or in what programming language.</li>
        </ol>
    </li>
</ul>
<p style='margin-top:0in;margin-right:0in;margin-bottom:0in;margin-left:1.0in;line-height:107%;font-size:15px;font-family:"Calibri",sans-serif;'>&nbsp;</p>
<ul style="list-style-type: disc;">
    <li>Introduction to Big-O<ol style="list-style-type: circle;">
            <li>The following run in constant time : O(1)<ul style="list-style-type: square;">
                    <li><span style="color:#548235;">a := 1</span></li>
                    <li><span style="color:#548235;">b := 2</span></li>
                    <li><span style="color:#548235;">c := a + 5 * b</span></li>
                    <li><span style="color:#548235;">i := 0</span></li>
                    <li><span style="color:#548235;">while i &lt; 11 &nbsp;Do // because this is not depend on input size n</span>
                        <ul style="list-style-type: disc;">
                            <li><span style="color:#548235;">I = I + 1</span></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>The following run in linear time: O(n)<ul style="list-style-type: square;">
                    <li><span style="color:#548235;">I := 0</span></li>
                    <li><span style="color:#548235;">While I &lt; n Do</span>
                        <ul style="list-style-type: disc;">
                            <li><span style="color:#548235;">I = I + 1</span></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>The following run in quadratic time : O(N^2)<ul style="list-style-type: square;">
                    <li><span style="color:#548235;">For ( I = 0; I&lt; n ; I++)</span>
                        <ul style="list-style-type: disc;">
                            <li><span style="color:#548235;">For ( J = 0 ; j &lt; n; j++)</span>
                                <ol style="list-style-type: circle;">
                                    <li><span style="color:#548235;">Do some</span></li>
                                </ol>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ol>
    </li>
</ul>
<p style='margin-top:0in;margin-right:0in;margin-bottom:0in;margin-left:2.5in;line-height:107%;font-size:15px;font-family:"Calibri",sans-serif;'><span style="color:#548235;">&nbsp;</span></p>
<ul style="list-style-type: square;">
    <li><span style="color:#548235;">For(I = 0 ; I &lt; n ; I++)</span>
        <ul style="list-style-type: disc;">
            <li><span style="color:#548235;">For ( j = I; j &lt; n; j++)</span>
                <ol style="list-style-type: circle;">
                    <li><span style="color:#548235;">Do some</span></li>
                </ol>
            </li>
        </ul>
    </li>
</ul>
<ol style="list-style-type: circle;">
    <li>The following run in log time : O(log2(n))<ul style="list-style-type: square;">
            <li><span style="color:#548235;">Low := 0</span></li>
            <li><span style="color:#548235;">High := n &ndash; 1</span></li>
            <li><span style="color:#548235;">While low &lt;= high Do</span>
                <ul style="list-style-type: disc;">
                    <li><span style="color:#548235;">Mid := (low + high) / 2</span></li>
                    <li><span style="color:#548235;">If array[mid] == value : return mid</span></li>
                    <li><span style="color:#548235;">Else if arrat[mid] &lt; value : lo = mid + 1</span></li>
                    <li><span style="color:#548235;">Else if arry[mid] &gt; value : hi = mid &ndash; 1</span></li>
                </ul>
            </li>
        </ul>
    </li>
    <li>Example:<ul style="list-style-type: square;">
            <li><span style="color:#548235;">I := 0&nbsp;</span></li>
            <li><span style="color:#548235;">While I &lt; 3 * n Do</span>
                <ul style="list-style-type: disc;">
                    <li><span style="color:#548235;">J := 10</span></li>
                    <li><span style="color:#548235;">While j &lt;= 50 do</span>
                        <ol style="list-style-type: circle;">
                            <li><span style="color:#548235;">J = j + 1</span></li>
                        </ol>
                    </li>
                    <li><span style="color:#548235;">J = 0</span></li>
                    <li><span style="color:#548235;">While j &lt; n*n*n do</span>
                        <ol style="list-style-type: circle;">
                            <li><span style="color:#548235;">J = j + 2</span></li>
                        </ol>
                    </li>
                    <li><span style="color:#548235;">I = I + 1</span></li>
                </ul>
            </li>
            <li><span style="color:#548235;">F (n) &nbsp;= 3n * (40 + &nbsp;(n^3)/2) = 120n + &nbsp;(3 n^4 )/ 2</span></li>
            <li><span style="color:#548235;">O(f(n)) = O(n^4)</span></li>
        </ul>
    </li>
</ol>
<p style='margin-top:0in;margin-right:0in;margin-bottom:0in;margin-left:1.0in;line-height:107%;font-size:15px;font-family:"Calibri",sans-serif;'>&nbsp;</p>
<ol style="list-style-type: circle;">
    <li><strong>Finding all subsets of a set &ndash; O(2^n)</strong></li>
    <li><strong>Finding all permutations of a string &ndash; O(n!)</strong></li>
    <li><strong>Sorting using mergesort &ndash; O(n log(n) )</strong></li>
    <li><strong>Iterating over all the cells in a matrix of size n by m &ndash; O(nm)</strong></li>
</ol>
