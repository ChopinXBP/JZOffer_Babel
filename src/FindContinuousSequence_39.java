/**
 * 
 * @author ChopinXBP
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序。
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class FindContinuousSequence_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = FindContinuousSequence(3);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}
	
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    	if(sum <= 0)return null;
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if(sum <= 2)return result;
    	
    	//长度为2个数的序列（只有奇数有）
    	if((sum & 0x01) == 1){
    		ArrayList<Integer> list = new ArrayList<>();
    		list.add(sum / 2);
    		list.add(sum / 2 + 1);
    		result.add(list);
    	}
    	
    	//长度大于2个数的序列
        ArrayList<Integer> factor = new ArrayList<>();
        for(int i = 1; i < sum; i++){
        	if(sum % i == 0){
        		factor.add(i);
        	}
        }       
        for(int i = 0; i < factor.size(); i++){
        	int curfactor = factor.get(i);
        	int otherfactor = sum / curfactor;
        	//另一个因子为偶数
        	if((otherfactor & 0x01) == 0){
        		//两个因子均为偶数不可能构成序列
        		if((curfactor & 0x01) == 0) continue;
        		//以和为curfactor的两点为中心的序列长度不会超过正数界
        		int length = otherfactor / 2 - 1;
        		int center = curfactor / 2;
        		if(center > length){
        			ArrayList<Integer> list = new ArrayList<>();
        			for(int j = center - otherfactor + 1; j <= center + otherfactor; j++){
        				list.add(j);
        			}
        			result.add(list);
        		}
        	}
        	//另一个因子为奇数
        	else{
        		//以curfactor为中心点的序列长度不会超过正数界
        		int length = otherfactor / 2;
        		if(curfactor > length){
        			ArrayList<Integer> list = new ArrayList<>();
        			for(int j = curfactor - length; j <= curfactor + length; j++){
        				list.add(j);
        			}
        			result.add(list);
        		}
        	}       	
        }
        
        Collections.sort(result, (ArrayList<Integer> list1, ArrayList<Integer> list2) -> Integer.compare(list1.get(0), list2.get(0)));
        return result;
    }

}
