package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _11478_부분문자열 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();
		
		
		String str = br.readLine();
		
		for(int i=1; i<=str.length();i++) {
			for(int k=0; k<=str.length()-i; k++) {
				String part = str.substring(k , k+i);//k부터 i개
				set.add(part);
			}
		}
		System.out.println(set.size());
	}

}

