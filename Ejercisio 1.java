import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class InvertBinaryTree {
    public Node invertTree(Node root) {
        if (root == null) return null;
        
        Node tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        
        return root;
    }
}

public class ListOfDepths {
    public List<LinkedList<Node>> listOfDepths(Node root) {
        List<LinkedList<Node>> result = new ArrayList<>();
        if (root == null) return result;
        
        LinkedList<Node> current = new LinkedList<>();
        current.add(root);
        
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            
            for (Node node : parents) {
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }
            }
        }
        return result;
    }
}

public class MaximumDepth {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);

        return Math.max(depthLeft, depthRight) + 1;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthTest {

    @Test
    public void maxDepthTest() {
        MaximumDepth maxDepth = new MaximumDepth();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        assertEquals(3, maxDepth.maxDepth(root));
        root.left.left.left = new Node(8);
        assertEquals(4, maxDepth.maxDepth(root));
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
