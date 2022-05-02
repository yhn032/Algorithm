package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_Findme {
	static int[] time = new int[100001];
	static int N;
	static int K;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//�������� ��ġ
		N = Integer.parseInt(st.nextToken());
		//������ ��ġ
		K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println(0);
		}
		else {
			bfs(N);
		}
	}

	private static void bfs(int n) {
		// TODO Auto-generated method stub
		//�ʺ�켱Ž���� ��� Ž�������� �������� ť ����
		Queue<Integer> q = new LinkedList<>();
		//������ġ(�������� ��ġ)�� ť�� �ִ´�.
		q.add(n);
		time[n] = 1; //�ð��� 1�� ���������� ���� 1�� �������Ѽ� �����̰� ������ ��������, �ð��� üũ���ش�.

		
		while(!q.isEmpty()) {
			//ť�� �ִ� ������ �ϳ��� ������ Ž���� ������ �Ŵ�.
			int temp = q.poll();
			
			for(int i=0; i<3; i++) {
				int next = 0;
				
				if(i==0) {//���������� �̵��ϴ� ����� ��, Ž���� �ʿ��� �ε���
					next = temp + 1;
				} else if(i==1) {//�������� �̵��ϴ� ����� ��, Ž���� �ʿ��� �ε���
					next = temp - 1;
				} else {//�����̵��ϴ� ����� ��, Ž���� �ʿ��� �ε���
					next = temp * 2;
				}
				//ã�Ҵٸ� ����ϰ� ����
				if(next==K) {
					System.out.println(time[temp]);
					return;
				}
				
				//�迭�ȿ� �ִµ� ���� Ž������ ���� ���̶�� Ž�� ����̹Ƿ� ť�� �߰��Ѵ�.
				//Ž���� ��ġ�� ����� �ð��� ���� ��ġ���� ����Ǿ��� �ð����� +1�Ѵ�.
				if(next >= 0 && next < time.length && time[next] == 0) {
					q.add(next);
					//Ž����ġ �ð� = ���� ��ġ �ð� + 1 -> 1�ʰ� ����ؼ� Ž���� ���� ������ �����ִ� ��
					time[next] = time[temp] + 1;
				}
			}
			
		}
	}

}
