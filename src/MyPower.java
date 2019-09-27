/**
 * 
 * @author ChopinXBP
 *         ���ֿ⺯��pow������һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η��� ˼·��
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

		// �Ż���ʽ����exponent >> 1����exponent/2����(exponent & 0x1) == 0����exponent%2 == 0
		if ((exponent & 0x1) == 0) {
			return MyPow(base, exponent >> 1) * MyPow(base, exponent >> 1);
		} else if ((exponent & 0x1) == 1) {
			return base * MyPow(base, exponent >> 1) * MyPow(base, exponent >> 1);
		}

		return -1; // �߽�baseΪ0,����-1
	}

	// ע�⿼�Ǳ߽�baseΪ0���ж�double������base == 0.0��Ҫдר�ŵĺ���equal���ж�
	public static boolean equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}

}
