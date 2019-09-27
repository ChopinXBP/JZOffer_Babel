/**
 * 
 * @author ChopinXBP 
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 *  
 *
 */

public class HasBintree {
	
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
		TreeNode root1 = new TreeNode(0);
		TreeNode pNode1 = root1;
		pNode1.left = new TreeNode(8);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(8);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(9);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(2);
		pNode1 = root1.left;
		pNode1.left = new TreeNode(5);

		
		TreeNode root2 = new TreeNode(8);
		TreeNode pNode2 = root2;
		pNode2.right = new TreeNode(9);
		pNode2 = root2.right;
		pNode2.left = new TreeNode(3);
		pNode2.right = new TreeNode(2);
		
		boolean result = Solution(root1, root2);
		System.out.println(result);
	}
	
	public static boolean Solution(TreeNode root1, TreeNode root2){
		//�жϱ߽�
		if(root1 == null || root2 == null) return false;
		//�Ե�ǰ���������������ƥ��||�Ե�ǰ������ӽ��������������ƥ��||�Ե�ǰ������ӽ��������������ƥ��
		return isSameTree(root1, root2) || Solution(root1.left, root2) || Solution(root1.right, root2);

	}

	//�ж�root1�ڸý���Ӧ�������Ƿ���root2ƥ��
	public static boolean isSameTree(TreeNode root1, TreeNode root2){
		if(root2 == null) return true;							//������root2�ı߽�
		else if(root1 == null && root2 != null) return false;	//������root1�ı߽�

		//��ǰ���&&���������н��&&���������н��
		if(root1.val == root2.val){
			return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
		}else{
			return false;
		}
	}
}
