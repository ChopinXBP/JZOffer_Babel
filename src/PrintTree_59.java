/**
 * 
 * @author ChopinXBP
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintTree_59 {
	
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
		TreeNode pHead = new TreeNode(0);
		TreeNode p1= new TreeNode(1);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(3);
		TreeNode p4= new TreeNode(4);
		TreeNode p5= new TreeNode(5);
		TreeNode p6= new TreeNode(6);
		pHead.left = p1;
		pHead.right = p2;
		p1.left = p3;
		p1.right = p4;
		p2.left = p5;
		p2.right = p6;
		
		ArrayList<ArrayList<Integer>> result = Print(pHead);
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {       
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if(pRoot == null)return result;
    	
    	LinkedList<TreeNode> tree = new LinkedList<>(); 
    	tree.add(pRoot);
    	
    	while(!tree.isEmpty()) {
    		TreeNode pNode;
    		ArrayList<Integer> list = new ArrayList<>();   		
    		int num = tree.size();   			
			for (int i = 0; i < num; i++) {
				pNode = tree.pollFirst();
				if (pNode.left != null) {
					tree.add(pNode.left);
				}
				if (pNode.right != null) {
					tree.add(pNode.right);
				}
				list.add(pNode.val);
			}
    		if(!list.isEmpty()) result.add(list);
    	}
    	
    	return result;
    }

}
