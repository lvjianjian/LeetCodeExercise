import java.util.*;

/**
 * Created by zhongjianlv on 18-1-16.
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        int[] r = new int[k];
        helper(1,n,r,0,result);
        return result;
    }


    private void helper(int c, int n, int[] r, int index,List<List<Integer>> result){
        if(index == r.length){
            List<Integer> temp = new ArrayList();
            for(int i =0;i < r.length;++i){
                temp.add(r[i]);
            }
            result.add(temp);
            return;
        }

        for(int i = c;i <=n;++i){
            r[index] = i;
            helper(i+1,n,r,index+1,result);
        }
    }

}
