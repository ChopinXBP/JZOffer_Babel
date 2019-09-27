/**
 * 
 * @author ChopinXBP
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class MoreThanHalfNum_Solution_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution2(array));
	}

	
	//////////////////////方法一：遍历计数///////////////////////
	public static class Data{
		int data;
		int num;
		Data(int data){
			this.data = data;
			num = 1;
		}
	}
	
	public static int MoreThanHalfNum_Solution(int [] array) {
		if (array.length <= 0) return 0;
		
        HashSet<Data> datalist = new HashSet<>();
        for(int i = 0; i < array.length; i++){
        	if(!isExistNum(datalist, array[i])){
        		Data newdata = new Data(array[i]);
        		datalist.add(newdata);
        	}
        }
        
        int result = 0;
        for(Data it : datalist){
			if(it.num > array.length / 2){
				result = it.data;
			}
		}
        
        return result;
    }
	
	public static boolean isExistNum(HashSet<Data> datalist, int i){
		for(Data it : datalist){
			if(it.data == i){
				it.num++;
				return true;
			}
		}
		return false;
	}
	
	//////////////////////方法一改进：HashMap///////////////////////
	public static int MoreThanHalfNum_Solution1(int[] array) {
		//利用HashMap，key值存储元素，val值存储次数
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {

			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				int count = map.get(array[i]);
				map.put(array[i], ++count);
			}
		}
		
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Integer key = (Integer) entry.getKey();
			Integer val = (Integer) entry.getValue();
			if (val > array.length / 2) {
				return key;
			}
		}
		return 0;
	}
	
	////////////////方法二：快速寻找中位数（快排思想）//////////////////
	public static int MoreThanHalfNum_Solution2(int[] array) {
		if (array.length <= 0)
			return 0;

		int start = 0;
		int length = array.length;
		int end = length - 1;
		int middle = length >> 1;

		int index = Partition(array, start, end);	

		//若index正好等于middle，也就是中位数，若index>middle，则中位数在index左边，若index<middle,则中位数在index右边
		//递归找到将index匹配至中位数位置
		while (index != middle) {
			if (index > middle) {
				index = Partition(array, start, index - 1);
			} else {
				index = Partition(array, index + 1, end);
			}
		}
		int result = array[middle];

		//计算出现次数是否超过一半
		int times = 0;
		for (int i = 0; i < length; ++i) {
			if (array[i] == result)
				times++;
		}
		if (times * 2 < length) {
			System.out.println(times);
			return 0;
		} else {
			return result;
		}
	}

	//以flag为界，不断交换左右元素，左边元素全小于flag所对应的值，右边元素全大于flag所对应的值，返回中位数所在位置
	public static int Partition(int[] array, int start, int end) {
		int flag = (array[start] + array[end]) / 2;

		while (start < end) {
			while (array[end] > flag) {
				end--;
			}
			swap(array, start, end);
			while (array[start] <= flag) {
				start++;
			}
			swap(array, start, end);
		}
		return start;
	}

	public static void swap(int[] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}
	
	////////////////方法三：在线处理算法（数组特点）//////////////////
	public int MoreThanHalfNum_Solution3(int[] array) {
		if (array.length <= 0) {
			return 0;
		}
		int result = array[0];
		int times = 1;			//起始次数设置为1	

		//若当前次数为0，将result更新为当前数字。若当前数字与result相同，次数+1；若不同则-1。
		//由于目标数字出现次数比其他数字加起来还多，因此最后result中存的数字为怀疑的目标数字
		for (int i = 0; i < array.length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			}
			else if (array[i] == result)
				times++;
			else
				times--;
		}
		
		//计算result中怀疑的目标数字出现次数，进行最终确定
		int time = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == result)
				time++;
		}
		
		if (time * 2 < array.length) {
			//System.out.println(time);
			return 0;
		} else {
			return result;
		}
	}

}
