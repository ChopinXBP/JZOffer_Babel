/**
 * 
 * @author ChopinXBP
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 */

public class SumSolution_45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(Sum_Solution(10));
			System.out.println(Sum_Solution2(10));
	}
	
	//利用短路特性实现递归，当n>0为假则后半部分不执行
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
    
    //利用异常退出实现递归
	public static int Sum_Solution2(int n) {
		return sum(n);
	}

	public static int sum(int n) {
		try {
			int i = 1 % n;
			return n + sum(n - 1);
		} catch (Exception e) {
			return 0;
		}
	}


}
