/**
 * 
 * @author ChopinXBP
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
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
    	
    	ispass[idx] = false;	//将标志位恢复
    	return false;
    }
    
}
