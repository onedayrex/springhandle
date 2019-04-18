package com.onedayrex.git.springhandle.api.algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] sort = new int[]{45,65,98,78,44,2,56,3,1,74,9};
        mergeSort(sort);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 分
     * @param sort
     */
    private static void mergeSort(int[] sort) {
        int[] temp = new int[sort.length];
        mergeSort(sort,0,sort.length-1,temp);
    }

    private static void mergeSort(int[] sort, int left, int right, int[] temp) {
        //只有在左边<右边才去做分的操作
        if (left < right) {
            int mid = (left + right) / 2;
            //左边排序
            mergeSort(sort, left, mid, temp);
            //右边排序
            mergeSort(sort, mid+1, right, temp);
            //合并
            merge(sort, left, mid, right, temp);
        }
    }

    private static void merge(int[] sort, int left, int mid, int right, int[] temp) {
        //左边指针
        int i = left;
        //右边指针
        int j = mid + 1;
        //临时指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (sort[i] <= sort[j]) {
                //左边比右边小，把左边放到临时数组中
                temp[t++] = sort[i++];
            }else {
                //右边比左边小，把右边放到临时数组中
                temp[t++] = sort[j++];
            }
        }
        //当两边比对完了以后，如果两边不对称，则需要单独把其中一边的全部移动到临时数组中

        //如果左边多了，则全部移到临时数组
        while (i <= mid) {
            temp[t++] = sort[i++];
        }

        //如果右边多了，则全部移到临时数组
        while (j <= right) {
            temp[t++] = sort[j++];
        }
        t = 0;
        //把临时数组中的全部copy到数组中
        while (left <= right) {
            sort[left++] = temp[t++];
        }
    }
}
