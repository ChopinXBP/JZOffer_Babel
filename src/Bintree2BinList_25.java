/**
 * 
 * @author ChopinXBP 
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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

	/////////////////����1���������ת����/////////////////////
	
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        
        pRootOfTree = Solution(pRootOfTree);
        //�������������ͷ���
        while(pRootOfTree.left != null){
        	pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
    
    public static TreeNode Solution(TreeNode root){
    	if(root == null) return null;
    	//�ȼ�¼�����ҽ������ֵ����Сֵ��������
    	TreeNode leftnode = LeftChildrightest(root);
    	TreeNode rightnode = RightChildLeftest(root); 
    	//�����������㣨�ݹ����ת��������Ϊ����
    	root.left = Solution(root.left);
    	root.right = Solution(root.right);
    	//˫������ת��
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
    //�������������ҽ�㣬Ҳ�����������ֵ
    public static TreeNode LeftChildrightest(TreeNode root){
    	if(root.left == null)return null;
    	
    	TreeNode pNode = root.left;
    	while(pNode.right != null){
    		pNode = pNode.right;
    	}
    	return pNode;
    }
    //���������������㣬Ҳ����������Сֵ
    public static TreeNode RightChildLeftest(TreeNode root){
    	if(root.right == null)return null;
    	
    	TreeNode pNode = root.right;
    	while(pNode.left != null){
    		pNode = pNode.left;
    	}
    	return pNode;
    }
    
    /////////////////����2����������ǵݹ�ת����/////////////////////
    //����ջʵ�ַǵݹ����������   	
	public TreeNode Convert2(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode tail = null;// ���ڱ����ѳ������β�����
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			
			if (isFirst) {
				root = p;// ��������������еĵ�һ���ڵ��Ϊroot
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
	
	/////////////////����3����������ݹ�ת����/////////////////////

	TreeNode tail = null;
	TreeNode realHead = null;	//��������ͷ���λ�ã�Ҳ����������λ��
	public TreeNode Convert3(TreeNode pRootOfTree) {
		ConvertSub(pRootOfTree);
		return realHead;
	}
	private void ConvertSub(TreeNode pRootOfTree) {
		if (pRootOfTree == null)return;
		
		ConvertSub(pRootOfTree.left);
		
		//ÿ�ν���һ���ѳ������β���뵱ǰ���˫�����ӣ��ƶ�β���
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




 
