package com.sda;

import java.util.Random;

//Написать программу выводящую на экран случайно сгенерированное трёхзначное натуральное число и сумму его цифр

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(999);
        int summDigit = 0;
        System.out.print("Сумма цифр числа "+ number);
        for (; number > 0; number /= 10){
            int digit = number%10;
            summDigit += digit;
        }
        System.out.print( " равна " + summDigit);
   }
}
