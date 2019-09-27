/**
 * 
 * @author ChopinXBP 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. 
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
		
		//每次循环打印矩阵中一个圈
		//循环条件可改为while(2 * beginpoint < rowEdge && 2 * beginpoint < colEdge)
		while(count < num){
			//顶边
			while(col < colEdge){
				result.add(matrix[row][col++]);
				count++;
			}
			row++;col--;
			//右边
			while(row < rowEdge){
				result.add(matrix[row++][col]);
				count++;
			}
			col--;row--;
			if(count >= num)break;		//判断是否已经打印完（顶边/右边必存在）
			//底边
			while(col >= beginpoint){
				result.add(matrix[row][col--]);
				count++;
			}
			row--;col++;
			//左边
			while(row > beginpoint){
				result.add(matrix[row--][col]);
				count++;
			}
			//缩小一圈矩阵
			beginpoint++;
			rowEdge--;colEdge--;
			row = beginpoint;col = beginpoint;
		}
		
		return result;
	}
	
	//解法二：矩阵转置，效率略低
	/*
	 * 采用旋转魔方的方式 一次取一行，然后旋转
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
		// TODO 自动生成的方法存根
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
