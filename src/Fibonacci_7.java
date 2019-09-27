/**
 * 
 * @author ChopinXBP 要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 
 *
 */

public class Fibonacci_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Fibonacci(5);
		System.out.println(n);
	}

	public static int Fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1 || n == 2)
			return 1;

		int num1 = 1;
		int num2 = 2;
		int sum = 2;

		for (int i = 0; i < n - 3; i++) {
			sum = num1 + num2;

			if (i % 2 == 0) {
				num1 += num2;
			} else if (i % 2 == 1) {
				num2 += num1;
			}
		}

		return sum;
	}

}

//C++动态规划版

//class Solution {
//public: 
//	int Fibonacci(int n) { 
//		int f = 0, g = 1; 
//		while(n--){ 
//			g += f;
//			f = g - f; 
//		} 
//	return f;
//	}
//};

