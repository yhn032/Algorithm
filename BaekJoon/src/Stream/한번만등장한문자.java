import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split("")) //한 글자씩 잘라서 String 배열을 만들고 이를 stream화 한다.
                .collect(Collectors.groupingBy(s1 -> s1))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() <= 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.joining());
    }
    
    /*
        1. 문자열 스트림 생성
        2. 각 알파벳을 그룹핑(빈도수 계산)
        3. EntrySet으로 만들기 
        4. 만든 entry로 스트림 생성 
        5. 빈도수가 1이하인 엔트리만 필터하여 가공
        6. map으로 만들어 key값을 뽑아오기 
        7. 뽑아온 키를 정렬 
        8. 가공을 마친후 값을 가져온다.
    */
}
