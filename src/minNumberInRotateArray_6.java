/**
 * 
 * @author ChopinXBP
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 首先我们先明确最小值必出现在分界点上。
 * 思路：二分法，注意1.相等元素，2.子序列递增有序/仍然为旋转数组，3.用子序列中点与尾点比较（比与头点）更容易实现
 *
 */

public class minNumberInRotateArray_6 {

	private static int[] test = {4,5,6,7,9,1,2,3,4,5};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = Solution(test);
		System.out.println(min);
	}

	public static int Solution(int[] array) {
		if (array.length == 0)
			return 0;

		int flag = (array.length - 1) / 2; // 标记中间元素
		int head = 0;
		int tail = array.length - 1;

		while (head != tail) {
			//中点在分隔点前
			if(array[flag] > array[tail]){
				head = flag + 1;
			}
			//中点在分隔点后
			else if(array[flag] <= array[tail]){
				//子序列非递减有序
				if(array[head] <= array[flag]){
					flag = head;
					break;
				}
				//子序列仍然为旋转数组
				else{
					tail = flag;
				}
			}
			flag = (head + tail) / 2;
		}

		return array[flag];
	}

}
