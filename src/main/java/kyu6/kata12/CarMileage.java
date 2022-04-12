package main.java.kyu6.cw37;

/*
"7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.

"Interesting" Numbers
Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

Any digit followed by all zeros: 100, 90000
Every digit is the same number: 1111
The digits are sequential, incementing†: 1234
The digits are sequential, decrementing‡: 4321
The digits are a palindrome: 1221 or 73837
The digits match one of the values in the awesomePhrases array
† For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

So, you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
Error Checking
A number is only interesting if it is greater than 99!
Input will always be an integer greater than 0, and less than 1,000,000,000.
The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
You should only ever output 0, 1, or 2.
 */

import java.util.Arrays;

public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        System.out.println(number);
        if (number>99) {
            // check the array
            if (contains(awesomePhrases, number)) return 2;
            // check if the number is palindrome
            if (isPalindrome(number)) return 2;
            // check if the number contains of the same digits
            if (checkSameDigits(number)) return 2;
            // check if the number contains zeroes
            if (checkSequentalZeroes(number)) return 2;
            // check if the number contains sequental digits
            if (checkSequental(number)) return 2;
            // check if the number contains reverse sequental digits
            if (checkReverseSequental(number)) return 2;
        }

        if(number>97){
            if (contains(awesomePhrases,number+1) || contains(awesomePhrases,number+2)) return 1;
            if (isPalindrome(number+1) || isPalindrome(number+2)) return 1;
            if (checkSameDigits(number+1) || checkSameDigits(number+2)) return 1;
            if (checkSequentalZeroes(number+1) || checkSequentalZeroes(number+2)) return 1;
            if (checkSequental(number+1) || checkSequental(number+2)) return 1;
            if (checkReverseSequental(number+1) || checkReverseSequental(number+2)) return 1;
        }

        return 0;
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public static boolean isPalindrome(int number) {
        int r,sum=0,temp;

        temp=number;
        while(number>0){
            r=number%10;
            sum=(sum*10)+r;
            number=number/10;
        }
        if(temp==sum)
            return true;
        else
            return false;
    }

    public static boolean checkSameDigits(int number)
    {
        // Find the last digit
        int digit = number % 10;

        while (number != 0) {

            // Find the current last digit
            int current_digit = number % 10;

            // Update the value of number
            number = number / 10;

            // If there exists any distinct
            // digit, then return No
            if (current_digit != digit) {
                return false;
            }
        }

        // Otherwise, return Yes
        return true;
    }

    public static boolean checkSequentalZeroes(int number) {
        String str = String.valueOf(number);
        String zeroes = "";
        for (int i = 0; i < str.length()-1; i++) {
            zeroes += "0";
        }
        if (str.substring(1).equals(zeroes)) return true;
        return false;
    }

    public static boolean checkSequental(int number) {
        int digit = number % 10;
        if (digit==0) digit=10;
        number = number / 10;
        while (number != 0) {
            int current_digit = number % 10;
            number = number / 10;
            if (current_digit != digit-1) {
                return false;
            }
            digit = current_digit;
        }
        return true;
    }

    public static boolean checkReverseSequental(int number) {
        int digit = number % 10;
        number = number / 10;
        while (number != 0) {
            int current_digit = number % 10;
            number = number / 10;
            if (current_digit != digit+1) {
                return false;
            }
            digit = current_digit;
        }
        return true;
    }

}
