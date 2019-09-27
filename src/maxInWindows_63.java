/**
 * 
 * @author ChopinXBP
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class maxInWindows_63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> result = maxInWindows(num, 3);
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> result = new ArrayList<>();
    	if(num == null || size <= 0 || size > num.length) return result;
    	//记录元素下标的队列 （只记录下标）	
    	LinkedList<Integer> list = new LinkedList<>();
    	//构建初始队列，从初始窗口倒数第二个元素k开始执行一次操作：从前往后将队列中元素k小的所有元素删除，并将元素k加在队首，此时队尾元素最大
    	for(int i = 0; i < size - 1; i++) {
    		while(!list.isEmpty() && num[i] > num[list.peekFirst()]) {
    			list.pollFirst();
    		}
    		list.addFirst(i);
    	}
    	
    	//初始队列最大元素为size - 1个，对与每一个新元素k = num[i]    	
    	for(int i = size - 1; i < num.length; i++) {
    		//从前往后移去比k小的元素，将k插入队首
    		while(!list.isEmpty() && num[i] > num[list.peekFirst()]) {
    			list.pollFirst();
    		}
    		list.addFirst(i);
    		//检查队尾元素（当前最大值的坐标）是否超出窗口范围（被移出窗口），若超出则删去（每次移动最多删去一个）
    		if(i - list.peekLast() + 1 > size) {
    			list.pollLast();
    		}
    		result.add(num[list.peekLast()]);
    	}
    	  	
    	return result;
    }	
}
