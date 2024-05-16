public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number)
    {
        int lastDigit = 0;
        int lastDigit2 = 0;
        int firstDigit = 0;
        int num = number ;

        lastDigit = num % 10;

        if(number >= 0)
        {
            while(num != 0)
            {
                lastDigit2 = num % 10;

                firstDigit = num % 10 ;

                num = num / 10 ;


            }
            return firstDigit + lastDigit ;
        }
        else
        {
            return -1;
        }
    }

}