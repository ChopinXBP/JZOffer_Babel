/**
 * 
 * @author ChopinXBP
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ�䡣
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
    	//�ݹ���ֹ��������ͷ��βƥ��ɹ�
    	if(stridx == strlen && patidx == patlen) {
    		return true;
    	}
    	//pattern�ȵ�β����ƥ��ʧ��(����str�ȵ�β������str=""��pattern={.*})
    	else if(stridx != strlen && patidx == patlen) {
    		return false;
    	}
    	//pattern��һ���ַ���*��
    	else if(patidx + 1 < patlen && pattern[patidx + 1] == '*') {
    		//str��ǰ�ַ�ƥ��,���ǿ�����pattern��ǰ�ַ�����0�λ�1�λ��ε����
    		if(stridx != strlen && (pattern[patidx] == '.' || str[stridx] == pattern[patidx])) {
    			return Solution(str, pattern, stridx, patidx + 2)			//����0��
    					|| Solution(str, pattern, stridx + 1, patidx + 2)	//����1��
    					|| Solution(str, pattern, stridx + 1, patidx);		//���ֶ��
    		}
    		//str��ǰ�ַ���ƥ�䣬ֻ������pattern��ǰ�ַ�����0�ε����
    		else {
    			return Solution(str, pattern, stridx, patidx + 2);
    		}
    		
    	}
    	//pattern��һ���ַ�����*��,�ҵ�ǰ�ַ�ƥ���ǰ�ַ�Ϊ.��
    	else if(stridx != strlen && (pattern[patidx] == '.' || pattern[patidx] == str[stridx])) {
    		return Solution(str, pattern, stridx + 1, patidx + 1);
    	}
    	else {
    		return false;
    	}
    }
}
