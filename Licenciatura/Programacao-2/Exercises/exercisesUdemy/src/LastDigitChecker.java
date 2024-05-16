public class LastDigitChecker {

    public static boolean hasSameLastDigit(int x, int y, int z)
    {
        int t1, t2, t3 ;
        if(x < 10 || x > 1000 || y < 10 || y > 1000 || z < 10 || z  > 1000)
        {
            return false ;
        }
        else
        {
            t1 = x % 10 ;
            t2 = y % 10 ;
            t3 = z % 10 ;

            if(t1 == t2 || t1 == t3 || t2 == t3)
            {
                return true ;
            }
            else
            {
                return false ;
            }
        }
    }

    public static boolean isValid(int x)
    {
        if(x < 10 || x > 1000)
        {
            return false ;
        }
        else
        {
            return true ;
        }
    }


}