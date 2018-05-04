/**
 * Created by zhongjianlv on 18-1-4.
 * <p>
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class Judge_Route_Circle_657 {
    public boolean judgeCircle(String moves) {
        int[] position = new int[2];
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            switch (aChar) {
                case 'L':
                    ++position[0];
                    break;
                case 'R':
                    --position[0];
                    break;
                case 'U':
                    ++position[1];
                    break;
                case 'D':
                    --position[1];
                    break;
            }
        }
        if (position[0] == 0 && position[1] == 0)
            return true;
        else
            return false;
    }
}
