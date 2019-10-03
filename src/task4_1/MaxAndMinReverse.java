package task4_1;
/*
*  Массив размерностью 20, заполняется случайными целыми числами от -10 до 10.
*  Найти максимальный отрицательный и минимальный положительный элементы массива. Поменять их местами.
**/


import java.util.Arrays;
import java.util.Random;

public class MaxAndMinReverse {

    public static void main(String[] args) {
        int[] mas;
        int[] max;
        int[] min;
        mas = MaxAndMinReverse.generateMas();
        printf(mas);
        max = findMax(mas);
        min = findMin(mas);
        System.out.println("Минимальное значение под индексом " + min[0] + " равно " + min[1]);
        System.out.println("Максимальное значение под индексом " + max[0] + " равно " + max[1]);
        mas = reverseMas(mas,max[0],min[0]);
        printf(mas);
    }

    public static void printf(int[] mas){
        Arrays.stream(mas).forEach(x-> System.out.print(x+" "));
        System.out.println();
    }

    private static int[] reverseMas(int[] mas, int max, int min){
        int x;
        x = mas[max];
        mas[max] = mas[min];
        mas[min] = x;
        return mas;
    }

    private static int[] findMin(int[] mas){
        int [] minIndexAndVal = new int[2];
        minIndexAndVal[1] = mas[0];
        for (int i = 1; i < mas.length ; i++) {
            if (minIndexAndVal[1] > mas[i]) {
                minIndexAndVal[0] = i;
                minIndexAndVal[1] = mas[i];
            }
        }
        return minIndexAndVal;
    }

    private static int[] findMax(int[] mas){
        int [] maxIndexAndVal = new int[2];
        maxIndexAndVal[1] = mas[0];
        for (int i = 1; i < mas.length ; i++) {
            if (maxIndexAndVal[1] < mas[i]) {
                maxIndexAndVal[0] = i;
                maxIndexAndVal[1] = mas[i];

            }
        }
        return maxIndexAndVal;
    }


    private static int[] generateMas(){
        Random ran = new Random();
        int[] mas = new int[20];
        for (int i = 0; i <20 ; i++) {
            mas[i] = ran.nextInt(21) - 10;
        }
        return mas;
    }
}
