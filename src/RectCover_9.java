/**
 * 
 * @author ChopinXBP 
 * ��n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * ˼·��쳲���������
 *
 */

public class RectCover_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Solution(5);
		System.out.println(n);
	}
	
	public static int Solution(int target){
		if(target == 0) return 0;
		int rol1 = 1;
		int rol2 = 0;
		
		while(target != 0){
			target--;
			rol1 += rol2;
			rol2 = rol1 - rol2;
		}
		
		return rol1;
	}

}
