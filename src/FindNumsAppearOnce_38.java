/**
 * 
 * @author ChopinXBP
 * һ�����������������������֮�⣬���������ֶ�������ż���Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * 
 */


import java.util.ArrayList;
public class FindNumsAppearOnce_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {2, 4, 3, 6, 3, 2, 5, 5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
	}
	
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if(array == null || num1 == null || num2 == null)return;
        //�����������ֵ�������������Ϊ���������������Ľ���Ҳ�Ϊ0
		int xorresult = array[0];
        for(int i = 1; i < array.length; i++){
        	xorresult ^= array[i];
        }
        //�ҳ��������ƽ����Ϊ1�����λ
        int loc = 0;
        while(xorresult != 0){
        	if((xorresult & 0x01) == 1)break;
        	xorresult = xorresult >> 1;
        	loc ++;
        }
        //���������ְ�����һλ�Ƿ�Ϊ1��Ϊ2�飬ÿ���бض������ɶԵ������ҷֱ����������������
        int num = 1;
        while(loc > 0){
        	num = num << 1;
        	loc--;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
        	if((array[i] & num) == 0){
        		list1.add(array[i]);
        	}else{
        		list2.add(array[i]);
        	}
        }
        //�����������������������Ľ��Ϊ������ĵ�������
        xorresult = list1.get(0);
        for(int i = 1; i < list1.size(); i++){
        	xorresult ^= list1.get(i);
        }
        num1[0] = xorresult;
        xorresult = list2.get(0);
        for(int i = 1; i < list2.size(); i++){
        	xorresult ^= list2.get(i);
        }
        num2[0] = xorresult;      
    }

}
