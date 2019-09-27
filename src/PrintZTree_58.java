/**
 * 
 * @author ChopinXBP
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintZTree_58 {
	
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
    	
    	//放入根节点
    	tree.add(pRoot);
    	ArrayList<Integer> root = new ArrayList<>();
    	root.add(pRoot.val);
    	result.add(root);
    	
    	//设定打印标志
    	boolean printflag = true;
    	while(!tree.isEmpty()) {
    		//当printflag为真时从右向左打印，反之从左向右
    		TreeNode pNode;
    		ArrayList<Integer> list = new ArrayList<>();
    		LinkedList<TreeNode> temp = new LinkedList<>();	//临时存储压栈结点,防止删除冲突 
    		int num = tree.size();
    		//奇数行printflag=true，出栈后->前，压栈右->左
    		if(printflag) {    			
        		for(int i = 0; i < num; i++) {
        			pNode = tree.pollLast();
        			if(pNode.right != null) {
        				temp.add(pNode.right);
        				list.add(pNode.right.val);
        			}
        			if(pNode.left != null) {
        				temp.add(pNode.left);
        				list.add(pNode.left.val);
        			}      			
        		}
        		printflag = false;
    		}
    		//偶数行printflag=false，出栈后->前，压栈左->右
    		else {
    			for(int i = 0; i < num; i++) {
        			pNode = tree.pollLast();
        			if(pNode.left != null) {
        				temp.add(pNode.left);
        				list.add(pNode.left.val);
        			} 
        			if(pNode.right != null) {
        				temp.add(pNode.right);
        				list.add(pNode.right.val);
        			}
        		}  
        		printflag = true;
    		}
    		
    		if(!temp.isEmpty()) tree.addAll(temp);
    		if(!list.isEmpty()) result.add(list);
    	}
    	return result;
    }
}
