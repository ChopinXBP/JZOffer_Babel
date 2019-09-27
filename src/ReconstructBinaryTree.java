
/**
 * 
 * @author ChopinXBP
 * ��Ŀ����
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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

	//����ǰ���������������ع�������
	//ע�⣺ԭ����pre��in����ȫ�ֱ�������Ҫ�Ժ�������������Ӧ�޸�
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
	
	//�ݹ��ع�������
	private static void ReConstructSolution(TreeNode tree, int flag, int head, int tail, int root){
		//�����������У��ȵݹ��ؽ�����������ݹ��ؽ�������
		if(root != head && root!= tail){
			int leftroot = pre[flag+1];
			tree.left = new TreeNode(leftroot);
			ReConstructSolution(tree.left, flag+1, head, root-1, Find(leftroot));
			
			int rightroot = pre[flag+(root-head)+1];
			tree.right = new TreeNode(rightroot);
			ReConstructSolution(tree.right, flag+(root-head)+1, root+1, tail, Find(rightroot));
		}
		//ֻ�����������ݹ��ؽ�������
		else if(root == head && root != tail){
			int rightroot = pre[flag+(root-head)+1];
			tree.right = new TreeNode(rightroot);
			ReConstructSolution(tree.right, flag+(root-head)+1, root+1, tail, Find(rightroot));
		}
		//ֻ�����������ݹ��ؽ�������
		else if(root == tail && root != head){
			int leftroot = pre[flag+1];
			tree.left = new TreeNode(leftroot);
			ReConstructSolution(tree.left, flag+1, head, root-1, Find(leftroot));
		}
		
	}
	
	//���������������ĳһԪ������λ��
	private static int Find(int data){
		for(int i = 0;i<in.length;i++){
			if(in[i] == data)return i;
		}
		return -1;
	}


	
}
