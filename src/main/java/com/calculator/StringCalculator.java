package com.calculator;


import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;


public class StringCalculator
{
  public static int add(String numbers)
  {
    if(numbers.isEmpty() || numbers.equals(" "))
    return 0;
    else 
    {
    
    String delimiter = ",|n";
    
    if (numbers.startsWith("//"))       //case with delimiters
    {
        int index = numbers.indexOf("//") + 2;
        delimiter = numbers.substring(index, index + 1);
        String newNumbers = numbers.substring(numbers.indexOf("n") + 1);
        int sum = 0;
        int temp;
        List negativeList = new ArrayList();
        
        String[] arrOfNum = newNumbers.split(delimiter);
        int len = arrOfNum.length;

        for (int i=0; i < len; i++) {
            if(arrOfNum[i].equals("") == true || arrOfNum[i].equals(" "))
                temp = 0;
            else
                temp = Integer.valueOf(arrOfNum[i].trim());
            if (temp < 0) 
                negativeList.add(temp);
            else if(temp <= 1000)
                sum += temp;
        }
        if (negativeList.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeList.toString());
        }
        return (sum);

    }
    else                                 //base case
    {
    String[] arrOfNum = numbers.split(",|n");
    int len = arrOfNum.length;
    int sum = 0;
    int temp;
    List negativeList = new ArrayList();
    for(int i=0; i < len; i++ )
    {
      if(arrOfNum[i].equals("") == true || arrOfNum[i].equals(" "))
        temp = 0;
      else
        temp = Integer.valueOf(arrOfNum[i].trim());
      if (temp < 0) 
        negativeList.add(temp);
        else if(temp <= 1000)
            sum += temp;
    }
    if (negativeList.size() > 0) {
        throw new RuntimeException("Negatives not allowed: " + negativeList.toString());
  
    }
    return (sum);
    
  }
  }
}

  // public static void main(String args[])
  // {
  //   Scanner sc = new Scanner(System.in);
  //   String s = sc.nextLine();
  //   int sum;
  //   if(s.isEmpty() || s.equals(" "))
  //   {
  //     sum = 0;
  //   }
  //   else
  //   {
  //    sum = Add(s);
  //   }
  //   System.out.println(sum);
    
    
    
  // }
}