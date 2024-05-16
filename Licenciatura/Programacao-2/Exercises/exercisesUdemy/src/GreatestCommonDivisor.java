public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second)
    {
        int i, j ;
        int g1 = 0 ;
        if(first < 10 || second < 10)
        {
            return -1;
        }
        else
        {
            int menor, maior ;

            if(first <= second)
            {
                menor = first ;
                maior = second ;
            }
            else
            {
                menor = second ;
                maior = first ;
            }

            for(i = 1; i <= menor; i++)
            {
                for(j = 1; j <= maior; j++)
                {
                    if(maior % j == 0 && menor % i == 0 && i == j)
                    {
                        g1 = i ;
                    }
                }
            }
            return g1 ;

        }
    }

}