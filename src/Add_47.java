/**
 * 
 * @author ChopinXBP
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 */

public class Add_47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Add(2, 3));
	}
	
	//x^y执行加法,(x&y)<<1进位操作
	//x+y = x^y + (x&y)<<1
    public static int Add(int num1,int num2) {
    	int loc = num1 ^ num2;				//相加数位值
    	int bit = (num1 & num2) << 1;		//进位值
    	while(bit != 0) {
    		int carrybit = (loc & bit) << 1;
    		loc = loc ^ bit;
    		bit = carrybit;
    	}
    	return loc;
    }

}
