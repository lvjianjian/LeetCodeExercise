import java.util.Stack;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 * <p>
 * Examples:
 * Input: N = 1, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 2
 * Output: 1
 * <p>
 * Input: N = 4, K = 5
 * Output: 1
 * <p>
 * Explanation:
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 * Note:
 * <p>
 * N will be an integer in the range [1, 30].
 * K will be an integer in the range [1, 2^(N-1)].
 */

public class K_th_Symbol_in_Grammar_779 {
    public int kthGrammar(int N, int K) {
        int r = 0;
        Stack<Integer> stacks = new Stack<>();
        K -= 1;
        for(int i = 0; i < N - 1; ++i){
            stacks.push(K % 2);
            K /= 2;
        }
        while(!stacks.isEmpty()){
            int temp = stacks.pop();
            r = (r + temp) % 2;
        }
        return r;
    }

}
