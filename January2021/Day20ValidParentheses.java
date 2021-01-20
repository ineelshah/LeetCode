class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()) {
            if(isOpenParanthesis(c)) {
                stack.push(c);
            } else {
                
                if(stack.isEmpty()) return false;
                else if(c == ')' && stack.peek() != '(') return false;
                else if(c == ']' && stack.peek() != '[') return false;
                else if(c == '}' && stack.peek() != '{') return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isOpenParanthesis(char c) {
        if(c == '(' || c == '[' || c == '{') return true;
        return false;
    }
    
}