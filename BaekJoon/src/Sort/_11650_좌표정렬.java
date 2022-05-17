package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _11650_좌표정렬 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n =Integer.parseInt(br.readLine());
		pos p[] = new pos[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			
			p[i] = new pos(x, y);
		}
		
		//증가하는 방향 -> 오름차순
		Arrays.sort(p, new Comparator<pos>() {

			@Override
			public int compare(pos o1, pos o2) {
				// TODO Auto-generated method stub
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
			
		});
		
		for(pos pp : p) {
			System.out.println(pp.x + " " + pp.y);
		}
	}
}

class pos {
	int x;
	int y;
	
	public pos(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
