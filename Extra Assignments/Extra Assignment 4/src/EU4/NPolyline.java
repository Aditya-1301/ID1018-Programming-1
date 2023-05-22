package EU4;

import java.util.ArrayList;
import java.util.Iterator;

public class NPolyline implements Polyline {
    private static class Node {
        public Point vertex;
        public Node nextNode;

        public Node(Point vertex) {
            this.vertex = vertex;
            nextNode = null;
        }
    }

    private Node vertices;
    private String colour = " black ";
    private int width = 1; // pixels

    public NPolyline() {
        this.vertices = null;
    }

    public NPolyline(Point[] vertices) {
        if (vertices.length > 0) {
            Node node = new Node(new Point(vertices[0]));
            this.vertices = node;
            int pos = 1;
            while (pos < vertices.length) {
                node.nextNode = new Node(new Point(vertices[pos++]));
                node = node.nextNode;
            }
        }
    }

    // *** MORE CODE HERE ***
    public String toString() {
        String ss = "Polyline";
        Node currentNode = vertices;
        if (vertices == null) {
            ss = ss + " null";
        }
        while (currentNode != null) {
            ss = ss + " " + currentNode.vertex.toString();
            currentNode = currentNode.nextNode;
        }
        ss+= " color:  " + getColour() + ",  width:  " + getWidth() + ",  length:  " + length();
        return ss;
    }

    public Point[] getVertices() {
        int n = numberOfNodes();
        Point[] points = new Point[n];
        if (n == 0) {
            System.out.println("There are 0 vertices");
        } else {
            Node currentNode = vertices;
            int i = 0;
            while (i < n && currentNode != null) {
                points[i] = currentNode.vertex;
                currentNode = currentNode.nextNode;
                i++;
            }
        }
        return points;
    }

    public int numberOfNodes() {
        int numberOfNodes = 0;
        Node currentNode = vertices;
        if (vertices == null) {
            return 0;
        }
        while (currentNode != null) {
            currentNode = currentNode.nextNode;
            numberOfNodes++;
        }
        return numberOfNodes;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getColour() {
        return this.colour;
    }

    public int getWidth() {
        return this.width;
    }

    public double length() {
        double length = 0;
        Node currentNode = vertices;
        if(currentNode==null){
            return 0;
        }
        while (currentNode.nextNode != null) {
            length += currentNode.vertex.distance(currentNode.nextNode.vertex);
            currentNode = currentNode.nextNode;
        }
        return length;
    }

    public void add(Point vertex) {
        Node currentNode = vertices;
        if (currentNode == null) {
            vertices = new Node(vertex);
            return;
        }
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = new Node(vertex);
    }

//        public void insertBefore(Node position, Point vertexName){
//            Node currentNode =vertices;
//            if(currentNode==position){
//                vertices.nextNode =new Node(vertexName);
//                return;
//            }
//            while (currentNode.nextNode!=position){
//                currentNode=currentNode.nextNode;
//            }
//            Node Element=new Node(vertexName);
//            currentNode.nextNode=Element;
//            Element.nextNode=position;
//        }

    public void insertBefore(Point vertex, String vertexName) {
        Node currentNode = vertices;
        if (elementExists(vertexName) == false) {
            System.out.println("Element before which you want to perform insertion does not exist");
            return;
        }
        if (currentNode.vertex.getName().equals(vertexName)) {
            Node newNode = new Node(vertex);
            newNode.nextNode = currentNode;
            vertices=newNode;
            return;
        } else if (currentNode == null) {
            System.out.println("There are no elements before which an element could be added");
            return;
        } else {
            while (currentNode.nextNode != null && !currentNode.nextNode.vertex.getName().equals(vertexName)) {
                currentNode = currentNode.nextNode;
            }
//            System.out.println(currentNode.vertex.getName());
            Node element = new Node(vertex);
            Node afterInsert = currentNode.nextNode;
//            currentNode = element;
//            element.nextNode = currentNode.nextNode;
            currentNode.nextNode = element;
            element.nextNode = afterInsert;
        }
    }

    public boolean elementExists(String vertexName) {
        Node currentNode = vertices;
        boolean elementExists = false;
        while (currentNode != null) {
            if (currentNode.vertex.getName().equals(vertexName)) {
                elementExists = true;
                break;
            } else currentNode = currentNode.nextNode;
        }
        return elementExists;
    }

    //        public void remove(Node position){
//            Node current =vertices;
//            if(position==vertices)vertices =vertices.nextNode;
//            while( current!=position ){
//                if(current.nextNode==null || current.nextNode==position){ break; }
//                else{ current=current.nextNode; }
//            }
//            current.nextNode=position.nextNode;
//            return;
//        }
    public Node returnNodeByValue(String vertexName) {
        Node currentNode = vertices;
        while (!currentNode.vertex.getName().equals(vertexName)) {
            if (currentNode.nextNode == null) {
                break;
            } else {
                currentNode = currentNode.nextNode;
            }
        }
        return currentNode;
    }

    public void remove(String vertexName) {
        Node currentNode = vertices;
        if (elementExists(vertexName) == false) {
            System.out.println("Element to be deleted does not exist");
        } else {
            Node position = returnNodeByValue(vertexName);
            if (position == vertices) vertices = vertices.nextNode;
            while (position != null && currentNode != position) {
                if (currentNode.nextNode == null || currentNode.nextNode == position) {
                    break;
                } //|| current.next==position
                else {
                    currentNode = currentNode.nextNode;
                }
            }
            currentNode.nextNode = position.nextNode;
            return;
        }
    }

    public Iterator<Point> iterator() {
        Node currentNode = vertices;
        ArrayList<Point> arrayList = new ArrayList<>();
        while (currentNode != null) {
            arrayList.add(currentNode.vertex);
            currentNode = currentNode.nextNode;
        }
        return arrayList.iterator();
    }
}
