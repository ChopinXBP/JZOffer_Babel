/**
 * 
 * @author ChopinXBP
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
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
    	
    	//����Ϊ2���������У�ֻ�������У�
    	if((sum & 0x01) == 1){
    		ArrayList<Integer> list = new ArrayList<>();
    		list.add(sum / 2);
    		list.add(sum / 2 + 1);
    		result.add(list);
    	}
    	
    	//���ȴ���2����������
        ArrayList<Integer> factor = new ArrayList<>();
        for(int i = 1; i < sum; i++){
        	if(sum % i == 0){
        		factor.add(i);
        	}
        }       
        for(int i = 0; i < factor.size(); i++){
        	int curfactor = factor.get(i);
        	int otherfactor = sum / curfactor;
        	//��һ������Ϊż��
        	if((otherfactor & 0x01) == 0){
        		//�������Ӿ�Ϊż�������ܹ�������
        		if((curfactor & 0x01) == 0) continue;
        		//�Ժ�Ϊcurfactor������Ϊ���ĵ����г��Ȳ��ᳬ��������
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
        	//��һ������Ϊ����
        	else{
        		//��curfactorΪ���ĵ�����г��Ȳ��ᳬ��������
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
