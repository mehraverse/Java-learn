abstract class Shape{
    private String color;

    public Shape(String color){
        this.color = color;
    }

    public void display(){
        System.out.println("Color is: "+color);
    }

    abstract double area();
}

class Circle extends Shape{
    private double radius;
    public Circle(String color, double radius){
        super(color);
        this.radius=radius;
    }
    @Override
    double area(){
        return Math.PI * radius * radius; 
    }
}

class Rectangle extends Shape{
    private double width, length;
    public Rectangle(String color, double width, double length){
        super(color);
        this.width = width;
        this.length = length;
    }
    @Override
    double area(){
        return width*length;
    }
}

public class Main{
    public static void main(String[] args){
        Shape myCircle = new Circle("Red", 3);
        Shape myRectangle = new Rectangle("Green", 4, 5);

        myCircle.display();
        System.out.println("Area of circle: "+ myCircle.area());

        myRectangle.display();
        System.out.println("Area of rectangle: "+ myRectangle.area());
    }
}