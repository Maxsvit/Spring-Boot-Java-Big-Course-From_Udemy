package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

   public static int[] solution(int[] numbers) {
       int[] newNumbers = new int[numbers.length - 2];
       for(int i = 0; i < numbers.length - 2; i++){
           if(numbers[i]  < numbers[i + 1] && numbers[i + 1] > numbers[i + 2]){
               int end = numbers[i] + numbers[i + 1] + numbers[i + 2];
               newNumbers[i] = i;
           } else if (numbers[i]  > numbers[i + 1] && numbers[i + 1] < numbers[i + 2]) {
               int end = numbers[i] + numbers[i + 1] + numbers[i + 2];
               newNumbers[i] = i;
           }
       }

       return newNumbers;

    }
    public static void main(String[] args) {

        int[] numbers = {1,2,4,3,1};

        int[] solution = solution(numbers);
        System.out.println(Arrays.toString(solution));


    }
}