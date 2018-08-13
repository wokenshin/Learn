package Java14;

import java.io.*;

/**
 * @author kenshin
 * @date 2018/5/30 下午5:10
 */
public class InsertContent {

    public static void insert(String fileName, long pos, String insertContent) throws IOException{

        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();

        try(
                RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
                //使用临时文件来保存插入点后的数据
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn   = new FileInputStream(tmp)){

            raf.seek(pos);
            //下面代码将插入点后的内容读入临时文件中保存
            byte[] bbuf = new byte[64];
            //用于保存实际读取的字节书
            int hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0){
                //将读取的数据写入临时文件
                tmpOut.write(bbuf, 0, hasRead);
            }

            //下面代码用于插入内容
            //把文件记录指针重新定位到pos位置
            raf.seek(pos);
            //追加需要插入的内容
            raf.write(insertContent.getBytes());
            //追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0){
                raf.write(bbuf, 0, hasRead);
            }

        }
    }

    public static void main(String[] args) throws IOException{
        //会在工程的根目录下去找这个文件，如果没有的话就重新创建一个
        insert("InsertContent.java", 45, "插入的内容\r\n");
    }
}
