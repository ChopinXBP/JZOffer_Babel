/**
 * 
 * @author ChopinXBP 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *  
 *
 */

public class HasBintree {
	
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
		TreeNode root1 = new TreeNode(0);
		TreeNode pNode1 = root1;
		pNode1.left = new TreeNode(8);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(8);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(9);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(2);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(5);

		
		TreeNode root2 = new TreeNode(8);
		TreeNode pNode2 = root2;
		pNode2.right = new TreeNode(9);
		pNode2 = root2.right;
		pNode2.left = new TreeNode(3);
		pNode2.right = new TreeNode(2);
		
		boolean result = Solution(root1, root2);
		System.out.println(result);
	}
	
	public static boolean Solution(TreeNode root1, TreeNode root2){
		//判断边界
		if(root1 == null || root2 == null) return false;
		//以当前结点所在子树进行匹配||以当前结点左子结点所在子树进行匹配||以当前结点右子结点所在子树进行匹配
		return isSameTree(root1, root2) || Solution(root1.left, root2) || Solution(root1.right, root2);

	}

	//判断root1在该结点对应的子树是否与root2匹配
	public static boolean isSameTree(TreeNode root1, TreeNode root2){
		if(root2 == null) return true;							//遍历到root2的边界
		else if(root1 == null && root2 != null) return false;	//遍历到root1的边界

		//当前结点&&左子树所有结点&&右子树所有结点
		if(root1.val == root2.val){
			return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
		}else{
			return false;
		}
	}
}
