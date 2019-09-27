/**
 * 
 * @author ChopinXBP
 * 翻转句子中的单词顺序。例如，“student. a am I”。
 */

public class ReverseSentence_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseSentence("I am a student."));
		System.out.println(ReverseSentence("  "));
	}

    public static String ReverseSentence(String str) {
        if(str == null || str == "")return "";
        if(str == " ")return " ";
        
        String[] strlist = str.split(" ");                                 
        int length = strlist.length - 1;
        if(length < 0)return "";
        StringBuilder newstr = new StringBuilder(strlist[length--]);
        while(length >= 0) {
        	newstr.append(" ").append(strlist[length--]);
        }
        
        return newstr.toString();
    }

}
