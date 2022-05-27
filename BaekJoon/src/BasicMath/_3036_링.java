package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3036_링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int ring = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int ring_arr[] = new int[ring];
		
		for(int i=0; i<ring;i++) {
			ring_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int gcdVal = 0;
		
		//초기 링의 반지름 저장
		int start_r = ring_arr[0];
		for(int i=1; i<ring; i++) {
			gcdVal = gcd(start_r, ring_arr[i]); 
			sb.append(start_r/gcdVal).append('/').append(ring_arr[i]/gcdVal).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int gcd(int i, int j) {
		// TODO Auto-generated method stub
		int max = Math.max(i, j);
		int min = Math.min(i, j);
		
		while(min != 0) {
			int r = max%min;
			max = min;
			min = r;
		}
		return max;
	}

}
