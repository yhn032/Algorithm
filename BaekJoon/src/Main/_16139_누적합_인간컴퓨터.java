package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16139_누적합_인간컴퓨터 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String question = br.readLine();
		
		
		//누적합 배열을 만들자
		//dp[n][a] -> 0~n까지의 범위중에서 특정 문자 a의 개수를 저장한다. a에는 특정 문자의 아스키코드값에서 'a'를 뺀값을 저장한다.
		//2~5까지의 범위가 주어진다면 
		//dp[5][a] - dp[1][a이다. 
		//모든 알파벳의 수는 26개이다. a-z
		int dp[][] = new int[question.length()][26];
		
		
		//문자열은 변하지 않기 때문에 
		//해당 문자열에서 특정 구간에서 특정 문자열이 몇개가 있는지를 각각 저장하면 된다.!
		//문자열을 한 번만 O(n)으로 탐색하면서 특정 문자열이 등장했을때 해당 문자열의 아스키코드값에 해당하는 번지수에 이전값보다+1을 저장한다. 
		//특정문자가 연속되면 값이 1,2,3 이런식으로 되겠지만 웬만하면 0이 반복될 것이다. 
		//메모리 낭비가 있어보이긴 하는데 이렇게라도 해야지,,, 
		
		//초깃값 초기화. 모든 알파벳 소문자는 'a'보다 크거나 같으니 인덱스가 음수가 될 일은없음
		dp[0][question.charAt(0)-'a']++;
		
		//초깃값을 제외한 다음 문자부터 값을 저장한다.
		for(int i=1; i<question.length(); i++) {
			int tmp = question.charAt(i)-'a';
			
			for(int j=0; j<26; j++) {
				dp[i][j] = dp[i-1][j]; //해당 문자열에 대해 이전값을 누적한다. 
			}
			
			dp[i][tmp]++; //특정 문자열의 등장 횟수르 증가시킨다.
		}
		
		
		
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0; k<t; k++) {
			st = new StringTokenizer(br.readLine());
			
			char find = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			
				
			
			if(start == 0) {
				sb.append(dp[end][find-'a']).append('\n');
			}else {
				sb.append(dp[end][find-'a'] - dp[start-1][find-'a']).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}

}
