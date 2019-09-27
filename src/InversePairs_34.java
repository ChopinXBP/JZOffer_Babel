/**
 * 
 * @author ChopinXBP
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
 * 
 */



public class InversePairs_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {7, 5, 6, 4};
		int[] array = {1,2,3,4,5,6,7,0};
		System.out.println(InversePairs(array));
	}
	
	//ģ��鲢������������Ӷ�o��nlogn��
    public static int InversePairs(int [] array) {
    	if(array == null) return -1;
    	
    	int head = 0;
    	int tail = array.length - 1;
    	int[] copy = new int[array.length];		//��¼�鲢����������
    	
    	int count = Solution(array, copy, head, tail);
    	
    	return count;
    }
    
    public static int Solution(int[] array, int[] copy, int head, int tail){
    	if(head == tail){
    		copy[head] = array[head];
    		return 0;
    	}
    	
    	int lefttail = (head + tail) / 2;			//��벿��βָ��
    	int righthead = lefttail + 1;				//�Ұ벿��ͷָ��
    	int righttail = tail;						//�Ұ벿��βָ��
    	
    	int leftcount = Solution(array, copy, head, lefttail) % 1000000007;
    	int rightcount = Solution(array, copy, righthead, tail) % 1000000007;
    	
    	//����벿��βָ���Ӧֵ�������Ұ벿��βָ���Ӧֵ���бȽϣ���lefttail��Ӧֵ����righttail��Ӧֵ������ڣ�righttail - righthead + 1���������
    	//������������ν�βָ���Ӧֵ�ȽϽϴ��������������η�������copy��ԭ�����У�ʹ���ų�һ�ε����������С�
    	int midcount = 0;
    	int indexCopy = tail;
    	while(lefttail >= head && righttail >= righthead){
    		if(array[lefttail] > array[righttail]){
    			midcount += righttail - righthead + 1;
    			copy[indexCopy--] = array[lefttail--];
    			if(midcount >= 1000000007) midcount %= 1000000007;			//��ֹ��ֵ����������
    		}else{
    			copy[indexCopy--] = array[righttail--];
    		}
    	}
    	
    	while(lefttail >= head){
    		copy[indexCopy--] = array[lefttail--]; 
    	}
    	while(righttail >= righthead){
    		copy[indexCopy--] = array[righttail--];
    	}
    	for(int i = head; i <= tail; i++){
    		array[i] = copy[i];
    	}
    	
    	return (leftcount + rightcount + midcount) % 1000000007;
    }

}
