import java.util.ArrayList;

/**
 * Created by zhongjianlv on 18-3-31.
 * <p>
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 * <p>
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class Asteroid_Collision_735 {

    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> res = new ArrayList<>(2500);
        int s = 0, size, size2;
        while (s < asteroids.length) {
            if (asteroids[s] < 0) {
                size = -asteroids[s];
                for (int i = res.size() - 1; i >= -1; i--) {
                    if (i == -1) {
                        res.add(asteroids[s]);
                        break;
                    }
                    size2 = res.get(i);
                    if (size2 > 0) {
                        if (size2 < size) {
                            res.remove(res.size() - 1);
                        } else if (size2 == size) {
                            res.remove(res.size() - 1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        res.add(asteroids[s]);
                        break;
                    }
                }
            } else {
                res.add(asteroids[s]);
            }
            ++s;
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
//        System.arraycopy(res, 0, r, 0, res.size());
        return r;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] ints = new int[n];
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Integer> intList2 = new ArrayList<>(n);

        System.out.println("array");
        long start = System.nanoTime();
        for (int i = 0, length = ints.length; i < length; i++) {
            ints[i] = i;
        }
        System.out.println(System.nanoTime() - start);


        System.out.println("default arrayList");
        start = System.nanoTime();
        for (int i = 0, length = ints.length; i < length; i++) {
            intList.add(i);
        }
        System.out.println(System.nanoTime() - start);


        System.out.println("capacity n arraylist");
        start = System.nanoTime();
        for (int i = 0, length = ints.length; i < length; i++) {
            intList2.add(i);
        }
        System.out.println(System.nanoTime() - start);
    }
}
