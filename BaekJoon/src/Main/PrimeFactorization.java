import java.util.*;
class Solution_Prime {
    public int[] solution(int n) {
        int[] answer = {};
        Set<Integer> list = new HashSet<>();
        for(int i =2; i<= Math.sqrt(n); i++){
            while(n%i==0){
                list.add(i);
                n/=i;
            }
        }
        
        if(n != 1) list.add(n);
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    //prime factorization
    //어떤 수 N이 두 인수의 곱셈으로 표현된다면, 인 수중 한개 이상은 반드시 '루트N'보다 작거나 같다.
    //Set의 경우 중복은 제거해주지만, 넣은 순서를 보장하지 않기 때문에 마지막에 오름차순 정렬을 추가한다.
}
