package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _5622_다이얼전화 {
	
	/*
	 * 숫자	문자	시간
		1 :			2
		2 : ABC		3
		3 : DEF		4
		4 : GHI		5
		5 : JKL		6
		6 : MNO		6
		7 : PQRS	8
		8 : TUV		9	
		9 : WXYZ	10
		
		WA
		92 -> 10 + 3
	*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int arr[] = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<26; i++) {
			map.put((char)(i+65),arr[i]+1);
		}
		
		String str = br.readLine();
		
		int sum=0;
		for(int i=0; i<str.length();i++) {
			sum += map.get(str.charAt(i));
		}
		
		System.out.println(sum);
		
		
		
	}

}

