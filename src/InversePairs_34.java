/**
 * 
 * @author ChopinXBP
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 */



public class InversePairs_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {7, 5, 6, 4};
		int[] array = {1,2,3,4,5,6,7,0};
		System.out.println(InversePairs(array));
	}
	
	//模拟归并排序操作，复杂度o（nlogn）
    public static int InversePairs(int [] array) {
    	if(array == null) return -1;
    	
    	int head = 0;
    	int tail = array.length - 1;
    	int[] copy = new int[array.length];		//记录归并排序后的数组
    	
    	int count = Solution(array, copy, head, tail);
    	
    	return count;
    }
    
    public static int Solution(int[] array, int[] copy, int head, int tail){
    	if(head == tail){
    		copy[head] = array[head];
    		return 0;
    	}
    	
    	int lefttail = (head + tail) / 2;			//左半部分尾指针
    	int righthead = lefttail + 1;				//右半部分头指针
    	int righttail = tail;						//右半部分尾指针
    	
    	int leftcount = Solution(array, copy, head, lefttail) % 1000000007;
    	int rightcount = Solution(array, copy, righthead, tail) % 1000000007;
    	
    	//将左半部分尾指针对应值依次与右半部分尾指针对应值进行比较，若lefttail对应值大于righttail对应值，则存在（righttail - righthead + 1）个逆序对
    	//计算过程中依次将尾指针对应值比较较大者自右向左依次放入整段copy和原序列中，使其排成一段递增排序序列。
    	int midcount = 0;
    	int indexCopy = tail;
    	while(lefttail >= head && righttail >= righthead){
    		if(array[lefttail] > array[righttail]){
    			midcount += righttail - righthead + 1;
    			copy[indexCopy--] = array[lefttail--];
    			if(midcount >= 1000000007) midcount %= 1000000007;			//防止数值过大先求余
    		}else{
    			copy[indexCopy--] = array[righttail--];
    		}
    	}
    	
    	while(lefttail >= head){
    		copy[indexCopy--] = array[lefttail--]; 
    	}
    	while(righttail >= righthead){
    		copy[indexCopy--] = array[righttail--];
    	}
    	for(int i = head; i <= tail; i++){
    		array[i] = copy[i];
    	}
    	
    	return (leftcount + rightcount + midcount) % 1000000007;
    }

}
