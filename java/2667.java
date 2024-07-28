package study.java;
import java.io.*;
import java.util.Arrays;

public class Main {

    private static int n;
    private static int[][] map = new int[25][25]; 
    private static boolean[][] visit = new boolean[25][25];
    private static int[] dy = {1,0,-1, 0};
    private static int[] dx = {0,1,0,-1}; 
    private static int[] cnt = new int[25*25];
    private static int home = 0; 

    public static void main(String[] args) throws IOException {
        

        System.setIn(new FileInputStream("/Users/sowon/Desktop/study/java/input.txt"));
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); // 선언
        n = Integer.parseInt(sc.readLine());

        map = new int[n][n];
        cnt = new int[n*n];

        for(int i=0; i<n;i++) {
            String[] str = sc.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    home++;
                }
            }
        }

        Arrays.sort(cnt);
        System.out.println(home);

        for(int i=0; i<cnt.length; i++){
            if(cnt[i]!=0){
                System.out.println(cnt[i]);
            }

        }


    }


    private static void dfs(int y, int x){
        visit[y][x] = true;
        cnt[home]++;

        for(int i =0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny<n && nx<n){
                if(map[ny][nx]!=0 && !visit[ny][nx]){
                    dfs(ny, nx);
                }
            }
        }
    }

}

