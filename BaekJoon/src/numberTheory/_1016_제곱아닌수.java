package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016_제곱아닌수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		//소수 대신 제곱수를 기준으로 같은 원리 적용하기 
		boolean[] check = new boolean[(int)(max-min+1)];
		
		for(long i=2; max >= i*i; i++) {//2의 제곱수부터 Max보다 작거나 같을 때까지 반복
			long pow = i*i;
			long start_idx = min/pow;
			
			if(min%pow != 0) {
				start_idx++;//나머지가 있다면 1을 더해야 min보다 큰 값에서 탐색을 시작할 수 있다.
			}
			for(long k = start_idx; pow*k <= max; k++) {
				check[(int)((k*pow)-min)] = true;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<=max-min; i++) {
			if(!check[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}

