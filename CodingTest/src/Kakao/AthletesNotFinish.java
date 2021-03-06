package Kakao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예
participant	completion	return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
입출력 예 설명
예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
*/
class Solution1 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		// 맵에 중복없이 값을 저장해주기 위해서 hashmap을 사용합니다.
		HashMap<String, Integer> athletes = new HashMap<String, Integer>();
		// participants의 운동선수들을 맵에 저장하고 Key값에는 운동선수의 이름을, value 값에는 1을 저장합니다.
		// 완주한 선수들을 같은 맵에 저장하는데 똑같이 key에는 운동선수의 이름을, value에는 1을 저장합니다.
		// hashmap은 중복값을 저장하지 못하기 때문에 같은 값이 입력되려고 하면 value에 1을 +하도록 설계메소드를 사용해줍니다.
		// 이때, 완주하지 못한 선수만 +1이 되지 않고 1이 저장되어 있기 때문에 keyset을 받아서 조회한 결과 value가 1인 키값이
		// 완주하지 못한 선수입니다.

		for (String s : participant) {
			// 참가한 모든 참가자들을 (운동선수 = 0) (Key = Set)형태로 저장한다.
			// 단 이때, 동명이인인 선수를 구분해주기 위해서 같은 이름이 들어오면 getordefault를 사용했을 때, 앞에서 나온 동명이인이
			// value가 0으로
			// 저장되었을테니, 0을 반환하고 그 값에 +1을 해준다.
			// 결론적으로 보면 해시맵에는 중복된 Key가 존재할 수 없으므로, 같은 Key에 다른 value값이 저장되려고 하면 이전 값을 덮어써
			// 버린다.
			// 따라서 동명이인인 선수만 value가 +2로 카운팅 되어 있을 것이다. 나머지는 1
			athletes.put(s, athletes.getOrDefault(s, 0) + 1);
		}
		//participant를 반복으로 조회하면 당연히 두번의 키 값을 조회하므로, 값이 2개 나오는데 이건 반복이 아니라 그냥 두 번 호출한거임
		for(String s : participant) {
			System.out.print(athletes.get(s) + " "); 
		}
		System.out.println();
		//athletes즉 map을 탐색하면 1번밖에 안나옴
		for(String s : athletes.keySet()) {
			System.out.print(athletes.get(s) + " "); 
		}

		for (String n : completion) {
			// 완주한 참여자들은 위에서 value를 모두 1로 저장했으니 getOrDefault결과 1이 반환되고 -1을 하므로 value값이 모두
			// 0로 바뀐다.
			// 단, 이때 완주하지 못한 선수만 value가 1로 남아있다. 추가로 동명이인의 경우만 +1 이므로
			// 기존의 값을 가져온다면 1에서 -1을 해주면 완주한 선수는 0이되고, 동명이인의 경우만 +1로 0이 아니다.
			athletes.put(n, athletes.get(n) - 1);
		}
		
		System.out.println();
		
		for(String s : athletes.keySet()) {
			System.out.print(athletes.get(s) + " "); 
		}
		/*
		Iterator<Map.Entry<String, Integer>> iter = athletes.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if (entry.getValue() != 0) {
				answer = entry.getKey();
				break;
			}
		}
		*/
		
		/*

		for (String key : athletes.keySet()) {
			if (athletes.get(key) != 0) {
				answer = key;
				break;
			}
		}
		*/
		
		for(Map.Entry<String, Integer> finish : athletes.entrySet()) {
			if (finish.getValue() != 0) {
				answer = finish.getKey();
				break;
			}
		}

		return answer;
	}
}

public class AthletesNotFinish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "mislav", "ana" };

		System.out.println(s.solution(participant, completion));

	}

}
