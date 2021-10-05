import java.util.Random;
import java.util.Scanner;

public class FloydWarshall {
	
	int arr_max;
	int[][] arr;
	int[] col,row;
	int x,y,w,v,c;
	final int INF = 1001;
	public FloydWarshall(int max){
		this.arr_max = max;
		v=max;
		arr = new int[max][max];
		col = new int[max];
		row = new int[max];
	}
	
	public void randomScan(){
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		//v=r.nextInt(arr_max);
		c=r.nextInt(v*(v-1)/2);
		/*v=scan.nextInt();
		c=scan.nextInt();*/
		
		for(int i=0;i<v;i++){
		    for(int j=0;j<v;j++){
		      arr[i][j]=INF;
		  }
		}
		for(int i=0;i<c;i++){
			
			x=r.nextInt(v-1)+1;
			y=r.nextInt(v-1)+1;
		    w=r.nextInt(20);
		    /*x=scan.nextInt();
			y=scan.nextInt();
		    w=scan.nextInt();*/
		  	arr[x-1][y-1]=w;
		  	arr[y-1][x-1]=w;
		}
		/*for(int i=0;i<v;i++){
		    for(int j=0;j<v;j++){
		    	System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}*/
		scan.close();
	}
	public void floydWarshall(){
	  for(int i=0;i<v;i++){
		  int p=0,r=0;
		  for(int j=0;j<v;j++){
		    if(arr[j][i]!=INF){
		      col[p++]=j;
		    }
		    if(arr[i][j]!=INF){
		      row[r++]=j;
		    }
		  }
		  for(int j=0;j<p;j++){
		    for(int k=0;k<r;k++){
		      int s=arr[col[j]][i]+arr[i][row[k]];
		      if(arr[col[j]][row[k]]>=s){
		        arr[col[j]][row[k]]=s;
		      }
		    }
		  }
		  for(int j=0;j<v;j++){
			    for(int k=0;k<v;k++){
			    	System.out.print(arr[j][k] + " ");
			  }
			    System.out.println();
			}
		  System.out.println();
	  }
	}

	public static void main(String[] args) {
		FloydWarshall dj = new FloydWarshall(100);
		//System.out.println("Random array generated is as follows:");
		dj.randomScan();
		long start = System.currentTimeMillis();
		dj.floydWarshall();
		long time = System.currentTimeMillis() - start;
		System.out.println("Time: " + time + " ms");
		
	}
}

