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
		//국가의 수
		int N = Integer.parseInt(st.nextToken());
		//순위를 알고 싶은 국가번호
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
				//두 값을 비교했을 때, 디폴트 정렬은 오름차순이므로 
				//두 값의 차이가(o1 - o2)
				//음수 -> 값의 위치를 교환하지 않는다. 
				//양수 -> 값의 위치를 교환한다. 
				//내림차순으로 정렬할 경우 오름차순 정렬법에서 비교 기준만 반대로 하면 된다.
				//두 값의 차이가(o2 - o1)
				//음수 -> 값의 위치를 교환하지 않는다.
				//양수 -> 값의 위치를 교환한다.
				
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
				//기본값으로 1을 주고, 내림차순으로 정렬했으니 어차피 rk[0]은 1등이다. 
				//따라서 rk[0]과 rk[1]의 모든 메달의 수가 같은 경우가 아니라면 후자는 자동으로 전자의 순위+1해서 2등이 된다.
				rk[i].rank = i+1;
			}
		}
	}

}
