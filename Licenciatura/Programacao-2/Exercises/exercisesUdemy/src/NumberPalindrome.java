public class NumberPalindrome {

    public static boolean isPalindrome(int number)
    {
        int reverse = 0;
        int lastDigit = 0;

        int num = number ;
        do
        {

            lastDigit = num % 10;

            reverse = reverse * 10 ;

            reverse = reverse + lastDigit ;

            num = num / 10;

        }
        while(num != 0) ;

        if(reverse == number)
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }
}
