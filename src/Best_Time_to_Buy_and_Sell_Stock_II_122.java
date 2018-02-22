/**
 * Created by zhongjianlv on 2018/2/22
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public int maxProfit(int[] prices) {
        int all = 0;
        if(prices.length == 0) return all;
        int min = prices[0];
        int max = min;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] < min){
                all += (max - min);
                max = min = prices[i];
            }
            else{
                if(prices[i] < max){
                    all += (max - min);
                    min = prices[i];
                    max = prices[i];
                }else{
                    max = prices[i];
                }
            }
        }
        all += (max - min);
        return all;
    }
}
