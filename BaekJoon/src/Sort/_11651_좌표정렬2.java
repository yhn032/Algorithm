package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _11651_좌표정렬2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n =Integer.parseInt(br.readLine());
		pos2 p[] = new pos2[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			
			p[i] = new pos2(x, y);
		}
		
		//증가하는 방향 -> 오름차순
		Arrays.sort(p, new Comparator<pos2>() {

			@Override
			public int compare(pos2 o1, pos2 o2) {
				// TODO Auto-generated method stub
				if(o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
			
		});
		
		for(pos2 pp : p) {
			System.out.println(pp.x + " " + pp.y);
		}
	}
}

class pos2 {
	int x;
	int y;
	
	public pos2(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
