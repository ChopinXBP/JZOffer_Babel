/**
 * 
 * @author ChopinXBP 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
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

	//方法1：求全排列最小
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
	
	//方法2：自定义比较器（用拼接后的字符串比较）
	public static String PrintMinNumber2(int [] numbers) {
		if(numbers == null)return null;
		
		ArrayList<Integer> numStr = new ArrayList<>();		
		for(int i = 0; i < numbers.length; i++){
			String str  = numbers[i] + "";
			numStr.add(Integer.parseInt(str));
		}
		/*
		//这种方式定义比较器时间与空间效率均较低
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
