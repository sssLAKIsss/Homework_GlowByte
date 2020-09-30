import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;




public class Homework_1 {
    /** Проверяем, расставлены ли конкретные скобки
     * * по математическим законам,если да, то
     * затираем их на пробел
     */
    private static void CheckOn(char brk1, char brk2, Stack<Character> stack) {
        for (int i = 1; i < stack.size(); i++) {
            if (stack.get(i) == brk2) {
                if (stack.get(i - 1) == brk1)
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

    /**
     * СОздаем стек
     * @return Стек , элементы которого - скобки
     * @throws IOException
     */
    private static Stack<Character> createStack() throws IOException {
        Stack<Character> stack = new Stack<>();

            System.out.println("Введите последовательность скобок");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }
            return stack;

    }

    /**
     * Удаление пустых значений до первого непустого
     * если в стеке ничего не останется, то последовательность скобок соответсвтует условию задачи
     */
    private static void removeAndCheck(Stack<Character> stack) {
        for (int i = stack.size() - 1; i > -1 ; i--) {
            if (stack.get(i) == ' ') {
                stack.pop();
            }
            else break;
        }

        if (stack.size() != 0) {
            System.out.println("Расставление скобок не по правилам математики");
        }
        else System.out.println("Расставление скобок  по правилам математики");
    }

    /**
     * Объявляет тип скобок, проходящих проверку
     * Проверяет вашу последовательность методами, объявленными выше
     */
    public static  void finalCheck() {
        try {
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
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

    }

    public static void main(String[] args) {
        finalCheck();
    }
}
