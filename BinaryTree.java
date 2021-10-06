
public class BinaryTree<T> {
    private BinaryTreeNode<T> root; 

    public BinaryTree() {
        this.root = null; 
    }

    public void add(T element) {
        if(this.root == null) {
            this.root = new BinaryTreeNode<T>(element); 
        } else {
            
            BinaryTreeNode<T> temp_node = null; 
            Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(); // develop a queue. 
            queue.enQueue(this.root); 
            while(!queue.isEmpty()) {
                temp_node = queue.deQueue(); 
                if(temp_node.getLeft() == null) {
                    temp_node.setLeft(new BinaryTreeNode<T>(element)); 
                    break; 
                } else {
                    queue.enQueue(temp_node.getLeft()); 
                }

                if(temp_node.getRight() == null) {
                    temp_node.setRight(new BinaryTreeNode<T>(element)); 
                    break; 
                } else {
                    queue.enQueue(temp_node.getRight()); 
                }
            }
        }
    }

    public void levelOrderTraversal() {
        if(this.root == null) {
            System.out.println("Tree is empty !!!"); 
        } else {
            BinaryTreeNode<T> temp_node = null; 
            Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(); 
            queue.enQueue(this.root); // enQueue root node to queue. 
            while(!queue.isEmpty()) {
                temp_node = queue.deQueue(); 
                System.out.println(temp_node.getData()); 
                if(temp_node.getLeft() != null) {
                    queue.enQueue(temp_node.getLeft()); 
                } 
                if(temp_node.getRight() != null) {
                    queue.enQueue(temp_node.getRight()); 
                }
            }
        }
    }
    
}

class BinaryTreeNode<T> {

    private BinaryTreeNode<T> left; 
    private BinaryTreeNode<T> right; 
    private T data; 
    
    public BinaryTreeNode() {
        this.left = null; 
        this.right = null; 
    }

    public BinaryTreeNode(T ele) {
        this.data = ele; 
        this.left = null; 
        this.right = null; 
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left; 
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right; 
    }

    public BinaryTreeNode<T> getLeft() {
        return this.left; 
    }

    public BinaryTreeNode<T> getRight() {
        return this.right; 
    }

    public void setData(T data) {
        this.data = data; 
    }

    public T getData() {
        return this.data; 
    }
    
}
