package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    static Scanner s = new Scanner(System.in);
    static Random r = new Random();

    static String magicWord;

    public static void main(String[] args)
    {

// LESSON 17 (46) - long exercise about functions

        //ex3
        greet();

        //ex4+5
        for (int i = 1; i <= 10; i++)
        {
            printNum(i);
        }
        System.out.println();
        System.out.println();

        //ex6
        int k = 5;
        changeNumber (k);
        System.out.println("k is: " + k);   // k will have not changed, is still 5

        //ex7
        multiply(5, 4);
        multiply(3, 6);
        multiply(7, 5);
        System.out.println();

        //ex8
        calc(5, 4, '-');
        calc(3, 6, '+');

        //ex9
        System.out.println("Average: " + returnAverage (1, 4, 9));

        //ex10
        int[] arr10 = {5, 7, 3, 10, 8};
        int num10 = 3;
        System.out.println("Is in? " + checkIfIn(arr10, num10));

        //ex11
        printDividers(12);
        System.out.println();

        //ex12
        printHello();
        System.out.println();

        //ex14
        numberType(3.6f);
        numberType(3.6);
        numberType(3);

        //ex15
        System.out.println("Please enter an interger: ");
        int try15 = getScanner().nextInt();
        System.out.println("Entered integer was: " + try15);

        //ex16
        int[] arr16 = {66, 55, 77, 99, 111, 3};
        System.out.println(String.format("Random number from the array: %d", randomise(arr16)));

        //ex17
        String str17 = "blah ";
        System.out.println("New string: " + addStuff(str17));

        //ex19
        magicWord = "Mila";
        printWord(magicWord);
        changeWord("aliM");
        System.out.println(magicWord);    // this would print the new word, the variable has changed
                                          // since it's a global variable

        //ex20
        int[] arr20 = {2, 6, 7, 8, 34, 16};
        multiplyZugi(arr20);
        addOne(arr20);
        setZero(arr20);
        System.out.println("The current array is: ");
        for (int i = 0; i < arr20.length; i++)
        {
            System.out.print(arr20[i] + "  ");
        }
        // the original array has changed! methods affect array in parameter as if it were a global variable
        System.out.println();
        System.out.println();

        //ex21
        int num21 = 524;
        System.out.println("The sum of the digits is: " + addDigits(num21));

        //ex22
        char[] char22 = {'p', 'a', 's', 's', '1', '2', '3', '4'};
        System.out.println("Password OK? " + checkPassword(char22));
        System.out.println("Password OK? " + checkPasswordV2(char22));
        System.out.println();

        //ex23
        int[][] matrix23 = new int[3][3];
        System.out.println("The 3x3 matrix is: ");
        for (int i_row = 0; i_row < 3; i_row++)
        {
            for (int i_col = 0; i_col < 3; i_col++)
            {
                matrix23[i_row][i_col] = r.nextInt(100) + 1;
                System.out.print(matrix23[i_row][i_col] + "  ");
            }
            System.out.println();
        }
        System.out.println(String.format("Sum of all numbers in that matrix: %d", returnMatrixSum(matrix23)));
        System.out.println();

        //ex25
        int fact25 = 11;
        System.out.println(String.format("The factorial of %d is: %d", fact25, recursFactorial(fact25)));



    }

    //ex25
    public static long recursFactorial (int fact)
    {
        if (fact == 0 || fact == 1)
        {
            return 1;
        }
        else
        {
           return fact * recursFactorial(fact - 1);
        }
        // return (fact == 0 || fact == 1) ? 1 : fact * recursFactorial(fact - 1);             // shorter :)
    }

    //ex23
    public static int returnMatrixSum (int[][] matrix)
    {
        int sum23 = 0;
        for (int i_row = 0; i_row < 3; i_row++)
        {
            for (int i_col = 0; i_col < 3; i_col++)
            {
                sum23 += matrix[i_row][i_col];
            }
        }
        return sum23;
    }

    //ex22
    public static boolean checkPassword (char[] char22)
    {
        boolean check22 = false;
        if (char22.length >= 8)
        {
            for (int i = 0; i < char22.length; i++)
            {
                if (Character.isDigit(char22[i]))
                {
                    check22 = true;
                    break;
                }
            }
            if (check22 == true)
            {
                check22 = false;
                for (int i = 0; i < char22.length; i++)
                {
                    if (Character.isLetter(char22[i]))
                    {
                        check22 = true;
                        break;
                    }
                }
            }
        }
        return check22;
    }

    public static boolean checkPasswordV2 (char[] char22)
    {
        boolean check22l = false;
        boolean check22d = false;
        if (char22.length >= 8)
        {
            for (int i = 0; i < char22.length; i++)
            {
                if (Character.isDigit(char22[i]))
                {
                    check22d = true;
                    break;
                }
            }
            if (check22d == true)
            {
                check22l = false;
                for (int i = 0; i < char22.length; i++)
                {
                    if (Character.isLetter(char22[i]))
                    {
                        check22l = true;
                        break;
                    }
                }
            }
        }
        return check22d && check22l;
    }

    //ex21
    public static int addDigits (int num21)
    {
        int sum21 = 0;
        do
        {
            sum21 = sum21 + (num21 % 10);
            num21 /= 10;
        }
        while (num21 != 0);
        return sum21;
    }

    //ex20
    public static void multiplyZugi (int[] arr20)
    {
       for (int i = 0; i < arr20.length; i++)
       {
           if (arr20[i] % 2 == 0)
           {
               arr20[i] *= 2;
           }
       }
    }

    public static void addOne (int[] arr20)
    {
        arr20[arr20.length - 1] += 1;
    }

    public static void setZero (int[] arr20)
    {
        for (int i = 0; i < arr20.length; i++)
        {
            if (arr20[i] % 2 != 0)
            {
                arr20[i] = 0;
            }
        }
    }

    //ex19
    public static void printWord (String str19)
    {
        System.out.println("The word is: " + str19);
    }

    public static void changeWord (String str19)
    {
        magicWord = str19;
    }

    //ex17
    public static String addStuff (String str17)
    {
        str17 = str17 + "@@@";
        str17 = addTwoStars(str17);
        str17 = addOneHash(str17);
        return str17;
    }

    public static String addTwoStars (String str17)
    {
        return str17 + "**";
    }

    public static String addOneHash (String str17)
    {
        return str17 + "#";
    }

    //ex16
    public static int randomise (int[] arr16)
    {
        return (arr16[r.nextInt(arr16.length)]);
    }

    //ex15
    public static Scanner getScanner ()
    {
        return s;
    }

    //ex14
    public static void numberType (int num14)
    {
        System.out.println("integer!");
    }

    public static void numberType (float num14)
    {
        System.out.println("float!");
    }

    public static void numberType (double num14)
    {
        System.out.println("double!");
    }

    //ex12
    private static void printHello ()
    {
        System.out.print("hello ");
        printWorld ();
    }

    private static void printWorld ()
    {
        System.out.println("world");
    }

    //ex11
    private static void printDividers (int num11)
    {
        for (int i = 1; i < num11; i++)
        {
            if (num11 % i == 0)
            {
                System.out.print(i + "  ");
            }
        }
    }

    //ex10
    private static boolean checkIfIn (int[] arr10, int num10)
    {
        int i;
        for (i = 0; i < arr10.length; i++)
        {
            if (arr10[i] == num10)
            {
                break;
            }
        }
        return i == arr10.length ? false : true;
    }

    //ex9
    public static float returnAverage (int num9a, int num9b, int num9c)
    {
        return ((float)(num9a + num9b + num9c) / 3);
    }

    //ex8
    public static void calc (int num8a, int num8b, char calc_act)
    {
        switch (calc_act)
        {
            case '+':
                System.out.println(String.format("%d + %d = %d", num8a, num8b, num8a + num8b));
                break;
            case '-':
                System.out.println(String.format("%d - %d = %d", num8a, num8b, num8a - num8b));
                break;
        }
    }

    //ex7
    public static void multiply (int num7a, int num7b)
    {
        System.out.println(String.format("%d * %d = %d", num7a, num7b, num7a * num7b));
    }

    //ex6
    public static void changeNumber (int num6)
    {
        num6++;
    }

    //ex4+5
    private static void printNum(int num4)
    {
        System.out.print(num4 + " ");
    }

    //ex3
    private static void greet()
    {
        System.out.println("Good morning!");
    }


}
