/**
 * 
 * @author ChopinXBP
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 *
 * ע��null���մ��������ո�
 *
 */

/*
 * ��ѽ��
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
	//����
	//return str.toString().replaceAll("\\s", "%20");
 */


public class StringReplace_2 {
	public static void main(String[] args){
		StringBuffer stringBuffer = new StringBuffer("");
		String string = replaceSpace(stringBuffer);
		System.out.println(string);
	}
	
	public static String replaceSpace(StringBuffer str) {
		if(str==null)return "�ַ���Ϊ��";
		
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
