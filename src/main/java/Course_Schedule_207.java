import java.util.*;

/**
 * Created by zhongjianlv on 2018/2/9
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * For example:
 * <p>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * <p>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class Course_Schedule_207 {

    //topo 排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if(n <= 1) return true;
        int[] pre_num = new int[numCourses];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            int pre = prerequisites[i][1];
            int now = prerequisites[i][0];
            if(!map.containsKey(pre))
                map.put(pre,new HashSet<>());
            map.get(pre).add(now);
            ++pre_num[now];
        }
        Stack<Integer> ok = new Stack<>();
        for(int i = 0;i <numCourses;++i){
            if(pre_num[i] == 0)
                ok.push(i);
        }
        while(!ok.isEmpty()){
            int temp = ok.pop();
            if(map.containsKey(temp)){
                Set<Integer> set = map.get(temp);
                for(int k:set){
                    --pre_num[k];
                    if(pre_num[k] == 0)
                        ok.push(k);
                }
            }
            --numCourses;
        }
        if(numCourses == 0) return true;
        else return false;
    }
}
