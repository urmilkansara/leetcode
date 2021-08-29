package com.leetcode;

import util.InputHelper;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * */
public class BuyAndSellStock
{

	public static void main(String[] args)
	{
		InputHelper inputHelper = new InputHelper();
		while (true){
			String[] strings = inputHelper.getSingleString().split(" ");
			int[] stockPrices = new int[strings.length];
			for(int i = 0; i < strings.length; i++) {
				stockPrices[i] = Integer.parseInt(strings[i]);
			}

			System.out.println(BuyAndSellStock.getMaxProfit(stockPrices));
		}
	}

	private static int getMaxProfit(final int[] stockPrices)
	{

		int minStockPrice = stockPrices[0];
		int profit = 0;
		for(int i =1 ;i < stockPrices.length; i++){
			if(profit < stockPrices[i] -  minStockPrice){
				profit = stockPrices[i] -  minStockPrice;
			} else if (stockPrices[i] < minStockPrice){
				minStockPrice = stockPrices[i];
			}
		}
		return profit;
	}
}
