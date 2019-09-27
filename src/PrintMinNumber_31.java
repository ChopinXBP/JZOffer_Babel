/**
 * 
 * @author ChopinXBP 
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class PrintMinNumber_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {4, 42, 4321, 43, 432};
		System.out.println(PrintMinNumber1(numbers));
	}

	//����1����ȫ������С
	public static String PrintMinNumber1(int [] numbers) {
		if(numbers == null)return null;
		
		ArrayList<String> numStr = new ArrayList<>();		
		for(int i = 0; i < numbers.length; i++){
			String str  = numbers[i] + "";
			numStr.add(str);
		}
		
		TreeSet<String> strList = new TreeSet<>();		
		Solution(numStr, 0, strList);
		return strList.first();
    }
	
	public static void Solution(ArrayList<String> numStr, int begin, TreeSet<String> strList){
		if(begin == numStr.size()){
			StringBuilder resultStr = new StringBuilder();
			for(int i = 0; i < numStr.size(); i++){
				resultStr.append(numStr.get(i));
			}
			strList.add(resultStr.toString());
		}
		
		for(int i = begin; i < numStr.size(); i++){
			Tmp(numStr, i, begin);
			Solution(numStr, begin + 1, strList);
			Tmp(numStr, i, begin);
		}
	}
	
	public static void Tmp(ArrayList<String> numStr, int i, int j){
		String tmp = numStr.get(i);
		numStr.set(i, numStr.get(j));
		numStr.set(j, tmp);
	}
	
	//����2���Զ���Ƚ�������ƴ�Ӻ���ַ����Ƚϣ�
	public static String PrintMinNumber2(int [] numbers) {
		if(numbers == null)return null;
		
		ArrayList<Integer> numStr = new ArrayList<>();		
		for(int i = 0; i < numbers.length; i++){
			String str  = numbers[i] + "";
			numStr.add(Integer.parseInt(str));
		}
		/*
		//���ַ�ʽ����Ƚ���ʱ����ռ�Ч�ʾ��ϵ�
		Collections.sort(numStr, (Integer str1, Integer str2)
				-> Integer.compare(Integer.parseInt(str1 + "" + str2), Integer.parseInt(str2 + "" + str1)));
		*/
		Collections.sort(numStr, new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2){
				String str1 = num1 + "" + num2;
				String str2 = num2 + "" + num1;
				return str1.compareTo(str2);
			}
		});
		
		StringBuilder resultStr = new StringBuilder();
		for(int i = 0; i < numStr.size(); i++){
			resultStr.append(numStr.get(i));
		}
		return resultStr.toString();
    }
}
