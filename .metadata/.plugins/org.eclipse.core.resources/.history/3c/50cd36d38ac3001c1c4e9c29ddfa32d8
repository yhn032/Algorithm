package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		//적절한 동전이 선택된 경우 계수
		int count = 0;
		//동전의 종류 개수
		int N = Integer.parseInt(st.nextToken());
		//조합해야할 금액
		int K = Integer.parseInt(st.nextToken());
		int money[] = new int[N];
		
		for(int i=0; i<N;i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		//동전의 가치가 가장 큰 것부터 비교를 시작합니다. 
		for(int i=N-1; i>=0; i--) {
			//몫 연산자가 0보다 커야 그 동전을 사용할 수 있음 -> 만들고자 하는 K가 4000인데 10000을 사용할 수 있나? 몫연산자가 적어도 1은 나와야 함
			if((K/money[i])>0) {
				count += K/money[i];
				K = K%money[i];//다음 연산에서는 동전을 사용하고 남은 돈에 대헤 가치를 생각해야 한다.
			}
		}
		System.out.println(count);
		
	}

}
