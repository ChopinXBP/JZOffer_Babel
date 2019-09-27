/**
 * 
 * @author ChopinXBP 
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 *
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FirstNotRepeatingChar_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dsalkjhkajshdfkjhasfkjh";
		System.out.println(FirstNotRepeatingChar(str));
		System.out.println(FirstNotRepeatingChar2(str));
	}

	//���ߴ�������һ�������¼�ظ�Ԫ��
    public static int FirstNotRepeatingChar(String str) {
    	if(str == null || str.length() <= 1) return -1;
    	
    	ArrayList<Character> charlist = new ArrayList<>();
    	ArrayList<Character> relist = new ArrayList<>();
    	for(int i = 0; i < str.length(); i++){
    		char element = str.charAt(i);
    		if(!charlist.contains(element)){
    			charlist.add(element);
    		}else{
    			relist.add(element);
    		}
    	}
    	
    	for(int i = 0; i < str.length(); i++){
    		char element = str.charAt(i);
    		if(!relist.contains(element)) return i;
    	}
    	
        return -1;
    }
    
    
    //����Hashmap��¼ÿһ���ַ��ĳ��ִ���
    public static int FirstNotRepeatingChar2(String str) {
    	if(str == null || str.length() <= 1) return -1;
    	
    	LinkedHashMap<Character, Integer> charmap = new LinkedHashMap<>();
    	
    	for(int i = 0; i < str.length(); i++){
    		char element = str.charAt(i);
    		if(!charmap.containsKey(element)){
    			charmap.put(element, 1);
    		}else{
    			int num = charmap.get(element).intValue() + 1;
    			charmap.put(element, num);
    		}
    	}
    	
    	for(int i = 0; i < str.length(); i++){
    		char element = str.charAt(i);
    		if(charmap.get(element).equals(1)) return i;
    	}
    	
    	return -1;
    }
}
