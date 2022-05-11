package DateStrucImple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class _3190_snake {
	static int N, K, X, L, d=0;
	static String C;
	static Map<Integer, String> move;
	static int map[][];
	//   				R  D   L   U
	static int dx[] = {1, 0, -1,  0};
	static int dy[] = {0, 1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//�Է¹ޱ� 
		//������ ũ��
		N = Integer.parseInt(br.readLine());
		
		//����� ����
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		move = new HashMap<Integer, String>();
		
		//����� ��ġ �ʱ�ȭ �ϱ�
		//������ġ�� ���������� 1�� 1���̶�� ������, ���� 0,0�� ���� ���̱� ������ 
		//�ε����� �����ֱ� ���ؼ� �Է¹��� ����� ��ġ���� -1�Ͽ� �迭�� �ε����� �µ��� �����Ѵ�.
		for(int i=0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			//����� 1�� ǥ��. ������������ ����� ������ �� ����
			map[a][b] = 1;
		}
		
		//������ȯ������ ����
		L = Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine()); 
			//�ð� ����
			X = Integer.parseInt(st.nextToken());
			//���� ���� D(right), L(left)
			C = st.nextToken();
			move.put(X, C);
		}
		
		Dummy();
	}

	private static void Dummy() {
		// TODO Auto-generated method stub
		Deque<Integer> dq = new LinkedList<Integer>(); 
		//��ť�� ����ϸ鼭 ���̰� ������ ���ο� ��ġ�� ť�� �����鼭 ���� ����
		//���̰� ������ ť�� ��Ҹ� ����ؼ� ���� ����
		//ť�� ���� size�� ���� ���̰� �ȴ�. front����; rear�Ӹ�;
		
		dq.add(0);//�������� �Ӹ�
		int time = 0; 
		int snake_x = 0;
		int snake_y = 0;
		
		//�������ǿ� ������ ������ ���� �ݺ�(Ż�������� �����ؾ� �Ѵ�.)
		while(true) {
			time++; //Ÿ�� ����
			int xx = snake_x + dx[d];
			int yy = snake_y + dy[d];
			
			
			//���� �ε��� ��� ����
			if(xx > N-1 || yy > N-1 || xx < 0 || yy < 0) {
				break;
			}
			
			//�ڽ��� ���뿡 �ε��� ��� ���� ny*n + nx
			if(dq.contains(yy*N + xx)) {
				break;
			}
			
			//���� ���� ������ �������� �ʴ´ٸ� ���� �̵���Ű��.
			if(map[yy][xx] == 1) {//����� �����ϴ� ��� �������� -> ����� ��ġ�� �Ӹ��� �߰��ϱ� 
				map[yy][xx] = 0;//�Ծ����� 0���� �ʱ�ȭ
				//�� �迭�� ��ҿ� ��ȣ���� �ٿ��� �� ��ȣ�� ť�� �ְ� 
				//ť�� �����ϴ� ��ȣ�� ���� ���̰� �����ϴ� �����̴�.
				dq.add(yy*N + xx);
			} else { //����� ���� ��� ������ �ڸ��� �Ӹ��� �̵�.
				dq.add(yy*N + xx);
				dq.poll();
			}
			
			//���� �̵��� ����Ǽ�
			//���� �ð��� ���� ��ȯ ����� ���� �ϳ����
			if(move.containsKey(time)){
				String data = move.get(time);
				if(data.equals("D")) {
					d += 1;
					if(d == 4) d = 0;
				}else {
					d -= 1;
					if(d ==-1) d = 3;
				}
				
			}
			
			//���� ��ġ�� ���� �̵��� ���� �ʱ���ġ�� ����
			snake_x = xx;
			snake_y = yy;
			
		}
		System.out.println(time);
		
	}

}
