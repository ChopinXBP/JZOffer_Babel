/**
 * 
 * @author ChopinXBP
 * ���1��n��1����λ�ϳ��ֵĴ���
 *
 */

public class NumberOf1Between1AndN_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1Between1AndN_Solution1(12023));
		System.out.println(NumberOf1Between1AndN_Solution2(12023));
		System.out.println(NumberOf1Between1AndN_Solution3(12023));
	}

	
	//���ɣ���λ����
	public static int NumberOf1Between1AndN_Solution1(int n) {
		if(n <= 0) return 0;
		int result = 0;
		int loc = 1;	//��ǰλ��
		int high = 0;	//��λ���֣���λ��
		int now = 0;	//��ǰλ���֣�1λ��
		int low = 0;	//��λ���֣���λ��
		
		while(n / loc > 0){
			high = n / (loc * 10);
			now = n / loc % 10;
			low = n % loc;
			
			if(now == 0){
				result += high * loc;
			}
			else if(now == 1){
				result += high * loc + low + 1;
			}
			else if(now >= 1){
				result += (high + 1) * loc;
			}
			
			loc *= 10;
		}
		
		return result;
	}
	
	//���д��1����C++�¿ɹ���Ϊһ����ʽ
	//��ǰλnow=0/1ʱ��+8�Ը�λhigh��Ӱ�죻��ǰλnow>=2ʱ��+8�������λ��Ч����ͬ��high+1
	public static int NumberOf1Between1AndN_Solution2(int n) {
		int result = 0;
		for (long loc = 1; loc <= n; loc *= 10) {
			if(n / loc % 10 == 1){
				result += (n / loc + 8) / 10 * loc + (n % loc + 1);
			}else{
				result += (n / loc + 8) / 10 * loc;
			}
		}
		return result;
	}
	
	
	//���д��2������Ϊһ����ʽ
	//�ж�ȥ����λ������������ں��ʽ�ӣ�����ǰλС��1�����0������ǰλ����1�����low��λ����+1������ǰλ����1,���һ��loc��ǰλ����Ч��(high+1)*loc
	public static int NumberOf1Between1AndN_Solution3(int n) {
		if (n <= 0)
			return 0;
		int result = 0;
		for (long loc = 1; loc <= n; loc *= 10) {
			long high = n / (loc * 10);		//��λ����
			long rest = n % (loc * 10);		//ȥ����λ���ֺ������
			result += high * loc + Math.min(Math.max(rest - loc + 1, 0), loc);
		}
		return result;
	}
}
