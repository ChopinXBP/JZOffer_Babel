/**
 * 
 * @author ChopinXBP
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 * ���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
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
	
	//����Hashmap
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

    //������Ŀ����:�������ֶ���1-length��Χ��
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
