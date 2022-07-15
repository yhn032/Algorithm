package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2805_나무자르기 {
	static int tree[];
	static int n, m;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//나무의 수
		n = Integer.parseInt(st.nextToken());
		//가져가려고 하는 나무의 길이
		m = Integer.parseInt(st.nextToken());
		
		tree = new int[n];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = tree[i] > max ? tree[i] : max;
		}
		
		int min = 0;
		
		while(min < max) {
			
			int mid = (min+max)/2;
			
			if(tr_hap(mid) < m) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
	}
	private static long tr_hap(int mid) {
		// TODO Auto-generated method stub
		long sum = 0;
		
		for(int i =0 ;i<n; i++) {
			if(tree[i] < mid) continue;//0을 더하나 스킵하나 똑같음
				
			sum += tree[i]-mid;
		}
		return sum;
	}

}

