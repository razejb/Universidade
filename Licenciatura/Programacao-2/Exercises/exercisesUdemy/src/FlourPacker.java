public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal)
    {
        if (bigCount < 0 || smallCount < 0 || goal < 0)
        {
            return false;
        }

        int totalFlour = 5 * bigCount + smallCount;

        if (totalFlour >= goal && goal % 5 <= smallCount)
        {
            return true;
        }

        return false;
    }
}