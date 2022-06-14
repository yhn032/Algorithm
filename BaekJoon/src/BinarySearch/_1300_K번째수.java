package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1300_K번째수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//배열의 크기 n*n 
		int n = Integer.parseInt(br.readLine());
		
		//1차원 배열에서 k번째수
		int k = Integer.parseInt(br.readLine());
		
		
		//B[K] = x를 만족하는 K를 찾는 문제 
		//B[K] -> x보다 작거나 같은 수가 K개 있다. 
		
		long min = 1;//i*j의 최솟값은 1
		long max = k;//x보다 작거나 같은 수는 k개보다 많을 수 없음
		
		while(min < max) {
			long mid = (min+max)/2;
			int count=0; //x보다 작거나 같은 개수가 k인 것중에서 최대를 구해라 된다. 
			
			//각 행의 원소개수는 n개를 넘을수 없다. n*n배열이기 때문이다.
			
			for(int i=1; i<=n; i++) {
				count += Math.min(mid/i, n);
			}
			
			//임의의 수x(mid)보다 작은 수가 B[K]보다 많다면
			if(k <= count) {
				max = mid;
			}else {
				min = mid+1;
			}
					
			
		}
		System.out.println(min);
	}

}
