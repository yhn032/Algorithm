package recursion;

import java.util.Scanner;

public class _17478_재귀함수가뭔가요 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append('\n');
		
		  
		 
		
		recursion(n,0);
		
		System.out.println(sb);
	}

	private static void recursion(int n, int cnt) {
		// TODO Auto-generated method stub
		_4(cnt);
		sb.append("\"재귀함수가 뭔가요?\"").append('\n');
		
		if (n == cnt) {
			_4(cnt);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append('\n');
			_4(cnt);
			sb.append("라고 답변하였지.").append('\n');
			return;
		}
		
		_4(cnt);
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append('\n');
		_4(cnt);
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append('\n');
		_4(cnt);
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append('\n');
		recursion(n, cnt+1);
		_4(cnt);
		sb.append("라고 답변하였지.").append('\n');
		
	}

	private static void _4(int cnt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cnt; i++) {
			sb.append("____");
		}
	}
}
