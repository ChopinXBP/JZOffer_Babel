/**
 * 
 * @author ChopinXBP
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 *
 */



public class LeftRotateString_41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution("abcXYZdef", 3));
	}

	public static String Solution(String str, int n){
		if(str == null || str == "")return "";
		int length = str.length();		
		if(n < 0 || length == 0)return "";
		
		n = n % length;		
        str += str;
        return str.substring(n, n + length);
		

//		String str1 = str.substring(n);
//		String str2 = str.substring(0, n);
//		StringBuilder newstr = new StringBuilder(str1);
//		
//		return newstr.append(str2).toString();
	}
}
