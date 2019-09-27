/**
 * 
 * @author ChopinXBP 
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
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
			//��żflagǰ������һ��ż����ʼ����ѭ��
			if((array[oddflag] & 0x01) == 0){				
				while(evenflag < array.length){
					//����һ����������֮ǰ������ż������һ��ð��
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

//�ڶ���˼·���ٴ���һ������
//class Solution{
//public:
//    void reOrderArray(vector<int> &array) {
// 
//        vector<int> array_temp;
//        vector<int>::iterator ib1, ie1;
//        ib1 = array.begin();
// 
// 
//        for (; ib1 != array.end();){            //����ż�����ͱ��浽�����飬ͬʱ��ԭ������ɾ��
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
//        for (; ib2 != ie2; ib2++)             //�������������ӵ�������
//        {
//            array.push_back(*ib2);
//        }
//    }
//};