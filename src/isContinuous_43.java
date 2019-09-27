/**
 * 
 * @author ChopinXBP
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的。
 * 其中，大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 */

import java.util.Arrays;


public class isContinuous_43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0, 3, 5, 7, 4};
		System.out.println(isContinuous(numbers));
	}

    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5)return false;
        
        Arrays.sort(numbers);					//数组排序
        int zeronum = 0;						//记录0值（王牌）个数
        int i = 0;
        while(i < 4 && numbers[i] == 0) {
        	zeronum++;
        	i++;
        }
        
        int locnum = numbers[zeronum];			//取第一张非王牌作为当前牌
        for(i = zeronum + 1; i < 5; i++) {
        	//若下一张牌等于当前牌，则发生重复，直接结束返回false
        	if(numbers[i] == locnum) {
        		return false;
        	}
        	//若下一张牌等于当前牌+1，则当前牌+1并继续
        	else if(numbers[i] == locnum + 1) {
        		locnum++;
        	}
        	//若下一张牌不等于当前牌或当前牌+1，则消耗一张王卡,保持当前位置，当前牌+1并继续
        	else {
        		zeronum--;
        		locnum++;
        		i--;
        	}
        	
        	if(zeronum < 0) return false;	//若超量消耗王卡，直接结束返回false
        }
        
        return true;
    }
}
