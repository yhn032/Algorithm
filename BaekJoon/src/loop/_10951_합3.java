package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10951_гу3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		
		while( (str=br.readLine()) != null ) {
				
				int a = str.charAt(0) - 48;
				int b = str.charAt(2) - 48;
				
				sb.append(a+b).append('\n');
		}
		System.out.println(sb);
	}

}

