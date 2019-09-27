/**
 * 
 * @author ChopinXBP 
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
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

	//在线处理：开辟一个数组记录重复元素
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
    
    
    //利用Hashmap记录每一个字符的出现次数
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
