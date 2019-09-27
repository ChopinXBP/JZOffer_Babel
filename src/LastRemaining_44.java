/**
 * 
 * @author ChopinXBP
 * 0，1，……，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 * 删除后，从被删除数字的下一个数字开始不断重复删除第m个数字，求这个圆圈里剩下的最后一个数字。
 *
 */

import java.util.LinkedList;

public class LastRemaining_44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LastRemaining_Solution(5, 6));
		System.out.println(LastRemaining_Solution2(5, 6));
		System.out.println(LastRemaining_Solution3(5, 6));
	}

	//模拟游戏验证
	public static int LastRemaining_Solution(int n, int m) {
		if (m <= 0 || n <= 0) return -1;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		int loc = 0;
		while (list.size() > 1) {
			loc = (loc + m - 1) % list.size();
			System.out.println(list.get(loc));
			list.remove(loc);
		}

		return list.get(0);
	}

	
	//递推公式推导（循环法）
	public static int LastRemaining_Solution2(int n, int m) {
		if (m <= 0 || n <= 0) return -1;
		
		int result = 0;
		for(int i = 2; i <= n; i++) {
			result = (result + m) % i;
		}
		
		return result;
	}
	
	//递推公式推导（递归法）
	public static int LastRemaining_Solution3(int n, int m) {
		if (m <= 0 || n <= 0) return -1;
		
		if(n == 1) {
			return 0;
		}else {
			return (LastRemaining_Solution3(n - 1, m) + m) % n;
		}
	}
}
