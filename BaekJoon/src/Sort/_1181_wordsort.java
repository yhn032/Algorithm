package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class _1181_wordsort {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<word> set = new TreeSet<word>();
		for(int i=0; i<N;i++) {
			String str = br.readLine();
			set.add(new word(str, str.length()));
		}
		
		for(word s : set) {
			System.out.println(s);
		}
		
	}

}

class word implements Comparable<word>{
	
	String str;
	int str_length;
	
	public word(String str, int str_length) {
		this.str = str;
		this.str_length = str_length;
	}

	@Override
	public int compareTo(word o) {
		// TODO Auto-generated method stub
		//글자수가 같으면 사전 순으로 정렬
		if(this.str_length == o.str_length) { 
			//문자열을 비교하는 방법
			return this.str.compareTo(o.str); 
		}
		 
		return this.str_length - o.str_length;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.str;
	}
	
}
