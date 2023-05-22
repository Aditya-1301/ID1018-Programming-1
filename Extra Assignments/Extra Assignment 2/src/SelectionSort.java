import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int n=5;
        int a[]= new int[n];int t,min;
        Scanner sc=new Scanner(System.in);
        for (int i = 1; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        int j=0;
        for (int i = 1; i <n ; i++) {
            min=i;
            for ( j = i+1; j <n ; j++) {
                if(a[min]>a[j]){
                    min=j;
                }
            }
                t=a[min];
                a[min]=a[i];
                a[i]=t;

        }
        for (int i = 1; i <n ; i++) {
            System.out.println(a[i]);
        }
    }
}
