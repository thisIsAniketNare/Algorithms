package quickSorting;

import java.util.Random;

public class QuickSort {
	int arr_max;
	int[] arr;
	int pivot;
	public QuickSort(int max){
		this.arr_max = max;
		arr = new int[max];
	}
	
	public void randomScan(){
		Random r = new Random();
		for(int i=0;i<arr_max;i++){
			arr[i]=r.nextInt(1000);
			//System.out.print(arr[i] + " ");
		}
		//System.out.println();
	}
	
	public int partition(int start, int end){
		pivot=arr[start]; int i=start+1, j=end;
		while ( i <= j ){
			while ( arr[j] > pivot ) {
				j--;
			}
			while ( i<arr_max && arr[i] <= pivot) {
				i++;
			}
			if(i<=j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
			}
		}
		int temp = arr[start];
		arr[start] = arr[j];
		arr[j]=temp;
		
		return j;
			
	}
	public void sort(int start, int end){
		if ( start < end ){
			int q = partition(start, end);
			sort(start, q-1);
			for(int i=0;i<arr_max;i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			sort(q+1, end); 
			
		}
	}

	public static void main(String[] args) {
		QuickSort ms = new QuickSort(8);
		ms.randomScan();
		System.out.println("Random array generated is as follows:");
		for(int i=0;i<ms.arr_max;i++){
			System.out.print(ms.arr[i] + " ");
		}
		System.out.println();
		
		
		long start = System.nanoTime();
		ms.sort(0,ms.arr_max-1);
		long time = System.nanoTime()-start;
		
		System.out.println("\nTime: " + time + " ns\n");
		
	}
}
