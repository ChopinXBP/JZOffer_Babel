/**
 * 
 * @author ChopinXBP
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 * ����������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 *
 */

/*
 * ��ѽ��˼·length�������������������е�һ�п�ʼ����
 * ���ж��к��ж��У�����target����������һ������targetС��������һ
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
 * ˼·����
��ÿһ�п���������������飬
���ö��ֲ��ң�
ͨ������ÿһ�еõ��𰸣�
ʱ�临�Ӷ���nlogn

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
