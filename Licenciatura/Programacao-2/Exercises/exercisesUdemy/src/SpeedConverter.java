public class SpeedConverter {


    public static void printConversion(double kilometersPerHour){


        long mi = Math.round(kilometersPerHour/1.609 ) ;

        if (kilometersPerHour < 0)
        {
            System.out.println("Invalid Value");
        }
        else
        {
            System.out.println(kilometersPerHour + " km/h = " + mi + " mi/h" );

        }

    }
    public static long toMilesPerHour(double x){

        if(x < 0)
        {
            return -1;
        }
        else
        {
            printConversion(x) ;
            return Math.round(x / 1.609) ;
        }
    }


    public static void main(String[] args)
    {
        toMilesPerHour(5.6) ;
    }
}

