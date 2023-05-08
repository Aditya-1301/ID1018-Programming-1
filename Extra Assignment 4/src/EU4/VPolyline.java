package EU4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class VPolyline implements Polyline {
    private Point [] vertices;
    private String colour = " black ";
    private int width = 1;
    public VPolyline ()
    {
        this . vertices = new Point [0];
    }
    public VPolyline ( Point [] vertices )
    {
        this . vertices = new Point [ vertices . length ];
        for (int i = 0; i < vertices . length ; i++)
            this . vertices [i] = new Point ( vertices [i ]);
    }
    public String toString () {
        String ss = "Polyline";
        for (int i = 0; i <this.vertices.length ; i++)
            ss +=vertices[i];
        ss += "colour:  " + colour + ",  width:  " + width + ",  length:  " + length();
        return  ss;
    }
    public Point [] getVertices () {
        return vertices;
    }
    public String getColour (){
        return this.colour;
    }
    public int getWidth (){
        return this.width;
    }
    public double length (){
        double length=0;
        for (int i = 0; i <this.vertices.length-1; i++) {
            length+=this.vertices[i].distance(this.vertices[i+1]);
        }
        return length;
    }
    public void setColour ( String colour ){
        this.colour=colour;
    }
    public void setWidth ( int width ){
        this.width=width;
    }
    public void add ( Point vertex ){
        Point [] h = new Point [ this . vertices . length + 1];
        int i = 0;
        for (i = 0; i < this . vertices . length ; i++)
            h[i] = this . vertices [i];
        h[i] = new Point ( vertex );
        this . vertices = h;
    }
    public void insertBefore ( Point vertex , String vertexName ){
        ArrayList<Integer> indexes=new ArrayList<>();
        boolean elementExists=false;
        int i;
        for (i = 0; i < this . vertices . length ; i++)
        {
            if(this.vertices[i].getName().equals(vertexName)){
                elementExists=true;
                indexes.add(i);
            }
        }
        Point [] h = new Point [ this . vertices . length + indexes.size()];
        if (elementExists){
            for (int k = 0; k <indexes.size() ; k++) {
                for (i = 0; i <=indexes.get(k); i++)
                {
                    h[i]=this.vertices[i];
                    if(i==indexes.get(k))h[i]=new Point(vertex);
                }
                for (i = indexes.get(k)+k+1; i <this .vertices .length + 1; i++)
                {
                    h[i]=this.vertices[i-1];
                }
            }
            this . vertices = h;
        }
        else System.out.println("Element before which you want add does not exist");
    }
    public void remove ( String vertexName ){
        int i = 0;
        ArrayList<Integer> indexes=new ArrayList<>();
        boolean elementExists=false;
        for (i = 0; i < this . vertices . length  ; i++) {
            if(this.vertices[i].getName().equals(vertexName)){
                indexes.add(i);
                elementExists=true;
            }
        }
        if (elementExists){
            Point [] h = new Point [ this . vertices . length - indexes.size()];
            for (int k = 0; k <indexes.size() ; k++) {
                for (i = 0; i < indexes.get(k); i++)
                {
                    h[i]=this.vertices[i];
                }
                for (i = indexes.get(k); i < this . vertices . length - 1; i++) {
                    h[i]=this.vertices[i+1];
                }
            }
            this . vertices = h;
        }
        else System.out.println("The element that you want to remove does not exist");
    }

    public Iterator<Point> iterator() {
        ArrayList<Point> arrayList =new ArrayList<>();
        for (int i = 0; i <vertices.length ; i++) {
            arrayList.add(vertices[i]);
        }
        return arrayList.iterator();
    }
}
