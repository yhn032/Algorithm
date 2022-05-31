package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11050_이항계수1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int a = factorial(n);
		int b = factorial(k);
		int c = factorial(n-k);
		
		int answer = a/(b*c);
		System.out.println(answer);
	}

	private static int factorial(int n) {
		// TODO Auto-generated method stub
		if(n==0) {//0! = 1
			return 1;
		}
		
		int fact=1;
		
		for(int i=n;i>1; i--) {
			fact *= i;
		}
		return fact;
	}

}
