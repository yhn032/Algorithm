package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2750_BUBBLE_ASC {
	static int temp[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		temp = new int[N];
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = Integer.parseInt(br.readLine());
		}
		
		//정렬하기 
		bubble_sort(temp);
		
		for(int i : temp) {
			System.out.println(i);
		}
	}

	
	public static void bubble_sort(int[] a) {
		bubble_sort(a, a.length);
	}
	
	
	private static void bubble_sort(int[] a, int length) {
		// TODO Auto-generated method stub
		for(int i=1; i<length; i++) {
			for(int k =0; k<length-1; k++) {
				if(a[k] > a[k+1]) {
					swap(a, k, k+1);
				}
			}
		}
	}
	//          k      k+1
	private static void swap(int[] a, int i, int j)  {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
	
}

	
