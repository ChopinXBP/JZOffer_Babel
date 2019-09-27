
/**
 * 
 * @author ChopinXBP
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *
 * ˼·��ע���ջ֮ǰ��ջ1����Ԫ�أ���Ҫ��ջ1��Ԫ����ȫ��ѹ��ջ2�������ε�����
 *
 */

import java.util.Stack;

public class TwoStack2Queue {

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void push(int node) {
		if (stack1.size() != stack1.capacity()) {
			stack1.push(node);
		}
	}

	public static int pop() {
		// �ɻ���isEmpty()
		if (stack2.size() != 0) {
			return stack2.pop();
		} else if (stack2.size() == 0 && stack1.size() != 0) {
			while (stack1.size() != 0) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
		return -1;
	}
}
