/**
 * 
 * @author ChopinXBP
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s所有可能值出现的概率
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


	//方法一：递归法
	public static int[] PrintProbability(int number) {
		int[] result = new int[number * 6 - number + 1];		
		for (int i = 1; i <= 6; i++) {
			probability(number, number, i, result);
		}		
		return result;
	}
	//将骰子分为两堆，a堆有1个，b堆有idx-1个
	public static void probability(int number, int idx, int sum, int[] result) {
		//当骰子只剩一个时，将其点数和进行记录
		if (idx == 1) {
			result[sum - number]++;
		}
		else {
			//将a堆的骰子点数1-6加至b堆的所有点数和。
			for (int i = 1; i <= 6; i++) {
				probability(number, idx - 1, sum + i, result);
			}
		}
	}
	
	
	//方法二：循环法
	public static int[] PrintProbability1(int number) {

		int[] result = new int[6 * number];
		
		// 第一次抛掷骰子
		for (int i = 1; i <= 6; i++) {
			result[i] = 1;
		}
		
		for(int i = 2; i <= number; i++) {
			int[] temp = new int[6 * number + 1];
			// i骰子的出现次数j等于之前次数为j-k(k=1-6)的次数总和。k不能大于j
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
