/**
 * 
 * @author ChopinXBP 
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *  
 *
 */
public class MirrorBintree_17 {

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
		TreeNode root = new TreeNode(0);
		root = Init(root);
		PreResearch(root);
		System.out.println('\n');
		Solution(root);
		PreResearch(root);
	}
	
	public static TreeNode Init(TreeNode root){		
		TreeNode pNode = root;
		pNode.left = new TreeNode(1);
		pNode.right = new TreeNode(2);
		pNode = root.left;
		pNode.left = new TreeNode(3);
		pNode.right = new TreeNode(4);
		pNode = root.right;
		pNode.left = new TreeNode(5);
		pNode.right = new TreeNode(6);
		pNode = root.left.left;
		pNode.left = new TreeNode(7);
		pNode.right = new TreeNode(8);
		pNode = root.right.left;
		pNode.left = new TreeNode(9);
		return root;
	}
	
	public static void PreResearch(TreeNode root){
		if(root != null){
			System.out.print(root.val);
			PreResearch(root.left);
			PreResearch(root.right);
		}	
	}

	
	public static void Solution(TreeNode root){
		if(root != null){
			TreeNode pNode = root;
			//进行交换
			TreeNode tmp = pNode.left;
			pNode.left = pNode.right;
			pNode.right = tmp;
			
			Solution(pNode.left);
			Solution(pNode.right);
		}
	}
}
