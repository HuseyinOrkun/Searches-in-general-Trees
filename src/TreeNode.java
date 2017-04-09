import java.util.ArrayList;
import java.util.List;

/**
 * Created by huseyin on 30.03.2017.
*/

public class TreeNode{
    private int data;
    private List<TreeNode> children;

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
        this.children.add(child);
    }

    public void addChild(int data) {
        TreeNode newChild = new TreeNode(data);
        children.add(newChild);
    }

    public void addChildren(List<TreeNode> children) {
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}



