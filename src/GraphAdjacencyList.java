import java.util.ArrayList;
import java.util.LinkedList;

public class GraphAdjacencyList {

    private ArrayList<LinkedList<Node>> aList;
    public GraphAdjacencyList(){
        aList = new ArrayList<>();
    }

    public void addNode(Node node){
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);

        aList.add(currentList);
    }

    public void addEdge(int src, int dst) {
        if(!checkEdge(src, dst))
            aList.get(src).add(aList.get(dst).get(0));
    }

    public boolean checkEdge(int src, int dst) {
        for(Node node : aList.get(src)){
            if(node== aList.get(dst).get(0))
                return true;
        }
        return false;
    }

    public void print(){
        for(LinkedList<Node> list : aList){
            for(Node node : list){
                System.out.print(node.getData() + " -> ");
            }
            System.out.print("\n");
        }
    }
}
