package OU5;

import java.util.ArrayList;

public class Polyline {
    private Point [] vertices;
    private String colour = " black ";
    private int width = 1;
    public Polyline ()
    {
        this . vertices = new Point [0];
    }
    public Polyline ( Point [] vertices )
    {
        this . vertices = new Point [ vertices . length ];
        for (int i = 0; i < vertices . length ; i++)
            this . vertices [i] = new Point ( vertices [i ]);
    }
    public String toString () {
        /*for (int i = 0; i <this.vertices.length ; i++)
            System.out.println("PolyLine(" + vertices[i] + " " + colour +  " " + width + ')');
        return null;

         */
        String ss = "Polyline";
        for (int i = 0; i <this.vertices.length ; i++)
            ss +=vertices[i];
        ss += "colour:  " + colour + ",  width:  " + width;
        return  ss;
    }
    public Point [] getVertices () {
      Point [] newVertices=new Point[vertices.length];
        for (int i = 0; i < vertices.length ; i++) {
            newVertices[i]=new Point(this.vertices[i]);
        }
        return newVertices;
    }
    public String getColour () {
      return this.colour;
    }
    public int getWidth () {
        return this.width;
    }
    public void setColour ( String colour ) {
        this.colour=colour;
    }
    public void setWidth ( int width ) {
        this.width=width;
    }
    public double length () {
        double length=0;
        for (int i = 0; i <this.vertices.length-1; i++) {
            length+=this.vertices[i].distance(this.vertices[i+1]);
        }
        return length;
    }

    public void addLast ( Point vertex )
    {
        Point [] h = new Point [ this . vertices . length + 1];
        int i = 0;
        for (i = 0; i < this . vertices . length ; i++)
            h[i] = this . vertices [i];
        h[i] = new Point ( vertex );
        this . vertices = h;
    }

    public void addBefore ( Point vertex , String vertexName ) {
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

    public void remove ( String vertexName ) {

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

    public class PolylineIterator {
        private int current = -1;
        public PolylineIterator ()
        {
            if ( Polyline . this . vertices . length > 0)
                current = 0;
        }
        public boolean hasVertex ()
        {
            return current != -1;
        }
        public Point vertex ()
                throws java . util . NoSuchElementException
        {
            if (! this . hasVertex ())
                throw new java . util . NoSuchElementException (

                        "end of iteration ");
            Point vertex = Polyline . this . vertices [ current ];
            return vertex ;
        }
        public void advance ()
        {
            if ( current >= 0 &&
                    current < Polyline . this . vertices . length - 1)
                current ++;
            else
                current = -1;
        }
    }
}
