import java.util.Random;

public class DynamicKnapsack {
	int[] weight;
	int[] val;
	int[][] wgt;
	int[] consider;
	int arr_max;
	
	public DynamicKnapsack(int inputs){
		arr_max = inputs;
		weight = new int[inputs];
		val = new int[inputs];
		
		consider = new int[inputs];
	}
	public void randomScan(){
		Random r = new Random();
		for(int i=0;i<arr_max;i++){
			weight[i] = r.nextInt(10)+1;
			val[i] = r.nextInt(100);
		}
		System.out.print("Weights: ");
		for(int i=0;i<arr_max;i++){
			System.out.print(weight[i] + " ");
		}
		System.out.print("\nValues:  ");
		for(int i=0;i<arr_max;i++){
			System.out.print(val[i] + " ");
		}
		System.out.println();
	}
	
	int max(int a, int b){return a>b?a:b;}
	
	public void knapsack(int W){
		wgt = new int[arr_max][W+1];
		for(int i=0;i<arr_max;i++){
			for(int j=0;j<=W;j++){
				if(j<weight[i]){
					if(i==0) wgt[i][j]=0;
					else wgt[i][j]=wgt[i-1][j];
				}
				else{
					if(i==0) wgt[i][j]=val[i];
					else wgt[i][j]=max(val[i] + wgt[i-1][j-weight[i]],wgt[i-1][j]);
				}
				System.out.print(wgt[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Considering ");
		int i = arr_max-1;
		int j = W;
		int max = wgt[i][j];
		
		while(j>0&&i>0){
			max = wgt[i-1][j]>wgt[i][j-1]?wgt[i-1][j]:wgt[i][j-1];
			if(max==wgt[i][j-1]){
				System.out.print(i+1);
			}
			else{
				System.out.print(i);
			}
			j=j-weight[i];
			i--;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		DynamicKnapsack ks = new DynamicKnapsack(10);
		ks.randomScan();
		ks.knapsack(7);
	}
}
