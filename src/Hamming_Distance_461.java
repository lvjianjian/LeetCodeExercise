/**
 * Created by zhongjianlv on 17-12-28.
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 */
public class Hamming_Distance_461 {

    public int hammingDistance(int x, int y) {
        int a = x^y;
        int num = 0;
        while (a != 0){
            int temp = a % 2;
            num += temp;
            a = (a - temp) / 2;
        }
        return num;
    }

    public static void main(String[] args) {
        Hamming_Distance_461 hamming_distance_461 = new Hamming_Distance_461();
        System.out.println(hamming_distance_461.hammingDistance(11,5));
    }
}
