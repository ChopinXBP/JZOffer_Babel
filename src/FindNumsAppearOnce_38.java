/**
 * 
 * @author ChopinXBP
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
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
        //计算所有数字的异或结果，结果必为两个单独的数异或的结果且不为0
		int xorresult = array[0];
        for(int i = 1; i < array.length; i++){
        	xorresult ^= array[i];
        }
        //找出异或二进制结果中为1的最低位
        int loc = 0;
        while(xorresult != 0){
        	if((xorresult & 0x01) == 1)break;
        	xorresult = xorresult >> 1;
        	loc ++;
        }
        //将所有数字按照这一位是否为1分为2组，每组中必定包含成对的数字且分别包含两个单独数字
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
        //对两个数组所有数字求异或的结果为其包含的单独数字
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
