/**
 * 
 * @author ChopinXBP
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 *
 */

public class Add_47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Add(2, 3));
	}
	
	//x^yִ�мӷ�,(x&y)<<1��λ����
	//x+y = x^y + (x&y)<<1
    public static int Add(int num1,int num2) {
    	int loc = num1 ^ num2;				//�����λֵ
    	int bit = (num1 & num2) << 1;		//��λֵ
    	while(bit != 0) {
    		int carrybit = (loc & bit) << 1;
    		loc = loc ^ bit;
    		bit = carrybit;
    	}
    	return loc;
    }

}
