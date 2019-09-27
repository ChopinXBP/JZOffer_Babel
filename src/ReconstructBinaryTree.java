
/**
 * 
 * @author ChopinXBP
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 */


public class ReconstructBinaryTree {


	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}

	private static int[]pre = {1,2,4,7,3,5,6,8};
	private static int[]in = {4,7,2,1,5,3,8,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode BinTree = ReConstructBinaryTree(pre, in);
		System.out.println("Over");
	}

	//根据前序遍历与中序遍历重构二叉树
	//注意：原题中pre与in并非全局变量，需要对函数参数进行相应修改
	public static TreeNode ReConstructBinaryTree(int []pre, int[] in){
		TreeNode BinTree = new TreeNode(pre[0]);
		
		int flag = 0;
		int head = 0;
		int tail = in.length-1;
		int root = Find(pre[0]);
		
		if(root != -1){
			ReConstructSolution(BinTree, flag, head, tail, root);
		}
				
		return BinTree;
	}
	
	//递归重构二叉树
	private static void ReConstructSolution(TreeNode tree, int flag, int head, int tail, int root){
		//左右子树均有，先递归重建左子树，后递归重建右子树
		if(root != head && root!= tail){
			int leftroot = pre[flag+1];
			tree.left = new TreeNode(leftroot);
			ReConstructSolution(tree.left, flag+1, head, root-1, Find(leftroot));
			
			int rightroot = pre[flag+(root-head)+1];
			tree.right = new TreeNode(rightroot);
			ReConstructSolution(tree.right, flag+(root-head)+1, root+1, tail, Find(rightroot));
		}
		//只有右子树，递归重建右子树
		else if(root == head && root != tail){
			int rightroot = pre[flag+(root-head)+1];
			tree.right = new TreeNode(rightroot);
			ReConstructSolution(tree.right, flag+(root-head)+1, root+1, tail, Find(rightroot));
		}
		//只有左子树，递归重建左子树
		else if(root == tail && root != head){
			int leftroot = pre[flag+1];
			tree.left = new TreeNode(leftroot);
			ReConstructSolution(tree.left, flag+1, head, root-1, Find(leftroot));
		}
		
	}
	
	//返回中序遍历数组某一元素所在位置
	private static int Find(int data){
		for(int i = 0;i<in.length;i++){
			if(in[i] == data)return i;
		}
		return -1;
	}


	
}
