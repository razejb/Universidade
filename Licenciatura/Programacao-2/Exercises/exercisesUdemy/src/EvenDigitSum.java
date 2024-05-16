public class EvenDigitSum {
    public static int getEvenDigitSum(int number)
    {
        int num = number ;
        int lastDigit = 0;
        int evenSum = 0;

        if(number >= 0)
        {
            while(num != 0)
            {
                lastDigit = num % 10 ;

                if(lastDigit % 2 == 0)
                {
                    evenSum = evenSum + lastDigit ;
                }

                num = num / 10 ;
            }

            return evenSum ;
        }
        else
        {
            return -1;
        }
    }
}
