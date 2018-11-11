/**
 * 通过继承Thread类创建线程的方法示例，以及线程对象的创建及执行方法示例
 * 
 * @author (YHZ) 
 * @version (2013-6-25)
 */

class CreateThread1 extends Thread  //CreateThread1的对象即为线程
{
    /**
     * 定义构造函数。若不定义，则使用系统默认的构造函数创建对象，该构造函数无参数
     */
    public CreateThread1(String name)  //name用来定义线程名
    {
        setName(name);  //设置线程名
    }
    
    /**
     * 重写run方法，该方法在线程启动时会自动执行；若不重写该方法，则报告默认的run方法，即不做具体工作
     */
    public void run() 
    {
        System.out.println("子线程是：" + this);  //显示线程信息
    }
    
    public static void main(String args[])  //测试类CreateThread1
    {
        for (int i = 0; i < 3; i ++)
        {
            Thread t = new CreateThread1("线程" + (i + 1));  //创建线程
            t.start();  //启动线程，但并非马上执行，而是使线程进入“就绪”状态；所以，线程的报告顺序与创建顺序并不一致。
        }
    }
}
