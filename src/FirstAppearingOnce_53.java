/**
 * 
 * @author ChopinXBP
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;


public class FirstAppearingOnce_53 {

	static HashMap<Character, Integer> map = new HashMap<>();
	static ArrayList<Character> list = new ArrayList<Character>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        if(map.containsKey(ch)) {
        	map.put(ch, map.get(ch) + 1);
        }else {
        	map.put(ch, 1);
        }
        list.add(ch);
    }
    
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
		for (char key : list) {
			if (map.get(key) == 1) return key;
		}
		return '#';
    }
}
