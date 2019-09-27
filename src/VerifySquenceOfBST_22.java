/**
 * 
 * @author ChopinXBP 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
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
        //序列分段递归
        return Solution(sequence, begin, end);
    }
    
    public static boolean Solution(int [] seq, int begin, int end){
    	//若序列元素小于两个，必符合后序遍历
    	if(end - begin <= 1) return true;
    	
		int root = seq[end]; //序列尾结点为当前根节点，也是左右子树大小分隔值	
		int edge = begin; 	 //用于记录左右子树分隔点，最终edge指向右子树根节点所在序列位置
		//确定分隔点所在序列位置
		while (edge < end) {
			if (seq[edge] > root) break;
			edge++;
		}
		//若分隔点后有值小于分隔值，则不符合二叉搜索树后序遍历条件
		for(int i = edge; i < end; i++){
			if (seq[i] < root) return false;
		}
		//递归检验两个子树序列
		return Solution(seq, begin, edge - 1) && Solution(seq, edge, end - 1);		
    }
}



