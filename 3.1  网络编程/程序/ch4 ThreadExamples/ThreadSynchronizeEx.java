
/**
 * 演示线程同步的示例程序
 * 
 * @author (YHZ) 
 * @version (2013-6-25)
 */

public class ThreadSynchronizeEx extends Thread
{
    public void run()
    {
        test();
    }
    
    //一个简单的用于测试的函数,通过对比有无synchronized + static观察效果
    private static synchronized  void test()
    {
        for (int i = 1; i < 100; i++) 
        { 
            System.out.print( i + " \t");
            if ( i % 10 == 0)
                System.out.println();
        }  
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        for (int i = 1; i < 5; i ++)
        {
            ThreadSynchronizeEx t = new ThreadSynchronizeEx();  //创建一个线程对象
            t.start();  //执行该线程            
        }
    }
}
