/**
 * 
 * @author ChopinXBP
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 注意null、空串、连续空格
 *
 */

/*
 * 最佳解答
 * 
 public class Solution {
    public String replaceSpace(StringBuffer str) {
     if(str==null)
     {
        return null;
     }
     for(int i=0;i<str.length();i++)
     {
         char c = str.charAt(i);
         if(c==' ')
         {
            str.replace(i,i+1,"%20");
         }
      }
      String newstr = str.toString();
      return newstr;   
    }
}
	//神解答
	//return str.toString().replaceAll("\\s", "%20");
 */


public class StringReplace_2 {
	public static void main(String[] args){
		StringBuffer stringBuffer = new StringBuffer("");
		String string = replaceSpace(stringBuffer);
		System.out.println(string);
	}
	
	public static String replaceSpace(StringBuffer str) {
		if(str==null)return "字符串为空";
		
		int index = 0;
		//int end = str.length();
		while (index != str.length()) {
			int i;
			if ((i = str.indexOf(" ", index)) >= 0) {				
				index = i;
				str.replace(i, i + 1, "%20");
				//System.out.println(str);
			} else {
				break;
			}
		}
		return str.toString();
		
		
	}

}
