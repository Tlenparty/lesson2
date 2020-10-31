package ru.geekbrains;

import java.util.Arrays;

public class MainApp {
    // lesson2
    // Задание 1
    public static void invertArray() { // Создали метод invertArray
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; // Задали числовой массив
        for (int i = 0; i < arr.length; i++) { // Циклом прошлись по элементам массива
            if (arr[i] == 0) { // Если индекс равеен 0 то присвоить 1
                arr[i] = 1;
            } else arr[i] = 0; // Остальное 0
            System.out.print(arr[i] + " "); // Проверка выводом на экран
        }
    }

    // Как делать 1м вариантом не понял .
    //Задание 2
    public static void fillArray() { // Создали метод fillArray
        int[] arr = new int[8]; // Задали целочисленный массив с размером 8
        for (int i = 0, k = 0; i < arr.length; i++, k += 3) {
            arr[i] = k;
            System.out.print(arr[i] + " ");
        }
    }

    // Задание 3
    public static void changeArray() {
        int[] w = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < w.length; i++) {
            if (w[i] < 6) {
                w[i] *= 2;
            } //
             System.out.print(w[i] + " "); // Проверка
        }
    }

    // Задание 4
    public static void fillDiagonal() {

        int[][] arr = new int[4][4];
        // 0 0 0 0  |  1 0 0 0   arr [0][0] = 1;
        // 0 0 0 0  |  0 1 0 0   arr [1][1] = 1;
        // 0 0 0 0  |  0 0 1 0   arr [2][2] = 1;
        // 0 0 0 0  |  0 0 0 1   arr [3][3] = 1;
        //           i __________j

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {  // Если индекс равны то присваиваем 1
                    arr[i][j] = 1;
                } else arr[i][j] = 0;  // если нет 0
                System.out.print(arr[i][j] + " "); // Вывод в консоль чтобы проверить
            }
            System.out.println();

        }
    }

    // Задание 5
    public static void findMax() {
        int max = 0;
        int min = 0;
        int[] w = {0, 10, 5,};

        for (int i = 0; i< w.length; i++) {

            if ((w[0] > w[1]) && (w[0] > w[2])) {
                max = w[0] ;
            } else if ((w[1] > w[2]) && (w[1] > w[0])) {
                max = w[1] ;
            } else max = w[2] ;
            if ((w[0] < w[1]) && (w[0] < w[2])) {
                min = w[0] ;
            } else if ((w[1] < w[2]) && (w[1] < w[0])) {
                min = w[1] ;
            } else  min = w[2];

        }
        System.out.println("Максимум = " + max );
        System.out.println("Минимум = " + min );
    }


    // Задание 6


    public static boolean checkBalance (int[] arr) { // Создали метод принимающий массив и возвращаеющий boolean
        int leftSum = 0; // Задали начальное значение левой части
        int rightSum = 0; // Задали начальное значение правой части

        for (int i = 0; i < arr.length; i++) { // Создали цикл который проходит по массиву

            for (int j = 0; j < i; j++) // Создали цикл внутри цикла который проходит по левой части
                leftSum += arr[j]; // leftSum = leftSum + arr[j];  К сумме слева присвоили индекс "левого массива"

            for (int j = i; j < arr.length; j++) // Создали цикл внутри цикла который проходит по правой части
                rightSum += arr[j]; // rightSum =rightSum + arr[j];  К сумме слева присвоили индекс "правого массива"
                                           // Внутри первого цикла мы на каждом шагу считаем левую и правую часть
                                             // таким образом мы проверяем все места в массиве
                if (rightSum == leftSum) // Теперь сравниваем эти части  если равны то
                    return true;   // метод завершается тут
                else {              // если нет
                    leftSum = 0;    // то присваиваем ноль левой сумме
                    rightSum = 0;   // то  присваиваем ноль правой сумме
                }
            }
            return false; // метод завершается

        }

    // Задание 7
    private static void move(int[] arr, int offset) {  // Создали метод который не возвращает, принимает массив и число offset)
        System.out.println("offset = " + offset + ", before: " + Arrays.toString(arr)); // Выводим в консоль offset (число смещений) и массив значения ДО
        int offsetModule = Math.abs(offset); // присваиваем offsetModule значение модуля offset ч/з библиотеку Math
        if (offset == 0 || offsetModule == arr.length) {// если смещение = 0 или  его модуль = длинне массива то делать не чего не нужно
            System.out.println("after: " + Arrays.toString(arr)); // значение после
            return;
        }
        // пересчет offset если его модуль больше длины массива
        if (offset > arr.length)  //если число смещений больше длины массива
            offset -= arr.length; // то отнимаем у числа смещений длину массива
        else if (offsetModule > arr.length)  // для отрицательного смещения, берем его модуль и если он больше длины массива
            offset += arr.length;  //  Отнимаем от числа смещений длину массива (+ потмоу что число смещений отрицательное)


        for (int step = 0; step < offsetModule; step++)  // создадим цикл, количетво итераций = модулю смещения
            if (offset > 0)  // если смещение положитеьное, то
                for (int j = 0; j < arr.length; j++)    // идем от начала массива
                    // ТУТ НУЖЕН МЕТОД КОТОРЫЙ БУДЕТ МЕНЯТЬ ЭЛЕМЕНТЫ МАССИВА
                    swapWithLastElement(arr, j); // меняем каждый элемент с последним

            else
                for (int j = arr.length - 1; j >= 0; j--)  // идем от конца массива
                    swapWithLastElement(arr, j); // меняем каждый элемент с последним
        System.out.println("after:" + Arrays.toString(arr)); // значение после

    }



    // Метод swapWithLastElement ничего не возвращает и принимает массив arr  и index ( идекс элемента массива)
    public static void swapWithLastElement(int[] arr, int index){  // Созадли метод который будет менять наши элементы массива

        int replacamentValue = arr[index]; // Создали переменную чтобы запомнить значение массива которое будем заменять
        arr[index] = arr[arr.length-1]; // присваиваем каждому индексу значение последнего элемента в массиве
        arr[arr.length-1] = replacamentValue;
    }





    public static void main(String[] args) {

        System.out.println(checkBalance(new int[]{1,2,3,4}));
        move(new int[] {0,1,2,3,4}, 5);
        move(new int[] {0,1,2,3,4,5,6}, 1);
        move(new int[] {0,1,2,3,4,5}, -6);
        move(new int[] {0,1,2,3}, 0);



    }
}

