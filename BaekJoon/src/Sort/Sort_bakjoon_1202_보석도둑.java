package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Jewel implements Comparable<Jewel>{
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        return (int) (o.price-this.price);
    }
}
public class Sort_bakjoon_1202_보석도둑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Jewel> valuableJewel = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        List<Jewel> jewelList = new ArrayList<>(N);
        List<Integer> bagList = new ArrayList<>(K);

        //보석 초기화
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            jewelList.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //가방 초기화
        for(int k=0; k<K; k++) {bagList.add(Integer.parseInt(br.readLine()));}

        //작은 가방에 넣을 수 있는 최대 가치의 보석을 넣어야 한다. //가치가 큰것을 기준으로 내림차순 정렬
        Collections.sort(jewelList, (o1, o2) ->  o1.weight - o2.weight);
        //가방이 가벼운 것부터 오름차순 정렬
        Collections.sort(bagList);

        int idx = 0;
        long answer = 0L;

        for(int k=0; k<K; k++){//보석이 가방보다 많을수도 있고 적을 수도 있음. 보석을 담을 가방이 기준이 되어야 한다.
            int nowBagSize = bagList.get(k);
            while(idx < N){
                if(jewelList.get(idx).weight <= nowBagSize){
                    valuableJewel.add(new Jewel(jewelList.get(idx).weight,jewelList.get(idx).price));
                    idx++;
                }else break;


            }
            if(!valuableJewel.isEmpty()) answer += valuableJewel.poll().price;
        }
        System.out.println(answer);
    }
}
