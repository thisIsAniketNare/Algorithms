import java.util.Random;
import java.util.Scanner;

public class LongestCommonSubsequence {
	char[] Y;
	char[] X;
	int[] consider;
	int[][] wgt;
	int y,x;
	int count=0;
	
	public LCS(int y, int x){
		Y = new char[y];
		X = new char[x];
		consider = new int[x];
		wgt = new int[x+1][y+1];
		this.y=y;
		this.x=x;
	}
	
	public void randomScan(){
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<y;i++){
			Y[i] = (char)(65 + r.nextInt(26));
		}
		for(int i=0;i<x;i++){
			X[i] = (char)(65 + r.nextInt(26));
		}
		
	  /*for(int i=0;i<y;i++){
			Y[i] = scan.nextLine().charAt(0);
		}
		for(int i=0;i<x;i++){
			X[i] = scan.nextLine().charAt(0);
		}*/
		
    /*OR*/
    
		/*Y[0] = 'A';
		Y[1] = 'A';
		Y[2] = 'B';
		Y[3] = 'G';
		Y[4] = 'G';
		Y[5] = 'D';
		Y[6] = 'E';
		X[0] = 'A';
		X[1] = 'B';
		X[2] = 'G';
		X[3] = 'E';
		
		System.out.print("Array1: ");
		for(int i=0;i<y;i++){
			System.out.print(Y[i]);
		}
		System.out.print("\nArray2: ");
		for(int i=0;i<x;i++){
			System.out.print(X[i]);
		}
		System.out.println();*/
		scan.close();
	}
	
	int max(int a, int b){return a>b?a:b;}
	
	public void knapsack(){
		for(int i=0;i<y;i++){
			wgt[0][i] = 0;
		}
		for(int i=0;i<x;i++){
			wgt[i][0] = 0;
		}
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				if(wgt[i-1][j]==wgt[i][j-1]){
					if(Y[j-1]==X[i-1]){
						wgt[i][j]=wgt[i-1][j]+1;
					}
					else{
						wgt[i][j]=wgt[i-1][j];
					}
				}
				else{
					wgt[i][j] = max(wgt[i-1][j],wgt[i][j-1]);
				}
				System.out.print(wgt[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Considering ");
		int i = x;
		int j = y;
		int max = wgt[i][j];
		
		while(j>0&&i>0){
			if(max==wgt[i][j-1]){
				j--;
			}
			else if(max==wgt[i-1][j]){
				i--;
			}
			else{
				consider[count++]=i-1;
				j--;
				i--;
				max=wgt[i][j];
			}
		}
		if(max>0){
			consider[count++] = 0;
		}
	}
	
	public static void main(String[] args){
		LCS ls = new LCS(500,500);
		ls.randomScan();
		long start = System.currentTimeMillis();
		ls.knapsack();
		long time = System.currentTimeMillis() - start;
		for(int i=ls.count-1;i>=0;i--){
			System.out.print(ls.X[ls.consider[i]]);
		}
		System.out.print("\nLength: " + ls.count);
		System.out.print("Time: " + time + " ms");
	}
}
