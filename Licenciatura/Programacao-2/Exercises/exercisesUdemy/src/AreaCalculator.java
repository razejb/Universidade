public class AreaCalculator {

    public static double area(double radius)
    {


        if(radius > -1)
        {
            return radius * radius * Math.PI ;
        }
        else
        {
            return -1.0 ;
        }
    }

    public static double area(double x, double y)
    {
        if(x > -1 && y > -1)
        {
            return x * y ;
        }
        else
        {
            return -1;
        }
    }

}
