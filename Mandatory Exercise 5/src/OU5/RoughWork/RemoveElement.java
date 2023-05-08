package OU5.RoughWork;
import java.util.*;
public class RemoveElement {
    public static void main(String []args){
        int []ar =new int[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            ar[i]=sc.nextInt();
        }
        int []a3=new int[4];
        for(int i=0;i<4;i++){
            if(i>2)a3[i]=ar[i+1];
            else a3[i]=ar[i];
        }
        for(int i=0;i<4;i++){
            System.out.println(a3[i]);
        }
    }
}
