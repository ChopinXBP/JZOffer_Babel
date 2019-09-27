/**
 * 
 * @author ChopinXBP 
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
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

	////////////////////////����һ��TreeSetģ�����ѣ�Tree�ײ�Ϊ�������////////////////////////////
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
	

	/////////////////////////////������������˼��///////////////////////////////
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
 
		//������λ������Ϊk-1����ǰk�����Ѿ�����С��k����
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
 
	//�������������ѡ��һ��λ�ã���ѡ��λ�õ�����С�������Ƶ��������ߣ���ѡ��λ�õ����ִ�������Ƶ�������ұ�,�����ֻص�����λ��,���ظ�λ��
	public static int Partition(int[] array, int start, int end) {
		//��һ��start��end֮������Ŀ��λ�ã�(��������)(��Сֵ+Math.random()*(���ֵ-��Сֵ+1))
		int index = (int)(start + Math.random() * (end - start + 1));		
		
		//��Ŀ��λ�õ�ֵ�ŵ�������ڱȽϣ���ʼ��flagֵ��start��smallֵΪ�������б�Ŀ��ֵС����֮��
		swap(array, index, end);
		int flag = start;
		
		//index��start��ʼѭ����end-1�������ֱ�Ŀ��ֵ������endλ�õ�ֵ��С��������flag��index������flagͬʱ�ƽ�һ��
		for(index = start; index < end; index++){	
			if(array[index] < array[end]){
				if(flag != index)
					swap(array, index, flag);
				flag++;
			}
		}
		//���ĩβ������small����
		swap(array, flag, end);
		
		return flag;
	}
 
	public static void swap(int[] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}

}
