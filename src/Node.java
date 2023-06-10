public class Node {
    private char data;
    private boolean visited;
    public Node(char data){
        this.data = data;
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
}
