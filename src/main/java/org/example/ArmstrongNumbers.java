package org.example;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int numberLen = 0;
        int temp = numberToCheck;
        while (temp > 0) {
            numberLen++;
            temp /= 10;
        }

        temp = numberToCheck;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numberLen);
            temp /= 10;
        }

        return sum == numberToCheck;
    }

}
