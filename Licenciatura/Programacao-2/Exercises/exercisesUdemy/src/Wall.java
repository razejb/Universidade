public class Wall {

    //instance variables
    private double width;
    private double height;

    //Constructors
    public Wall() {
    }

    public Wall(double w, double h) {

        if (w < 0) {
            this.width = 0;
        }
        else
        {
            this.width = w;
        }
        if (h < 0) {
            this.height = 0;
        }
        else
        {
            this.height = h;
        }
    }

    //Getters
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    //Setters
    public void setWidth(double setValueWidth) {

        if (setValueWidth < 0) {
            this.width = 0;
        } else {
            this.width = setValueWidth;
        }
    }

    public void setHeight(double setValueHeigth) {

        if (setValueHeigth < 0) {
            this.height = 0;
        } else {
            this.height = setValueHeigth;
        }
    }

    public double getArea() {

        return width * height;
    }

    public static void main(String[] args) {

        Wall wall = new Wall(5,4);
        System.out.println("area= " + wall.getArea());

        wall.setHeight(-1.5);
        System.out.println("width= " + wall.getWidth());
        System.out.println("height= " + wall.getHeight());
        System.out.println("area= " + wall.getArea());

    }
}
