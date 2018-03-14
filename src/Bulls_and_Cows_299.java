import java.util.HashMap;

/**
 * Created by zhongjianlv on 18-3-14.
 * <p>
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * For example:
 * <p>
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * <p>
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class Bulls_and_Cows_299 {

    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] as = new int[10];
        int[] bs = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a == b) {
                ++A;
            } else {
                if (as[b-'0'] != 0) {
                    ++B;
                    --as[b-'0'];
                } else {
                    bs[b-'0']++;
                }
                if (bs[a - '0'] != 0) {
                    ++B;
                    --bs[a-'0'];
                } else {
                    as[a-'0']++;
                }
            }
        }
        return A + "A" + B + "B";
    }

    public String getHint2(String secret, String guess) {
        int A = 0;
        int B = 0;
        HashMap<Character, Integer> as = new HashMap<>();
        HashMap<Character, Integer> bs = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a == b) {
                ++A;
            } else {
                if (as.containsKey(b) && as.get(b) != 0) {
                    ++B;
                    as.put(b, as.get(b) - 1);
                } else {
                    bs.put(b, bs.getOrDefault(b, 0) + 1);
                }
                if (bs.containsKey(a) && bs.get(a) != 0) {
                    ++B;
                    bs.put(a, bs.get(a) - 1);
                } else {
                    as.put(a, as.getOrDefault(a, 0) + 1);
                }
            }
        }
        return A + "A" + B + "B";
    }


}
