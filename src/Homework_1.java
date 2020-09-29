import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;




public class Homework_1 {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        char fig1 = '{';
        char fig2 = '}';
        char circl1 = '(';
        char circl2 = ')';
        char squad1 = '[';
        char squad2 = ']';
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) == fig2) {
                if (stack.get(i - 1) == fig1) {
                    stack.set(i, ' ');
                    stack.set(i - 1, ' ');
                }
                else if (stack.get(i - 1) == ' ') {
                    int j = i - 1 ;
                    while(j != 0) {
                        j--;
                        if (stack.get(j) != ' ' && stack.get(j) == fig1) {
                            stack.set(j, ' ');
                            stack.set(i, ' ');
                        }
                    }
                }

            }
            if (stack.get(i) == circl2) {
                if (stack.get(i - 1) == circl1) {
                    stack.set(i, ' ');
                    stack.set(i - 1, ' ');

                }
                else if (stack.get(i - 1) == ' ') {
                    int j = i - 1;
                    while(j != 0) {
                        j--;
                        if (stack.get(j) != ' ' && stack.get(j) == circl1) {
                            stack.set(j, ' ');
                            stack.set(i, ' ');
                        }
                    }
                }
            }
            if (stack.get(i) == squad2) {
                if (stack.get(i - 1) == squad1) {
                    stack.set(i, ' ');
                    stack.set(i - 1, ' ');
                }
                else if (stack.get(i - 1) == ' ') {
                    int j = i - 1;
                    while(j != 0) {
                        j--;
                        if (stack.get(j) != ' ' && stack.get(j) == squad1) {
                            stack.set(j, ' ');
                            stack.set(i, ' ');
                        }
                    }
                }
            }

        }
        for (int i = stack.size() - 1; i > -1 ; i--) {
            if (stack.get(i) == ' ') {
                stack.pop();
            }
            else break;
        }

        if (stack.size() != 0) {
            System.out.println("Расставление скобок не по математике");
        }
        else System.out.println("Расставление скобок  по математике");
        //System.out.println(stack);
    }
}
