public class SharedDigit {

    public static boolean hasSharedDigit(int x, int y)
    {
        int t1, t2, t3, t4 ;
        if(x < 10 || x > 99 || y < 10 || y > 99)
        {
            return false ;
        }
        else
        {
            t1 = x / 10 ;
            t2 = x % 10 ;
            t3 = y / 10 ;
            t4 = y % 10 ;

            if(t1 == t3 || t1 == t4 || t2 == t4 || t2 == t3)
            {
                return true ;
            }
            else
            {
                return false ;
            }
        }
    }

}