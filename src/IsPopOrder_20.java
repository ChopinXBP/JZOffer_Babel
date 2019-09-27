/**
 * 
 * @author ChopinXBP 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
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
		//若出栈指示器走完popA，则为说明弹出序列是该栈的弹出顺序。
		while (popflag < num) {
			if(pushflag < num){
				//序列元素不同时，持续入栈
				if(pushA[pushflag] != popA[popflag]){
					stack.push(pushA[pushflag]);
				}
				//序列元素相同时，模拟一次入栈后出栈，即两个指示器同时前进一位
				else{
					popflag++;
				}
			}else{
				//若栈顶元素相同，则出栈，不同则返回false
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

	//代码优化版
	public boolean IsPopOrder2(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;
		Stack<Integer> s = new Stack<Integer>();
		// 用于标识弹出序列的位置
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			// 如果栈不为空，且栈顶元素等于弹出序列
			while (!s.empty() && s.peek() == popA[popIndex]) {
				// 出栈
				s.pop();
				// 弹出序列向后一位
				popIndex++;
			}
		}
		return s.empty();
	}

}
