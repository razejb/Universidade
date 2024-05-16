public class PerfectNumber {

    public static boolean isPerfectNumber(int number)
    {
        int sum = 0;
        int i ;
        if(number < 1)
        {
            return false;
        }
        else
        {
            for(i = 1; i < number; i++)
            {
                if(number % i == 0)
                {
                    sum = sum + i ;
                }
            }

            if(sum == number)
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
