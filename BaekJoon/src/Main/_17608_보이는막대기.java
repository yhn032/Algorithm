package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _17608_보이는막대기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int building[] = new int[N];
		for(int i=0; i<N;i++) {
			building[i] = Integer.parseInt(br.readLine());
			//System.out.print(building[i] + " ");
		}
		int count=1;
		int max = building[N-1];
		for(int i=N-2; i>=0;i--) {
			if(max < building[i]) {
				count++;
				//7 8 5의 막대기가 주어졌다면 오른쪽에서 봤을 때, 7은 8에 가려져서 보이지 않는다.
				//따라서 현재 맥스값보다 더 큰값이 나오면 최대값을 갱신해서 최대값보다 큰 막대만 보이도록 해야한다.
				max = building[i];
			}
		}
		System.out.println(count);
	}
}
