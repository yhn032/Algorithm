package DivideAndConquor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629 {
	
	static long C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long result = multiplexer(A, B);
		System.out.println(result);
	}

	private static long multiplexer(long a, long b) {
		// TODO Auto-generated method stub
		if(b == 1) return a%C;
		
		long temp = multiplexer(a, b/2);
		
		if(b %2 == 1) return (temp*temp%C) * a % C;

		return temp*temp%C;
	}
}
