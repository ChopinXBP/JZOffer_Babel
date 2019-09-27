/**
 * 
 * @author ChopinXBP 
 * 给一个数组，返回它的最大连续子序列的和。
 *
 */

public class FindGreatestSumOfSubArray_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {6,-3,-2,7,-15,1,2,2};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
	//动态规划/在线处理算法
    public static int FindGreatestSumOfSubArray(int[] array) {
    	if(array == null)return 0;
    	if(array.length == 0)return array[0];
    	
        int max = array[0];			//积累值
        int result = array[0];		//最终结果
        for(int i = 1; i < array.length; i++){
        	max += array[i];
        	if(max > result) result = max;	//当积累值大于结果值则更新结果
        	if(max < 0) max = 0;			//当和为负数抛弃之前积累结果
        }
        return result;
    }

}
