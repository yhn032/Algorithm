package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _8979 {
	static class Rank{
		
		int nationNum = 0;
		int gold = 0;
		int silver = 0;
		int bronze = 0;
		int rank = 0;
		
		Rank(int nationNum, int gold, int silver, int bronze){
			this.nationNum = nationNum;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = 1;
		}

		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		st = new StringTokenizer(br.readLine());
		//������ ��
		int N = Integer.parseInt(st.nextToken());
		//������ �˰� ���� ������ȣ
		int K = Integer.parseInt(st.nextToken());
		
		Rank rk[] = new Rank[N];

		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int nation = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			rk[i] = new Rank(nation, gold, silver, bronze);
		}
		
		
		Arrays.sort(rk,new Comparator<Rank>() {

			@Override
			public int compare(Rank o1, Rank o2) {
				// TODO Auto-generated method stub
				//�� ���� ������ ��, ����Ʈ ������ ���������̹Ƿ� 
				//�� ���� ���̰�(o1 - o2)
				//���� -> ���� ��ġ�� ��ȯ���� �ʴ´�. 
				//��� -> ���� ��ġ�� ��ȯ�Ѵ�. 
				//������������ ������ ��� �������� ���Ĺ����� �� ���ظ� �ݴ�� �ϸ� �ȴ�.
				//�� ���� ���̰�(o2 - o1)
				//���� -> ���� ��ġ�� ��ȯ���� �ʴ´�.
				//��� -> ���� ��ġ�� ��ȯ�Ѵ�.
				
				if(o1.gold > o2.gold) {
					
					return -1;
					
				} else if(o1.gold == o2.gold) {
					
					if(o1.silver > o2.silver) {
						return -1;
					} else if(o1.silver == o2.silver) {
						
						if(o1.bronze > o2.bronze) {
							return -1;
						} else {
							return 0;
						}
					}
				}
				return 1;
			}
			
		});
		
		/*
		for(int i =0; i<N;i++) {
			System.out.printf("%d %d %d %d\n", rk[i].nationNum, rk[i].gold, rk[i].silver, rk[i].bronze);
		}
		*/
		setRank(rk);
		
		for(int i=0; i<N;i++) {
			if(rk[i].nationNum == K) {
				System.out.println(rk[i].rank);
			}
		}
		
	}
	private static void setRank(Rank[] rk) {
		// TODO Auto-generated method stub
		for(int i=1; i<rk.length; i++) {
			if(rk[i].gold == rk[i-1].gold && rk[i].silver == rk[i-1].silver && rk[i].bronze == rk[i-1].bronze) {
				rk[i].rank = rk[i-1].rank;
			} else {
				//�⺻������ 1�� �ְ�, ������������ ���������� ������ rk[0]�� 1���̴�. 
				//���� rk[0]�� rk[1]�� ��� �޴��� ���� ���� ��찡 �ƴ϶�� ���ڴ� �ڵ����� ������ ����+1�ؼ� 2���� �ȴ�.
				rk[i].rank = i+1;
			}
		}
	}

}
