import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateBSTTest {
    
    @Test
    public void validateBstTest() {
        ValidateBST validateBst = new ValidateBST();
        
        
        Node root = new Node(4);
        root.left = new Node(5); 
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.left.left = new Node(8);
        
        assertFalse(validateBst.isValidBST(root));
        root.left.value = 2;      
        root.left.left.left = null;
        assertTrue(validateBst.isValidBST(root));
    }
}

class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
        this.value = value;
    }
}



public class ValidateBST {

    public boolean isValidBST(Node root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null) return true;
        
        
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }
        
        
        return isValidBST(node.left, min, node.value) 
            && isValidBST(node.right, node.value, max);
    }
}

public class IsSubTree {

    public boolean isSubtree(Node first, Node second) {
        if (second == null) return true;  
        if (first == null) return false;  
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        preOrder(first, sb1);
        preOrder(second, sb2);
        
        return sb1.toString().contains(sb2.toString());
    }

    private void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");  
            return;
        }
        sb.append("#").append(node.value);  
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
}

public class FirstCommonAncestor {

    class AncestorNode {
    boolean nodeFound;
    Node ancestor;
}

    public Node firstCommonAncestor(Node root, Node firstNode, Node secondNode) {
    throw new UnsupportedOperationException(message: "Not implemented yet");
}

    private AncestorNode postOrderSearch(Node root, Node firstNode, Node secondNode) {
    if (root == null) {
    return new AncestorNode();
    }

    AncestorNode leftResult = postOrderSearch(root.left, firstNode, secondNode);
    if (leftResult.ancestor != null) return leftResult;

    AncestorNode rightResult = postOrderSearch(root.right, firstNode, secondNode);
    if (rightResult.ancestor != null) return rightResult;

    AncestorNode result = new AncestorNode();

    iff(leftResult.nodeFound && rightResult.nodeFound) {
    result.ancestor = root;
    return result;
    }
}

