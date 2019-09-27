/**
 * 
 * @author ChopinXBP
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 * ������������ȷ��Сֵ�س����ڷֽ���ϡ�
 * ˼·�����ַ���ע��1.���Ԫ�أ�2.�����е�������/��ȻΪ��ת���飬3.���������е���β��Ƚϣ�����ͷ�㣩������ʵ��
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

		int flag = (array.length - 1) / 2; // ����м�Ԫ��
		int head = 0;
		int tail = array.length - 1;

		while (head != tail) {
			//�е��ڷָ���ǰ
			if(array[flag] > array[tail]){
				head = flag + 1;
			}
			//�е��ڷָ����
			else if(array[flag] <= array[tail]){
				//�����зǵݼ�����
				if(array[head] <= array[flag]){
					flag = head;
					break;
				}
				//��������ȻΪ��ת����
				else{
					tail = flag;
				}
			}
			flag = (head + tail) / 2;
		}

		return array[flag];
	}

}
