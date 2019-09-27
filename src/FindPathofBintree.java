/**
 * 
 * @author ChopinXBP 
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
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
    	ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();	//记录所有符合路径列表
    	if(root == null) return result;
    	
    	ArrayList<Integer> route = new ArrayList<>();//记录每一条访问路径
    	int sum = 0;
    	Solve(result, route, root, target, sum);
    	
    	if(result.size() != 0 || result.size() != 1){
    		//嵌套容器排序——外部对象调用
    		//Collections.sort(result, cmp);
    		//嵌套容器排序——lambda表达式
    		Collections.sort(result, (ArrayList<Integer> list1, ArrayList<Integer> list2)
    				-> Integer.compare(list2.size(), list1.size()));
    	}
    	return result;
    }
    
    //递归对每条路径进行记录，当结点值的和大于目标整数时，提前结束递归；当访问至叶节点时，若结点值的和等于目标整数，则将该访问路径加入符合路径列表
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
    		//若需要分岔,则需要重新new一个和route相同的访问路径
    		Solve(result, new ArrayList<>(route), root.right, target, sum);
    		Solve(result, new ArrayList<>(route), root.left, target, sum);
    	}
    }
    
    //将嵌套容器按size大小排序，从大到小（list2.size()-list1.size()返回正数，则从大到小排序）
    static Comparator<ArrayList<Integer>> cmp = new Comparator<ArrayList<Integer>>(){
    	public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
			return list2.size() - list1.size();
		}
	};


	
	//极其简洁的递归方法参考
	public class Solution {
	    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    private ArrayList<Integer> list = new ArrayList<>();
	    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	        help(root, target);
	        //嵌套容器排序——内部类写法
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
	        target -= root.val;		//每次递归减小一次target值
	        if (target == 0 && root.left == null && root.right == null)
	            result.add(new ArrayList<>(list));
	        else if(target > 0){
		        if(root.right!=null)FindPath(root.right, target);
		        if(root.left!=null)FindPath(root.left, target);
	        }
	        list.remove(list.size() - 1);	//访问到叶节点时进行递归回退
	    }
	}
}
