public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes)
    {
        if(kiloBytes >= 0)
        {
            int megabytes = kiloBytes / 1024 ;
            int rKB = kiloBytes % 1024 ;

            System.out.println(kiloBytes + " KB = " + megabytes + " MB and " + rKB +" KB");
        }
        else
        {
            System.out.println("Invalid Value") ;
        }
    }

}
