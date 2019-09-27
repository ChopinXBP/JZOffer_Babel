
/**
 * 
 * @author ChopinXBP
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：注意出栈之前若栈1仍有元素，需要把栈1的元素先全部压入栈2，再依次弹出。
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
		// 可换成isEmpty()
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
