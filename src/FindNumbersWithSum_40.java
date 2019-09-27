
/**
 * 
 * @author ChopinXBP
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S。
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 */

import java.util.ArrayList;

public class FindNumbersWithSum_40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 4, 5, 7, 8, 15 };
		ArrayList<Integer> result = FindNumbersWithSum(array, 13);
		System.out.println(result.get(0) + " " + result.get(1));
	}

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		if (array == null)
			return null;

		ArrayList<Integer> result = new ArrayList<>(2);
		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			int num1 = array[left];
			int num2 = array[right];
			if (num1 + num2 == sum) {
				result.add(num1);
				result.add(num2);
                break;
			} else if (num1 + num2 < sum) {
				left++;
			} else if (num1 + num2 > sum) {
				right--;
			}
		}

		return result;

	}
}
