package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2490 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<3;i++) {
			int yuut_count = 0;
			st = new StringTokenizer(br.readLine()," ");
			int [] yuut = new int[4];

			for(int k =0; k < 4; k++) {
				yuut[k] = Integer.parseInt(st.nextToken());
				if(yuut[k] == 1) {
					yuut_count++;
				}
			}
			switch(yuut_count) {
				case 0:
					sb.append('D').append('\n');
					break;
				case 1:
					sb.append('C').append('\n');
					break;
				case 2:
					sb.append('B').append('\n');
					break;
				case 3:
					sb.append('A').append('\n');
					break;
				case 4:
					sb.append('E').append('\n');
					break;
			}
		}
		System.out.println(sb);
	}

}
