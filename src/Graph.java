import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Node> nodes = new ArrayList<Node>();
    private int[][] matrix;

    public Graph(int size){
        matrix = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int src, int dst){
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst){
        return matrix[src][dst] == 1;
    }

    public void printGraph(){
        System.out.print("   ");
        for(Node node : nodes)
            System.out.print(node.getData()+" ");

        System.out.print("\n");

        for(int i = 0; i < matrix.length; i++){
            System.out.print(nodes.get(i).getData() + ": ");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void depthFirstSearch(int src){
        boolean[] visited = new boolean[matrix.length];
        DFSHelper(src, visited);
    }

    private void DFSHelper(int src, boolean[] visited) {

        if (visited[src])
           return;

        visited[src] = true;

        for(int i = 0; i < matrix[src].length; i++){
            if(matrix[src][i] == 1){
                System.out.println("Visited: " + nodes.get(i).getData());

                DFSHelper(i, visited);
            }
        }
    }

    public void breadthFirstSearch(int src){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        queue.offer(src);
        visited[src] = true;

        while(queue.size() != 0){
            src = queue.poll();
            System.out.println("Visited: " + nodes.get(src).getData());

            for(int i = 0; i < matrix[src].length; i++){
                if(matrix[src][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
