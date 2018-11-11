/**
 * 通过实现Runnable接口的方式创建线程的方法示例，以及线程对象的创建及执行方法示例
 * 
 * @author (YHZ) 
 * @version (2013-6-25)
 */

class CreateThread2 implements Runnable  //当只需要重写run方法，或者该类已经有了基类，不能从Thread类继承而来时采用
{
    private String name; //线程的名字
    
    /**
     * 定义构造函数。若不定义，则使用系统默认的构造函数创建对象，该构造函数无参数
     */
    public CreateThread2(String name)  //name用来定义线程名
    {
        this.name = name;  //不能使用方法setName(name)，因为该类的对象并不是一个线程
    }
    
    /**
     * 重写run方法，该方法在线程启动时会自动执行；若不重写该方法，则报告默认的run方法，即不做具体工作
     */
    public void run() 
    {
        System.out.println("子线程名是：" + name);  //显示线程名字
    }
    
    public static void main(String args[])  //测试类CreateThread1
    {
        for (int i = 0; i < 3; i ++)
        {
            Thread t = new Thread(new CreateThread2("线程" + (i + 1)));  //创建线程,Thread有一个使用Runnable接口创建对象的构造函数
            t.start();  //启动线程
        }
    }
}