# Extra Assignments

## Assignment 1

The problem is to determine the least integer in a sequential collection of integers. The given solution contains two errors that need to be identified and corrected. The first error prevents the algorithm from halting, while the second error produces incorrect results for certain integer sequences. The solution involves iterating through the collection, extracting partial sequences, and narrowing down the possible elements until the least element is found. The exercises accompanying the problem ask to trace and analyze the solution, identify and correct the errors, and propose an alternative solution using a different strategy.

## Assignment 2

The problem is to sort the elements of a set X in ascending order. The given algorithm is the exchange sort algorithm. It involves comparing elements and swapping them if necessary to arrange them in the desired order. The algorithm uses nested loops to iterate through the elements and perform comparisons and exchanges. The exercises associated with the problem ask to visualize the algorithm, analyze its time complexity for comparisons and exchanges, compare its complexity with another sorting algorithm (selection sort), and provide a proof of correctness for the algorithm.

## Assignment 3

A) The problem involves creating a model of a chessboard and its pieces. The chessboard is an 8x8 grid of squares identified by rows (a-h) and columns (1-8). Each square, or field, can hold a chess piece, which can be placed, removed, marked, or unmarked. The pieces are differentiated by color (white or black) and name (Pawn, Rook, Knight, Bishop, Queen, and King). The exercises ask to complete the definition of the Chessboard class, create the necessary classes and members, explain why Field is a nested class, and create a test program.

B) The program "ReachableFieldsOnChessboard" creates a chessboard and several chess pieces. Each piece enters the board, marks the fields it can reach, removes the markings, and then steps off the board to make room for the next piece. The chessboard is displayed during the presentations. The exercises associated with the piece presentations involve creating and testing the "ReachableFieldsOnChessboard" program, explaining how different types of pieces are stored in a common array, and discussing the ability of pieces to present themselves in a common way and alternatives to this approach.

## Assignment 4

This assignment is an extension of the last mandatory assignment, where the task was to create an abstract model of a polyline, which is a planar figure consisting of connected line segments. The polyline is defined by its vertices, color, and width. The shape of the polyline changes when its vertices are modified, and operations such as adding, inserting, and removing vertices are supported. The goal is to create an interface called Polyline to represent the abstract model.

Exercises on polylines:
- Create a class VPolyline that implements the Polyline interface and represents a planar polyline. Implement the required methods and add a toString method to return the string representation of the line. Store the vertices in an array.
- Create a class NPolyline that implements the Polyline interface and represents a planar polyline. Implement the required methods and add a toString method to return the string representation of the line. Store the vertices in a sequence of linked nodes.
- Draw an object of type NPolyline, including the sequence of nodes and corresponding vertices in the drawing.
- Create a common test program for VPolyline and NPolyline. Use the Polyline interface to refer to instances of these classes and call their methods. Depending on the class to be tested, comment out the appropriate line.
- Iterate over a polyline using a for-each loop, printing each vertex. This is possible because the Polyline interface extends the `Iterable<Point>` interface.
- Create a static method in a separate class called Polylines that accepts an array of Polylines and returns the shortest polyline in the array that is yellow. Use this method with arrays of VPolyline, NPolyline, and a mix of both types. Discuss how an array can contain objects of different types and how the same method can accept instances of different types.
