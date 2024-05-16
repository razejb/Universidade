public class NumberToWords {

    public static void numberToWords(int number)
    {
        number = reverse(number) ;
        if(number < 0)
        {
            System.out.println("Invalid Value");
        }
        else
        {

            int num = number ;
            int dc = getDigitCount(number) ;
            while(dc != 0)
            {

                int ld = num % 10 ;

                switch(ld)
                {
                    case 0:
                        System.out.println("Zero");
                        break;

                    case 1:
                        System.out.println("One");
                        break;

                    case 2:
                        System.out.println("Two");
                        break;

                    case 3:
                        System.out.println("Three");
                        break;

                    case 4:
                        System.out.println("Four");
                        break;

                    case 5:
                        System.out.println("Five");
                        break;

                    case 6:
                        System.out.println("Six");
                        break;

                    case 7:
                        System.out.println("Seven");
                        break;

                    case 8:
                        System.out.println("Eight");
                        break;

                    case 9:
                        System.out.println("Nine");
                        break;

                    default:
                        System.out.println("Invalid Value");
                }

                num = num / 10 ;
                dc-- ;
            }
        }
    }

    public static int reverse(int number)
    {
        int n, reversed = 0;

        n = number ;

        while(number != 0)
        {
            n = number % 10 ;
            reversed = reversed * 10 ;
            reversed = reversed + n ;
            number = number / 10 ;
        }
        return reversed ;
    }

    public static int getDigitCount(int number)
    {
        int count = 0 ;
        if(number < 0)
        {
            return -1;
        }
        else if(number == 0)
        {
            return 1;
        }
        else
        {
            for(int i = 0; number != 0; i++)
            {

                count++ ;
                number = number / 10 ;
            }
        }
        return count ;
    }

}