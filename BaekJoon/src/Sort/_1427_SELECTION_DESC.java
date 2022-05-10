package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1427_SELECTION_DESC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		
		int arr[] = new int[N.length()];
		
		for(int i=0; i<arr.length;i++) {
			arr[i] = N.charAt(i)-'0';
		}
		
		//arr을 내림차순으로 정렬할 건데 선택정렬을 쓸거다. 최댓값을 찾아서 swap하자 
		
		//라운드는 배열의크기-1
		for(int i =0; i<arr.length-1;i++) {
			int max_idx = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[j] > arr[max_idx]) {
					max_idx = j;
				}
				
			}
			swap(arr, max_idx, i);
		}
		
		for(int i : arr) {
			System.out.print(i);
		}
		
		
		
		
	}

	private static void swap(int[] arr, int max_idx, int i) {
		// TODO Auto-generated method stub
		int temp = arr[max_idx];
		arr[max_idx] = arr[i];
		arr[i] = temp;
	}

}
