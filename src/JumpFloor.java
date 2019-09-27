/**
 * 
 * @author ChopinXBP 
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * 
 *
 */
public class JumpFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = Solve(5);
		int num2 = Solve2(5);
		System.out.println(num);
		System.out.println(num2);
	}

	//����������������ˣ���Ч�ʼ���
	public static int Solve(int target) {
		if (target < 3)
			return target;

		return Solve(target - 1) + Solve(target - 2);
	}

	// ��ѽ��ѭ��˳�Ʒ�
	public static int Solve2(int target) {

		if (target == 1 || target == 2) {
			return target;
		}

		// ��һ�׺͵ڶ��׿��ǹ��ˣ���ʼ��ǰ̨��Ϊ�����ף�������
		// ˼·����ǰ̨�׵���������=��ǰ̨�׺���һ�׵�̨�׵���������+��ǰ̨�׺��˶��׵�̨�׵���������

		int jumpSum = 0;// ��ǰ̨�׵���������
		int jumpSumBackStep1 = 2;// ��ǰ̨�׺���һ�׵�̨�׵���������(��ʼֵ��ǰ̨���ǵ�3��)
		int jumpSumBackStep2 = 1;// ��ǰ̨�׺��˶��׵�̨�׵���������(��ʼֵ��ǰ̨���ǵ�3��)

		for (int i = 3; i <= target; i++) {

			jumpSum = jumpSumBackStep1 + jumpSumBackStep2;
			jumpSumBackStep2 = jumpSumBackStep1;// ����һ������һ�ε�����Ϊ��������
			jumpSumBackStep1 = jumpSum; // ��ǰ̨������һ�ε�����Ϊ����һ��

		}

		return jumpSum;

	}
}
