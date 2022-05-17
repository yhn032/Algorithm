package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10989_계수정렬 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		int counting[] = new int[10001]; //수의 범위 1~10000
		
		for(int i=0; i<n; i++) {
			counting[Integer.parseInt(br.readLine())]++;//빈도수를 계산해줘야 한다.
		}
		
		//위의 과정을 거치면 counting배열에는 각 숫자의 빈도수가 입력된다. -> 즉 counting[5]의 값은 입력 값중 5의 개수를 나타낸다. 
		//따라서 카운팅소트에 있는 값이 0이될 때 까지 -1을 하면서 결과배열에 출력해준다.
		
		//0은 수의 범위에 포함되지 않으므로 skip
		//인덱스에 해당하는 값이 0이면 건너 뛰기 때문에 배열에 담기엔 인덱스 처리가 골치아픔 바로 출력
		for(int i=1; i<counting.length; i++) {
			while(counting[i] > 0) {
				sb.append(i).append('\n');
				counting[i]--;
			}
		}
		System.out.println(sb);
		
		
	}

}
