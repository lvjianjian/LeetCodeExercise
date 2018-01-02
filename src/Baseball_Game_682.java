import java.util.*;

/**
 * Created by zhongjianlv on 18-1-2.
 * <p>
 * You're now a baseball game point recorder.
 * <p>
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * <p>
 * You need to return the sum of the points you could get in all the rounds.
 */
public class Baseball_Game_682 {

    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch (op) {
                case "+":
                    Integer integer = list.get(list.size() - 1);
                    Integer integer1 = list.get(list.size() - 2);
                    list.add(integer + integer1);
                    break;
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                default:
                    list.add(Integer.valueOf(op));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }
}
