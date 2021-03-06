package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//도시의 개수 
		int N = Integer.parseInt(br.readLine());
		
		//도로의 길이 
		long []way = new long[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1;i++) {
			way[i] = Long.parseLong(st.nextToken());
		}
		
		//기름의 가격 
		long []oil = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}
		//비싼곳에서는 필요한 만큼만, 싼곳에서 많이
		//처음도시에서는 반드시 주유를 해야한다. 
		//다음으로 도착한 도시보다 기름값이 싼 곳이 있다면 그 곳까지 갈 수 있는 기름만 구매
		//새로 도착한 곳에서 또 자신보다 기름값이 싼 곳이 있다면 그 곳까지 갈 수 있는 기름만 구매 
		//만약 위 과정을 진행하다가 더 이상 저렴한 가격이 없고 도착지점이 나온다면 그대로 꼴인
		
		/*
			N 4
			R 2 3 1
			O 5 2 4 1
		*/
		
		
		long total_oil_price = 0;
		long min_oil_cost = oil[0];
		
		for(int i=0; i<oil.length-1;i++) {
			if(min_oil_cost > oil[i]) {//현재최소값보다 저렴한 기름값을 찾으면 현재 있는 곳에서 기름을 구매하여 그곳까지 이동해라 
				min_oil_cost = oil[i];
			}
			total_oil_price += min_oil_cost * way[i];
		}
		
		System.out.println(total_oil_price);
	}

}
