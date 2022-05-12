package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107_remote {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//목표 채널
		int N = Integer.parseInt(br.readLine());
		
		//고장난 버튼수
		int M = Integer.parseInt(br.readLine());
		
		boolean error[] = new boolean[10];
		if(M != 0) { //고장난 버튼이 있는 경우는 불린 배열 갱신
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int n = Integer.parseInt(st.nextToken());
				error[n] = true;//고장난 버튼의 인덱스에 해당하는 위치에는 true값을 주어 고장남을 표시해주자. -> 나머지는 기본값인 false
			}
		} 
		//고장난 버튼이 없는 경우는 모두 false상태로 시작
		
		/*
		 * for(int i =0; i<error.length;i++) { System.out.println(error[i]); }
		 */
		//+,-버튼으로만 이동해야 하는 경우와, 숫자버튼을 눌러서 근사값으로 이동한 후에 +,-으로 추가 이동하는 경우 2가지 경우의 최소값을 구한다.
		
		
		//1. 0~9까지의 버튼이 모두 고장나서 +,-버튼으로만 가야한다면 그때의 버튼을 눌러야 하는 경우의 수
		int result = Math.abs(N-100);
		
		//목표 채널과 근사한 숫자를 누른후에 +,-로 이동하는 경우
		//근사한 값을 찾는 경우의수가 너무 많아서 그냥 깡으로 다 검사하자 [완전탐색]
		//기본적으로 숫자버튼을 누르는 횟수를 글자수로 받아서 카운트해준다.
		/*
			0~999999의 모든 숫자를 탐색할거다. 
			최악의 경우를 생각하면 최대 채널번호인 500000으로 이동해야할 때 자릿수를 보아하니 채널은 6자리수가 최대이고, 버튼 중 가장 큰수 9를 제외하고 모두 고장났다고 가정할 때, 
			999999까지 이동해서 +,-버튼으로만 이동해야 할 수도있음(100에서 부터 이동하는게 최솟값일 수도 있지만 고장나지 않은 버튼이 9만 있다고 가정하면 최대값은 999999이다.)
		*/
		
		for(int i =0; i<=999999; i++) {
			//숫자 버튼을 눌러서 이동하고자 하는 값의 길이를 구한다. 길이가 숫자버튼을 누르는 횟수가 되리라.
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean broken = false;
			//2-1
			//근사값으로 누르기 전에 만약 고장난 버튼을 눌러야 하는 상황이 온다면 바로 패스해버리자.
			for(int j=0; j<len;j++) {
				//문자열을 정수화 시키기
				if(error[str.charAt(j)-'0']) {
					//여기서 true를 주었으니 밑에 조건을 검사하지 않고 바로 다음으로 넘어간다. 
					broken= true;
					break;
				}
			}
			if(broken==true) continue;
			//2-2
			if(!broken) {//이동할 수 있는 값 중에서 모든 숫자를 버튼으로 누를 수 있는 경우 
				//초기위치 100에서 버튼으로 눌러서 이동할 수 있는 위치 i와의 차이를 구하고, 버튼을 누르는 횟수는 문자열의 길이이므로 더해준다. 
				//이런식으로 모든 경우의수를 탐색하면서 최솟값을 구해주는 과정을 반복하면 반복문이 종료되었을 때는 가장 작은 값이 남아있겠지,,,?
				int min = Math.abs(N-i) + len;
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
		
	}

}
