/**
 * 
 * @author ChopinXBP 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *         思路：Integer.toBinaryString(n)转为字符串判断
 *
 */

public class NumberOf1_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Solve(-5);
		System.out.println(n);
	}

	// -------------投机取巧的解法：转换为字符串---------------------//
	public static int Solve(int n) {

		int result = 0;
		String binstr = Integer.toBinaryString(n);
		System.out.println(binstr);

		for (int i = 0; i < binstr.length(); i++) {
			if (binstr.charAt(i) == '1')
				result++;
		}

		return result;
	}

	// -------------可能陷入死循环的解法：从右向左移---------------------//
	// 从n的2进制形式的最右边开始判断是不是1,该解法如果输入时负数会陷入死循环，因为负数右移时，在最高位补得是1,最后会补成0xFFFFFFFF。 

	public static int NumberOf1_CanNotUse(int n) {
		int count = 0;
		while (n != 0) {
			// 用1和n进行位与运算，结果要是为1则n的2进制形式.最右边那位肯定是1，否则为0
			if ((n & 1) == 1) {
				count++;
			}
			// 把n的2进制形式往右推一位
			n = n >> 1;
		}
		return count;
	}

	// --------------------正解：从左向右移---------------------------//
	// 思想：用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数

	private static int NumberOf1_low(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	// ---------------------------最优解----------------------------//
	// 思想：把一个整数减去1，再和原整数做与运算，会把整数最右边的一个1变成0。
	// 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。

	public static int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}

}
