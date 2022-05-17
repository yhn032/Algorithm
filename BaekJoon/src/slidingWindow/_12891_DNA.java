package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891_DNA {
	static int checkDNA[];
	static int currentDNA[];
	static int checkSecret;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//문자열의 크기 S, 부분 문자열의 크기 P
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		//조건에 충족하는 윈도우의 개수를 계수해줄 변수
		int cnt = 0;
		
		//문자열 데이터 
		char DNA[] = new char[S];
		
		//비밀번호 체크 배열 -> 개수의 기준을 잡아주는 조건 배열 A C G T
		checkDNA = new int[4];
		
		//현재 부분 문자열의 상태 배열 -> 현재 부분 문자열을 이루는 문자의 개수가 몇 개인지 저장
		currentDNA = new int[4];
		
		//조건 배열와 상태배열을 비교해서 조건에 충족하는 문자의 개수를 담을 변수
		checkSecret = 0;
		
		//문자열 데이터를 입력받아서 문자열 배열로 만들기 
		DNA = br.readLine().toCharArray();

		//조건배열 초기화하기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			checkDNA[i] = Integer.parseInt(st.nextToken());
			
			if(checkDNA[i] == 0) {
				//조건으로 주어지는 개수가 0개라면,,, -> 조건을 체크할 필요가 없다. 0개보다 많아야 한다는 기준은 비교를 하지 않아도 만족하지 않는가? 
				//미리 카운트 해줘서 비교를 최대한 줄여주자.
				checkSecret++;
			}
		}
		
		//가장 초기의 P 부분 문자열을 처리한다. 
		//쉽게 말해 가장 처음으로 잡게되는 부분 문자열에 대해, 상태배열을 초기화 해주는 작업
		for(int i=0; i<P; i++) {
			Add(DNA[i]);
		}
		
		//초기 윈도우가 조건을 만족한다면 카운트 증가
		if(checkSecret == 4) cnt++;
		
		//본격적으로 윈도우를 슬라이딩 하는 부분
		//가장 초기에 생성된 내용에 대해서는 위에서 유효성 검사를 했으니 오른쪽으로 한 칸 이동한다.
		for(int i=P; i < S; i++) {
			int j = i-P;
			//한 칸 옆으로 이동한 후 가장 마지막 위치 -> 새로 들어온 문자
			Add(DNA[i]);
			
			//삭제해야하는 문자 -> 이전 윈도우의 시작지점
			Delete(DNA[j]);
			
			//변경사항을 수정하고 상태 확인
			if(checkSecret == 4) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void Delete(char c) {
		// TODO Auto-generated method stub
		switch(c) {
		case 'A':
			//현재 상태배열의 개수를 줄이기 전에 상태배열과 조건배열이 같았다면, 이제는 조건을 만족하지 못하게 되므로 checksecret값을 1감소 시키고 상태배열을 갱신한다.
			if(currentDNA[0] == checkDNA[0]) {
				checkSecret--;
			}
			currentDNA[0]--; //상태 배열 상에서 A에 대한 개수를 감소
			break;
		case 'C':
			if(currentDNA[1] == checkDNA[1]) {
				checkSecret--;
			}
			currentDNA[1]--; 
			break;
			
		case 'G':
			if(currentDNA[2] == checkDNA[2]) {
				checkSecret--;
			}
			currentDNA[2]--; 
			break;
			
		case 'T':
			if(currentDNA[3] == checkDNA[3]) {
				checkSecret--;
			}
			currentDNA[3]--; 
			break;
			
	}
	}

	private static void Add(char c) {
		// TODO Auto-generated method stub
		switch(c) {
			case 'A':
				currentDNA[0]++; //상태 배열 상에서 A에 대한 개수를 증가
				if(currentDNA[0] == checkDNA[0]) {
					//상태배열이 조건배열보다 클때마다 ++을 해주면 값이 새로들어올때마다 조건만 만족하면 계속해서 +되므로, 처음으로 같을 때 한 번만 체크한다. 
					//어차피 윈도우가 움직일때, 새로 들어온것과 빠진 문자에 대해서만 체크하기 때문에 한문자에 대한 checkSecret값의 증감이 1보다 크지 않다.
					checkSecret++;
				}
				break;
			case 'C':
				currentDNA[1]++; //상태 배열 상에서 A에 대한 개수를 증가
				if(currentDNA[1] == checkDNA[1]) {
					checkSecret++;
				}
				break;
				
			case 'G':
				currentDNA[2]++; //상태 배열 상에서 A에 대한 개수를 증가
				if(currentDNA[2] == checkDNA[2]) {
					checkSecret++;
				}
				break;
				
			case 'T':
				currentDNA[3]++; //상태 배열 상에서 A에 대한 개수를 증가
				if(currentDNA[3] == checkDNA[3]) {
					checkSecret++;
				}
				break;
				
		}
	}

}


/*
	슬라이딩 윈도우는 2개의 포인터로 범위를 지정한 다음, 범위를 유지한채로 이동하며 문제를 해결합니다. 
	
	
	P와 S의 최대 길이가 1,000,000으로 매우 크다. 중첩 반복을 쓰면 시간이 초과된다. 반복문 내부에서 반복횟수를 최적화할 수도 있겠지만
	시간복잡도를 O(n)으로 줄여볼 수 있는 슬라이딩 윈도우를 사용해보자 
	
	전제 문자열이 S이고, 부분문자열이 P일때 
	1. 두개의 포인터 간격을 문자열의 길이로 잡고 이 크기를 유지한다.(윈도우)
	2. 크기를 유지한 상태로 옆으로 이동하면서 조건을 체크한다.(슬라이딩)
	이렇게하면 배열S의 길이만큼만 탐색하면 되므로 O(n) 삽가능
 */