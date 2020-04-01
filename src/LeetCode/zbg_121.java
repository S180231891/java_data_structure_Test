package LeetCode;

/**
 * 寻找买卖股票的最佳时机
 * 只能进行一次交易，先买入，后卖出，计算最大利润(差值)
 */
public class zbg_121
{
    public static void main(String[] args) {
        int[] n = {7,1,5,3,6,4};
        int res = maxProfit(n);
        System.out.println(res);
    }

    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
