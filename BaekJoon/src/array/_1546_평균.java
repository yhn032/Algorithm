package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1546_Æò±Õ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		//ÃÖ´ñ°ª
		int M = arr[N-1];
		double newarr[] = new double[N];
		for(int i=0; i<N;i++) {
			newarr[i] = ((arr[i]*1.0)/M)*100;
		}
		
		double sum = 0;
		
		for(double i : newarr) {
			//System.out.print(i + " ");
			sum += i;
		}
		
		double avg = (sum)/N;
		
		System.out.println(avg);
		
		
		
	}

}

