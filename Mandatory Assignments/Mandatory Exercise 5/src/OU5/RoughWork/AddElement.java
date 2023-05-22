package OU5.RoughWork;
import java.util.*;
public class AddElement {
    public static void main(String []args){
        int []ar =new int[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            ar[i]=sc.nextInt();
        }
        int[] a2=new int[6];
        for(int i=0;i<6;i++){
            if(i<3)a2[i]=ar[i];
            else if(i==3)a2[3]=5;
            else a2[i]=ar[i-1];
        }
        for(int i=0;i<6;i++){
            System.out.println(a2[i]);
        }
    }
}
