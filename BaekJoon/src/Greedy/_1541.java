package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * String s = "0009"; String w = "01"; int a = Integer.parseInt(s); int b =
		 * Integer.parseInt(w); System.out.println(a); System.out.println(b);
		 * System.out.println(a-b);
		 */
		//-�� �������� ���ڿ��� �и��� �� ���ϱ� ������ ���� �ؾ� �Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
				
		String[] operand = sentence.split("-");
		
		int dap = 0;
		
		for(int i =0; i<operand.length;i++) {
			int sum =0;
			//System.out.println(operand[i]);
			if(operand[i].contains("+")) {
				String []plus = operand[i].split("[+]");
				for(int k=0; k< plus.length;k++) {
					sum += Integer.parseInt(plus[k]);
				}
				operand[i] = String.valueOf(sum);
			}
			//System.out.println(operand[i]);
		}
		
		int start = Integer.parseInt(operand[0]);
		
		for(int i=1; i < operand.length;i++) {
			start -= Integer.parseInt(operand[i]);
		}
		System.out.println(start);
	}

}