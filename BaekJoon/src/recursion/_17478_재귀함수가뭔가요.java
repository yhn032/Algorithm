package recursion;

import java.util.Scanner;

public class _17478_����Լ��������� {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.").append('\n');
		
		  
		 
		
		recursion(n,0);
		
		System.out.println(sb);
	}

	private static void recursion(int n, int cnt) {
		// TODO Auto-generated method stub
		_4(cnt);
		sb.append("\"����Լ��� ������?\"").append('\n');
		
		if (n == cnt) {
			_4(cnt);
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"").append('\n');
			_4(cnt);
			sb.append("��� �亯�Ͽ���.").append('\n');
			return;
		}
		
		_4(cnt);
		sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.").append('\n');
		_4(cnt);
		sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.").append('\n');
		_4(cnt);
		sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"").append('\n');
		recursion(n, cnt+1);
		_4(cnt);
		sb.append("��� �亯�Ͽ���.").append('\n');
		
	}

	private static void _4(int cnt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cnt; i++) {
			sb.append("____");
		}
	}
}
