/*
 * BestTimeToBuyAndSellStock
 */
package com.pk.algorithms.arrays;

/**
 *
 * @author parveenkumar
 */
public class BestTimeToBuyAndSellStock {
    /*
    You have an array for which the ith element is the price of a 
    given stock on day i.
    You are allowed to complete at most one transaction 
    (i.e., buy one and sell one share of the stock), 
    Design an algorithm to find the maximum profit.
    You cannot sell a stock before you buy one.
    
    Example:
    Input: {7, 1, 5, 3, 6, 4}
    Output: 5
    
    Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Not 7-1 = 6, as selling price needs to be larger than buying price.
    
    */
    public static void main_stocks(String[] args){
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println("Brute Force - " + new BestTimeToBuyAndSellStock().maxProfitBruteForce(input));
        int out = new BestTimeToBuyAndSellStock().maxProfitOnePass(input);
        System.out.println("One Pass - " + out);
    }
    //Approach#1 - BruteForce
    public int maxProfitBruteForce(int[] prices){
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    
    //Approach#2 - One Pass
    public int maxProfitOnePass(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                //System.out.println(i +  " Min Prices - " + minPrice);
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
                //System.out.println(i + " Max Profit - " + maxProfit);
            }
        }
        return maxProfit;
    }
}
