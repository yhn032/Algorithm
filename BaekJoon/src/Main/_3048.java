package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3048 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 왼 -> 오른쪽으로 이동하는 개미 수
		int N1 = Integer.parseInt(st.nextToken());
		// 오른 -> 왼쪽으로 이동하는 개미 수
		int N2 = Integer.parseInt(st.nextToken());

		// 오른쪽으로 이동하는 개미들의 현재 상태
		String temp1 = br.readLine();
		char ant_left_right[] = new char[N1];
		for (int i = 0; i < N1; i++) {
			ant_left_right[i] = temp1.charAt(N1 - 1 - i);// 뒤에서부터 읽어온다.
		}

		String temp2 = br.readLine();
		char ant_right_left[] = new char[N2];
		ant_right_left = temp2.toCharArray();

		// 전체적인 위치를 나타낼 문자배열, 방향을 나타내줄 상태배열. true(right), false(left)
		char ant[] = new char[N1 + N2];
		boolean check[] = new boolean[N1 + N2];

		for (int i = 0; i < N1; i++) {
			ant[i] = ant_left_right[i];
			check[i] = true;
		}

		for (int i = N1; i < N1 + N2; i++) {
			ant[i] = ant_right_left[i - N1];
			check[i] = false;
		}

		
		/*
		 * for (char s : ant) { System.out.print(s); } System.out.println();
		 */
		
		// 이제 비교하면서 swap해보자
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			for (int i = 0; i < ant.length - 1; i++) {
				if (check[i] == true && check[i + 1] == false) {
					// 개미의 위치를 swap
					char tmp = ant[i];
					ant[i] = ant[i + 1];
					ant[i + 1] = tmp;
					// 개미의 방향을 나타내는 상태변수도 swap
					boolean tmp2 = check[i];
					check[i] = check[i + 1];
					check[i + 1] = tmp2;
					/*
					T가 1초씩 증가함에 따라 변하는 상태를 보고자 함이다. 
					비교를 현재위치i에서 다음위치 i+1을 비교하는데, 자리를 바꾸고 
					i++을 해주지 않는다면, 똑같은 개미만 계속 비교를 해서 
					결국 1초동안 A개미는 마주보고 오는 역방향 개미들을 모두 점프하게 된다. 
					따라서 자리를 바꾸었다면,반복이 끝나고 i가 증가하는데 
					i에서 i+1위치로 간 A를 또 검사하지 않기 위해서 i를 마지막에 +1해주어 
					A가 또 비교 대상에 오지 않도록 한다. 
					다음 T에서 어차피 또 A는 마주칠텐데 그때 자리를 스왑하면 됨 
					*/
					i++;
				}
			}

		}
		

		// T가 0이라면 위의 while을 수행하지 않고 바로 초기 상태를 출력한다.
		for (char tmp : ant) {
			System.out.print(tmp);
		}

		/*for (boolean s : check) {
			System.out.print(s + " ");
		}*/

	}

}
