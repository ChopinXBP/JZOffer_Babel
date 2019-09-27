/**
 * 
 * @author ChopinXBP
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 */

public class IsSymmetrical_57 {

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

	public static boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)return true;
        return Solution(pRoot.left, pRoot.right);
    }

	public static boolean Solution(TreeNode pleft, TreeNode pright) {
		if(pleft == null && pright == null)return true;
		if(pleft == null ^ pright == null)return false;
		return pleft.val == pright.val && Solution(pleft.right, pright.left) && Solution(pleft.left, pright.right);
	}
}
