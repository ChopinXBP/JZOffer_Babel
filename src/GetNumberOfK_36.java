/**
 * 
 * @author ChopinXBP
 * ͳ��һ�����������������г��ֵĴ�����
 *
 */

public class GetNumberOfK_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {3, 3, 3, 3, 4, 5};
		System.out.println(GetNumberOfK1(array, 3));	
		System.out.println(GetNumberOfK2(array, 6));	
	}

	//����һ��ƽ�����Ӷ�o(n)�������ҵ�ĳһ��K��λ�ã��Ӹ�λ������ǰ���ֱ��������͡���K��������ʱ���á�
	public static int GetNumberOfK1(int [] array , int k) {
	    if(array == null || array.length == 0) return 0;
	    
		int location = array.length >> 1;
		int begin = 0;
		int end = array.length - 1;
		while(begin != end){
			if(array[location] == k)
				break;
			else if(array[location] < k)
				begin = location + 1;
			else if(array[location] > k)
				end = location - 1;
			
			location = (begin + end) >> 1;
		}
				
		int count = 0;
		int p = location - 1;
		while(p >= 0 && array[p--] == k) count++;
		while(location < array.length && array[location++] == k)count++;
		
		return count;
    }
	
	//�����������Ӷ�o(logn)���ҵ�ĳһ��K��ʼ�ͽ���λ�ã������м�K�ĸ�������K�����϶�ʱ����
		public static int GetNumberOfK2(int [] array , int k) {
		    if(array == null || array.length == 0) return 0;
		    
		    //���K��ʼλ��
			int location1 = array.length >> 1;
			int begin = 0;
			int end = array.length - 1;
			while(begin <= end){
				if(array[location1] < k)
					begin = location1 + 1;
				else
					end = location1 - 1;
				
				location1 = (begin + end) >> 1;
			}
			location1++;	//ԭ�㷨���ص��ǵ�һ��K��ǰһ��λ��
			
			//���K����λ��
			int location2 = array.length >> 1;
			begin = 0;
			end = array.length - 1;
			while(begin <= end){
				if(array[location2] <= k)
					begin = location2 + 1;
				else
					end = location2 - 1;
				
				location2 = (begin + end) >> 1;
			}
								
			return location2 - location1 + 1;
	    }
}
