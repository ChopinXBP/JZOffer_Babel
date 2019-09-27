/**
 * 
 * @author ChopinXBP
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s���п���ֵ���ֵĸ���
 * 
 */

public class PrintProbability_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 6;
		int[] result = PrintProbability(6);
		int[] result2 = PrintProbability1(6);
		for (int i = 0; i <= number * 6 - number; i++) {
			System.out.println("i: " + i + " count: " + result[i]);
		}
		System.out.println("  ");
		for (int i = number; i <= number * 6; i++) {
			System.out.println("i: " + i + " count: " + result2[i]);
		}
		System.out.println("  ");

	}


	//����һ���ݹ鷨
	public static int[] PrintProbability(int number) {
		int[] result = new int[number * 6 - number + 1];		
		for (int i = 1; i <= 6; i++) {
			probability(number, number, i, result);
		}		
		return result;
	}
	//�����ӷ�Ϊ���ѣ�a����1����b����idx-1��
	public static void probability(int number, int idx, int sum, int[] result) {
		//������ֻʣһ��ʱ����������ͽ��м�¼
		if (idx == 1) {
			result[sum - number]++;
		}
		else {
			//��a�ѵ����ӵ���1-6����b�ѵ����е����͡�
			for (int i = 1; i <= 6; i++) {
				probability(number, idx - 1, sum + i, result);
			}
		}
	}
	
	
	//��������ѭ����
	public static int[] PrintProbability1(int number) {

		int[] result = new int[6 * number];
		
		// ��һ����������
		for (int i = 1; i <= 6; i++) {
			result[i] = 1;
		}
		
		for(int i = 2; i <= number; i++) {
			int[] temp = new int[6 * number + 1];
			// i���ӵĳ��ִ���j����֮ǰ����Ϊj-k(k=1-6)�Ĵ����ܺ͡�k���ܴ���j
			for(int j = i; j <= 6 * i; j++) {
				for(int k = 1; k <= j && k <= 6; k++) {
					temp[j] += result[j - k];
				}
			}
			result = temp;
		}

		return result;
	}
}
