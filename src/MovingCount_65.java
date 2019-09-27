/**
 * 
 * @author ChopinXBP
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ�
 * ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
