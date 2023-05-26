package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25682 {
    private static int [][] black, white;
    private static int M, N, K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //init start
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        black = new int[M+1][N+1];
        white = new int[M+1][N+1];

        String str;

        for(int i=1; i<=M; i++){
            str = br.readLine();
            for(int j=1; j<=N; j++){
                if(str.charAt(j-1) == 'B'){
                    if(check(i,j)){
                        sumWhite(i,j);
                    }else {
                        sumBlack(i,j);
                    }
                }else {
                    if(check(i,j)){
                        sumBlack(i,j);
                    }else {
                        sumWhite(i,j);
                    }
                }
            }
        }


        int result = 4000000;
        for(int i=0; i<=M-K; i++){
            for(int j=0; j<N-K; j++){
                result = Math.min(
                        result,
                        Math.min(
                                black[i+K][j+K] - black[i][j+K] - black[i+K][j] + black[i][j],
                                white[i+K][j+K] - white[i][j+K] - white[i+K][j] + white[i][j]
                        )
                );
            }
        }

        System.out.println(result);
    }

    private static void sumBlack(int row, int col) {
        black[row][col] = black[row-1][col] + black[row][col-1] - black[row-1][col-1] + 1;
        white[row][col] = white[row-1][col] + white[row][col-1] - white[row-1][col-1];
    }

    private static void sumWhite(int row, int col) {
        black[row][col] = black[row-1][col] + black[row][col-1] - black[row-1][col-1];
        white[row][col] = white[row-1][col] + white[row][col-1] - white[row-1][col-1] + 1;
    }

    private static boolean check(int row, int col) {

        return row % 2 == 1 && col % 2 == 1 || row % 2 == 0 && col % 2 == 0;
    }
//    private static String[][] map;
//    private static int M, N, K;
//    private static int min = Integer.MIN_VALUE;
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        //init start
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        map = new String[M][N];
//
//        for(int i=0; i<M; i++){
//            String str = br.readLine();
//            for(int j=0; j<str.length(); j++){
//                map[i][j] = String.valueOf(str.charAt(j));
//            }
//        }
//        //init end
//
//        //BFS
//        for(int i=0; i<=M-K; i++){
//            for(int j=0; j<=N-K; j++){
//                BFS(i, j);
//            }
//        }
//
//        System.out.println(min);
//    }
//
//    private static void BFS(int x, int y) {
//        String startPos = map[x][y];
//        boolean flag = true; //true B, false W
//
//        int count = 0;
//
//        if(startPos.equals("B")) flag = true;
//        else flag = false;
//
//        if(flag){
//            for(int i=x, m=1; i<x+K; i++, m++){
//                for(int j=y, n=1; j<y+K; j++, n++){
//                    if(m % 2 != 0 && n%2 != 0){
//                        if(map[x][y].equals("W")) count++;
//                    }else if(m % 2 == 0 && n % 2 == 0){
//                        if(map[x][y].equals("W")) count++;
//                    }
//                }
//            }
//        }else {
//            for(int i=x, m=1; i<x+K; i++, m++){
//                for(int j=y, n=1; j<y+K; j++, n++){
//                    if(m % 2 != 0 && n%2 != 0){
//                        if(map[x][y].equals("B")) count++;
//                    }else if(m % 2 == 0 && n % 2 == 0){
//                        if(map[x][y].equals("B")) count++;
//                    }
//                }
//            }
//        }
//
//        min = count < min ? count : min;
//
//    }
}
