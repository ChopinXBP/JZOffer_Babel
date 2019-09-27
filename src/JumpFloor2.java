/**
 * 
 * @author ChopinXBP 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 *
 */
public class JumpFloor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = Solve(5);
		System.out.println(num);
	}

	//可用数学归纳法证明，f(n) = 2 ^ (n - 1)
	public static int Solve(int target) {

		return (int)Math.pow(2, target - 1);
	}

	//C++实现参考（位运算）
//	class Solution {
//	public:
//		int jumpFloorII(int number) {
//			return  1<<--number;
//		}
//	};

}
