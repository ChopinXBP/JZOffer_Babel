/**
 * 
 * @author ChopinXBP 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 */

import java.util.Stack;

public class Bintree2BinList_25 {
	
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
		TreeNode root = new TreeNode(5);
		Init(root);
		root = Convert(root);
		while(root.right != null){
			System.out.print(root.val);
			root = root.right;
		}
		while(root.left != null){
			System.out.print(root.val);
			root = root.left;
		}
	}
	
	public static TreeNode Init(TreeNode root){		
		TreeNode pNode = root;
		pNode.left = new TreeNode(1);
		pNode.right = new TreeNode(7);
		pNode = root.left;
		pNode.left = new TreeNode(0);
		pNode.right = new TreeNode(3);
		pNode = root.right;
		pNode.left = new TreeNode(6);
		pNode.right = new TreeNode(8);
		pNode = root.left.right;
		pNode.left = new TreeNode(2);
		pNode.right = new TreeNode(4);
		pNode = root.right.right;
		pNode.right = new TreeNode(9);
		return root;
	}

	/////////////////方法1：先序遍历转换法/////////////////////
	
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        
        pRootOfTree = Solution(pRootOfTree);
        //将根结点移至表头结点
        while(pRootOfTree.left != null){
        	pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
    
    public static TreeNode Solution(TreeNode root){
    	if(root == null) return null;
    	//先记录下左右结点的最大值和最小值用于连接
    	TreeNode leftnode = LeftChildrightest(root);
    	TreeNode rightnode = RightChildLeftest(root); 
    	//先序遍历各结点（递归调用转换过程中为后序）
    	root.left = Solution(root.left);
    	root.right = Solution(root.right);
    	//双向链表转换
    	if(leftnode != null){
    		leftnode.right = root;
    		root.left = leftnode;
    	}
    	if(rightnode != null){
    		rightnode.left = root;
    		root.right = rightnode;
    	}
    	
        return root;
    }
    //返回左子树最右结点，也即左子树最大值
    public static TreeNode LeftChildrightest(TreeNode root){
    	if(root.left == null)return null;
    	
    	TreeNode pNode = root.left;
    	while(pNode.right != null){
    		pNode = pNode.right;
    	}
    	return pNode;
    }
    //返回右子树最左结点，也即右子树最小值
    public static TreeNode RightChildLeftest(TreeNode root){
    	if(root.right == null)return null;
    	
    	TreeNode pNode = root.right;
    	while(pNode.left != null){
    		pNode = pNode.left;
    	}
    	return pNode;
    }
    
    /////////////////方法2：中序遍历非递归转换法/////////////////////
    //借助栈实现非递归中序遍历。   	
	public TreeNode Convert2(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode tail = null;// 用于保存已成链表的尾部结点
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			
			if (isFirst) {
				root = p;// 将中序遍历序列中的第一个节点记为root
				tail = root;
				isFirst = false;
			} else {
				tail.right = p;
				p.left = tail;
				tail = p;
			}
			
			p = p.right;
		}
		return root;
	}
	
	/////////////////方法3：中序遍历递归转换法/////////////////////

	TreeNode tail = null;
	TreeNode realHead = null;	//保留链表头结点位置，也就是最左结点位置
	public TreeNode Convert3(TreeNode pRootOfTree) {
		ConvertSub(pRootOfTree);
		return realHead;
	}
	private void ConvertSub(TreeNode pRootOfTree) {
		if (pRootOfTree == null)return;
		
		ConvertSub(pRootOfTree.left);
		
		//每次将上一次已成链表的尾部与当前结点双向连接，移动尾结点
		if (tail == null) {
			tail = pRootOfTree;
			realHead = pRootOfTree;
		} else {
			tail.right = pRootOfTree;
			pRootOfTree.left = tail;
			tail = pRootOfTree;
		}
		
		ConvertSub(pRootOfTree.right);
	}
}




 
