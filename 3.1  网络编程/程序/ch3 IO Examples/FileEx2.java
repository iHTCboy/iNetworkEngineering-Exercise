import java.io.*;
public class FileEx2 {
    public static void main(String[] args) 
    {
        File f=new File("d:"+File.separator+"Hello.txt");
            if (f.exists())
        f.delete();
        else
            try
            {
                f.createNewFile();
            }
            catch(Exception e)
            {     
                System.out.println(e.getMessage());
            }
    }
}
