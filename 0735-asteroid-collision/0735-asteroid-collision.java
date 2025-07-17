class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if (curr > 0) {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(curr)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(curr)) {
                    // Both are same size, both explode
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    // No right-moving asteroid to collide with
                    stack.push(curr);
                }
                // Else: current asteroid explodes, do nothing
            }
        }

        // Build result from stack
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
