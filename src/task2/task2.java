package task2;

import java.util.*;

public class task2 {
    private static Scanner sc;

    static {
        task2.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println("Введите 1(упорядочить массив) или 2 (калькулятор)");
        try {
            i = sc.nextInt();
            if(i == 2){
                task2.calc();
            }else{
                task2.mas();
            }
        }catch (InputMismatchException e){
            System.out.println("Введенные данные не валидны");
        }

    }

    private static void mas(){
        System.out.println("Введите размер массива");
        int x = sc.nextInt();
        List<String> list = new ArrayList<>(x);
        for (int i = 0; i <= x ; i++) {
            list.add(sc.nextLine());
            System.out.println(i);
        }
        list.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println(list.get(list.size()-1));
    }


    private static void calc(){
        System.out.println("Введите выражение . Пример : 2 + 3; 4 * 8 и тд");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("\\s", "");
        if (str.contains("+")) {
            double x1 = Double.parseDouble(str.substring(0, str.indexOf('+')));
            double x2 = Double.parseDouble(str.substring(str.indexOf('+') + 1));
            System.out.println(x1 + x2);
        } else if (str.contains("-")) {
            double x1 = Double.parseDouble(str.substring(0, str.indexOf('-')));
            double x2 = Double.parseDouble(str.substring(str.indexOf('-') + 1));
            System.out.println(x1 - x2);
        } else if (str.contains("*")) {
            double x1 = Double.parseDouble(str.substring(0, str.indexOf('*')));
            double x2 = Double.parseDouble(str.substring(str.indexOf('*') + 1));
            System.out.println(x1 * x2);
        } else if (str.contains("/")) {
            double x1 = Double.parseDouble(str.substring(0, str.indexOf('/')));
            double x2 = Double.parseDouble(str.substring(str.indexOf('/') + 1));
            System.out.println(x1 / x2);
        }
    }
}
