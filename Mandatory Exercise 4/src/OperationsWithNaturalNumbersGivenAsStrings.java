import java.util.*;
import static java . lang . System . out;
public class OperationsWithNaturalNumbersGivenAsStrings{

    public static void main(String []args){
                out . println (" OPERATIONS ON NATURAL NUMBERS " +
                "IN CHARACTER STRINGS ");
// enter two natural numbers
        Scanner in = new Scanner ( System .in );
        out . println ("two natural numbers :");
        String tal1 = in. next ();
        String tal2 = in. next ();
        out . println ();
// add the numbers and show the result
        String sum = add (tal1 , tal2 );
        show (tal1 , tal2 , sum , '+');
// subtract the numbers and show the result
        String difference=subtract(tal1,tal2);
        show (tal1 , tal2 , difference , '-');
        /*I don't know why this is happening but the 'add' and 'subtract' function cannot work simultaneously yet;
          I keep getting the error :
          Exception in thread "main" java.util.NoSuchElementException: No line found
	      at java.util.Scanner.nextLine(Scanner.java:1540)
	      at HelloWorld.subtract(HelloWorld.java:48)
	      at HelloWorld.main(HelloWorld.java:7)*/
    }
    public static String add(String num1,String num2){
//        Scanner sc=new Scanner(System.in);
//        String num1=sc.nextLine();
//        String num2=sc.nextLine();
        int len1=num1.length();
        int len2 = num2.length();
        int d1,d2,carry=0;//d1 and d2 represent the digit of string num1 and num2 in that specific iteration.
        String sum="";
        int length=Math.max(len1,len2);
        if(len1>len2){
            for(int i =0;i<length-len2;i++){
                num2="0"+num2;
                //i<length-len2 as we need to add as many 0s to num2 as required to make the length of num1 and num2 the same.
            }
        }
        else if(len2>len1){
            for(int i = 0;i<length-len1;i++){
                num1="0"+num1;
                //i<length-len1 as we need to add as many 0s to num1 as required to make the length of num1 and num2 the same.
            }
        }
//        out.println(" "+num1);
//        out.println("+"+num2);
        // System.out.println(length);
        for(int i=length-1;i>-1;i--){
            //i starts at length-1 as length alone gives the value for the length of the entire array.
            d1=Character.getNumericValue(num1.charAt(i));
            d2=Character.getNumericValue(num2.charAt(i));
            sum = ((d1+d2+carry)%10) + sum ;
            carry=(d1 + d2 + carry)/10;
//             System.out.println("------------------");
//             System.out.println(i);
//             System.out.println(d1);
//             System.out.println(d2);
//             System.out.println(carry);
//             System.out.println(sum);
        }
        if(carry != 0)sum = "1" + sum;
        return(sum);
    }

    public static String subtract(String num1,String num2) {
//        Scanner sc = new Scanner(System.in);
//        String num1=sc.nextLine();
//        String num2=sc.nextLine();
        int len1 = num1.length();
        int len2 = num2.length();
        int d1, d2, carry = 0;//d1 and d2 represent the digit of string num1 and num2 in that specific iteration.
        String difference = "";
        int length = Math.max(len1, len2);
        if (len1 >= len2) {
            for (int i = 0; i < length - len2; i++) {
                num2 = "0" + num2;
                //i<length-len2 as we need to add as many 0s to num2 as required to make the length of num1 and num2 the
                // same.
            }
//            out.println(" " + num1);
//            out.println("-" + num2);
            // System.out.println(length);
            for (int i = length - 1; i > -1; i--) {
                //i starts at length-1 as length alone gives the value for the length of the entire array.
                d1 = Character.getNumericValue(num1.charAt(i));
                if (i < length - 1 && carry != 0) d1--;
                //If we are not at the last digit of the number(or at the beginning of the loop in this situation) and num1
                // value for the  variable 'carry' exists, it  means that the digit from which we are subtracting in this
                // iteration has to be reduced by 1.
                d2 = Character.getNumericValue(num2.charAt(i));
                // if(i>0)d=Character.getNumericValue(num1.charAt(i-1));
                if (d1 < d2) {carry = 10;}
                else carry=0;
                difference = (((d1 + carry) - d2) % 10) + difference;
                // System.out.println("------------------");
                // System.out.println(i);
                // System.out.println(d1);
                // System.out.println(d2);
                // System.out.println(carry);
                // System.out.println(sum);
            }
            return(difference);
        } else if (len2 > len1) {
            /*
            The logic I used for the subtraction function was that I want to always subtract the bigger number by the
            smaller number, thus for the entire case of len2 > len1 I have adapted the code so that the operation is
            num2-num1 and then I output -(num2-num1).
            */

            for (int i = 0; i < length - len1; i++) {
                num1 = "0" + num1;
                //i<length-len1 as we need to add as many 0s to num1 as required to make the length of num1 and num2 the
                // same.
            }
//            out.println(" " + num1);
//            out.println("-" + num2);
            // System.out.println(length);
            for (int i = length - 1; i > -1; i--) {
                //i starts at length-1 as length alone gives the value for the length of the entire array.
                d1 = Character.getNumericValue(num2.charAt(i));
                if (i < length - 1 && carry != 0) d1--;
                //If we are not at the last digit of the number(or at the beginning of the loop in this situation) and num1
                // value for the  variable 'carry' exists, it  means that the digit from which we are subtracting in this
                // iteration has to be reduced by 1.
                d2 = Character.getNumericValue(num1.charAt(i));
                if (i == 0 && d2 == 0 && carry != 0) d1++;
                //For num1 case like 12-120 we get 008 as the answer if we don't increment d1 by 1, but we only need to
                // increment the first digit if num1 value for carry exists.

                // if(i>0)d=Character.getNumericValue(num1.charAt(i-1));
                if (d1 < d2) carry = 10;
                difference = (((d1 + carry) - d2) % 10) + difference;
                // System.out.println("------------------");
                // System.out.println(i);
                // System.out.println(d1);
                // System.out.println(d2);
                // System.out.println(carry);
                // System.out.println(sum);
            }
            return ("-" + difference);
        }
        return "";
    }
    public static void show ( String num1 , String num2 ,
                              String result , char operator )
    {
// set an appropriate length on numbers and result
        int len1 = num1 . length ();
        int len2 = num2 . length ();
        int len = result . length ();
        int maxLen = Math .max ( Math .max (len1 , len2 ), len );
        num1 = setLen (num1 , maxLen - len1 );
        num2 = setLen (num2 , maxLen - len2 );
        result = setLen ( result , maxLen - len );
// show the expression
        out . println (" " + num1 );
        out . println ("" + operator + " " + num2 );
        for (int i = 0; i < maxLen + 2; i++)
            out . print ("-");
        out . println ();
        out . println (" " + result + "\n");
    }
    // The setLen method prepends the supplied number of
// spaces ato the beginning of a string public static String setLen ( String s, int nofSpaces )
    public static String setLen ( String s, int nofSpaces )
    {
        StringBuilder sb = new StringBuilder (s);
        for (int i = 0; i < nofSpaces ; i++)
            sb. insert (0, " ");

        return sb. toString ();
    }
}