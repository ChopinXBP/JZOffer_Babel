/**
 * 
 * @author ChopinXBP
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ������������ǲ��������ġ�
 * ���У���\С�����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
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
        
        Arrays.sort(numbers);					//��������
        int zeronum = 0;						//��¼0ֵ�����ƣ�����
        int i = 0;
        while(i < 4 && numbers[i] == 0) {
        	zeronum++;
        	i++;
        }
        
        int locnum = numbers[zeronum];			//ȡ��һ�ŷ�������Ϊ��ǰ��
        for(i = zeronum + 1; i < 5; i++) {
        	//����һ���Ƶ��ڵ�ǰ�ƣ������ظ���ֱ�ӽ�������false
        	if(numbers[i] == locnum) {
        		return false;
        	}
        	//����һ���Ƶ��ڵ�ǰ��+1����ǰ��+1������
        	else if(numbers[i] == locnum + 1) {
        		locnum++;
        	}
        	//����һ���Ʋ����ڵ�ǰ�ƻ�ǰ��+1��������һ������,���ֵ�ǰλ�ã���ǰ��+1������
        	else {
        		zeronum--;
        		locnum++;
        		i--;
        	}
        	
        	if(zeronum < 0) return false;	//����������������ֱ�ӽ�������false
        }
        
        return true;
    }
}
