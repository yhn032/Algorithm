package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10430_³ª¸ÓÁö {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		sb.append((a+b)%c).append('\n');
		sb.append(((a%c)+(b%c))%c).append('\n');
		sb.append((a*b)%c).append('\n');
		sb.append(((a%c)*(b%c))%c).append('\n');
		
		System.out.println(sb);
	}

}
