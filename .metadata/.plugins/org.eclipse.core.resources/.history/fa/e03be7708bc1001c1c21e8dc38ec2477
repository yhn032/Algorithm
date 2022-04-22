package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char text [][] = new char[5][15];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//데이터 입력받기 
		for(int i=0; i < text.length; i++) {
			String temp = br.readLine();
			//				각 행마다 열의 개수가 다를 수 있음
			for(int k=0; k < temp.length(); k++) {
				text[i][k] = temp.charAt(k);
			}
		}
		
		for(int t = 0; t < 15; t++) {
			for(int m = 0; m < 5 ; m++) {
				if(text[m][t] == '\0')
					continue;
				sb.append(text[m][t]);
			}
		}
		
		System.out.println(sb);
		
		
	}

}
