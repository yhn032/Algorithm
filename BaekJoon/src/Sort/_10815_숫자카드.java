package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//상근이 카드
		int n = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		Set<Integer> ts = new TreeSet<Integer>();
		
		for(int i=0; i<n; i++) {
			ts.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		int check[] = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			if(ts.contains(Integer.parseInt(st.nextToken()))){
				check[i]++;
			}
		}
		
		
		for(int i : check) {
			System.out.print(i + " ");
		}
	}

}

