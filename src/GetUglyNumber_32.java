/**
 * 
 * @author ChopinXBP
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 */

import java.util.LinkedList;
import java.util.TreeSet;

public class GetUglyNumber_32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetUglyNumber_Solution(1500));
	}

	public static int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        if(index <= 6) return index;	//0-6的丑数为其本身
        
        LinkedList<Integer> uglyNum = new LinkedList<>();	//丑数顺序列
        uglyNum.add(1);
        TreeSet<Integer> newugly = new TreeSet<>();	//备选新丑数序列
        newugly.add(2);
        newugly.add(3);
        newugly.add(5);
        
        //每次循环将newugly中最小的丑数加入uglyNum，并将其的2、3、5倍数放入newugly
        while(uglyNum.size() < index){ 
        	//不考虑大数，这段用来防止int的溢出，删去溢出的负数，可用long类型替代int
        	while(newugly.first() <= uglyNum.getLast()){
        		newugly.pollFirst();
    		}
        	int newuglynum = newugly.pollFirst();
        	newugly.add(newuglynum * 2);
        	newugly.add(newuglynum * 3);
        	newugly.add(newuglynum * 5);
        	uglyNum.add(newuglynum);
        }
        return uglyNum.getLast();
    }

}
