import java.io.*;  //文件操作要用到

public class FileEx1
{
    public static void main(String args[]) throws IOException  //异常处理的另外一种方法：抛出异常，而不是直接处理
    {
        File dir=new File("d:\\book");  //第一个反斜扛用于转义;该语句只是创建File对象，而不生成目录或文件！
        File f=new File(dir,"a.txt");

    //  File path=new File("d:\\book\a.txt");
        File f2=new File("d:\\book\\b.txt");
        System.out.println("");
        System.out.println("----------"+f+"的有关信息----------");
        System.out.println("exist:        "+f.exists());
        System.out.println("name:         "+f.getName());
        System.out.println("path:         "+f.getPath());
        System.out.println("absolute path:"+f.getAbsolutePath());
        System.out.println("is a file:    "+f.isFile());
        System.out.println("is a directory:"+f.isDirectory());
        System.out.println("length:        "+f.length());
        System.out.println("can read:      "+f.canRead());
        System.out.println("can write:     "+f.canWrite());
        File newf=new File("c.txt");
        System.out.println("-----------rename"+f+"-----------------");
        f.renameTo(newf);
        System.out.println("name:                 "+newf.getName());
        System.out.println(f+" exist:  "+f.exists());
        System.out.println(newf+" exist:    "+newf.exists());
        System.out.println("compare f to f2:   "+f.equals(f2));
        newf.delete();
        System.out.println(newf+"   exist:     "+newf.exists());

    }
}
