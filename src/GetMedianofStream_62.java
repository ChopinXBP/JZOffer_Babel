/**
 * 
 * @author ChopinXBP
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianofStream_62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private PriorityQueue <Integer> minheap = new PriorityQueue <>();
	private PriorityQueue<Integer> maxheap = new PriorityQueue<>(15, new Comparator<Integer>() {
		@Override
		//反转为最大堆
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});
	private int count = 0;
	
	//所有大于等于中位数的数据放在最小堆，所有小于中位数的数据放在最大堆
    public void Insert(Integer num) {
    	count++;
    	//当数据总数为奇数时，数据先进入最大堆筛选,最大堆顶部元素进入最小堆
    	if((count & 0x01) == 1) {
    		maxheap.add(num);
    		minheap.add(maxheap.poll());
    	}
    	//当数据总数为偶数时，数据先进入最小堆筛选,最小堆顶部元素进入最大堆
    	else {
    		minheap.add(num);
    		maxheap.add(minheap.poll());
    	}
    }

    public Double GetMedian() {
    	//数据为偶数时，最小堆和最大堆顶部为中位数
    	if((count & 0x01) == 0) {
    		return new Double((minheap.peek() + maxheap.peek())) / 2;
    	}
    	//数据为奇数时，最小堆顶部为中位数
    	else {
    		return new Double(minheap.peek());
    	}
    }
}
