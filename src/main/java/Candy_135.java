/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy_135 {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int i = 0;
        while (i < ratings.length) {
            if (i == 0) {
                candies[i] = 1;
            } else {
                if (ratings[i] > ratings[i - 1])
                    candies[i] = candies[i - 1] + 1;
                else if (ratings[i] == ratings[i - 1])
                    candies[i] = 1;
                else {
                    int j = i + 1;
                    while (j < ratings.length && ratings[j] < ratings[j - 1])
                        ++j;
                    int next = j;
                    candies[--j] = 1;
                    while (i < j) {
                        --j;
                        candies[j] = candies[j + 1] + 1;

                    }
                    candies[j-1] = Math.max(candies[j-1], candies[j] + 1);
                    i = next - 1;

                }
            }
            ++i;
        }

        int candy = 0;
        for (int k = 0; k < ratings.length; ++k) {
            candy += candies[k];
        }
        return candy;
    }

    public static void main(String[] args) {
        Candy_135 candy_135 = new Candy_135();
            System.out.println(candy_135.candy(new int[]{1,2,10,20,100,20}));
    }

}
