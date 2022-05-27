package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686_치킨배달 {
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
		chick_house = new boolean[chick.size()]; //열려 있는 치킨집
	
		//시작 번호, 깊이(치킨집 개수)
		dfs(0, 0);
		
		System.out.println(answer);
	}
	private static void dfs(int start, int count) {
		// TODO Auto-generated method stub
		
		//base case
		if(count==M) {//열려있는 치킨집이 M과 같다면. 모든 거리의 최솟값을 구한다.
			int res=0;
			
			for(int i=0; i< house.size(); i++) {
				
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j < chick.size(); j++) {
					if(chick_house[j]) { //방문한 치킨집에 대해서만 모든집에 대한 거리의 최솟값을 구한다. 
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
	수익 창출을 위한 조건 -> 모든 집에대해 가까운 곳에 치킨집을 남기고 나머지는 폐업
	집과 치킨집의 좌표를 각각 자료구조에 저장
	열려있는 치킨집의 개수가 M과 같다면, 모든 집에 대하여 M개의 치킨집 중에서 최단 거리를 계산한다. 
	탐색을 시작하는 지점이 치킨집 list의 사이즈를 벗어나면 탐색 종료
	
	조합을 이용한 풀이 
	열려 있는 치킨집에 위치가 전체적인 결과에 관계가 없음 
	
	전체 치킨집에 개수 만큼 반복(재귀)을 진행한다.
	반복을 진행하다가 치킨집에 개수가 특정 수 M과 같아지면 
	재귀를 중단하고(base case) 현재 방문한 치킨집에 대해서 모든 집에서의 거리를 구하고 그 거리가 최소가 되도록 한다. -> 그래야 수익이 창출됨
	하나의 경우의 수에 대해서 최솟값을 구했다면 return을 만나고, 재귀가 끝이 나서 호출지점으로 돌아가게 되는데 
	돌아가면 방문한 치킨집에 대한 방문 표시를 지우게 되고, 반복의 첨자가 증가하기 때문에 이미 방문한 치킨집은 다시 방문하지 않을 수 있고, 다른 경우의수를 찾게 된다.
	
	
	
	경우의 수
	순열 
	선택의 순서가 결과에 관계 ㅇ
	크기가 큰 두 수를 뽑기
	24 != 42 
	
	조합 
	선택의 순서가 결과에 관계 x 
	두수의 합이 큰 조합을 고르기
	2+4 == 4+2
	
	
*/
