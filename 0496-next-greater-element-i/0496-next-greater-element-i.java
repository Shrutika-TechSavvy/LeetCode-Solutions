class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    
        HashMap<Integer, Integer> hm=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        int nextGreater[]=new int[nums2.length];


        for(int i=nums2.length-1; i>=0 ;i--){


            while(!stack.isEmpty() && stack.peek()<=nums2[i])
            {
                stack.pop();
            }

            if(stack.isEmpty()){
               hm.put(nums2[i],-1);
            }else{
                 hm.put(nums2[i],stack.peek());
            }


           stack.push(nums2[i]);
        }

        //Now finding the next greater element for each value of nums1 from 2
       int[] result = new int[nums1.length];
        int count = 0;
        for (int i : nums1) {
            if (hm.containsKey(i)) {
                result[count] = hm.get(i);
            } else {
                result[count] = -1;
            }
            count++;
        }

        return result;
    }
}