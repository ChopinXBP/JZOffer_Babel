/**
 * 
 * @author ChopinXBP 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 *
 */

public class reOrderArray_13 {

	static int[] array = {8, 3, 7, 5, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution(array);
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}
	
	public static void Solution(int[] array){
		int oddflag = 0;
		int evenflag = 0;
		
		while(evenflag < array.length){
			//奇偶flag前进到第一个偶数开始进入循环
			if((array[oddflag] & 0x01) == 0){				
				while(evenflag < array.length){
					//将下一个奇数与其之前的所有偶数进行一次冒泡
					if((array[evenflag] & 0x01) == 1){
						Swap(array, oddflag, evenflag);
						oddflag++;
					}
					evenflag++;
				}			
			}
			oddflag++;
			evenflag++;
			
		}
		
	}
	
	public static void Swap(int[]array, int i, int j){
		while(j != i){
			int tmp = array[j - 1];
			array[j - 1] = array[j];
			array[j] = tmp;
			j--;
		}
	}
	

}

//第二个思路：再创建一个数组
//class Solution{
//public:
//    void reOrderArray(vector<int> &array) {
// 
//        vector<int> array_temp;
//        vector<int>::iterator ib1, ie1;
//        ib1 = array.begin();
// 
// 
//        for (; ib1 != array.end();){            //遇见偶数，就保存到新数组，同时从原数组中删除
//            if (*ib1 % 2 == 0) {
//                array_temp.push_back(*ib1);
//                ib1 = array.erase(ib1);
//            }
//            else{
//                ib1++;
//            }
// 
//        }
//        vector<int>::iterator ib2, ie2;
//        ib2 = array_temp.begin();
//        ie2 = array_temp.end();
// 
//        for (; ib2 != ie2; ib2++)             //将新数组的数添加到老数组
//        {
//            array.push_back(*ib2);
//        }
//    }
//};