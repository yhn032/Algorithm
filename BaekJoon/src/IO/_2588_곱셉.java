package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2588_°ö¼Á {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		
		int arr2[] = new int[3];
		String str = br.readLine();
		for(int i=0; i<3; i++) {
			arr2[i] = str.charAt(i) - '0';
		}
		
		sb.append(a*arr2[2]).append('\n');
		sb.append(a*arr2[1]).append('\n');
		sb.append(a*arr2[0]).append('\n');
		sb.append(a*arr2[2] + a*arr2[1]*10 + a*arr2[0]*100).append('\n');
		System.out.println(sb);
	}

}
