
/**
 * Generate four integers randomly, and compare them with given four integers.
 * 
 * @author (yhz) 
 * @version (2009-01-11)
 */
import java.util.*;

public class GuessData
{
    private int[] initialData = new int[4];  //random data
    private int[] guessData = new int[4];  //user guessed data

    /**
     * Constructor
     */
    public GuessData()
    {
        generateRandomData();      
    }

    /**
     * 
     * @param  guessData   an array for user guessed data
     */
    public void setGuessData(int[] guessData)
    {
        this.guessData = guessData;
    }
    
    /**
     * generate four different integers
     */
    private void generateRandomData()
    {
        Random generator = new Random();
        for (int i = 0; i < 4; )
        {
            int temp = generator.nextInt(10);  // generator an integer from 0 to 9
            if (!isExist(temp, i))    // temp hasn't been generated
            {
                initialData[i] = temp;
                i ++;
            }
        }           
    }
    
    /**
     * judge the given data has been generated.
     * @param  data   a data need to be judged. 
     * @param  index  the number of having been generated valid.
     * @return   guessData  return true if data has been generated, or, return false;
     */    
    private boolean isExist(int data, int index)
    {
        for (int i = 0; i < index; i++)
        {
            if (data == initialData[i])
                return true;
         }
         return false;
    }
    
    /**
     * compare initialData with guessData in the first step
     * @param position record the position of the values which have appeared in guessData
     * @return the number of same value
     */
    private int compare_1(int[] position)
    {
        int count = 0; // the number of same value
        for (int i = 0; i < 4; i ++)
        {
            for(int j = 0; j < 4; j++)
            {
                if (guessData[j] == initialData[i])  // same value , ingore position
                {
                    position[count] = i;  // record the position of the value which is same to some value in guessData
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
    
    /**
     * compare initialData with guessData in the second step
     * @param position the position of the values which have appeared in guessData
     * @param count the number of same value
     * @return the number of same value and same position
     */
    private int compare_2(int[] position, int count)
    {
        int number = 0; // the number of same value and same position
        for (int i = 0; i < count; i ++)
        {
            int temp = position[i];
            if (initialData[temp] == guessData[temp]) // has the same position
                number ++;
         }
         return number;
    }
    
    /**
     * judge the number of same value and the number of both same value and same position
     * @return a string like "3A2B"
     */
    public String compare()
    {
        int[] position = new int[4];
        int count1 = compare_1(position);  // same value
        int count2 = compare_2(position, count1);  // same value and same position
        if (count1 == 4 && count2 == 4) 
            return "Congraduation! you win!";
        return count1 + "A" + count2 + "B";
    }
    
    public static void main(String[] args)
    {
        int[] guessData = {1,3,5,4};
        GuessData test = new GuessData();
        test.setGuessData(guessData);
    }
}
