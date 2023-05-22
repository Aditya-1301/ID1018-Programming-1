package OU5.RoughWork;
import java.util.Scanner;
public class InsertionSort {
        public static void main(String []args) {
            int n = 5;
            int[] a = new int[n];
            int t, min;
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                min = i;
                for (int j = 1; j < n; j++) {
                    if (a[min] < a[j]) {
                        min = j;
                    }
                    t = a[min];
                    a[min] = a[j];
                    a[j] = t;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }
}
