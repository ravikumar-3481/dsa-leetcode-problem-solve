class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        maxProfit = 0
        bestBuy = prices[0]

        for price in prices :
            if price > bestBuy:
                maxProfit = max(maxProfit, price - bestBuy)
            bestBuy = min(bestBuy, price)
        return maxProfit 