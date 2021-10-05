package nqueenproblem;

public class NQueenProblem {
	int n=20;
	int count = 0;
	boolean[][] board = new boolean[n][n];
	int[] queen = new int[n];
	
	public void initiate(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j]=false;
			}
		}
	}
	
	public boolean isQueenSafe(int row, int col){
		for(int i=0;i<n;i++){
			if(board[i][col]){
				return false;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(Math.abs(row-i)==Math.abs(col-j)){
					if(board[i][j]){
						return false;
					}	
				}
			}
		}
		return true;
	}
	
	public boolean nQueenProblem(int n, int row){
		if(row==n){
			//printBoard(board);
			count++;
			return true;
		}
		for(int i=0;i<n;i++){
			if(isQueenSafe(row,i)){
				board[row][i]=true;
				nQueenProblem(n,row+1);
				/*if(nQueenProblem(n,row+1)){
					return true;
				}*/
				board[row][i]=false;
			}
		}
		return false;
	}
	
	public void printBoard(boolean[][] board){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]==true){
					System.out.print(j+1 + " ");
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		NQueenProblem nqp = new NQueenProblem();
		
		nqp.initiate();		
		long start = System.currentTimeMillis();
		nqp.nQueenProblem(20, 0);
		long time = System.currentTimeMillis() - start;
		System.out.println("Time: " + time + " ms    Solutions: " + nqp.count);
	}
}
