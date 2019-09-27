/**
 * 
 * @author ChopinXBP
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
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
		char[] str10 = {'1', '.', '1', 'e', '+', '1', '6'};	//科学计数法前可以有小数点
		char[] str11 = {'.', '1', 'e', '+', '1', '6'};		//小数点前可以没有数字
		char[] str12 = {'1', '.'};							//小数点不能结尾
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

	//分类方法
    public static boolean isNumeric(char[] str) {
        if(str == null)return false;
        int length = str.length;
        //只有一位非数字返回false
        if(length == 1 && !isNum(str[0])) return false;
        
        int idx = 0;
        //跳过起始的正负号
        if(str[0] == '+' || str[0] == '-') idx++;
        
        boolean hasPoint = false;	//记录是否出现过小数点
        for(int i = idx; i < length; i++) {
        	//若该位是数字，继续前进
        	if(isNum(str[i])) {
        		continue;
        	}
        	//若第一次出现小数点（可以在起始不能在末尾），标记小数点已出现，继续前进
        	else if(str[i] == '.' && i != length - 1 && !hasPoint) {
        		hasPoint = true;
        		continue;
        	}
        	//若出现e/E，则检查其余数字是否全为数字（可以带正负号）
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
    
    //是否从idx之后全是数字
    public static boolean isWholeNum(char[] str, int idx) {
    	for(int i = idx; i < str.length; i++) {
    		if(!isNum(str[i])) return false;
    	}
    	return true;
    }
    
    //正则表达式法
	/*
	 * [\\+\\-]? 			-> 正或负符号出现与否
	 * \\d* 				-> 整数部分是否出现，d表示整数，*表示任意次
	 * (\\.\\d+)? 			-> 如果出现小数点，那么小数点后面必须有数字，+表示大于等于1次
	 * ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现， 紧接着必须跟着整数
	 */
	public class Solution {
		public boolean isNumeric(char[] str) {
			String string = String.valueOf(str);
			return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
		}
	}
}
