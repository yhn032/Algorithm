package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1316_그룹단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		List<Character> list = new ArrayList<Character>();
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		OUT:
		for(int i=0 ; i<n; i++) {
			String str = br.readLine();
			list.clear();
			for(int k=1; k<str.length();k++) {
				char c1 = str.charAt(k-1);
				char c2 = str.charAt(k);
				
				if(c1 != c2) {//이전값과 다음값이 다르다면,,,
					
					if(!list.contains(c1) && !list.contains(c2)) {//이전 값을 갖고 있지 않으면 값을 넣어라.
						list.add(c1);
						//list.add(c2);
					}else {//해당 값을 갖고 있는데 또나온거다.
						continue OUT;
					}
				}
				
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}

}

/*
	문자가 반복해서 등장해야 한다.
	하나의 문자도 1개가 연속적인 것으로 한다. 
	단, 반복적으로 등장하는데 그 사이에 다른 문자가 끼어있으면 그룹단어가 아니다. 
	
	반복이 끝날때마다 -> 값이 바뀔때마다 list에 바뀌기 이전의 값을 넣는다. 
	값을 넣기 전에 리스트에 값이 있는지 검사한다. -> 없으면 넣고, 만약 있다면 앞에서 등장했는데 또나왔다는 의미이므로 그룹단어가 아니다.
*/

