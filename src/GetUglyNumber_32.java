/**
 * 
 * @author ChopinXBP
 * ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *
 */

import java.util.LinkedList;
import java.util.TreeSet;

public class GetUglyNumber_32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetUglyNumber_Solution(1500));
	}

	public static int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        if(index <= 6) return index;	//0-6�ĳ���Ϊ�䱾��
        
        LinkedList<Integer> uglyNum = new LinkedList<>();	//����˳����
        uglyNum.add(1);
        TreeSet<Integer> newugly = new TreeSet<>();	//��ѡ�³�������
        newugly.add(2);
        newugly.add(3);
        newugly.add(5);
        
        //ÿ��ѭ����newugly����С�ĳ�������uglyNum���������2��3��5��������newugly
        while(uglyNum.size() < index){ 
        	//�����Ǵ��������������ֹint�������ɾȥ����ĸ���������long�������int
        	while(newugly.first() <= uglyNum.getLast()){
        		newugly.pollFirst();
    		}
        	int newuglynum = newugly.pollFirst();
        	newugly.add(newuglynum * 2);
        	newugly.add(newuglynum * 3);
        	newugly.add(newuglynum * 5);
        	uglyNum.add(newuglynum);
        }
        return uglyNum.getLast();
    }

}
