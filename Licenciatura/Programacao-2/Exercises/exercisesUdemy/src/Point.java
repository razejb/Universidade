public class Point {

    //instance variables
    private int x ;
    private int y ;

    //Constructors
    public Point(){

    }

    public Point(int x, int y){

        this.x = x;
        this.y = y;
    }

    //Getters
    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public void setx(int x){

        this.x = x ;
    }

    public void sety(int y){

        this.y = y ;
    }

    // Method to calculate the distance between this Point and (0, 0)
    public double distance() {

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    // Method to calculate the distance between this Point and another Point
    public double distance(Point anotherPoint) {

        int deltaX = this.x - anotherPoint.getx();
        int deltaY = this.y - anotherPoint.gety();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    // Method to calculate the distance between this Point and a specified (x, y)
    public double distance(int x, int y) {

        int deltaX = this.x - x;
        int deltaY = this.y - y;
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public static void main(String[] args) {

        Point first = new Point(6, 5);
        Point second = new Point(3, 1);
        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));
        Point point = new Point();
        System.out.println("distance()= " + point.distance());
    }
}
