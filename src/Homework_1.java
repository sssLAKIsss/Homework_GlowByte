import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;




public class Homework_1 {
    private static void CheckOn(char brk1, char brk2, Stack<Character> stack) { // Проверяем, расставлены ли конкретные скобки
        for (int i = 1; i < stack.size(); i++) {                                // по математическим законам,если да, то
            if (stack.get(i) == brk2) {                                         // затираем их на пробел
                if (stack.get(i - 1) == brk1) {
                    stack.set(i, ' ');
                    stack.set(i - 1, ' ');
                } else if (stack.get(i - 1) == ' ') {
                    int j = i - 1;
                    while (j != 0) {
                        j--;
                        if (stack.get(j) != ' ' && stack.get(j) == brk1) {
                            stack.set(j, ' ');
                            stack.set(i, ' ');
                            break;
                        }
                    }
                }
            }
        }
    }

    private static Stack<Character> createStack() throws IOException {  // Cоздаем стек из последовательности вводимых с
        Stack<Character> stack = new Stack<>();                         // с клавиатуры скобок

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        return stack;
    }

    private static void removeAndCheck(Stack<Character> stack) { // Удаление пустых значений до первого непустого, если в стеке ничего
        for (int i = stack.size() - 1; i > -1 ; i--) {           // не останется, то последовательность скобок соответсвтует
            if (stack.get(i) == ' ') {                           // условию задачи
                stack.pop();
            }
            else break;
        }

        if (stack.size() != 0) {
            System.out.println("Расставление скобок не по математике");
        }
        else System.out.println("Расставление скобок  по математике");
    }

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = createStack();

        char fig1 = '{';
        char fig2 = '}';
        char circl1 = '(';
        char circl2 = ')';
        char squad1 = '[';
        char squad2 = ']';

        CheckOn(squad1, squad2, stack);
        CheckOn(circl1, circl2, stack);
        CheckOn(fig1, fig2, stack);

        removeAndCheck(stack);
        //System.out.println(stack);
    }
}
