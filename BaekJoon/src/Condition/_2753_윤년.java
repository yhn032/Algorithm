package Condition;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2753_À±³â {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		
		if(year %4 ==0 && year%100 !=0 || year % 400==0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}

