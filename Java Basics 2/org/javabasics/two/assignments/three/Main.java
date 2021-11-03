package org.javabasics.two.assignments.three;

public class Main {
  public static void main(String[] args) {
    var circle = new Circle(6d);
    var triangle = new Triangle(100d, 100d);
    var rectangle = new Rectangle(10d, 10d);

    circle.display();
    triangle.display();
    rectangle.display();
  }
}
