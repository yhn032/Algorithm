package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class _2587 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		System.out.println((int)(sum/5));
		System.out.println(arr[2]);
	}
}
