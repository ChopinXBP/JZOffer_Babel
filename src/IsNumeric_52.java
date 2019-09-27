/**
 * 
 * @author ChopinXBP
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 * 
 */

public class IsNumeric_52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str0 = {'+', '1', '0'};
		char[] str1 = {'5', 'e', '2'};
		char[] str2 = {'-', '1', '2'};
		char[] str3 = {'3', '.', '1', '4'};
		char[] str4 = {'-', '1', 'E', '-', '1', '6'};
		char[] str5 = {'1', '1', 'e'};
		char[] str6 = {'1', 'a', '3', '.', '1', '4'};
		char[] str7 = {'1', '.', '2', '.', '1'};
		char[] str8 = {'+', '-', '5'};
		char[] str9 = {'-', '1', 'E', '-', '1', '.', '6'};
		char[] str10 = {'1', '.', '1', 'e', '+', '1', '6'};	//��ѧ������ǰ������С����
		char[] str11 = {'.', '1', 'e', '+', '1', '6'};		//С����ǰ����û������
		char[] str12 = {'1', '.'};							//С���㲻�ܽ�β
		System.out.println(isNumeric(str0));
		System.out.println(isNumeric(str1));
		System.out.println(isNumeric(str2));
		System.out.println(isNumeric(str3));
		System.out.println(isNumeric(str4));
		System.out.println(isNumeric(str5));
		System.out.println(isNumeric(str6));
		System.out.println(isNumeric(str7));
		System.out.println(isNumeric(str8));
		System.out.println(isNumeric(str9));
		System.out.println(isNumeric(str10));
		System.out.println(isNumeric(str11));
		System.out.println(isNumeric(str12));
	}

	//���෽��
    public static boolean isNumeric(char[] str) {
        if(str == null)return false;
        int length = str.length;
        //ֻ��һλ�����ַ���false
        if(length == 1 && !isNum(str[0])) return false;
        
        int idx = 0;
        //������ʼ��������
        if(str[0] == '+' || str[0] == '-') idx++;
        
        boolean hasPoint = false;	//��¼�Ƿ���ֹ�С����
        for(int i = idx; i < length; i++) {
        	//����λ�����֣�����ǰ��
        	if(isNum(str[i])) {
        		continue;
        	}
        	//����һ�γ���С���㣨��������ʼ������ĩβ�������С�����ѳ��֣�����ǰ��
        	else if(str[i] == '.' && i != length - 1 && !hasPoint) {
        		hasPoint = true;
        		continue;
        	}
        	//������e/E���������������Ƿ�ȫΪ���֣����Դ������ţ�
        	else if((str[i] == 'e' || str[i] == 'E') && i != idx && i != length - 1) {
        		if((str[i + 1] == '+' || str[i + 1] == '-') && i != length - 2) i++;
        		return isWholeNum(str, i + 1);
        	}
        	else {
        		return false;
        	}
        }
        
        return true;
    }
    
    public static boolean isNum(char word) {
    	if(word >= '0' && word <= '9') return true;
    	return false;
    }
    
    //�Ƿ��idx֮��ȫ������
    public static boolean isWholeNum(char[] str, int idx) {
    	for(int i = idx; i < str.length; i++) {
    		if(!isNum(str[i])) return false;
    	}
    	return true;
    }
    
    //������ʽ��
	/*
	 * [\\+\\-]? 			-> ���򸺷��ų������
	 * \\d* 				-> ���������Ƿ���֣�d��ʾ������*��ʾ�����
	 * (\\.\\d+)? 			-> �������С���㣬��ôС���������������֣�+��ʾ���ڵ���1��
	 * ([eE][\\+\\-]?\\d+)? -> �������ָ�����֣���ôe��E�϶����֣�+��-���Բ����֣� �����ű����������
	 */
	public class Solution {
		public boolean isNumeric(char[] str) {
			String string = String.valueOf(str);
			return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
		}
	}
}
