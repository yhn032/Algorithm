package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _11478_�κй��ڿ� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();
		
		
		String str = br.readLine();
		
		for(int i=1; i<=str.length();i++) {
			for(int k=0; k<=str.length()-i; k++) {
				String part = str.substring(k , k+i);//k���� i��
				set.add(part);
			}
		}
		System.out.println(set.size());
	}

}

