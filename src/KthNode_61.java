/**
 * 
 * @author ChopinXBP
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * 
 */



public class KthNode_61 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int num;
	private static TreeNode result;
	
	public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        num = 0;
        result = null;
        Solution(pRoot, k);
        
        return result;
    }
	
	public static void Solution(TreeNode pRoot, int k) {
		if(pRoot == null || num == k) {
			return;
		}
		Solution(pRoot.left, k);
		num++;
		if(num == k) {
			result = pRoot;
			return;
		}
		Solution(pRoot.right, k);
	}
}
