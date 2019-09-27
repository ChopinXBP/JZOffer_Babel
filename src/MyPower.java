/**
 * 
 * @author ChopinXBP
 *         复现库函数pow：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 思路：
 *
 */

public class MyPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = MyPow(3, 6);
		System.out.println(num);
	}

	public static double MyPow(double base, int exponent) {

		if (exponent < 0) {
			base = 1 / base;
			exponent = -exponent;
		} else if (exponent == 0) {
			return 1.0;
		} else if (exponent == 1) {
			return base;
		}

		// 优化方式：用exponent >> 1代替exponent/2，用(exponent & 0x1) == 0代替exponent%2 == 0
		if ((exponent & 0x1) == 0) {
			return MyPow(base, exponent >> 1) * MyPow(base, exponent >> 1);
		} else if ((exponent & 0x1) == 1) {
			return base * MyPow(base, exponent >> 1) * MyPow(base, exponent >> 1);
		}

		return -1; // 边界base为0,返回-1
	}

	// 注意考虑边界base为0，判断double不能用base == 0.0，要写专门的函数equal来判断
	public static boolean equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}

}
