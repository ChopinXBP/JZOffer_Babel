/**
 * 
 * @author ChopinXBP
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * 
 */

public class SumSolution_45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(Sum_Solution(10));
			System.out.println(Sum_Solution2(10));
	}
	
	//���ö�·����ʵ�ֵݹ飬��n>0Ϊ�����벿�ֲ�ִ��
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
    
    //�����쳣�˳�ʵ�ֵݹ�
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
