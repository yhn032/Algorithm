package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654_랜선자르기 {
	static int k, n;
	static long ransun[];
	static int count;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		//탐색 대상은 자를 랜선의 길이
		//이에따라 나눠지는 랜선의 개수가 m인경우 중 최대값을 구하기 -> 상한을 찾는 메소드 
		
		ransun = new long[k];
		
		for(int i=0; i<k; i++) {
			ransun[i] = Integer.parseInt(br.readLine());
		}
		
		//랜선의 개수 k의 최댓값은 10000이므로 정렬에서의 시간복잡도는 고려x
		Arrays.sort(ransun);
		
		//탐색 대상은 자를 랜선의 길이. 비교 대상은 랜선의 길이에 따라 나눠지는 랜선의 개수 
		long min = 1;
		long max = ransun[k-1]+1;
		
		while(min < max) {
			long mid = min + (max-min)/2;
			
			if(cut(mid) < n) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
	}
	private static int cut(long mid) {
		// TODO Auto-generated method stub
		int count=0; 
		
		for(int i=0; i<k; i++) {
			count += ransun[i]/mid;
		}
		
		
		return count;
	}

}
