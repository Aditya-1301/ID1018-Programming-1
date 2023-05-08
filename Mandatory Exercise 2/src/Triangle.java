import java.util.Scanner;
/*
This is the code for Mandatory exercise 2; This Class contains all the methods related to a
Triangle. The second class is used to call the main method to be able to implement our code and
ask the user which method they want to call.
*/

public class Triangle {
    //This function gives the area of the Triangle if the user provides the values for
    // the base and height.
    public static double area(double altitude, double base){
        double areaOfTriangle=(0.5)*altitude*base;
        return areaOfTriangle;
    }

    //This function and the one after it, return the value of the perimeter, once the user
    // enters the values of the sides of the Triangle.
    public static double perimeter(double side1, double side2, double side3){
        double perimeterOfTriangle;
        perimeterOfTriangle=(side1+side2+side3);
        return perimeterOfTriangle;
    }

    //This function and the one after it, return the value of the product of
    // the sides of the Triangle.
    public static double sideProduct(double side1,double side2,double side3){
        double product;
        product=side1*side2*side3;
        return product;
    }

    //This function and the one after it, give the value for the area of the Triangle once
    //the user enters the values of sides.
    public static double heronsFormulaArea(double side1,double side2,double side3){
        double semiPerimeter,areaByHeronsFormula;
        Scanner in=new Scanner(System.in);
        semiPerimeter=( side1 + side2 + side3 )/2;
        areaByHeronsFormula=Math.sqrt( semiPerimeter * (semiPerimeter-side1) *
                (semiPerimeter-side2) * (semiPerimeter-side3) );
        return areaByHeronsFormula;
    }

    //This function returns the value of the median length between side1 and side2.
    public static double medianLength(double side1, double side2){
        double median;
        median=(0.5)*Math.sqrt(2*(side1*side1)+2*(side2*side2)-(side1*side1));
        return median;
    }

    //This function returns the value of the length of the angle bisector between side1
    //and side2 with angle alpha between them.
    public static double bisector1 ( double side1, double side2, double alpha )
    {
        double p = 2 * side1 * side2 * Math.cos(alpha/ 2);
        double bis1 = p/(side1 + side2);
        return bis1;
    }

    //This function returns the value of the In-radius of this Triangle.
    public static double inRadius(double a,double b,double c){

        double area=Triangle.heronsFormulaArea(a,b,c);
        double semiPerimeter=(perimeter(a,b,c))/2;
        double inRadiusLength=area/semiPerimeter;
        return inRadiusLength;
    }

    //This function returns the value of the Circum-radius of this Triangle.
    public static double circumRadius(double a,double b,double c){
        double area,product,circumRadiusLength;
        area=Triangle.heronsFormulaArea(a,b,c);
        product=Triangle.sideProduct(a,b,c);
        circumRadiusLength= product/(4*area);
        return circumRadiusLength;
    }
}
















/*
public static double area(){
        Scanner in=new Scanner(System.in);
        double altitude, base;
        System.out.println("Enter the length of the altitude for this triangle:");
        altitude =in.nextDouble();
        System.out.println("Enter the length of the base for this triangle:");
        base = in.nextDouble();
        double areaOfTriangle=(0.5)*altitude*base;
        return areaOfTriangle;
}

public static double perimeter(){
        double perimeterOfTriangle, side1, side2, side3;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the length of the first side: ");
        side1=in.nextDouble();
        System.out.println("Enter the length of the second side: ");
        side2=in.nextDouble();
        System.out.println("Enter the length of the third side: ");
        side3=in.nextDouble();
        perimeterOfTriangle=(side1+side2+side3);
        return perimeterOfTriangle;
}

public static double sideProduct(){
        double side1=0,side2=0,side3=0,product;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the length of the first side: ");
        side1=in.nextDouble();
        System.out.println("Enter the length of the second side: ");
        side2=in.nextDouble();
        System.out.println("Enter the length of the third side: ");
        side3=in.nextDouble();
        product=side1*side2*side3;
        return product;
}

public static double heronsFormulaArea(){
        double side1=0,side2=0,side3=0,semiPerimeter,areaByHeronsFormula;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the length of the first side: ");
        side1=in.nextDouble();
        System.out.println("Enter the length of the second side: ");
        side2=in.nextDouble();
        System.out.println("Enter the length of the third side: ");
        side3=in.nextDouble();
        semiPerimeter=( side1 + side2 + side3 )/2;
        areaByHeronsFormula=Math.sqrt( semiPerimeter * (semiPerimeter-side1) *
                (semiPerimeter-side2) * (semiPerimeter-side3) );
        return areaByHeronsFormula;
}

public static double medianLength(){
        double side1,side2,median;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the length of the first side: ");
        side1=in.nextDouble();
        System.out.println("Enter the length of the second side: ");
        side2=in.nextDouble();
        median=(0.5)*Math.sqrt(2*(side1*side1)+2*(side2*side2)-(side1*side1));
        return median;
}

//This function returns the value of the length of the angle bisector between side2
    //and side3 with angle beta between them.
    public static double bisector2 ( double side2, double side3, double beta )
    {
        double p = 2 * side3 * side2 * Math.cos(beta/ 2);
        double bis2 = p/(side3 + side2);
        return bis2;
    }

    //This function returns the value of the length of the angle bisector between side1
    //and side3 with angle gamma between them as a double.
    public static double bisector3 ( double side1, double side3, double gamma )
    {
        double p = 2 * side1 * side3 * Math.cos(gamma/ 2);
        double bis3 = p/(side1 + side3);
        return bis3;
    }
*/