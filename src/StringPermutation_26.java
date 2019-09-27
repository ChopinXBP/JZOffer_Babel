/**
 * 
 * @author ChopinXBP
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�(���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��)
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
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
	
	////////////////////////////����1�������ݹ鷨/////////////////////////////////
	
    public static ArrayList<String> Permutation(String str) {
    	//��������TreeSet��ʱ���棬��֤�����ȥ��
    	ArrayList<String> result = new ArrayList<>();		//��������������������ȫ�ֱ���
    	
    	if(str == null || str.equals("")) return result;
    	if(str.length() == 1){
    		result.add(str);
    		return result;
    	}
    	
    	StringBuilder newstr = new StringBuilder(str);
    	//���ݷ����ַ������н��б������������
    	Solution(newstr, 0,result);
    	Collections.sort(result);
    	
    	return result;
    }


    //���ݷ���ȫ����
    public static void Solution(StringBuilder newstr, int begin, ArrayList<String> result){
    	if(begin == newstr.length()){
    		//�ݹ�����������ĸ������ʼ��ӡ
    		//ȥ�ط�������ӡǰ��contains�����ж�
    		if(!result.contains(newstr.toString())) result.add(newstr.toString());
    	}
    	
		for (int i = begin; i < newstr.length(); i++) {
			// ��begin��i��Ӧ�ַ����н���
			char tmp = newstr.charAt(i);
			newstr.setCharAt(i, newstr.charAt(begin));
			newstr.setCharAt(begin, tmp);

			// �ݹ齻�����Ӻ���ǰ
			Solution(newstr, begin + 1, result);

			// ��λ�ؽ���ǰ
			tmp = newstr.charAt(i);
			newstr.setCharAt(i, newstr.charAt(begin));
			newstr.setCharAt(begin, tmp);

		}
    }

    
    ////////////////////////////����2���ֵ��������㷨/////////////////////////////////
    //1.�ȶ��ַ�������г�ʼ���򲢴�ӡ��ʼ����
    //2.��β����ǰ�ҵ�һ���ɴ��С�����֣��ϴ��ߣ���λ��lIndex
    //3.��i��ʼ����ҵ���һ��С��lIndex-1��ֵ��λ��rIndex
    //4.��lIndex-1��rIndex-1λ�ö�Ӧ��ֵ���н�����Ҳ�����Ӻ���ǰ��һ���ɴ��С�����֣���С�ߣ����ǰ�������һ������ǰ�ߵ�ֵ
    //5.��lIndex-1������н��з�ת
    //6.��ӡ������У���������ѭ��    

	public ArrayList<String> Permutation2(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return list;
		}
		char[] chars = str.toCharArray();
		Arrays.sort(chars);					//�ȶ��ַ�������г�ʼ����
		list.add(String.valueOf(chars));
		int len = chars.length;
		while (true) {
			int lIndex = len - 1;
			int rIndex;
			//��β����ǰ�ҵ�һ���ɴ��С�����֣��ϴ��ߣ���λ��lIndex
			while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex]) {
				lIndex--;
			}
			if (lIndex == 0)
				break;
			rIndex = lIndex;
			//��i��ʼ����ҵ���һ��С��lIndex-1��ֵ��λ��rIndex
			while (rIndex < len && chars[rIndex] > chars[lIndex - 1]) {
				rIndex++;
			}
			//��lIndex-1��rIndex-1λ�ö�Ӧ��ֵ���н�����Ҳ�����Ӻ���ǰ��һ���ɴ��С�����֣���С�ߣ����ǰ�������һ������ǰ�ߵ�ֵ
			swap(chars, lIndex - 1, rIndex - 1);
			//��lIndex-1������н��з�ת
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
	
	

	////////////////////////////����3����ȱ������������ݷ���/////////////////////////////////
	private char[] seqs;
	private Integer[] book;
	// ���ڽ��ȥ��
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
		// �������п��� ��¼����
		if (arrs.length == step) {
			String str = "";
			for (int i = 0; i < seqs.length; i++) {
				str += seqs[i];
			}
			result3.add(str);
			return; // ������һ��
		}
		// ������������,����ÿһ�ֿ���
		for (int i = 0; i < arrs.length; i++) {
			// �Ƿ��߹�
			if (book[i] == 0) {
				seqs[step] = arrs[i];
				book[i] = 1;
				// ��һ��
				dfs(arrs, step + 1);
				// �������һ�� ����һ��
				book[i] = 0;
			}
		}
	}
	
	
}


