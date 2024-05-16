public class DiagonalStar {

    public static void printSquareStar(int number)
    {
        int i ;

        if(number < 5)
        {
            System.out.println("Invalid Value") ;
        }
        else
        {

            for(i = 1; i <= number; i++)
            {
                System.out.print("*");
            }

            System.out.println();

            for (i = 2; i <= number - 1; i++)
            {
                for (int j = 1; j <= number; j++)
                {
                    if(j == 1 || j == number || j == i || j == number - i + 1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }


                }
                System.out.println();
            }

            for(i = 1; i <= number; i++)
            {
                System.out.print("*");
            }
        }
    }

    public static void main(String[] args) {

        printSquareStar(15);
    }
}


