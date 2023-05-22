# Mandatory Assignments

Here I provide a small description of each Mandatory Assignment and I have provided the assignment PDF for each assignment in it's respective directory as well if someone is interested in more information.

## Assignment 1

### Logic and Vectors
- Temperature readings are collected at the same location over a few weeks.
- Readings are taken regularly, with an equal number of readings each week.

### Incomplete Solution
The provided program reads and displays the temperature readings. It then computes and stores the minimum, maximum, and average temperature for each week, and prints these results. Finally, it calculates and prints the minimum, maximum, and average temperature for the entire measurement period.

## Assignment 2

### Computation on a Triangle

To determine the properties of a triangle, such as side lengths, angles, circumcircle, and incircle, mathematical formulas can be used. By creating a class called Triangle with static methods, computations on triangle properties can be simplified. The Triangle class can contain methods for calculating area, circumference, bisectors, and more. 

Exercises on a Triangle:

- Create the Triangle class with static methods for computing triangle properties.
- Implement a method to calculate the length of a bisector based on two sides and the angle between them.
- Create a program called TriangleAndItsCircles to calculate the radii of the circumcircle and incircle using Triangle class methods.
- Draw a triangle with given side lengths and measure the radii of the circumcircle and incircle to verify the program's output.

## Assignment 3

### The Shortest Path

The problem at hand involves finding the intermediate stations on the shortest path in a commuter traffic system with four zones (Z1, Z2, Z3, and Z4). The system consists of stations X and Y, where zone Z1 contains only station X and zone Z4 contains only station Y. Zones Z2 and Z3 have multiple stations (U1, U2, ..., Um and V1, V2, ..., Vn, respectively) and are well connected to each other.

To determine the shortest path between station X and station Y, one must select an intermediate station from both zone Z2 and zone Z3. The objective is to minimize the overall path length. Direct paths exist between X and all stations in Z2, between any station in Z2 and any station in Z3, and between any station in Z3 and Y. The lengths of these paths are given as ai, bij, and cj, respectively.

Exercises on the Problem:

- Choose a specific instance of the problem with m = 3 and n = 4, and specify the path lengths. Create a visual representation of the instance, indicating the stations, paths, and their respective lengths.
- Represent the same instance using a table format similar to the template provided. Fill in the table with the appropriate path lengths for each combination of stations.
- Develop a memory-efficient algorithm that solves this problem in a general case using an update strategy. Describe the algorithm using words and pseudocode, including preconditions and postconditions.
- Create a Java program with two classes: TheShortestPath and DetermineTheShortestPath. TheShortestPath class should contain methods for calculating the intermediate stations on the shortest path and the length of the shortest path. The DetermineTheShortestPath class should have the main method where problem-specific data is entered and the methods from TheShortestPath class are called. Test the program with two separate instances and explain the obtained results.

## Assignment 4

### Arithmetic with Strings

Perform arithmetic operations on natural numbers expressed as character strings. Given two natural numbers represented as character strings of any length, the task is to perform various arithmetic operations on these numbers. The goal is to examine the character strings digit by digit and determine the next digit in the result, creating a new character string representing the result.

The program `OperationsWithNaturalNumbersGivenAsStrings` provides a solution to the problem. It includes the following methods:

- `add`: Accepts two natural numbers represented as character strings and returns their sum as a character string.
- `subtract`: Accepts two natural numbers represented as character strings and returns their difference as a character string. The first number is assumed to be not smaller than the second.
- `show`: Presents two natural numbers, an operator, and the result string.
- `setLen`: Prepends the supplied number of spaces to the beginning of a string.

The program prompts the user to enter two natural numbers, performs addition on the numbers, and displays the result. However, the subtraction operation is not implemented.

Exercises
- Algorithm for Addition: Create an algorithm that adds two natural numbers represented as character strings. Visualize the algorithm using a series of images that illustrate the operation's progress. Describe the algorithm using corresponding pseudocode and implement it as a Java method.
- Algorithm for Subtraction: Create an algorithm that subtracts two natural numbers represented as character strings. Visualize the algorithm using a series of images that illustrate the operation's progress. Describe the algorithm using corresponding pseudocode and implement it as a Java method.
- Completion of the Program: Enhance the `OperationsWithNaturalNumbersGivenAsStrings` program and make it a meaningful unit.
- Optional: Multiplication and Division Algorithms: Design and implement algorithms for multiplication and division of natural numbers represented as character strings.

## Assignment 5

### Point
- Represents a planar point on a two-dimensional plane.
- Properties:
  - Name: Name of the point.
  - Coordinates: Integer values representing the x and y coordinates of the point.
- Methods:
  - Constructor: Initializes a point with a name and coordinates.
  - Copy constructor: Creates a copy of an existing point.
  - toString(): Returns a string representation of the point.
  - getName(): Returns the name of the point.
  - getX(): Returns the x-coordinate of the point.
  - getY(): Returns the y-coordinate of the point.
  - setName(): Sets a new name for the point.
  - setX(): Modifies the x-coordinate of the point.
  - setY(): Modifies the y-coordinate of the point.
  - distance(): Computes the distance between two points.
  - equals(): Checks if two points are equal.

### Polyline
- Represents a polyline, a geometric figure consisting of connected line segments.
- Properties:
  - Vertices: An array of points representing the vertices of the polyline.
  - Colour: Colour of the polyline.
  - Width: Width of the polyline.
- Methods:
  - Constructor: Initializes an empty polyline or a polyline with given vertices.
  - toString(): Returns a string representation of the polyline.
  - getVertices(): Returns a vector containing copies of the polyline's vertices.
  - getColour(): Returns the colour of the polyline.
  - getWidth(): Returns the width of the polyline.
  - setColour(): Modifies the colour of the polyline.
  - setWidth(): Modifies the width of the polyline.
  - length(): Computes the length of the polyline.
  - addLast(): Adds a new vertex at the end of the polyline.
  - addBefore(): Adds a new vertex before a specified named vertex.
  - remove(): Removes a specified named vertex.

### PolylineIterator (Inner class in Polyline)
- Represents an iterator for visiting the vertices of a polyline in sequence.
- Properties:
  - Current: Index of the current vertex.
- Methods:
  - Constructor: Initializes the iterator to the first vertex of the polyline.
  - hasVertex(): Checks if there is another vertex available.
  - vertex(): Returns the current vertex and advances the iterator.
  - advance(): Advances the iterator to the next vertex.
