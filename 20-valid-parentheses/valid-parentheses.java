class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if ((n&1) != 0) {
            return false;
        }

        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i) ;
            if (c=='(') {
                stack[++top] = ')';
            } else if (c == '{') {
                stack[++top] = '}' ;
            } else if (c == '[') {
                stack[++top] = ']' ;
            } else {
                if (top == -1 || stack[top--] != c ) {
                    return false;
                }
             }
        }
        return top == -1;
    }
}