/**
 * 
 * @author ChopinXBP
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
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

	//����һ���Ӹ��ڵ㿪ʼ����һ�μ�֦�������
	private static int loc;		//ȫ�ֱ������ڼ�¼���λ��	
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)return null;
        
        //�ص����ڵ�
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
    	//��֦
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
    
    //�����������ù���
    public static TreeLinkNode GetNext2(TreeLinkNode pNode)
    {
        if(pNode == null)return null;
        //�����ǰ�����������������һ���Ϊ�ý���������������㣨��������е�ǰ�����������϶��Ѿ�ȫ����������
        if(pNode.right != null) {
        	pNode = pNode.right;
        	while(pNode.left != null) {
        		pNode = pNode.left;
        	}
        	return pNode;
        }
        //�����ǰ���û��������������һ���Ϊʹ�õ�ǰ�����������Ϊ�������ĸ��ڵ㣨���û�У���ý���Ѿ���������������һ����㣩
        while(pNode.next != null) {
        	if(pNode.next.left == pNode) {
        		return pNode.next;
        	}
        	pNode = pNode.next;
        }
        
        return null;
    }
}
