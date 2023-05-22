package EU4;

public class Point {
    private String name;
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName(){
        return name;
    }

    public void setX(int x){
        this.x=x;
    }

    @Override
    public String toString() {
        return "(" +
                name +
                " " + x +
                " " + y +
                ')';
    }


    public boolean equals(Point p) {
        System.out.println(p);
        System.out.println(this);
        return this.x == p.x && this.y == p.y && name.equals(p.name);
    }

    public void setY(int y){
        this.y=y;
    }

    public void setName(String name){
        this.name = name;
    }

    public double distance(Point p2){
        return Math.sqrt(Math.pow(this.x- p2.x,2)+Math.pow(this.y- p2.y,2));
    }
    Point(String name,int x,int y){
        setName(name);
        setX(x);
        setY(y);
    }
    Point(Point p){
        x=p.x;
        y=p.y;
        name=p.name;
    }
}
