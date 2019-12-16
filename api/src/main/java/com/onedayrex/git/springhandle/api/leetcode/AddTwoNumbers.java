package com.onedayrex.git.springhandle.api.leetcode;

public class AddTwoNumbers {

    public void maopao(int[] a){
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    //右面比左面小
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,5,1,3,4,9,8};
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.maopao(a);
        System.out.println(a);
    }
}
