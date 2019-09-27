/**
 * 
 * @author ChopinXBP 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PrintFromTopToBottom_21 {

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
		Init(root);
		ArrayList<Integer> result = Solution(null);
		for(int i = 0; i < result.size(); i++){
			System.out.print(result.get(i));
		}
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
	
	public static ArrayList<Integer> Solution(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null) return result;
				
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			TreeNode newnode = queue.poll();
			result.add(newnode.val);
			if(newnode.left != null) queue.add(newnode.left);
			if(newnode.right != null) queue.add(newnode.right);
		}
		return result;
	}
}
