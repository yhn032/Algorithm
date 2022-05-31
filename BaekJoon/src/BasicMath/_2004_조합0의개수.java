package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2004_조합0의개수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int diff = n-m;
		
		long cnt_5 = five_pow(n) - five_pow(diff) - five_pow(m);
		long cnt_2 = two_pow(n) - two_pow(diff) - two_pow(m);
		
		long min = Math.min(cnt_5, cnt_2);
		
		System.out.println(min);
		
	}

	private static long five_pow(int n) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		/*
			n = 25라면 25!은 25*24*23*...*3*2*1이다. 이 경우 5를 승수로 가지는 경우의수는 25 20 15 10 5이다. 이는 n/5인 5의 개수와 동치
		*/
		while (n >= 5) {
			count += (n / 5);
			n /= 5;
		}
		return count;
	}
	
	private static long two_pow(int n) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		while (n >= 2) {
			count += (n / 2);
			n /= 2;
		}
		return count;
	}
}

/*
	C(n,m)에서 끝자리 0의 개수를 출력하시오
	
	해당 수(target)의 약수 중에서 10의 배수의 개수를 구하라.
	
	입력범위
	0<= m <= n <= 2,000,000,000     n!=0
	
	C(n,m) = n!/(m!*(n-m)!)
		   = (n*...*n-m+1)/m!
		   
	0! == 1! == 1
	
	"조합은 반드시 정수로 떨어진다." n >= m이므로
	
	
*/
