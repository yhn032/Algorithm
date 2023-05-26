package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9063 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int maxX, minX, maxY, minY;

        maxX = maxY = Integer.MIN_VALUE;
        minY = minX = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            maxX = maxX < X ? X : maxX;
            maxY = maxY < Y ? Y : maxY;
            minX = minX > X ? X : minX;
            minY = minY > Y ? Y : minY;
        }

        System.out.println((maxX-minX) * (maxY - minY));
    }
}
