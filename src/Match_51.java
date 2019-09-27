/**
 * 
 * @author ChopinXBP
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 *
 */

public class Match_51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'a', 'a', 'a'};
		char[] str2 = {'a', 'a', '.', 'a'};
		char[] pattern1 = {'a', '.', 'a'};
		char[] pattern2 = {'a', 'b', '*', 'a', 'c', '*', 'a'};
		char[] pattern3 = {'a', 'b', '*', 'a'};
		System.out.println(match(str, pattern1));
		System.out.println(match(str, pattern2));
		System.out.println(match(str2, pattern3));
		
		char[] str4 = new char[0];
		char[] pattern4 = {'.', '*'};
		System.out.println(match(str4, pattern4));
	}
	
    public static boolean match(char[] str, char[] pattern)
    {
    	if(str == null && pattern == null)return true;
        if(str != null && pattern == null)return false;
        
        int stridx = 0;
        int patidx = 0;
        return Solution(str, pattern, stridx, patidx);
    }

    public static boolean Solution(char[] str, char[] pattern, int stridx, int patidx) {
    	
    	int strlen = str.length;
    	int patlen = pattern.length;
    	//递归终止条件：从头到尾匹配成功
    	if(stridx == strlen && patidx == patlen) {
    		return true;
    	}
    	//pattern先到尾部，匹配失败(可以str先到尾，例如str=""，pattern={.*})
    	else if(stridx != strlen && patidx == patlen) {
    		return false;
    	}
    	//pattern下一个字符是*号
    	else if(patidx + 1 < patlen && pattern[patidx + 1] == '*') {
    		//str当前字符匹配,考虑可能是pattern当前字符出现0次或1次或多次的情况
    		if(stridx != strlen && (pattern[patidx] == '.' || str[stridx] == pattern[patidx])) {
    			return Solution(str, pattern, stridx, patidx + 2)			//出现0次
    					|| Solution(str, pattern, stridx + 1, patidx + 2)	//出现1次
    					|| Solution(str, pattern, stridx + 1, patidx);		//出现多次
    		}
    		//str当前字符不匹配，只可能是pattern当前字符出现0次的情况
    		else {
    			return Solution(str, pattern, stridx, patidx + 2);
    		}
    		
    	}
    	//pattern下一个字符不是*号,且当前字符匹配或当前字符为.号
    	else if(stridx != strlen && (pattern[patidx] == '.' || pattern[patidx] == str[stridx])) {
    		return Solution(str, pattern, stridx + 1, patidx + 1);
    	}
    	else {
    		return false;
    	}
    }
}
