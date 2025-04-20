class Solution {
    public String largestNumber(int[] nums) {
        
        //Approach to the problem in a unique way
        //Use the priority queue 

        //Step 1: Sort the array in descending order , based on the unit place
        //Step 2: While store it in the priority queue<max heap>
        //Step 3: then pop up the element and create the string accordingle and return


        //Create a priority queue (max heap) with a custom comparator
        PriorityQueue<String> maxHeap=new PriorityQueue<>((a, b)-> (b+a).compareTo(a+b));

        //Adding all numbers to the heap as strings
        for(int num: nums){
            maxHeap.add(String.valueOf(num));
        }

        //If the largest is '0' then all are zeroes
        if(maxHeap.peek().equals("0")) return "0";

        //Build the largest number by poplling frim the max heap

        StringBuilder result=new StringBuilder();
        while(!maxHeap.isEmpty()){
            result.append(maxHeap.poll());
        }
        return result.toString();
    }
}