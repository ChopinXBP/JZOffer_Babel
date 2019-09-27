/**
 * 
 * @author ChopinXBP 
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 *
 */

import java.util.Stack;

public class IsPopOrder_20 {

	public static int[] pushA = { 1, 2, 3, 4, 5 };
	public static int[] popA = { 4, 5, 2, 3, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IsPopOrder(pushA, popA));
	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		if(pushA.length == 0 || popA.length == 0)
            return false;
		
		Stack<Integer> stack = new Stack<>();
		int num = pushA.length;
		int pushflag = 0;
		int popflag = 0;
		//����ջָʾ������popA����Ϊ˵�����������Ǹ�ջ�ĵ���˳��
		while (popflag < num) {
			if(pushflag < num){
				//����Ԫ�ز�ͬʱ��������ջ
				if(pushA[pushflag] != popA[popflag]){
					stack.push(pushA[pushflag]);
				}
				//����Ԫ����ͬʱ��ģ��һ����ջ���ջ��������ָʾ��ͬʱǰ��һλ
				else{
					popflag++;
				}
			}else{
				//��ջ��Ԫ����ͬ�����ջ����ͬ�򷵻�false
				if(stack.peek() == popA[popflag]){
					stack.pop();
					popflag++;
				}
				else{
					return false;
				}
			}
			pushflag++;
		}
		return true;

	}

	//�����Ż���
	public boolean IsPopOrder2(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;
		Stack<Integer> s = new Stack<Integer>();
		// ���ڱ�ʶ�������е�λ��
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			// ���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
			while (!s.empty() && s.peek() == popA[popIndex]) {
				// ��ջ
				s.pop();
				// �����������һλ
				popIndex++;
			}
		}
		return s.empty();
	}

}
