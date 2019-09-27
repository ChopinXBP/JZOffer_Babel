/**
 * 
 * @author ChopinXBP
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
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
