import java.util.Random;
//import java.util.Scanner;

public class DijkstraAlgorithm {
	int arr_max;
	int[][] arr;
	int[] visited,node;
	int x,y,w,v,c,inf=1001;
	public DijkstraAlgorithm(int max){
		this.arr_max = max;
		arr = new int[max][max];
		visited = new int[max];
		node = new int[max];
	}
	
	public void randomScan(){
		Random r = new Random();
		//Scanner scan = new Scanner(System.in);
		v=arr_max;
		c=r.nextInt(arr_max*(arr_max-1)/2);
		for(int i=0;i<v;i++){
		    for(int j=0;j<v;j++){
		      arr[i][j]=inf;
		  }
		}
		for(int i=0;i<c;i++){
			
			x=r.nextInt(10)+1;
			y=r.nextInt(10)+1;
		    w=r.nextInt(20);
		  	arr[x-1][y-1]=w;
		  	arr[y-1][x-1]=w;
		}
		/*for(int i=0;i<v;i++){
		    for(int j=0;j<v;j++){
		    	System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}*/
		//scan.close();
	}
	
	public void dijkstraAlgo(int start){
		for(int i=0;i<v;i++){
			visited[i]=0;
			node[i]=arr[start][i];
		}
		visited[start]=1; node[start]=0;
		for(int i=1;i<v;i++){
			int u = 0,smallest = inf;
			for(int j=0;j<v;j++){
				if(arr[start][j]<smallest&&visited[j]==0){
					smallest=arr[start][j];
					u=j;
				}
			}
			visited[u]=1;
			for(int j=0;j<v;j++){
				if(arr[u][j]>0&&arr[u][j]!=inf&&visited[j]==0){
					if(node[j]>node[u]+arr[u][j]){
						node[j]=node[u]+arr[u][j];
					}
				}
			}
			System.out.println();
			for(int z=0;z<v;z++){
				System.out.print(node[z] + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijkstraAlgorithm dj = new DijkstraAlgorithm(500);
		//System.out.println("Random array generated is as follows:");
		dj.randomScan();
		long start = System.currentTimeMillis();
		dj.dijkstraAlgo(0);
		long time = System.currentTimeMillis() - start;
		System.out.println("Time: " + time + " ms");
		
	}
}
