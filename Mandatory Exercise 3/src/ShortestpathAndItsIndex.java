import java.util.Scanner;

public class ShortestpathAndItsIndex {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        double[] a={1,2,3};
        double[][] b={
                {2,3,4,5},
                {3,4,5,6},
                {4,5,6,7}
        };
        double[] c={5,6,7,8};

        int []stationIndex=TheShortestPath.intermediateStations(a,b,c);
        System.out.println("Station Index: U"+(stationIndex[0]+1) + " V"+ (stationIndex[1]+1));
        double l=TheShortestPath.length(a,b,c);
        System.out.println("The length of the path traveled: " + l);
    }
}










//        for (int i = 0; i <3 ; i++) {
//            System.out.println("Enter the distances travelled from station 1 to 2 for case :"
//                    + i);
//            a[i]=in.nextDouble();
//            for (int j = 0; j <4 ; j++) {
//                System.out.println("Enter the distances travelled from station 2 to 3 for case :"
//                        + "("+ i +"," + j +")");
//                b[i][j]=in.nextDouble();
//            }
//            for (int k = 0; k <4 ; k++) {
//                System.out.println("Enter the distances traveled from station 3 to 4:for case :"
//                        + k);
//                c[k]= in.nextDouble();
//            }
//        }



