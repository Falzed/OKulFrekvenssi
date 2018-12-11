/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.util;

/**
 *
 * @author Oskari
 */
public class OmaTuple {
    private final double luku;
    private final char merkki;
    public OmaTuple(double a, char c) {
        this.luku=a;
        this.merkki=c;
    }
    public double getValue() {
        return this.luku;
    }
    public char getMerkki() {
        return this.merkki;
    }
    @Override
    public String toString() {
        return String.valueOf(merkki)+": "+luku;
    }
    
    /**
     *
     * @param unsorted
     * @return
     */
    public static OmaTuple[] omaMergeSort(OmaTuple[] unsorted) {
        OmaTuple[] copy = unsorted.clone();
        sort(copy, 0, unsorted.length - 1);
        return copy;
    }

    private static void sort(OmaTuple[] unsorted, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(unsorted, left, middle);
            sort(unsorted, middle + 1, right);
            merge(unsorted, left, middle, right);
        }
    }

    private static void merge(OmaTuple[] arr, int left, int middle, int right) {
        OmaTuple[] L = new OmaTuple[middle - left + 1];
        OmaTuple[] R = new OmaTuple[right - middle];

        for (int i = 0; i < middle - left + 1; i++) {
            L[i] = arr[left + i];
        }
//        System.out.println(left + ", " + middle + ", " + right);
        for (int i = 0; i < right - middle; i++) {
            R[i] = arr[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < middle - left + 1 && j < right - middle) {
            if ((double) L[i].getValue() >= (double) R[j].getValue()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < middle - left + 1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < right - middle) {
            arr[k] = R[j];
            j++;
            k++;
        }
//        System.out.println(Arrays.toString(arr));

    }
}
