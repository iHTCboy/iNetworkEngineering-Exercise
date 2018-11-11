import java.util.*;

public class Test
{
    private static int A1 = 10;
    private static int B1 = 45;
    private static int A2 = 20;
    private static int B2 = 30;
    private static long TIMES = 1000000;  //测试次数
    
    private int[] results = new int[B1 + B2 - A1 - A2 + 2];  //用于存放可能的不同的结果
    private int[] num = new int[B1 + B2 - A1 - A2 + 2]; //results中每种值出现的次数
    private int count = 0;  //results有效元素的个数

    //统计两个随机数的和的可能性
    public Test()
    {
        for (int i = 0; i < TIMES; i ++)
        {
            int x = generateRndInt(A1, B1);
            int y = generateRndInt(A2, B2);  
            //int z = x + y;
            int z = (x > y) ? x : y;  //x,y的较大值
            //int z = (x < y) ? x : y;  //x,y的较小值
            recordRnd(z);
        }
        sort();
        for (int i = 0; i < count; i ++)
        {
            System.out.println(results[i] + "出现的次数为：" + num[i]);
        }
    }
    
    //产生位于[lowLimit, highLimit]之间的随机整数
    private  int generateRndInt(int lowLimit, int highLimit)
    {
        Random rnd = new Random();
        int value = rnd.nextInt(highLimit - lowLimit + 1);
        return value + lowLimit;
    }
    
    //判断value是否已经在results中存在；若已经存在，计数器加1，返回;若不存在，将value存入results中，计数为1。
    private void recordRnd(int value)
    {
        for (int i = 0; i < count; i ++)
        {
            if (results[i] == value)
            {
                num[i] ++;
                return;
            }    
        }
        results[count] = value;
        num[count] = 1;
        count ++;
    }
    
    //以results中有效值按从小到达的顺序进行排序，同时调整num
    private void sort()
    {
        for (int i = 0; i < count; i ++)
        {
            int temp = results[i];
            int index = i;
            for (int j = i; j < count; j ++)
            {
                if (temp > results[j])
                {
                    index = j; 
                    temp = results[index];
                }
            }
            if (index != i)
            {
                temp = results[i];
                results[i] = results[index];
                results[index] = temp;
                
                temp = num[i];
                num[i] = num[index];
                num[index] = temp;
            }
        }
    }
}
