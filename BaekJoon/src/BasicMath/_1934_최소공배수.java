package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1934_최소공배수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//최대공약수
			int N = eucd(Math.max(a, b), Math.min(a, b));
			
			//최소공배수
			int M = a * (b / N);
			
			sb.append(M).append('\n');
		}
		
		
		System.out.println(sb);
			
	}

	private static int eucd(int max, int min) {
		// TODO Auto-generated method stub
		int r = max % min;
		
		if(r == 0) {
			return min;
		} else {
			return eucd(min, r);
		}
	}

}

/*
	유클리드 호제법 : 두 개의 수가 주어졌을 때, 최대공약수를 구하는 알고리즘
	두 개의 수 A, B가 존재하고, A를 B로 나눈 나머지를 C라고 하겠습니다. (A > B)
	이때, A와 B의 최대공약수는 B와 C의 최대공약수와 같습니다.
	
	EX> 두 개의 수 72, 42 중에서 큰 값을 작은 값으로 나머지 연산
	1. 72 % 42 = 30(C)
	앞에서 나눈 수를 다시 나머지로 나눈다.
	2. 42 % 30 = 12(C)
	계속 반복합니다. 
	3. 30 % 12 = 6
	4. 12 % 6  = 0
	나머지가 0이 되었을 때, 나눈 수 6이 최대 공약수가 된다. 


	최소공배수 : 최대 공약수 * (수1/최대공약수) * (수2/최대공약수)


*/