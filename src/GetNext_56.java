/**
 * 
 * @author ChopinXBP
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 */

import java.util.ArrayList;

public class GetNext_56 {
	
	public static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root1 = new TreeLinkNode(1);
		TreeLinkNode root2 = new TreeLinkNode(2);
		TreeLinkNode root3 = new TreeLinkNode(3);
		TreeLinkNode root4 = new TreeLinkNode(4);
		TreeLinkNode root5 = new TreeLinkNode(5);
		TreeLinkNode root6 = new TreeLinkNode(6);
		root1.left = root2;
		root1.right = root3;
		root2.next = root1;
		root3.next = root1;
		root2.left = root4;
		root2.right = root5;
		root4.next = root2;
		root5.next = root2;
		root3.left = root6;
		root6.next = root3;
		System.out.println(GetNext(root1).val);
	}

	//方法一：从根节点开始进行一次剪枝中序遍历
	private static int loc;		//全局变量用于记录结果位置	
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)return null;
        
        //回到根节点
        TreeLinkNode root = pNode;
        while(root.next != null) {
        	root = root.next;
        }
        
        ArrayList<TreeLinkNode> tree = new ArrayList<>();
        loc = -2;
        SetList(root, tree, pNode);
        
        if(loc < tree.size()) {
        	return tree.get(loc);
        }else {
        	return null;
        }
    }
    
    public static void SetList(TreeLinkNode p, ArrayList<TreeLinkNode> tree, TreeLinkNode pNode) {
    	//剪枝
    	if(loc == tree.size() - 1) return;
    	
    	if(p.left != null) {
    		SetList(p.left, tree, pNode);
    	}
    	tree.add(p);
    	if(p == pNode) {
    		loc = tree.size();
    	}
    	if(p.right != null) {
    		SetList(p.right, tree, pNode);
    	}
    }
    
    //方法二：利用规律
    public static TreeLinkNode GetNext2(TreeLinkNode pNode)
    {
        if(pNode == null)return null;
        //如果当前结点有右子树，则下一结点为该结点右子树的最左结点（中序遍历中当前结点的左子树肯定已经全部被遍历）
        if(pNode.right != null) {
        	pNode = pNode.right;
        	while(pNode.left != null) {
        		pNode = pNode.left;
        	}
        	return pNode;
        }
        //如果当前结点没有右子树，则下一结点为使得当前结点所在子树为左子树的父节点（如果没有，则该结点已经是中序遍历的最后一个结点）
        while(pNode.next != null) {
        	if(pNode.next.left == pNode) {
        		return pNode.next;
        	}
        	pNode = pNode.next;
        }
        
        return null;
    }
}
