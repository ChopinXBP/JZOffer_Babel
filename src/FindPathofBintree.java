/**
 * 
 * @author ChopinXBP 
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPathofBintree {
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
		TreeNode root = new TreeNode(1);
		root = Init(root);
		ArrayList<ArrayList<Integer>> result = FindPath(root, 9);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j));
			System.out.print('\n');
		}
	}
	
	public static TreeNode Init(TreeNode root){		
		TreeNode pNode = root;
		pNode.left = new TreeNode(2);
		pNode.right = new TreeNode(3);
		pNode = root.left;
		pNode.left = new TreeNode(5);
		pNode.right = new TreeNode(6);
		pNode = root.right;
		pNode.left = new TreeNode(5);
		pNode.right = new TreeNode(4);
		pNode = root.left.left;
		pNode.left = new TreeNode(1);

		return root;
	}

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {	
    	ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();	//��¼���з���·���б�
    	if(root == null) return result;
    	
    	ArrayList<Integer> route = new ArrayList<>();//��¼ÿһ������·��
    	int sum = 0;
    	Solve(result, route, root, target, sum);
    	
    	if(result.size() != 0 || result.size() != 1){
    		//Ƕ���������򡪡��ⲿ�������
    		//Collections.sort(result, cmp);
    		//Ƕ���������򡪡�lambda���ʽ
    		Collections.sort(result, (ArrayList<Integer> list1, ArrayList<Integer> list2)
    				-> Integer.compare(list2.size(), list1.size()));
    	}
    	return result;
    }
    
    //�ݹ��ÿ��·�����м�¼�������ֵ�ĺʹ���Ŀ������ʱ����ǰ�����ݹ飻��������Ҷ�ڵ�ʱ�������ֵ�ĺ͵���Ŀ���������򽫸÷���·���������·���б�
    public static void Solve(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> route, TreeNode root, int target, int sum){
    	route.add(root.val);
    	sum += root.val;
    	if(sum > target) return;
    	
    	if(root.left == null && root.right == null){
    		if(sum == target){
    			result.add(route);
    		}
    	}
    	else if(root.left == null){
    		Solve(result, route, root.right, target, sum);
    	}
    	else if(root.right == null){
    		Solve(result, route, root.left, target, sum);
    	}
    	else{
    		//����Ҫ�ֲ�,����Ҫ����newһ����route��ͬ�ķ���·��
    		Solve(result, new ArrayList<>(route), root.right, target, sum);
    		Solve(result, new ArrayList<>(route), root.left, target, sum);
    	}
    }
    
    //��Ƕ��������size��С���򣬴Ӵ�С��list2.size()-list1.size()������������Ӵ�С����
    static Comparator<ArrayList<Integer>> cmp = new Comparator<ArrayList<Integer>>(){
    	public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
			return list2.size() - list1.size();
		}
	};


	
	//������ĵݹ鷽���ο�
	public class Solution {
	    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    private ArrayList<Integer> list = new ArrayList<>();
	    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	        help(root, target);
	        //Ƕ���������򡪡��ڲ���д��
	        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
	            @Override
	            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
	                return list2.size() - list1.size();
	            }
	        });
	        return result;
	    }
	    
	    private void help(TreeNode root, int target) {
	        if (root == null)
	            return;
	        list.add(root.val);
	        target -= root.val;		//ÿ�εݹ��Сһ��targetֵ
	        if (target == 0 && root.left == null && root.right == null)
	            result.add(new ArrayList<>(list));
	        else if(target > 0){
		        if(root.right!=null)FindPath(root.right, target);
		        if(root.left!=null)FindPath(root.left, target);
	        }
	        list.remove(list.size() - 1);	//���ʵ�Ҷ�ڵ�ʱ���еݹ����
	    }
	}
}
