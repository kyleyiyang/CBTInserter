/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    ArrayList<TreeNode> lst;
    public CBTInserter(TreeNode root) {
        lst = new ArrayList<TreeNode>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            lst.add(temp);
            if (temp.left!=null) q.offer(temp.left);
            if (temp.right!=null) q.offer(temp.right);
        }
    }
    public int insert(int v) {
        TreeNode temp=new TreeNode(v);
        lst.add(temp);
        TreeNode parent=lst.get(lst.size()/2-1);
        if (parent.left==null) parent.left=temp;
        else parent.right=temp;
        return parent.val;
    }
    
    public TreeNode get_root() {
        return lst.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
