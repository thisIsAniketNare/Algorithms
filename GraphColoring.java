package graphColoring;

import java.util.Random;

public class GraphColoring {
	int arr_max;
	int[][] arr;
	int[] colored;
	int x,y,v,c,inf=0;
	
	public GraphColoring(int max){
		this.arr_max = max;
		arr = new int[max][max];
		colored = new int[max];
	}
	
	public void randomScan(){
		//Scanner scan = new Scanner(System.in);
		Random r = new Random();
		v=r.nextInt(arr_max)+1;
		c=r.nextInt(v*(v-1)/2);
		//m=scan.nextInt();
		for(int i=0;i<v;i++){
			colored[i]=0;
		    for(int j=0;j<v;j++){
		      arr[i][j]=inf;
		      if(i==j){
		    	  arr[i][j]=1;
		      }
		  }
		}
		for(int i=0;i<c;i++){
			x=r.nextInt(v)+1;
			y=r.nextInt(v)+1;
		  	arr[x-1][y-1]=1;
		  	arr[y-1][x-1]=1;
		}
		/*for(int i=0;i<v;i++){
		    for(int j=0;j<v;j++){
		    	System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}
		System.out.println();
		scan.close();*/
	}
	
	public boolean isSafe(int k,int c){
		for(int j=0;j<v;j++){
			if(arr[k][j]==1 && colored[j]==c){
				return false;
			}
		}
		return true;
	}
	public void graphColoring(int k){
		for(int c=1;;c++){
			if(isSafe(k,c)){
				colored[k]=c;
				break;
			}
		}
		if(k+1<v){
			graphColoring(k+1);
		}else if(colored[k]>0){
			return;
		}
	}
	
	public static void main(String[] args) {
		GraphColoring gc = new GraphColoring(5000);
		gc.randomScan();
		long start = System.currentTimeMillis();
		gc.graphColoring(0);
		long time =System.currentTimeMillis()- start;
		int max= gc.colored[0];
		for(int i=0;i<gc.arr_max;i++){
			if(gc.colored[i]>max){
				max = gc.colored[i];
			}
		}
		System.out.println("Time: " + time + " ms Colors required: " + max);
		for(int i=0;i<gc.v; i++){
			System.out.print(gc.colored[i] + " ");
		}
	}
}
