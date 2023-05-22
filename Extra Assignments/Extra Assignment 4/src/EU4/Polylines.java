package EU4;

import java.util.ArrayList;

public class Polylines {

        public static Polyline shortestYellowPolyline(Polyline[] lines){
        ArrayList<Polyline> yellowLines = new ArrayList<>();
        if( lines==null || lines.length==0 )return null;

            Polyline p=null;

        for (int i = 0; i <lines.length ; i++) {
            if(lines[i].getColour().equals("yellow")){
                yellowLines.add(lines[i]);
            }
        }
            double min= yellowLines.get(0).length();
            int minIndex=0;
        for (int i = 1; i <yellowLines.size() ; i++) {
            double length= yellowLines.get(i).length();
            if (min>length){
                min=length;
                minIndex=i;
            }
        }
        if (yellowLines.size()>0){
            p = yellowLines.get(minIndex);
        }
        else p=null;
        return p;
    }

}







//    public static Polyline shortestYellow(Polyline[] lines) {
//        Polyline shortestLine = null;
//        double shortestLineLength = Double.POSITIVE_INFINITY;
//        for(int i = 0; i < lines.length; i++) {
//            if (lines[i].getColour().equals("yellow")) {
//                if (shortestLine == null) shortestLine = lines[i];
//                else {
//                    double currentLineLength = 0;
//                    Point[] currentLinevertices = lines[i].getVertices();
//                    for (int j = 0; j < currentLinevertices.length - 1; j++)
//                        currentLineLength += currentLinevertices[j].distance(currentLinevertices[j+1]);
//
//                    if (currentLineLength < shortestLineLength) {
//                        shortestLine = lines[i];
//                        shortestLineLength = currentLineLength;
//                    }
//                }
//            }
//        }
//        return shortestLine;
//    }