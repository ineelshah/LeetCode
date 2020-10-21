class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids) {
            if(stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                while(true) {
                    int top = stack.peek();
                    if(top < 0) {
                        stack.push(asteroid);
                        break;
                    } else if(top < -asteroid) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            stack.push(asteroid);
                            break;
                        }
                    } else if (top > -asteroid) {
                        break;
                    } else if(top == -asteroid) {
                        stack.pop();
                        break;
                    }
                }
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}