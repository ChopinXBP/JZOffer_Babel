/**
 * 
 * @author ChopinXBP 
 * ��һ�����飬��������������������еĺ͡�
 *
 */

public class FindGreatestSumOfSubArray_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {6,-3,-2,7,-15,1,2,2};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
	//��̬�滮/���ߴ����㷨
    public static int FindGreatestSumOfSubArray(int[] array) {
    	if(array == null)return 0;
    	if(array.length == 0)return array[0];
    	
        int max = array[0];			//����ֵ
        int result = array[0];		//���ս��
        for(int i = 1; i < array.length; i++){
        	max += array[i];
        	if(max > result) result = max;	//������ֵ���ڽ��ֵ����½��
        	if(max < 0) max = 0;			//����Ϊ��������֮ǰ���۽��
        }
        return result;
    }

}
