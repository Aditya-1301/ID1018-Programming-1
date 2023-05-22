package OU5;

import java.util.ArrayList;
import java.util.Random;

public class SelectPolyline {
    public static final Random rand = new Random ();
    public static final int NOF_POLYLINES = 10;
    public static void main ( String [] args )
    {
// Create a random number of polylines
        Polyline [] polylines = new Polyline [ NOF_POLYLINES ];
        ArrayList<Integer> yellowPolylineIndex=new ArrayList<>();
        int minlength=0;boolean yellowFound=false;
        for (int i = 0; i < NOF_POLYLINES ; i++)
        { polylines [i] = randomPolyline ();
// Show the polylines
            System.out.println("no." + i + "     " + polylines[i].toString() + " "+ polylines[i].length());
        }
        // Determine the shortest yellow polyline
        for (int i = 0; i <NOF_POLYLINES ; i++) {
            if(polylines[i].getColour().equals("yellow")){
//                System.out.println("yellowFound");
                yellowFound =true;
                yellowPolylineIndex.add(i);
            }
            if(yellowFound){

                    for (int j = 1; j < yellowPolylineIndex.size(); j++) {
                        System.out.println("asdfg");
                        if (polylines[yellowPolylineIndex.get(minlength)].length() >
                                polylines[yellowPolylineIndex.get(j)].length()) {
                            minlength = j;
                        }
                    }
            }
        }
// Show the selected polyline
        System.out.println("short yellow:  ");
        if (yellowFound) {
            System.out.println(polylines[yellowPolylineIndex.get(minlength)].toString());
        }
        else System.out.println("There are no Yellow Lines in your program");
    }
    // The randomPoint method returns a new Point with a name
// randomly chosen from the single letters A--Z. Coordinates
// are random .
    public static Point randomPoint ()
    {
        String n = "" + ( char ) (65 + rand . nextInt (26));
        int x = rand . nextInt (11);
        int y = rand . nextInt (11);
        return new Point (n, x, y);
    }
    // The method randomPolyline returns a random polyline ,
// with a colour either blue , red , or yellow . The names
// of the vertices are single letters from the set A--Z.
// Two vertices can not have the same name .
    public static Polyline randomPolyline ()
    {
// Create an empty polyline and add vertices
        Polyline polyline = new Polyline ();
        int nofVertices = 2 + rand . nextInt (7);
        int nofSelectedVertices = 0;
        boolean [] selectedNames = new boolean [26];
// Two vertices can not have the same name
        Point chosenPoint = null ;
        char chosenChar = 0;
        while ( nofSelectedVertices < nofVertices )
        {
            chosenPoint=randomPoint();
            String pName=chosenPoint.getName();
            chosenChar = pName.charAt(0);
            //if(selectedNames[i] == false)
            if (!selectedNames[chosenChar-65])
            {
                selectedNames[chosenChar-65]= true;
                polyline.addLast(chosenPoint);
                nofSelectedVertices++;
            }
        }
        int randomColor=rand.nextInt(3);
        switch(randomColor){
            case 0:polyline.setColour("yellow");break;
            case 1:polyline.setColour("yellow");break;
            case 2:polyline.setColour("yellow");
        }
// Assign a colour
        return polyline;
    }
}
