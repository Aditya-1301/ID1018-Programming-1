package EU4;

import java.util.Arrays;
import java.util.Iterator;

public class PolylineTesterForTypeNAndV {
    public static void main(String[] args) {
        Point[] points = {new Point("a",1,2),new Point("b", 2,3),
                new Point("c",3,4),new Point("d",4,5)};
//        VPolyline points1 =new VPolyline(points);
//        VPolyline pl3=new VPolyline();
        NPolyline points1 =new NPolyline(points);
        NPolyline pl3=new NPolyline();
        System.out.println(pl3.length());
        pl3.add(new Point("f",0,4));
        System.out.println(pl3.length());
        System.out.println(pl3);
        pl3.add(new Point("g",1,4));
        pl3.insertBefore(new Point("d ", 0,3),"f");
        System.out.println(pl3);
        System.out.println(points1);
        System.out.println(Arrays.toString(points1.getVertices()));
        points1.insertBefore(new Point("insert",3,5),"b");
        System.out.println(Arrays.toString(points1.getVertices()));
        points1.remove("b");
        points1.remove("f");
        System.out.println(Arrays.toString(points1.getVertices()));
        points1.insertBefore(new Point("insert",4,5),"r");
        System.out.println(Arrays.toString(points1.getVertices()));
        System.out.println(points1.getColour());
        System.out.println(points1.length());
        System.out.println(points1.getWidth());
        Iterator<Point> i =points1.iterator();
        System.out.println(points1);
        while (i.hasNext()){
            System.out.println(i.next());
        }
        pl3.setColour("yellow");
        System.out.println(Polylines.shortestYellowPolyline(new Polyline[] {points1}));
    }
}
