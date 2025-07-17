class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // using stacks for this question, since 
        // we have to delete and compare with the newest
        // ones seen so fat

        // stack to store elements
        Stack<Integer> s1 = new Stack<>();
        s1.push(asteroids[0]);

        // iterating the array
        for (int i = 1; i < asteroids.length; i++) {
            int curr = asteroids[i];
            
            // to keep track wether curr is destroyed or not
            boolean destroyed = false;

            // check the sign of the curr element
            while (!s1.isEmpty() && (curr < 0 && s1.peek() > 0)) {
                if (Math.abs(curr) > Math.abs(s1.peek())) {
                    s1.pop();
                    // push curr element
                } else if (Math.abs(curr) == Math.abs(s1.peek())){
                    s1.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            
            // main work pushing into the stack
            if (!destroyed) {
                s1.push(curr);
            }

        }

        // return array
        int[] res = new int[s1.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s1.pop();
        }

        return res;
    }
}