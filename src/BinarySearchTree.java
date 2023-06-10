public class BinarySearchTree {
    private BinaryNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(BinaryNode node){
        root = insertHelper(root, node);
    }

    private BinaryNode insertHelper(BinaryNode root, BinaryNode node) {
        int data = node.getData();

        if(root == null) {
            root = node;
            return root;
        }
        if(data < root.getData())
            root.setLeft(insertHelper(root.getLeft(), node));
        else if(data > root.getData())
            root.setRight(insertHelper(root.getRight(), node));

        return root;
    }

    public void display(){
        displayHelper(root);
        System.out.println();
    }

    private void displayHelper(BinaryNode root) {
        if(root != null){
            displayHelper(root.getLeft());
            System.out.print(" " + root.getData());
            displayHelper(root.getRight());
        }

    }
    public boolean search(int data){
        return searchHelper(root, data);
    }
    private boolean searchHelper(BinaryNode root, int data) {
        if(root == null) return false;
        else if(root.getData() == data)return true;
        else if(data < root.getData()) return searchHelper(root.getLeft(), data);
        else return searchHelper(root.getRight(), data);
    }
    public void remove(int data) {
        if(search(data)) removeHelper(root, data);
        else System.out.println("Element not found");
    }
    private BinaryNode removeHelper(BinaryNode root, int data) {

        if(root == null) return root;
        else if(data < root.getData()) root.setLeft(removeHelper(root.getLeft(), data));
        else if(data > root.getData()) root.setRight(removeHelper(root.getRight(), data));
        else{
            if(root.getLeft() == null && root.getRight() == null) root = null;
            else if(root.getRight() != null) {
                root.setData(successor(root));
                root.setRight(removeHelper(root.getRight(), root.getData()));
            }
            else{
                root.setData(predecessor(root));
                root.setLeft(removeHelper(root.getLeft(), root.getData()));
            }
        }
        return root;
    }
    private int successor(BinaryNode root){ // find the least value below the right child of this root node
        root = root.getRight();
        while(root.getLeft() != null) root = root.getLeft();
        return root.getData();
    }

    private int predecessor(BinaryNode root){
        root = root.getLeft();
        while(root.getRight() != null) root = root.getRight();
        return root.getData();
    }

    private void INORDERtraverseTree(BinaryNode root) { // abi en sola iner sonra onun babasına çıkar sonra onun sağına gider
        if(root == null) return;
        INORDERtraverseTree(root.getLeft());
        System.out.println(root.getData());
        INORDERtraverseTree(root.getRight());
    }

    private void POSTORDERtraverseTree(BinaryNode root) { // en alt katman onun rootu şeklinde çıakr
        if(root == null) return;
        POSTORDERtraverseTree(root.getLeft());
        POSTORDERtraverseTree(root.getRight());
        System.out.println(root.getData());
    }
    public void PREORDERtraverseTree(){
        PREORDERtraverseTree(root);
    }
    private void PREORDERtraverseTree(BinaryNode root) { // en üst sol dayanklı in sonra sağ ekleye ekleye çık
        if(root == null) return;
        System.out.println(root.getData());
        PREORDERtraverseTree(root.getLeft());
        PREORDERtraverseTree(root.getRight());
    }

}
