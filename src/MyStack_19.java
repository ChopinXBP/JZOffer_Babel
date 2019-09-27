/**
 * 
 * @author ChopinXBP
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 */

import java.util.Stack;

public class MyStack_19 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class MyStack {
	    
		Stack<Integer> mystack = new Stack<Integer>();;
		Stack<Integer> minstack = new Stack<Integer>();;
		int min;
		
	    public void push(int node) {
	        if(mystack.isEmpty()){
	        	min = node;
	        }else{
	        	if(node < min) min = node;
	        }
	        mystack.push(node);
	        minstack.push(min);
	    }
	    
	    public void pop() {
	        if(!mystack.isEmpty()){
	        	minstack.pop();
	        	mystack.pop();
	        }
	        if(!minstack.isEmpty()){
	        	min = this.min();
	        }
	    }
	    
	    public int top() {
	        return mystack.peek();
	    }
	    
	    public int min() {
	        return minstack.peek();
	    }
	}
}
