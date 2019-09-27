/**
 * 
 * @author ChopinXBP 
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 */

import java.util.ArrayList;
import java.util.TreeSet;

public class GetLeastNumbers_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> result = GetLeastNumbers2(input, 4);
		for(int i = 0; i < result.size(); i++){
			System.out.print(result.get(i));
		}
	}

	////////////////////////方法一：TreeSet模拟最大堆（Tree底层为红黑树）////////////////////////////
	public static ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if(input.length == 0 || k <= 0 || k > input.length) return result;
		if(k == input.length){
			for(int i = 0; i < input.length; i++){
				result.add(input[i]);
			}
			return result;
		}
		
		TreeSet<Integer> mintree = new TreeSet<>();
		for(int i = 0; i < input.length; i++){
			if(i < k){
				mintree.add(input[i]);
			}else{
				if(input[i] < mintree.last()){
					mintree.pollLast();
					mintree.add(input[i]);
				}
			}
		}
		result.addAll(mintree);
		
		return result;
    }
	

	/////////////////////////////方法二：快排思想///////////////////////////////
	public static ArrayList<Integer> GetLeastNumbers2(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if(input.length == 0 || k <= 0 || k > input.length) return result;
		if(k == input.length){
			for(int i = 0; i < input.length; i++){
				result.add(input[i]);
			}
			return result;
		}
 
		int start = 0;
		int end = input.length - 1; 
		int index = Partition(input, start, end);	
 
		//若返回位置正好为k-1，则前k个数已经是最小的k个数
		while (index != k - 1) {
			if (index > k - 1) {
				index = Partition(input, start, index - 1);
			} else {
				index = Partition(input, index + 1, end);
			}
		}
		
		for(int i = 0; i < k; i++){
			result.add(input[i]);
		}
		
		return result;
	}
 
	//先在数组中随机选择一个位置，比选择位置的数字小的数字移到数组的左边，比选择位置的数字大的数字移到数组的右边,该数字回到最终位置,返回该位置
	public static int Partition(int[] array, int start, int end) {
		//找一个start到end之间的随机目标位置，(数据类型)(最小值+Math.random()*(最大值-最小值+1))
		int index = (int)(start + Math.random() * (end - start + 1));		
		
		//将目标位置的值放到最后用于比较，初始化flag值在start，small值为最终所有比目标值小的数之和
		swap(array, index, end);
		int flag = start;
		
		//index从start开始循环至end-1，若出现比目标值（即比end位置的值）小的数，将flag与index互换，flag同时推进一格
		for(index = start; index < end; index++){	
			if(array[index] < array[end]){
				if(flag != index)
					swap(array, index, flag);
				flag++;
			}
		}
		//最后将末尾的数与small互换
		swap(array, flag, end);
		
		return flag;
	}
 
	public static void swap(int[] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}

}
