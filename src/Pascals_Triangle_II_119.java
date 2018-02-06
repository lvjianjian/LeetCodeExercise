import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-6.
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Pascals_Triangle_II_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; ++i){
            result.add(0,1);
            for(int j = 1; j < result.size() - 1; ++j){
                result.set(j,result.get(j) + result.get(j+1));
            }
        }
        return result;
    }

}
