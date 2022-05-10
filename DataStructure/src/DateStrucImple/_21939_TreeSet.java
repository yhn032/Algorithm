package DateStrucImple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
/*
	recommend�� solved�� �ϳ� �̻� �������� �����Ѵٰ� ������ ���ܴ� ����� �ʿ䰡 ����. 
	������ȣ�� ���̵��� ������ �ڷᱸ���� �ʿ��� �� ����. 
	������ȣ�� �ߺ��� �Ұ��������� ���̵��� �ߺ� ���� -> map�� ����ؼ� ������ȣ�� key��, ���̵��� value�� ����. 
	������ ��� �ұ�? -> treeset�� ����ؼ� ������ ���·� ����. ���ı��ظ� ������ָ� �� ��  
*/
public class _21939_TreeSet {
	
	public static class Algorithm implements Comparable<Algorithm>{
		
		int idx_P;
		int level_L;
		
		public Algorithm() {
			
		}
		
		public Algorithm(int idx_P, int level_L) {
			// TODO Auto-generated constructor stub
			this.idx_P = idx_P;
			this.level_L = level_L;
		}
		
		@Override
		public int compareTo(Algorithm o) {
			// TODO Auto-generated method stub
			
			//���̵��� ���� ��� ������ȣ(idx)�� �������� �����մϴ�.
			if(level_L == o.level_L) {
				return idx_P - o.idx_P;
			} else { 
				return level_L - o.level_L;
			}
		}
		public String toString() {
			return "idx_P : " + idx_P + " level_L : " + level_L;
		}
		
	}
	
	//
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Algorithm> set = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			set.add(new Algorithm(P, L));
			map.put(P, L);
		}
		
		
		//System.out.println(set.toString());
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
				case "add": 
					int idx_P = Integer.parseInt(st.nextToken());
					int level_L = Integer.parseInt(st.nextToken());
					set.add(new Algorithm(idx_P,level_L));
					map.put(idx_P, level_L);
					break;
				case "recommend":
					if(Integer.parseInt(st.nextToken())==1) {
										//last�� ���� ū ��
										//��ü������ ������ ��, ���̵� ������ ������ �ǰ�, ���̵��� ���� ��� ���� ��ȣ�� ū ���� �ڿ� ������ �������� ���ĵ�
										//���� ���� ������(last)���� recommend 1�� �����ϴ�.
						sb.append(set.last().idx_P).append('\n');
					} else { //-1�̶�� -> ���̵��� ���� ����, ��������� ���� ��ȣ�� ���� ������(���������̹Ƿ� �̶��� ����)
						sb.append(set.first().idx_P).append('\n');
					}
					break;
				default://solved
					int P = Integer.parseInt(st.nextToken());
					set.remove(new Algorithm(P, map.get(P)));
					map.remove(P);
					break;
				
			}
		}
		System.out.println(sb);
	

		
	}

}
