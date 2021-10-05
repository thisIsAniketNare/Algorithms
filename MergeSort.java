package mergeSorting;

import java.util.Random;

public class MergeSort {

	int max;
	int[] arr;
	public MergeSort(int max){
		this.max = max;
		arr = new int[max];
	}
	
	public void randomScan(){
		Random r = new Random();
		for(int i=0;i<max;i++){
			arr[i]=r.nextInt(1000);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void merge(int start, int mid, int last){
		int i=start, j=mid+1, index=start;
		int[] temp = new int[max];
		while(i<=mid&&j<=last){
			if(arr[i]<arr[j]){
				temp[index++]=arr[i++];
			}
			else{
				temp[index++]=arr[j++];
			}
		}
		if(i>mid){
			while(j<=last){
				temp[index++]=arr[j++];
			}
		}
		else{
			while(i<=mid){
				temp[index++]=arr[i++];
			}
		}
		for(i=start;i<index;i++){
			arr[i]=temp[i];
		}
	}
	
	public void sort(int start, int last){
		if(start<last){
			int mid = (start+last)/2;
			sort(start, mid);
			for(int i=0;i<max;i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			sort(mid+1, last);
			merge(start, mid, last);
		}
	
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort(8);
		
    System.out.println("Random array generated is as follows:");
		ms.randomScan();
		
    System.out.println("Sorting starts... ");
		long start = System.nanoTime();
		ms.sort(0, ms.max-1);
		long time = System.nanoTime() - start;
		for(int i=0;i<ms.max;i++){
			System.out.print(ms.arr[i] + " ");
		}
		System.out.println("Time: " + time + " ns\n");
	}
}
