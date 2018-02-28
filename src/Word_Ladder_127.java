import java.util.*;

/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class Word_Ladder_127 {


    //基本思路是替换，但是可以2个set记录头尾部2头走，替换少的那部分
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        char[] s = null;
        int[] r = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(wordList.get(i), i);
        }

        if (map.containsKey(beginWord)) {
            r[map.get(beginWord)] = 1;
        }

        if (!map.containsKey(endWord)) return 0;

        String temp = beginWord;
        Queue<String> ss = new LinkedList<>();
        ss.add(temp);
        while (!ss.isEmpty()) {
            temp = ss.poll();
            s = temp.toCharArray();
            int k = 1;
            if (map.containsKey(temp))
                k = r[map.get(temp)];
            for (int i = 0; i < beginWord.length(); i++) {
                char aa = s[i];
                for (int j = 0; j < 26; j++) {
                    s[i] = (char) ('a' + j);
                    String key = new String(s);
                    if (map.containsKey(key)) {
                        int integer = map.get(key);
                        if (r[integer] == 0) {
                            r[integer] = k + 1;
                            ss.add(key);
                        }
                    }
                }
                s[i] = aa;
            }
        }

        return r[map.get(endWord)];
    }


    //slow
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        char[] s = beginWord.toCharArray();
        char[] e = endWord.toCharArray();
        int[] r = new int[n];
        Queue<String> strings = new LinkedList<>();
        Queue<Integer> ints = new LinkedList<>();
        boolean hasEnd = false;
        for (int i = 0; i < n; ++i) {
            String temp = wordList.get(i);
            if (cha_one(temp.toCharArray(), e)) {
                if (temp.equals(endWord)) {
                    r[i] = 0;
                    hasEnd = true;
                } else {
                    r[i] = 1;
                    strings.add(temp);
                    ints.add(1);
                }
            } else {
                r[i] = -1;
            }
        }
        if (!hasEnd) return 0;

        while (!strings.isEmpty()) {
            String temp = strings.poll();
            int k = ints.poll();
            for (int i = 0; i < n; ++i) {
                if (r[i] == -1) {
                    String temp2 = wordList.get(i);
                    if (cha_one(temp.toCharArray(), temp2.toCharArray())) {
                        r[i] = k + 1;
                        strings.add(temp2);
                        ints.add(r[i]);
                    }
                }
            }
        }

        int min = -2;
        for (int i = 0; i < n; ++i) {
            if (r[i] != -1 && cha_one(s, wordList.get(i).toCharArray())) {
                if (min < 0)
                    min = r[i];
                else {
                    if (r[i] < min)
                        min = r[i];
                }
            }
        }
        return min + 2;

    }


    private boolean cha_one(char[] s1, char[] s2) {
        boolean flag = false;
        for (int i = 0; i < s1.length; ++i) {
            if (s1[i] != s2[i]) {
                if (flag) return false;
                else flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Word_Ladder_127 word_ladder_127 = new Word_Ladder_127();
        List<String> list = new ArrayList<>();
        String[] ss = new String[]{"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};
        for (int i = 0; i < ss.length; i++) {
            list.add(ss[i]);
        }
        System.out.println(word_ladder_127.ladderLength("cet", "ism", list));

    }
}
