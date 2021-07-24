import java.util.*;

public class Calculator {
    Deque<Character> ops;
    Deque<Integer> nums;
    Map<Character, Integer> prior;
    Calculator() {
        ops = new LinkedList<>();
        nums = new LinkedList<>();
        prior = new HashMap<>();
        prior.put('+', 1);
        prior.put('-', 1);
        prior.put('*', 2);
        prior.put('/', 2);
    }
    int run(String s) {
        s = prepare(s);
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                ops.push(c);
                i++;
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    cal();
                }
                if (ops.isEmpty()) return -1;
                ops.pop();
                i++;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
            } else {
                while (!ops.isEmpty() && ops.peek() != '(' && prior.get(ops.peek()) >= prior.get(c)) {
                    cal();
                }
                ops.push(c);
                i++;
            }
        }
        while (!ops.isEmpty()) {
            cal();
        }
        return nums.isEmpty() ? -1 : nums.pop();
    }
    String prepare(String s) {
        s = "0" + s;
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(\\+", "\\(0+");
        s = s.replaceAll("\\(-", "\\(0-");
        return s;
    }
    void cal() {
        if (ops.isEmpty() || nums.size() < 2) return;
        char op = ops.pop();
        int b = nums.pop();
        int a = nums.pop();
        int res = 0;
        switch(op) {
            case '+' : {
                res = a + b;
                break;
            }
            case '-' : {
                res = a - b;
                break;
            }
            case '*' : {
                res = a * b;
                break;
            }
            case '/' : {
                if (b == 0) return;
                res = a / b;
                break;
            }
        }
        nums.push(res);
    }
}
