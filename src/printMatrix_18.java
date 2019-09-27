/**
 * 
 * @author ChopinXBP 
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. 
 *
 */

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class printMatrix_18 {
	
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		//int[][] matrix2 = {{1}, {2}, {3}, {4}};
		ArrayList<Integer> result = Print(matrix);
		
		for(int i = 0;i < result.size();i++){
			out.print(result.get(i));
		}
		out.close();
	}

	public static ArrayList<Integer> Print(int[][] matrix){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int rowEdge = matrix.length;
		int colEdge = matrix[0].length;
		int num = rowEdge * colEdge;
		int count = 0;
		int row = 0;
		int col = 0;
		int beginpoint = 0;
		
		//ÿ��ѭ����ӡ������һ��Ȧ
		//ѭ�������ɸ�Ϊwhile(2 * beginpoint < rowEdge && 2 * beginpoint < colEdge)
		while(count < num){
			//����
			while(col < colEdge){
				result.add(matrix[row][col++]);
				count++;
			}
			row++;col--;
			//�ұ�
			while(row < rowEdge){
				result.add(matrix[row++][col]);
				count++;
			}
			col--;row--;
			if(count >= num)break;		//�ж��Ƿ��Ѿ���ӡ�꣨����/�ұ߱ش��ڣ�
			//�ױ�
			while(col >= beginpoint){
				result.add(matrix[row][col--]);
				count++;
			}
			row--;col++;
			//���
			while(row > beginpoint){
				result.add(matrix[row--][col]);
				count++;
			}
			//��СһȦ����
			beginpoint++;
			rowEdge--;colEdge--;
			row = beginpoint;col = beginpoint;
		}
		
		return result;
	}
	
	//�ⷨ��������ת�ã�Ч���Ե�
	/*
	 * ������תħ���ķ�ʽ һ��ȡһ�У�Ȼ����ת
	 */

	public ArrayList<Integer> printMatrix_2(int[][] matrix) {
		ArrayList<Integer> al = new ArrayList<>();
		int row = matrix.length;
		while (row != 0) {
			for (int i = 0; i < matrix[0].length; i++) {
				al.add(matrix[0][i]);
			}
			if (row == 1)
				break;
			matrix = turn(matrix);
			row = matrix.length;
		}
		return al;
	}

	private int[][] turn(int[][] matrix) {
		// TODO �Զ����ɵķ������
		int col = matrix[0].length;
		int row = matrix.length;
		int[][] newMatrix = new int[col][row - 1];
		for (int j = col - 1; j >= 0; j--) {
			for (int i = 1; i < row; i++) {
				newMatrix[col - 1 - j][i - 1] = matrix[i][j];
			}
		}
		return newMatrix;
	}
}
