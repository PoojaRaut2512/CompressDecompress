/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompress 
{
    public static void method(File file) throws FileNotFoundException, IOException
    {
        String fileDirectory=file.getParent();
        System.out.println(fileDirectory);
        
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzipIS=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(fileDirectory+"\\DecompressedFile.txt");
                
        byte[] buffer=new byte[1024];
        int len;
        
        while((len=gzipIS.read(buffer))!=-1)
        {
            fos.write(buffer,0,len);
//            for(int i=0;i<buffer.length;i++){
//                System.out.print(buffer[i]+"");}
//            System.out.println(len);
        }
        
        gzipIS.close();
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) throws IOException
    {
        File path=new File("C:\\Users\\Dell\\Desktop\\\\CompressedFile.gz");
        method(path);
    }
}
