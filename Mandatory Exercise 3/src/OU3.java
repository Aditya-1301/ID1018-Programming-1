import java.util.Scanner;

class TheShortestPath
{
    // The method intermediateStations returns a vector of the
    // intermediate stations that are on the shortest path .
    // The ordinal number of the first station is located in
    // index 1 of the vector , and the second station on index 2.
    public static int [] intermediateStations ( double [] a,
                                                double [][] b,
                                                double [] c)
    {
// *** WRITE YOUR CODE HERE ***
        Double mindF=a[0]+b[0][0]+c[0];
        int shortestPathStations[]= {0,0}; //Array which stores the index of whichever station
                                           //gives the shortest path.
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <c.length ; j++) {
                if(mindF>a[i]+b[i][j]+c[j]){
                    mindF=a[i]+b[i][j]+c[j];
                    shortestPathStations[0]=i;
                    shortestPathStations[1]=j;
                }
            }
        }
        return shortestPathStations;
    }
    // The method length returns the length of the shortest path .
    public static double length ( double [] a,
                                  double [][] b,
                                  double [] c)
    {
// *** WRITE YOUR CODE HERE ***
        int []d=new int[2];
        for(int i=0;i<d.length;i++)
        d=intermediateStations(a, b, c);

        return a[d[0]]+b[d[0]][d[1]]+c[d[1]];
    }
}


