//import java.util.Scanner;

public class TrianglesAndItsCircles {

    public static void main(String[] args) {
        System.out.println("Circum-radius : "+ Triangle.circumRadius(3,4,5) + " units");
        System.out.println("In-radius : "+ Triangle.inRadius(3,4,5) + " units");

    }
}























//        Scanner in=new Scanner(System.in);
//        String [] commands;
//        commands = new String[]{
//                "Area of Triangle(Enter 1)",
//                "Perimeter of Triangle(Enter 2)",
//                "Area of Triangle using Heron's Formula(Enter 3)",
//                "Length of Median of the Triangle(Enter 4)",
//                "Length of bisector between side1 and side2(Enter 5)",
//                "Length of bisector between side2 and side3(Enter 6)",
//                "Length of bisector between side3 and side1(Enter 7)",
//                "Length of inradius of the triangle(Enter 8)",
//                "Length of circumradius of the triangle(Enter 9)",
//                "Enter a command:"};
//        for (int i = 0; i < commands.length ; i++) {
//            System.out.println(commands[i]);
//        }
//
//        int command=in.nextInt();
//
//        switch (command){
//            case 1:
//                System.out.println(Triangle.area());break;
//            case 2:
//                System.out.println(Triangle.perimeter());break;
//            case 3:
//                System.out.println(Triangle.heronsFormulaArea());break;
//            case 4:
//                System.out.println(Triangle.medianLength());break;
//        }
//        if(command==5 || command==6 || command==7 || command==8 || command==9){
//            double a,b,c;
//            System.out.println("Enter the length of the first side: ");
//            a=in.nextDouble();
//            System.out.println("Enter the length of the second side: ");
//            b=in.nextDouble();
//            System.out.println("Enter the length of the third side: ");
//            c=in.nextDouble();
//            System.out.println("Enter the value of angle alpha:");
//            double alpha= in.nextDouble();
//            System.out.println("Enter the value of angle beta:");
//            double beta= in.nextDouble();
//            System.out.println("Enter the value of angle gamma:");
//            double gamma= in.nextDouble();
//
//                switch (command){
//                    case 5:
//                        System.out.println(Triangle.bisector1(a,b,alpha));
//                        break;
//                    case 6:
//                        System.out.println(Triangle.bisector2(b,c,beta));
//                        break;
//                    case 7:
//                        System.out.println(Triangle.bisector3(c,a,gamma));
//                        break;
//                    case 8:
//                        System.out.println(Triangle.inRadius(a,b,c));
//                        break;
//                    case 9:
//                        System.out.println(Triangle.circumRadius(a,b,c));
//                        break;
//                    default:
//                        System.out.println("Invalid Command; " + "Enter a valid value to proceed");
//                        break;
//                }
//        }
