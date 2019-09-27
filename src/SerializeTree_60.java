/**
 * 
 * @author ChopinXBP
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 */

public class SerializeTree_60 {

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
		
		String result = Serialize(pHead);
		System.out.println(result);
		pHead = Deserialize(result);
		
	}

	public static String Serialize(TreeNode root) {
        if(root == null) return null;
		StringBuilder str = new StringBuilder();
		strBuild(root, str);
		return str.toString();
    }
	
	public static void strBuild(TreeNode root, StringBuilder str) {
		if(root == null) {
			str.append("#!");	//用‘#’代表null结点
			return;
		}
		str.append(root.val + "!");
		strBuild(root.left, str);
		strBuild(root.right, str);
	}
    
	private static int idx;
	
	public static TreeNode Deserialize(String str) {
        TreeNode root = null;
		if(str == null)return root;
       
		String[] strings = str.split("!");
		if(strings.length == 0) return root;
		
		idx = -1;
		root = treeBuild(strings);
		
        return root;
    }
	
	public static TreeNode treeBuild(String[] strings) {
		if(idx > strings.length) {
			return null;
		}
		idx++;
		TreeNode node = null;
		if(!strings[idx].equals("#")) {
			node = new TreeNode(Integer.parseInt(strings[idx]));
			node.left = treeBuild(strings);
			node.right = treeBuild(strings);
		}		
		return node;
	}
}
