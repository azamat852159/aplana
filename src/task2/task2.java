package task2;

import java.util.*;

/*
* Задача с массивом строк и калькулятором. На калькулятор вводится только 1 действие, входные данные вида 2*2-2 - не валидны
*
*
* */

public class task2 {
    private static Scanner sc;

    static {
        task2.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println("Введите 2(массив) или 1 (калькулятор)");
        try {
            i = sc.nextInt();
            if (i == 1) {
                task2.calc();
            } else {
                task2.mas();
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


    private static void calc() {
        System.out.println("Введите выражение с +,-,* или / . Пример : 2 + 3; 4 * 8 и тд");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("\\s", "");
        calc calc = new calc();
        if (str.substring(1).contains("+")) {
            calc.plus(str);
        } else if (str.substring(1).contains("-")) {
            calc.minus(str);
        } else if (str.substring(1).contains("*")) {
            calc.multiply(str);
        } else if (str.substring(1).contains("/")) {
            calc.divide(str);
        }else{
            System.out.println("Введены данные не по шаблону");
        }
    }
}

class calc {
    public void plus(String str) {
        double x1 = Double.parseDouble(str.substring(0, str.indexOf('+')));
        double x2 = Double.parseDouble(str.substring(str.indexOf('+') + 1));
        System.out.println(String.format("%.4f", x1 + x2));
    }

    public void minus(String str) {
        double x1;
        double x2;
        if (str.indexOf('-') != 0) {
            x1 = Double.parseDouble(str.substring(0, str.indexOf('-')));
        } else {
            str = removeCharAt(str, 0);
            x1 = (-1) * Double.parseDouble(str.substring(0, str.indexOf('-')));
        }
        x2 = Double.parseDouble(str.substring(str.indexOf('-') + 1));
        System.out.println(String.format("%.4f", x1 - x2));
    }

    public void multiply(String str) {
        double x1 = Double.parseDouble(str.substring(0,str.indexOf('*')));
        double x2 = Double.parseDouble(str.substring(str.indexOf('*') + 1));
        System.out.println(String.format("%.4f", x1 * x2));
    }

    public void divide(String str) {
        double x1 = Double.parseDouble(str.substring(0,str.indexOf('/')));
        double x2 = Double.parseDouble(str.substring(str.indexOf('/') + 1));
        if (x2 != 0) {
            System.out.println(String.format("%.4f", x1 / x2));
        } else {
            System.out.println("Нельзя делить на 0");
        }
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
