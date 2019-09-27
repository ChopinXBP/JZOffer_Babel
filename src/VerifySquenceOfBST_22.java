/**
 * 
 * @author ChopinXBP 
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 *
 */

public class VerifySquenceOfBST_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] sequence1 = {2,5,6,4,11,10,9,13,12,8};
		int [] sequence = {4,6,12,8,16,14,10};
		System.out.println(VerifySquenceOfBST(sequence1));
	}

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)return false;
    	int begin = 0;
        int end = sequence.length - 1;
        //���зֶεݹ�
        return Solution(sequence, begin, end);
    }
    
    public static boolean Solution(int [] seq, int begin, int end){
    	//������Ԫ��С���������ط��Ϻ������
    	if(end - begin <= 1) return true;
    	
		int root = seq[end]; //����β���Ϊ��ǰ���ڵ㣬Ҳ������������С�ָ�ֵ	
		int edge = begin; 	 //���ڼ�¼���������ָ��㣬����edgeָ�����������ڵ���������λ��
		//ȷ���ָ�����������λ��
		while (edge < end) {
			if (seq[edge] > root) break;
			edge++;
		}
		//���ָ������ֵС�ڷָ�ֵ���򲻷��϶��������������������
		for(int i = edge; i < end; i++){
			if (seq[i] < root) return false;
		}
		//�ݹ����������������
		return Solution(seq, begin, edge - 1) && Solution(seq, edge, end - 1);		
    }
}



