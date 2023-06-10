public class BinaryNode {
    private int data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setLeft(BinaryNode left){
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getLeft(){
        return this.left;
    }
    public BinaryNode getRight(){
        return this.right;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
