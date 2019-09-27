/**
 * 
 * @author ChopinXBP
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 
 */

import java.util.HashMap;

public class Duplicate_49 {

	public static int duplication[] = {0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {2,3,1,0,2,5,3};
		int length = 7;
		System.out.println(duplicate(numbers, length, duplication));
		System.out.println(duplicate2(numbers, length, duplication));
	}
	
	//利用Hashmap
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length <= 0 || numbers == null)return false;
        
        HashMap<Integer, Boolean> nums = new HashMap<>();
        for(int i = 0; i < length; i++) {
        	if(nums.containsKey(numbers[i])) {
        		duplication[0] = numbers[i];
        		return true;
        	}else {
        		nums.put(numbers[i], false);
        	}
        }
        
        return false;
    }

    //利用题目条件:所有数字都在1-length范围内
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(length <= 0 || numbers == null)return false;
        
        boolean[] judge = new boolean[length];
        for(int i = 0; i < length; i++) {
        	if(judge[numbers[i]] == true) {
        		duplication[0] = numbers[i];
        		return true;
        	}else {
        		judge[numbers[i]] = true;
        	}
        }
        
        return false;
    }
}
