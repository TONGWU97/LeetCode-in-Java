/**
 * Implement a Rectangle class which include the following attributes and methods:
Two public attributes width and height.
A constructor which expects two parameters width and height of type int.
A method getArea which would calculate the size of the rectangle and return.
样例
Example1:
Java:
    Rectangle rec = new Rectangle(3, 4);
    rec.getArea(); // should get 12，3*4=12
Python:
    rec = Rectangle(3, 4)
    rec.getArea()
Example2:
Java:
    Rectangle rec = new Rectangle(4, 4);
    rec.getArea(); // should get 16，4*4=16
Python:
    rec = Rectangle(4, 4)
    rec.getArea()
 */

public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
    // write your code here
    public int width, height;

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    /*
     * Define a method `getArea` which can calculate the area of the rectangle 
     * and return.
     */
    public int getArea() {
        return this.width * this.height;
    }
}