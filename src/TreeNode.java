import java.util.ArrayList;
import java.util.List;

/**
 * Created by huseyin on 30.03.2017.
*/

public class TreeNode{
    private int data;
    private List<TreeNode> children;
    private TreeNode parent = null;

    public TreeNode()
    {
        children = new ArrayList<>(10);
    }

    public TreeNode(int data)
    {
        children = new ArrayList<>(10);
        this.data = data;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(int data) {
        TreeNode newChild = new TreeNode(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<TreeNode> children) {
        for(TreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}



