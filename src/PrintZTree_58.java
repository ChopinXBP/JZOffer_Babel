/**
 * 
 * @author ChopinXBP
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
    	
    	//������ڵ�
    	tree.add(pRoot);
    	ArrayList<Integer> root = new ArrayList<>();
    	root.add(pRoot.val);
    	result.add(root);
    	
    	//�趨��ӡ��־
    	boolean printflag = true;
    	while(!tree.isEmpty()) {
    		//��printflagΪ��ʱ���������ӡ����֮��������
    		TreeNode pNode;
    		ArrayList<Integer> list = new ArrayList<>();
    		LinkedList<TreeNode> temp = new LinkedList<>();	//��ʱ�洢ѹջ���,��ֹɾ����ͻ 
    		int num = tree.size();
    		//������printflag=true����ջ��->ǰ��ѹջ��->��
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
    		//ż����printflag=false����ջ��->ǰ��ѹջ��->��
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
