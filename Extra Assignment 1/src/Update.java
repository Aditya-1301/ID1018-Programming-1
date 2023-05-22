//import java.util.Scanner;
public class Update {
    public static void min(int []a){
        int minIndex=0;
//        Scanner sc=new Scanner(System.in);
//        for (int i = 0; i <a.length ; i++) {
//            a[i]=sc.nextInt();
//        }
//        sc.close();
        for (int i = 1; i <a.length ; i++) {
            if(a[minIndex]>a[i]){
                minIndex=i;
            }
        }
        System.out.println("The minimum value in this array is: " + a[minIndex]);
        System.out.println("The position of the minimum value in the array is: "
                + minIndex);
    }

    public static void main(String[] args) {
//        int[]a={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int []a={15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        min(a);
    }
}
