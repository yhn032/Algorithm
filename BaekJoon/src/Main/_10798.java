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
		
		//������ �Է¹ޱ� 
		for(int i=0; i < text.length; i++) {
			String temp = br.readLine();
			//				�� �ึ�� ���� ������ �ٸ� �� ����
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
