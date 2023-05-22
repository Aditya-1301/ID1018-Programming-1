package OU5;

import java.util.Arrays;

public class PolylineTest {
    public static void main(String[] args) {
        Point[] p=new Point[4];

        p[0]=new Point("a",1,3);
        p[1]=new Point("b",3,5);
        p[2]=new Point("c",4,3);
        p[3]=new Point("d",5,4);
        Polyline pl1=new Polyline(p);
        Polyline pl3=new Polyline();
        pl3.addLast(new Point("f",0,4));
        pl3.addLast(new Point("f",1,4));
        System.out.println(pl3.length());
        //Polyline.PolylineIterator p1=new Polyline().new PolylineIterator();
        Polyline.PolylineIterator p1=pl1.new PolylineIterator();
        System.out.println(pl1);
        System.out.println(Arrays.toString(pl1.getVertices()));
        pl1.addBefore(new Point("insert",3,5),"b");
        System.out.println(Arrays.toString(pl1.getVertices()));
        pl1.remove("b");
        pl1.remove("f");
        pl1.addBefore(new Point("insert",3,5),"r");
        System.out.println(pl1);
        System.out.println(Arrays.toString(pl1.getVertices()));
        System.out.println(pl1.getColour());
//        System.out.println(Arrays.toString(pl1.getVertices()));
        System.out.println(pl1.length());
        System.out.println(pl1.getWidth());
        if (p1.hasVertex())
        {

            System.out.println(p1.vertex());
            p1.advance();
        }
    }
}
