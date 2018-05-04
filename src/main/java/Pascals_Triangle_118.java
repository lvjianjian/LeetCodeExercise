import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-6.
 * <p>
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Pascals_Triangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if(numRows == 0) return result;
        List<Integer> temp = null;
        temp = new ArrayList<>();
        temp.add(1);
        result.add(temp);
        if(numRows == 1) return result;
        for(int i = 1; i < numRows; ++i){
            temp = new ArrayList<>();
            temp.add(1);
            List<Integer> last = result.get(i-1);
            for(int j = 0; j < last.size()-1; ++j){
                temp.add(last.get(j) + last.get(j+1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}
