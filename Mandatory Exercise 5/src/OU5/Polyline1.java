package OU5;

public class Polyline1 {
    private Point [] vertices;
    private String colour = " black ";
    private int width = 1;
    public Polyline1 ()
    {
        this . vertices = new Point [0];
    }
    public Polyline1 ( Point [] vertices )
    {
        this . vertices = vertices;
    }
    public String toString () {
        for (int i = 0; i <this.vertices.length ; i++)
            System.out.println("PolyLine(" + vertices[i] + " " + colour +  " " + width + ')');
        return null;
    }
    public Point [] getVertices () {
        return vertices;
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
        h[i] =vertex;
        this . vertices = h;
    }
    public void addBefore ( Point vertex , String vertexName ) {
        Point [] h = new Point [ this . vertices . length + 1];
        int i = 0;
        int si=0;
        for (i = 0; i < this . vertices . length ; i++)
        {
            if(this.vertices[i].getName().equals(vertexName))si =i;
        }
        for (i = 0; i <=si; i++)
        {
            h[i]=this.vertices[i];
            if(i==si)h[i]=vertex;
        }
        for (i = si+1; i <this .vertices .length + 1; i++)
        {
            h[i]=this.vertices[i-1];
        }

        this . vertices = h;
    }
    public void remove ( String vertexName ) {
        Point [] h = new Point [ this . vertices . length - 1];
        int i = 0,ni=0;
        for (i = 0; i < this . vertices . length  ; i++) {
            if(this.vertices[i].getName().equals(vertexName))ni=i;
        }
        for (i = 0; i < ni; i++)
        {
            h[i]=this.vertices[i];
        }
        for (i = ni; i < this . vertices . length - 1; i++) {
            h[i]=this.vertices[i+1];
        }
        this . vertices = h;

    }
}
