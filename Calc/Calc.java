package Calc;
import java.util.Scanner;

public class Calc {
    static Scanner Scanner = new Scanner(System.in);
    static char operation;
    static String[] slovo;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение: ");
        Calc1(Scanner.nextLine());
    }

    public static String Calc1(String input) throws Exception {
        //1 - Проверка символа
        if (input.contains(" + ")) {
            slovo = input.split(" \\+ ");
            operation = '+';
        } else if (input.contains(" - ")) {
            slovo = input.split(" - ");
            operation = '-';
        } else if (input.contains(" * ")) {
            slovo = input.split(" \\* ");
            operation = '*';
        } else if (input.contains(" / ")) {
            slovo = input.split(" / ");
            operation = '/';
        } else {
            throw new Exception("Неккоректный знак операции");
        }

        //1.1 Выявим исключения
        if (operation == '*' || operation == '/') {
            if (slovo[1].contains("\""))
                throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка, а второго число при делении и умножении");
        }

        //2 - Удаление кавычек и пробелов через метод Replace и Trim
        slovo[0] = slovo[0].trim();
        slovo[1] = slovo[1].trim();
        for (int i = 0; i < slovo.length; i++) {
            slovo[i] = slovo[i].replace("\"", "");
        }
        //2.1 -  Подсчёт символов у первой и второй строки
        if (slovo[0].length() > 10 || slovo[1].length() > 10) {
            throw new Exception("Строки должны быть длинной не более 10 символов");
        }

            //3 - Операции с символами

            //3.1 - Сложение
            if (operation == '+') {
                System.out.println(slovo[0] + slovo[1]);

                //3.2 - Умножение
            } else if (operation == '*') {
                int umnozhenie = Integer.parseInt(slovo[1]);
                if (umnozhenie <= 10 && umnozhenie >= 1) {
                    String result = "";
                    for (int i = 0; i < umnozhenie; i++) {
                        result += slovo[0];
                    }
                    if (result.length() > 40) {
                        result = result.substring(0, 40);
                        result += "...";
                    }
                    System.out.println("\"" + result + "\"");
                } else {
                    throw new Exception("Калькулятор может принимать на вход числа от 1 до 10 включительно, не более");
                }

                //3.3 - Вычитание
            } else if (operation == '-') {
                int index = slovo[0].indexOf(slovo[1]);
                if (index < 0) {
                    System.out.println(slovo[0]);
                } else if (slovo[0].contains(slovo[1])) {
                    String result = slovo[0].replace(slovo[1], "");
                    System.out.println("\"" + result + "\"");
                }
            }

            //3.4 - Деление
            else if (operation == '/') {
                int delenie = Integer.parseInt(slovo[1]);
                if (delenie <= 10 || delenie >= 1) {
                    int lenght = slovo[0].length();
                    int step = lenght / delenie;
                    String result = slovo[0].substring(0, step);
                    System.out.println("\"" + result + "\"");
                } else {
                    throw new Exception("Калькулятор может принимать на вход числа от 1 до 10 включительно, не более");
                }
                return String.valueOf(operation);
            }
        return input;
    }
    }





