/**
 * 
 * @author ChopinXBP
 * 统计一个数字在排序数组中出现的次数。
 *
 */

public class GetNumberOfK_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {3, 3, 3, 3, 4, 5};
		System.out.println(GetNumberOfK1(array, 3));	
		System.out.println(GetNumberOfK2(array, 6));	
	}

	//方法一：平均复杂度o(n)。二分找到某一个K的位置，从该位置起向前向后分别计数后求和。对K数量较少时好用。
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
	
	//方法二：复杂度o(logn)，找到某一个K起始和结束位置，计算中间K的个数，对K数量较多时好用
		public static int GetNumberOfK2(int [] array , int k) {
		    if(array == null || array.length == 0) return 0;
		    
		    //获得K起始位置
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
			location1++;	//原算法返回的是第一个K的前一个位置
			
			//获得K结束位置
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
