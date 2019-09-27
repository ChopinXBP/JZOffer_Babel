/**
 * 
 * @author ChopinXBP
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 *
 */

/*
 * 最佳解答：思路length获得行数列数，从最大行第一列开始查找
 * 先判断行后判断列，若比target大则行数减一，若比target小则列数加一
 * 
public class Solution {
    public boolean Find(int [][] array,int target) {
		int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
*/

/*
 * 思路二：
把每一行看成有序递增的数组，
利用二分查找，
通过遍历每一行得到答案，
时间复杂度是nlogn

public class Solution {
	public boolean Find(int[][] array, int target) {

		for (int i = 0; i<array.length; i++){
			int low = 0;
			int high = array[i].length - 1;
			while (low <= high){
				int mid = (low + high) / 2;
				if (target>array[i][mid])
					low = mid + 1;
				else if (target<array[i][mid])
					high = mid - 1;
				else
					return true;
			}
		}
		return false;

	}
}
 */


public class TwoD_Array_Find_1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		boolean i = Find(5,array);
		boolean j = Find(7, array);
		boolean k = Find(16, array);
	}
	
    public static boolean Find(int target, int [][] array) {
        
    int cntx = array.length;
    int cnty = array[0].length;
    

    for(int i = 0; i<cntx ; i++){
       for(int j = 0;j<cnty ; j++){
           if(target == array[i][j])
               return true;
       }
    }
    return false;

    }

    

}
