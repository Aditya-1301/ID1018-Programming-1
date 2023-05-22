import java.util.Scanner;
public class ExchangeSort {
    public static void main(String[] args) {
        int n=5;
        int a[]= new int[n];int t;
        Scanner sc=new Scanner(System.in);
        for (int i = 1; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 1; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
              if(a[i]>a[j]){
                  t=a[i];
                  a[i]=a[j];
                  a[j]=t;
              }
            }
        }
        for (int i = 1; i <n ; i++) {
            System.out.println(a[i]);
        }
    }
}
