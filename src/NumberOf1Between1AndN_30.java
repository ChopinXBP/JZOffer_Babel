/**
 * 
 * @author ChopinXBP
 * 求从1到n中1在数位上出现的次数
 *
 */

public class NumberOf1Between1AndN_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1Between1AndN_Solution1(12023));
		System.out.println(NumberOf1Between1AndN_Solution2(12023));
		System.out.println(NumberOf1Between1AndN_Solution3(12023));
	}

	
	//归纳：按位考虑
	public static int NumberOf1Between1AndN_Solution1(int n) {
		if(n <= 0) return 0;
		int result = 0;
		int loc = 1;	//当前位数
		int high = 0;	//高位数字（多位）
		int now = 0;	//当前位数字（1位）
		int low = 0;	//低位数字（多位）
		
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
	
	//简洁写法1，在C++下可归纳为一条公式
	//当前位now=0/1时，+8对高位high无影响；当前位now>=2时，+8会产生进位，效果等同于high+1
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
	
	
	//简洁写法2，归纳为一条公式
	//判断去掉高位后的余数，对于后半式子，若当前位小于1，输出0；若当前位等于1，输出low低位数字+1；若当前位大于1,输出一个loc当前位，等效于(high+1)*loc
	public static int NumberOf1Between1AndN_Solution3(int n) {
		if (n <= 0)
			return 0;
		int result = 0;
		for (long loc = 1; loc <= n; loc *= 10) {
			long high = n / (loc * 10);		//高位数字
			long rest = n % (loc * 10);		//去掉高位数字后的余数
			result += high * loc + Math.min(Math.max(rest - loc + 1, 0), loc);
		}
		return result;
	}
}
