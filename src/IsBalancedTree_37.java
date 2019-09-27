/**
 * 
 * @author ChopinXBP
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 */

public class IsBalancedTree_37 {

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
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(1);
		TreeNode root3 = new TreeNode(0);
		TreeNode root4 = new TreeNode(3);
		TreeNode root5 = new TreeNode(4);
		root1.left = root2;
		root2.left = root3;
		//root3.right = root4;
		root1.right = root5;
		System.out.println(IsBalanced_Solution2(root1));
	}

	
	///////////////对每个结点计算深度的方法，重复遍历了结点///////////////////////
    public static boolean IsBalanced_Solution(TreeNode root) {  
    	if(root == null) return true;
        if(Math.abs(GetDepth(root.left) - GetDepth(root.right)) > 1) return false;
        
        //return isSearchTree(root);
        return true;
    }
    
    private static int GetDepth(TreeNode root){
    	if(root == null)return 0;
    	return Math.max(GetDepth(root.left), GetDepth(root.right)) + 1;
    }
    /*
    //判断搜索树
    private static boolean isSearchTree(TreeNode root){
    	if(root == null) return true;
    	boolean rootflag = true;
    	if(root.left != null && root.val < root.left.val)rootflag = false;
    	if(root.right != null && root.val > root.right.val)rootflag = false;
    	
    	return rootflag && isSearchTree(root.left) && isSearchTree(root.right);
    }
    */
    
    ///////////////对每个结点只遍历一次，并且进行剪枝处理///////////////////////
    public static boolean IsBalanced_Solution2(TreeNode root) {  
    	if(getTreeDepth(root) == -1)return false;
        return true;
    }
    
    private static int getTreeDepth(TreeNode root){
    	if(root == null)return 0;
    	int leftdepth = getTreeDepth(root.left);
    	if(leftdepth == -1)return -1;		//剪枝处理，一旦出现不平衡，直接返回-1至初始
    	int rightdepth = getTreeDepth(root.right);
    	if(rightdepth == -1)return -1;
    	
    	if(Math.abs(leftdepth - rightdepth) <= 1){
    		return Math.max(leftdepth, rightdepth) + 1;
    	}else{
    		return  -1;		//-1代表不平衡
    	}
    }
}
