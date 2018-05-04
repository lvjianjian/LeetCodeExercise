import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhongjianlv on 18-2-7.
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

public class Swim_in_Rising_Water_778 {

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] visit = new int[N][N];
        int[][] time = new int[N][N];
        PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        queue.add(new int[]{0,0,grid[0][0]});
        while(queue.size()!=0){
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            int v = temp[2];
            if(visit[i][j] == 1) continue;
            visit[i][j] = 1;
            int a = Integer.MAX_VALUE;
            int ni=0,nj=0;
            ni = i-1;
            nj = j;
            if(ni >= 0){
                if(visit[ni][nj] == 1){
                    a = Math.min(time[ni][nj], a);
                }else{
                    queue.add(new int[]{ni,nj,grid[ni][nj]});
                }
            }

            ni = i;
            nj = j-1;
            if(nj >= 0){
                if(visit[ni][nj] == 1){
                    a = Math.min(time[ni][nj], a);
                }else{
                    queue.add(new int[]{ni,nj,grid[ni][nj]});
                }
            }

            ni = i+1;
            nj = j;
            if(ni < N){
                if(visit[ni][nj] == 1){
                    a = Math.min(time[ni][nj], a);
                }else{
                    queue.add(new int[]{ni,nj,grid[ni][nj]});
                }
            }

            ni = i;
            nj = j+1;
            if(nj < N){
                if(visit[ni][nj] == 1){
                    a = Math.min(time[ni][nj], a);
                }else{
                    queue.add(new int[]{ni,nj,grid[ni][nj]});
                }
            }
            if(a != Integer.MAX_VALUE)
                a = Math.max(a, v);
            else
                a = v;
            time[i][j] = a;
            if(i == N - 1 && j == N - 1) break;
        }
        return time[N - 1][N - 1];
    }

    public static void main(String[] args) {
        Swim_in_Rising_Water_778 swim_in_rising_water_778 = new Swim_in_Rising_Water_778();
        System.out.println(swim_in_rising_water_778.swimInWater(new int[][]{{0,1},{2,3}}));
    }
}
