/**
 * 
 * @author ChopinXBP 
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * 
 *
 */
public class JumpFloor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = Solve(5);
		System.out.println(num);
	}

	//������ѧ���ɷ�֤����f(n) = 2 ^ (n - 1)
	public static int Solve(int target) {

		return (int)Math.pow(2, target - 1);
	}

	//C++ʵ�ֲο���λ���㣩
//	class Solution {
//	public:
//		int jumpFloorII(int number) {
//			return  1<<--number;
//		}
//	};

}
