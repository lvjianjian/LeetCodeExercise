import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-17.
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class Permutation_Sequence_60 {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] nn = new int[n];
        nn[0] = 1;
        for(int i = 1; i < n;++i)
            nn[i] = nn[i-1] * (i+1);
        List<Integer> l = new LinkedList<>();
        for(int i =1;i<=n;++i){
            l.add(i);
        }
        k -= 1;
        for(int i = n-2;i>=0;--i){
            int index = k / nn[i];
            sb.append(l.get(index));
            l.remove(index);
            k -= index * nn[i];
        }
        sb.append(l.get(0));
        return sb.toString();
    }

    public String getPermutation2(int n, int k) {
        int[] valid = new int[n];
        int[] ks = new int[1];
        int[] r = new int[n];
        helper(valid,r,ks,0,k);
        StringBuilder sb = new StringBuilder();
        for(int i =0;i < n;++i)
            sb.append(r[i]);
        return sb.toString();
    }


    private void helper(int[] valid, int[] r, int[] ks, int index,int k){
        if(index == r.length){
            ++ks[0];
            return;
        }

        for(int i = 1; i<=r.length;++i){
            if(ks[0] == k) return;
            if(valid[i-1] == 0){
                r[index] = i;
                valid[i-1] = 1;
                helper(valid,r,ks,index+1,k);
                valid[i-1] = 0;
            }
        }
    }
}
