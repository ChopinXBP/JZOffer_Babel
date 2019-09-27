/**
 * 
 * @author ChopinXBP
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 */

public class MovingCount_65 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(movingCount(3, 2, 2));
	}

	public static int result;
	
    public static int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <= 0) return 0;
        result = 0;
        boolean[][] ispass = new boolean[rows][cols]; 
        Solution(0, 0, threshold, rows, cols, ispass);
        return result;
    }
    
    public static void Solution(int x, int y, int threshold, int rows, int cols, boolean[][] ispass) {
    	if(x < 0 || x >= rows || y < 0 || y >= cols || ispass[x][y])return;
    	if(threshold < Sum(x, y)) return;
    	result++;
    	ispass[x][y] = true;
    	Solution(x - 1, y, threshold, rows, cols, ispass);
    	Solution(x + 1, y, threshold, rows, cols, ispass);
    	Solution(x, y - 1, threshold, rows, cols, ispass);
    	Solution(x, y + 1, threshold, rows, cols, ispass);
    }
    
    public static int Sum(int x, int y) {
    	int result = 0;
    	while(x != 0) {
    		result += x % 10;
    		x /= 10;
    	}
    	while(y != 0) {
    		result += y % 10;
    		y /= 10;
    	}
    	return result;
    }
}
