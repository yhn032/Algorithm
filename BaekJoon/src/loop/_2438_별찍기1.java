package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2438_�����1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			for(int k=1; k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}

