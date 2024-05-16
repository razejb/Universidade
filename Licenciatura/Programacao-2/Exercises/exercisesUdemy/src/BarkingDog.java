public class BarkingDog {


    public static boolean shouldWakeUp(boolean barking, int h)
    {
        if(h < 0 || h > 23)
        {
            return false ;
        }
        else if(barking == true && (h < 8 || h > 22))
        {
            return true ;
        }
        else
        {
            return false;
        }
    }
}
