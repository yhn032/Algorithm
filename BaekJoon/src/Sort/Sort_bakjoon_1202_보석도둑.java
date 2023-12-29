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
public class Sort_bakjoon_1202_�������� {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Jewel> valuableJewel = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        List<Jewel> jewelList = new ArrayList<>(N);
        List<Integer> bagList = new ArrayList<>(K);

        //���� �ʱ�ȭ
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            jewelList.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //���� �ʱ�ȭ
        for(int k=0; k<K; k++) {bagList.add(Integer.parseInt(br.readLine()));}

        //���� ���濡 ���� �� �ִ� �ִ� ��ġ�� ������ �־�� �Ѵ�. //��ġ�� ū���� �������� �������� ����
        Collections.sort(jewelList, (o1, o2) ->  o1.weight - o2.weight);
        //������ ������ �ͺ��� �������� ����
        Collections.sort(bagList);

        int idx = 0;
        long answer = 0L;

        for(int k=0; k<K; k++){//������ ���溸�� �������� �ְ� ���� ���� ����. ������ ���� ������ ������ �Ǿ�� �Ѵ�.
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
