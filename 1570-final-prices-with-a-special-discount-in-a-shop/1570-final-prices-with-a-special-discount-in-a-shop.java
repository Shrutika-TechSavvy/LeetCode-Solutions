class Solution {
    public int[] finalPrices(int[] prices) {
        //Brute-force approach is using two pointers

        //1. while standing at ith index check for j in further array if there's acondition:
        // prices[j]<prices[i]. If found then perform subtraction else check fro another j in array till length
        //if still not found then add that elemnt only in array
        //then again iterate through array likewise

        //for(i->n)
        //{
            //for(j->n)
            /*
                if(prices[j]<prices[i])
                {
                    int num=prices[i]-prices[j];
                    res[i]=num;
                    flag=1;
                }
             
        //}

        if(flag=-0) res[i]=prices[i];
       */ 
     int n = prices.length; // Length of the prices array
        int[] res = new int[n]; // Result array to store the final prices

        // Iterate through each price
        for (int i = 0; i < n; i++) {
            boolean discountFound = false;

            // Check for a discount from the right side
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] = prices[i] - prices[j]; // Apply discount
                    discountFound = true; // Mark that discount is found
                    break; // Stop searching as we found the nearest smaller price
                }
            }

            // If no discount is found, keep the original price
            if (!discountFound) {
                res[i] = prices[i];
            }
        }

        return res; // Return the result array
    }
}