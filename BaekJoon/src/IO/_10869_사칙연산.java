package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10869_사칙연산 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		sb.append(A+B).append('\n');
		sb.append(A-B).append('\n');
		sb.append(A*B).append('\n');
		sb.append(A/B).append('\n');
		sb.append(A%B).append('\n');
		
		System.out.println(sb);
	}

}
