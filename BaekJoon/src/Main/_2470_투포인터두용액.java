package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470_투포인터두용액 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//용액의 종류
		int N = Integer.parseInt(br.readLine());
		int list[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		int result[] = two_pointer(list, N);
		
		for(int i : result) {
			System.out.print(i + " ");
		}
		br.close();
	}

	private static int[] two_pointer(int[] list, int n) {
		// TODO Auto-generated method stub
		int result[] = new int[2];
		int start = 0; 
		int end = n-1;
		
		//최솟값의 비교기준으로 사용할 최댓값
		int maxdiff = 2000000000;
		
		while(start < end) {
			int sum = list[start] + list[end];
			
			if(Math.abs(sum) < maxdiff) {
				result[0] = list[start];
				result[1] = list[end];
				maxdiff = Math.abs(sum);
			}
			
			if(sum > 0) { //end값의 절댓값이 더 크다.
				end--;
			} else { //절댓값의 크기가 같거나, start값의 절대값이 더 크다.
				start++;
			}
		}
		
		return result;
	}

}
