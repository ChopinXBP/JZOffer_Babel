/**
 * 
 * @author ChopinXBP 
 * 用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：斐波那契数列
 *
 */

public class RectCover_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Solution(5);
		System.out.println(n);
	}
	
	public static int Solution(int target){
		if(target == 0) return 0;
		int rol1 = 1;
		int rol2 = 0;
		
		while(target != 0){
			target--;
			rol1 += rol2;
			rol2 = rol1 - rol2;
		}
		
		return rol1;
	}

}
