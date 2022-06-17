package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _13549_���ٲ���3 {
    static class Pos{
        int idx;
        int time;

        public Pos(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]); // �������� ��ġ
        int k = Integer.parseInt(inputs[1]); // ������ ��ġ

        int[]  visited = new int[100001];

        Queue<Pos> q = new LinkedList<>(); // location(��ġ) ����
        q.add(new Pos(n, 1)); // ���� time�� 1�� �س���, ��� ��½� 1 ����. visited�� ���� 0�� ��(�湮 ���� ��)�� �������ֱ� ���ؼ�.
        visited[n] = 1; 

        while (!q.isEmpty()) {
            Pos now = q.poll();

            if(now.idx+1>=0 && now.idx+1<=100000){ // ������ ��ĭ
                if(visited[now.idx+1] == 0 || visited[now.idx+1] > now.time+1){
                    visited[now.idx+1] = now.time+1;
                    q.add(new Pos(now.idx + 1, now.time + 1));
                }
            }

            if(now.idx-1>=0 && now.idx-1<=100000){ // �ڷ� ��ĭ
                if(visited[now.idx-1] == 0 || visited[now.idx-1] > now.time+1) {
                    visited[now.idx - 1] = now.time + 1;
                    q.add(new Pos(now.idx - 1, now.time + 1));
                }
            }

            if(now.idx*2>=0 && now.idx*2<=100000){ // �����̵�
                if(visited[now.idx*2] == 0 || visited[now.idx*2] > now.time) {
                    visited[now.idx*2] = now.time;
                    q.add(new Pos(now.idx*2, now.time));
                }
            }

        }

        System.out.println(visited[k]-1);



    }
}

