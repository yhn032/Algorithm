package Kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
	각 유저당 한 번에 1명 신고가능
	단, 동일인물에 대해서 신고횟수는 1로 count. 한 사람이 특정인물을 여러번 신고해도 count되지 않음
	신고한 사람이 이용정지가 되면 그 사람을 신고한 사람에게 메일 전송을 하는데 이 횟수를 출력하라.(return, id_list에 담긴 순서대로)
*/


class Solution3 {
    public int[] solution(String[] id_list, String[] report, int k) {
    	//신고 내역 
    	int[] answer = new int[id_list.length];
    	
    	//리스트에 있는 유저명과 배열의 인덱스값을 저장
        HashMap<String, Integer> mapIdx = new HashMap<String, Integer>();
        //신고당한 유저와 이 사람을 신고한 유저들을 저장
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        //기본 셋팅
        for(int i=0; i<id_list.length;i++) {
            String name = id_list[i];//사용자 ID
            mapIdx.put(name, i); //사용자ID에 대해서 인덱스값과 함께 저장
            map.put(name, new HashSet<>());
        }
    	
    	for(int i=0; i<report.length;i++) {
    		String result[] = report[i].split(" ");
    		//신고한 사람의 ID
    		String a = result[0];
    		//신고당한 사람의 ID
    		String b = result[1];
    		//신고당항 사람의 id와 매핑된 value값에다가 신고한 사람의 id를 추가한다. 단, HashSet의 특성상 중복은 불가능하다. -> 한 사람이 여러번 신고해도 1 count
    		map.get(b).add(a);
    	}
		//map2를 순환
		for(int i=0; i<id_list.length;i++) {
			//id_list[i]를 신고한 사람들이 저장되어 있음
			HashSet<String> send = map.get(id_list[i]);
			if(send.size() >= k) { //이용 정지대상이라면
				
				//아까 정한 임의의 인덱스로 id_list에 저장된 id와 같은 순서로 메일통보 횟수 저장
				//위에서 뽑은 send내의 있는 사용자에게 메일을 보내는 횟수를 +1
				for(String name : send) {
					answer[mapIdx.get(name)]++;
					//System.out.print(answer[i]);
				}
			}
		}
        return answer;
    }
}
public class ReceiveIncriminateResult {
	public static void main(String[] args) {
		
		int k = 2;
		
		String id_list[] = {"muzi", "frodo", "apeach", "neo"};
		String report[]  = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		Solution3 s3 = new Solution3();
		int[] result = s3.solution(id_list, report, k);

		for(int n : result) {
			System.out.print(n + " ");
		}
			
		//map.put(name, map.getOrDefault(name, 0)+1); //기본적으로 신고를 당한 사람은 1부터 시작 -> 근데 이런 경우에는 동일인물이 신고해도 카운트가 되므로 오류
		
		/*
			1. String, integer 형태의 map으로 전체 유저에 대한 임의의 인덱스 값을 저장  -> 나중에 배열에 메일 받을 횟수를 저장하기 위해 인덱스 위치를 지정해주는 것
			2. String, HashSet<> 형태의 map으로 전체 유저에 대해 유저가 신고한 사람을 저장. set을 사용한 이유는 한사람의 유저가 같은 사람을 반복적으로 신고했을때, 신고횟수를 카운트 하지 않기 위함이다. 
			3. 신고받은 사람이 나올때마다 배열에 인덱스를 사용해 접근하여 값을 1씩 증가시킨다. 
			4. 값이 >= k인 사람을 신고한 사람에게만 메일 전송 
		*/
	}
}
