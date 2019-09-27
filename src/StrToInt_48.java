/**
 * 
 * @author ChopinXBP
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * 
 */

public class StrToInt_48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StrToInt("+2147483647"));
	}

    public static int StrToInt(String str) {
    	int length = str.length();
    	if(length == 0) return 0;
    	
    	int result = 0;
    	int loc = 1;
    	int end = 0;
    	if(str.charAt(0) == '+') {
    		end++;
    	}
    	else if(str.charAt(0) == '-') {
    		loc = -1;
    		end++;
    	}
    	    	
    	length--;
    	while(length >= end) {
    		if(!isNum(str.charAt(length))) return 0;
    		result += Integer.parseInt(str.charAt(length) + "") * loc;
    		loc *= 10;
    		length--;
    	}
    	   	
    	return result;
    }
    
    public static boolean isNum(char c){
    	if(c >= '0' && c <= '9') {
    		return true;
    	}else {
    		return false;
    	}
    }
    
}
