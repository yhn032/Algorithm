package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5086_배수약수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			if(a1 == 0 && a2 ==0) break;
			
			if(a1 < a2 && a2%a1==0) {
				sb.append("factor").append('\n');
			}else if(a1>a2 && a1%a2==0) {
				sb.append("multiple").append('\n');
			}else {
				sb.append("neither").append('\n');
			}
			
		}
		
		System.out.println(sb);
	}

}
