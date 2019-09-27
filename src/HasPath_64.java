/**
 * 
 * @author ChopinXBP
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ�
 * ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 *
 */


public class HasPath_64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
		char[] str = {'A','B','C','B'};
		System.out.println(hasPath(matrix, 3, 4, str));
	}

	
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	if(matrix == null || str == null || str.length == 0)return false;
    	int length = matrix.length;
    	if(matrix.length == 0 || rows * cols != length || str.length > length)return false;
    	
    	boolean[] ispass = new boolean[length];
    	for(int i = 0; i < length; i++) {
    		if(Solution(i, 0, matrix, cols, str, ispass)) return true;
    	}
    	return false;
    }

    public static boolean Solution(int idx, int loc, char[] matrix, int cols, char[] str, boolean[] ispass){		    	
    	if(idx < 0 || idx >= matrix.length || matrix[idx] != str[loc] || ispass[idx]) return false;		
    	if(loc == str.length - 1)return true;
    	
    	ispass[idx] = true;
		
    	if(Solution(idx - 1, loc + 1, matrix, cols, str, ispass)
    			|| Solution(idx + 1, loc + 1, matrix, cols, str, ispass)
    			|| Solution(idx - cols, loc + 1, matrix, cols, str, ispass)
    			|| Solution(idx + cols, loc + 1, matrix, cols, str, ispass))
    		return true;
    	
    	ispass[idx] = false;	//����־λ�ָ�
    	return false;
    }
    
}
