package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686_ġŲ��� {
	static int N,M;
	static int map[][];
	static List<pos> house;
	static List<pos> chick;
	static boolean chick_house[];
	static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		house = new ArrayList<>();
		chick = new ArrayList<>();
		
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int k=0; k < N ;k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				
				if(map[i][k] == 1) { 
					house.add(new pos(i, k));
				
				}else if(map[i][k] == 2) {
					chick.add(new pos(i,k));
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		chick_house = new boolean[chick.size()]; //���� �ִ� ġŲ��
	
		//���� ��ȣ, ����(ġŲ�� ����)
		dfs(0, 0);
		
		System.out.println(answer);
	}
	private static void dfs(int start, int count) {
		// TODO Auto-generated method stub
		
		//base case
		if(count==M) {//�����ִ� ġŲ���� M�� ���ٸ�. ��� �Ÿ��� �ּڰ��� ���Ѵ�.
			int res=0;
			
			for(int i=0; i< house.size(); i++) {
				
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j < chick.size(); j++) {
					if(chick_house[j]) { //�湮�� ġŲ���� ���ؼ��� ������� ���� �Ÿ��� �ּڰ��� ���Ѵ�. 
						int dist = Math.abs(house.get(i).x - chick.get(j).x)
								+ Math.abs(house.get(i).y - chick.get(j).y);
						
						temp = Math.min(temp, dist);
					}
				}
				
				res += temp;
			}
			
			answer = Math.min(answer, res);
			return;
		}
		
		
		//recursive case
		for(int i=start; i<chick.size(); i++) {
			chick_house[i] = true;
			dfs(i+1, count+1);
			chick_house[i]=false;
		}
	}

}
class pos {
	int x;
	int y;
	
	pos(){
		
	}
	
	pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}


/*
	���� â���� ���� ���� -> ��� �������� ����� ���� ġŲ���� ����� �������� ���
	���� ġŲ���� ��ǥ�� ���� �ڷᱸ���� ����
	�����ִ� ġŲ���� ������ M�� ���ٸ�, ��� ���� ���Ͽ� M���� ġŲ�� �߿��� �ִ� �Ÿ��� ����Ѵ�. 
	Ž���� �����ϴ� ������ ġŲ�� list�� ����� ����� Ž�� ����
	
	������ �̿��� Ǯ�� 
	���� �ִ� ġŲ���� ��ġ�� ��ü���� ����� ���谡 ���� 
	
	��ü ġŲ���� ���� ��ŭ �ݺ�(���)�� �����Ѵ�.
	�ݺ��� �����ϴٰ� ġŲ���� ������ Ư�� �� M�� �������� 
	��͸� �ߴ��ϰ�(base case) ���� �湮�� ġŲ���� ���ؼ� ��� �������� �Ÿ��� ���ϰ� �� �Ÿ��� �ּҰ� �ǵ��� �Ѵ�. -> �׷��� ������ â���
	�ϳ��� ����� ���� ���ؼ� �ּڰ��� ���ߴٸ� return�� ������, ��Ͱ� ���� ���� ȣ���������� ���ư��� �Ǵµ� 
	���ư��� �湮�� ġŲ���� ���� �湮 ǥ�ø� ����� �ǰ�, �ݺ��� ÷�ڰ� �����ϱ� ������ �̹� �湮�� ġŲ���� �ٽ� �湮���� ���� �� �ְ�, �ٸ� ����Ǽ��� ã�� �ȴ�.
	
	
	
	����� ��
	���� 
	������ ������ ����� ���� ��
	ũ�Ⱑ ū �� ���� �̱�
	24 != 42 
	
	���� 
	������ ������ ����� ���� x 
	�μ��� ���� ū ������ ����
	2+4 == 4+2
	
	
*/
