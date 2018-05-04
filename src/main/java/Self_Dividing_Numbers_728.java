import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 17-12-26.
 */
public class Self_Dividing_Numbers_728 {

    public boolean isSelf(int i) {
        int copy = i;
        while (i != 0) {
            int yu = i % 10;
            if (yu == 0)
                return false;
            else{
                if((copy % yu) != 0)
                    return false;
                else
                    i = i / 10;
            }
        }
        return true;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if(isSelf(i))
                result.add(i);
        }
        return result;
    }
}
