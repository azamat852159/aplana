package task2;

import org.w3c.dom.ls.LSOutput;
import org.junit.Test;

import java.util.*;

/*
 * Задача с массивом строк и калькулятором. На калькулятор вводится только 1 действие, входные данные вида 2*2-2 - не валидны
 *
 *
 * */

public class task2 {
    private static boolean zero = false;
    private static Scanner sc;

    static {
        task2.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int i = 0;
        double z;
        System.out.println("Введите 2(массив) или 1 (калькулятор)");
        try {
            i = sc.nextInt();
            if (i == 1) {
                try {
                    z = calc();
                    if (!task2.zero) {
                        System.out.println(String.format("%.4f", z));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error");
                }
            } else if (i == 2) {
                task2.mas();
            } else {
                System.out.println("Операции под номером " + i + " нет");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введенные данные не валидны");
        }
    }

    private static void mas() {
        System.out.println("Введите размер массива");
        int x = sc.nextInt();
        List<String> list = new ArrayList<>(x);
        for (int i = 0; i <= x; i++) {
            list.add(sc.nextLine());
        }
        list.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println(list.get(list.size() - 1));
    }


    private static double calc() {
        System.out.println("Введите выражение с +,-,* или / . Пример : 2 + 3; 4 * 8 и тд");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("\\s", "");
        double z = 0;
        calc calc = new calc();
        if (str.substring(1).contains("+")) {
            z = calc.plus(str);
        } else if (str.substring(1).contains("-")) {
            z = calc.minus(str);
        } else if (str.substring(1).contains("*")) {
            z = calc.multiply(str);
        } else {
            try {
                z = calc.divide(str);
                return z;
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль неопределено");
                task2.zero = true;
            }
        }
        return z;
    }
}

class calc {
    public double plus(String str) throws NumberFormatException {
        double x1 = Double.parseDouble(str.substring(0, str.indexOf('+')));
        double x2 = Double.parseDouble(str.substring(str.indexOf('+') + 1));
        return x1 + x2;
    }

    public double minus(String str) throws NumberFormatException {
        double x1;
        double x2;
        if (str.indexOf('-') != 0) {
            x1 = Double.parseDouble(str.substring(0, str.indexOf('-')));
        } else {
            str = removeCharAt(str, 0);
            x1 = (-1) * Double.parseDouble(str.substring(0, str.indexOf('-')));
        }
        x2 = Double.parseDouble(str.substring(str.indexOf('-') + 1));
        return x1 - x2;
    }

    public double multiply(String str) throws NumberFormatException {
        double x1 = Double.parseDouble(str.substring(0, str.indexOf('*')));
        double x2 = Double.parseDouble(str.substring(str.indexOf('*') + 1));
        return x1 * x2;
    }

    public double divide(String str) throws NumberFormatException {
        double x1 = Double.parseDouble(str.substring(0, str.indexOf('/')));
        double x2 = Double.parseDouble(str.substring(str.indexOf('/') + 1));
        if (x2 != 0) {
            return x1 / x2;
        } else {
            throw new ArithmeticException();
        }
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
