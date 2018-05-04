import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhongjianlv on 18-3-28.
 * <p>
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class ReorganizeString_767 {
    public String reorganizeString(String S) {
        char[] ss = S.toCharArray();
        int[] count = new int[26];
        for (char s : ss) {
            ++count[s - 'a'];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a1, int[] a2) -> a2[0] - a1[0]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                queue.add(new int[]{count[i], i});
        }
        StringBuilder sb = new StringBuilder();
        int[] poll = null, poll2;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            while (!queue.isEmpty()) {
                poll2 = queue.poll();
                if (sb.length() > 0 && (char) (poll[1] + 'a') == sb.charAt(sb.length() - 1)) {
                    int[] temp = poll;
                    poll = poll2;
                    poll2 = temp;
                }
                while (poll2[0] != 0 && poll[0] != 0) {
                    sb.append((char) (poll[1] + 'a'));
                    sb.append((char) (poll2[1] + 'a'));
                    poll[0]--;
                    poll2[0]--;
                }
                if (poll[0] == 0) {
                    queue.add(poll2);
                    break;
                }
            }
        }

        if (poll != null && poll[0] > 0) {
            char temp = (char) (poll[1] + 'a');
            for (int i = sb.length() - 1; i >= 0; --i) {
                if (i == sb.length() - 1) {
                    if (sb.charAt(i) != temp) {
                        sb.insert(i + 1, temp);
                        poll[0]--;
                    }
                } else if (i == 0) {
                    if (sb.charAt(i) != temp) {
                        sb.insert(i, temp);
                        poll[0]--;
                    }
                } else {
                    if (sb.charAt(i) != temp && sb.charAt(i + 1) != temp) {
                        sb.insert(i, temp);
                        poll[0]--;
                    }
                }
                if (poll[0] == 0) return sb.toString();
            }
        }
        if(poll!=null && poll[0] !=0) return "";
        return sb.toString();
    }

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//        sb.append("aa");
//        for (int length = sb.length() - 1; length >= 0; length--) {
//            sb.insert(length+1,'b');
//        }
//        System.out.println(sb.toString());

        ReorganizeString_767 reorganizeString_767 = new ReorganizeString_767();
        System.out.println(reorganizeString_767.reorganizeString("aaaabc"));
        System.out.println(reorganizeString_767.reorganizeString("aaabc"));
        System.out.println(reorganizeString_767.reorganizeString("aaab"));
        System.out.println(reorganizeString_767.reorganizeString("aac"));
        System.out.println(reorganizeString_767.reorganizeString(
                "hthththththththththththththththththththththththththththnncncncncncncncncncncncncncncn" +
                        "cncncncncncncncncncnmmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmpmkxexexexexexe" +
                        "xexexexexexexexexexexexexexexikakakakakakakakakakakakakakakakakakakakaobobobobobo" +
                        "boboboboboboboboboboboboboboijijijijijijijijijijijijijijijijijijizyzyzyzyzyzyzyzyz" +
                        "yzyzyzyzyzyzyzyzyzyrqrqrqrqrqrqrqrqrqrqrqrqrqrqrqrqrqfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfsgsgs" +
                        "gsgsgsgsgsgsgsgsgsgsgsgsgsgwvwvwvwvwvwvwvwvwvwvwvwvwvwvwlululululululululululululu"));
        System.out.println(reorganizeString_767.reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao"));
    }
}
