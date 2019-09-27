/**
 * 
 * @author ChopinXBP
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1]��
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 *
 */

public class Multiply_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3};
		int[] result = multiply(input);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
    public static int[] multiply(int[] A) {
    	if(A == null || A.length == 0)return null;
    	int length = A.length;
    	
    	int[] resultup = new int[length];		//����������
    	int[] resultdown = new int[length];		//����������
    	
    	//����������
    	resultup[length - 1] = 1;
    	int num = length - 1;
    	for(int i = length - 2; i >= 0; i--) {
    		resultup[i] = resultup[i + 1] * A[num--];
    	}
    	
    	//����������
    	resultdown[0] = 1;
    	num = 0;
    	for(int i = 1; i < length; i++) {
    		resultdown[i] = resultdown[i - 1] * A[num++];
    	}
    	
    	//�ϲ�����
    	for(int i = 0; i < length; i++) {
    		resultup[i] = resultup[i] * resultdown[i];
    	}
    	
    	return resultup;
    }
}
