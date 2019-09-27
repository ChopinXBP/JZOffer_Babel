/**
 * 
 * @author ChopinXBP
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。(长度不超过9(可能有字符重复),字符只包括大小写字母。)
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class StringPermutation_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<String> input = Permutation(new String("bbacC"));
		//ArrayList<String> input = Permutation(new String("aa"));
		//ArrayList<String> input = Permutation(new String("a"));
		//ArrayList<String> input = Permutation(new String("abbc"));
		ArrayList<String> input = Permutation(new String("abc"));
		for(int i = 0; i < input.size(); i++){
			System.out.print(input.get(i) + " ");
		}
	}
	
	////////////////////////////方法1：交换递归法/////////////////////////////////
	
    public static ArrayList<String> Permutation(String str) {
    	//可以先用TreeSet临时保存，保证排序和去重
    	ArrayList<String> result = new ArrayList<>();		//对连续测试用例不能用全局变量
    	
    	if(str == null || str.equals("")) return result;
    	if(str.length() == 1){
    		result.add(str);
    		return result;
    	}
    	
    	StringBuilder newstr = new StringBuilder(str);
    	//回溯法对字符串排列进行遍历，最后排序
    	Solution(newstr, 0,result);
    	Collections.sort(result);
    	
    	return result;
    }


    //回溯法求全排列
    public static void Solution(StringBuilder newstr, int begin, ArrayList<String> result){
    	if(begin == newstr.length()){
    		//递归从最后两个字母交换开始打印
    		//去重方法：打印前用contains进行判断
    		if(!result.contains(newstr.toString())) result.add(newstr.toString());
    	}
    	
		for (int i = begin; i < newstr.length(); i++) {
			// 将begin与i对应字符进行交换
			char tmp = newstr.charAt(i);
			newstr.setCharAt(i, newstr.charAt(begin));
			newstr.setCharAt(begin, tmp);

			// 递归交换，从后往前
			Solution(newstr, begin + 1, result);

			// 复位回交换前
			tmp = newstr.charAt(i);
			newstr.setCharAt(i, newstr.charAt(begin));
			newstr.setCharAt(begin, tmp);

		}
    }

    
    ////////////////////////////方法2：字典序排列算法/////////////////////////////////
    //1.先对字符数组进行初始排序并打印初始序列
    //2.从尾部向前找第一个由大变小的数字（较大者）的位置lIndex
    //3.从i开始向后找到第一个小于lIndex-1的值的位置rIndex
    //4.将lIndex-1与rIndex-1位置对应的值进行交换，也即将从后往前第一个由大变小的数字（较小者）与从前往后最后一个大于前者的值
    //5.将lIndex-1后的序列进行翻转
    //6.打印这个序列，继续进行循环    

	public ArrayList<String> Permutation2(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return list;
		}
		char[] chars = str.toCharArray();
		Arrays.sort(chars);					//先对字符数组进行初始排序
		list.add(String.valueOf(chars));
		int len = chars.length;
		while (true) {
			int lIndex = len - 1;
			int rIndex;
			//从尾部向前找第一个由大变小的数字（较大者）的位置lIndex
			while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex]) {
				lIndex--;
			}
			if (lIndex == 0)
				break;
			rIndex = lIndex;
			//从i开始向后找到第一个小于lIndex-1的值的位置rIndex
			while (rIndex < len && chars[rIndex] > chars[lIndex - 1]) {
				rIndex++;
			}
			//将lIndex-1与rIndex-1位置对应的值进行交换，也即将从后往前第一个由大变小的数字（较小者）与从前往后最后一个大于前者的值
			swap(chars, lIndex - 1, rIndex - 1);
			//将lIndex-1后的序列进行翻转
			reverse(chars, lIndex);

			list.add(String.valueOf(chars));
		}

		return list;
	}

	private void reverse(char[] chars, int k) {
		if (chars == null || chars.length <= k)
			return;
		int len = chars.length;
		for (int i = 0; i < (len - k) / 2; i++) {
			int m = k + i;
			int n = len - 1 - i;
			if (m <= n) {
				swap(chars, m, n);
			}
		}

	}

	private void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}
	
	

	////////////////////////////方法3：深度遍历搜索（回溯法）/////////////////////////////////
	private char[] seqs;
	private Integer[] book;
	// 用于结果去重
	private HashSet<String> result3 = new HashSet<String>();

	public ArrayList<String> Permutation3(String str) {
		ArrayList<String> arrange = new ArrayList<String>();
		if (str == null || str.isEmpty())
			return arrange;
		char[] strs = str.toCharArray();
		seqs = new char[strs.length];
		book = new Integer[strs.length];
		for (int i = 0; i < book.length; i++) {
			book[i] = 0;
		}
		dfs(strs, 0);
		arrange.addAll(result3);
		Collections.sort(arrange);
		return arrange;
	}

	private void dfs(char[] arrs, int step) {
		// 走完所有可能 记录排列
		if (arrs.length == step) {
			String str = "";
			for (int i = 0; i < seqs.length; i++) {
				str += seqs[i];
			}
			result3.add(str);
			return; // 返回上一步
		}
		// 遍历整个序列,尝试每一种可能
		for (int i = 0; i < arrs.length; i++) {
			// 是否走过
			if (book[i] == 0) {
				seqs[step] = arrs[i];
				book[i] = 1;
				// 下一步
				dfs(arrs, step + 1);
				// 走完最后一步 后退一步
				book[i] = 0;
			}
		}
	}
	
	
}


