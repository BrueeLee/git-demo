package cn.learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//文件合并 ping.n
public class Test2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File[] files = new File[5];
        String name = "mongodb-compass-1.16.3-win32-x64.exe.";
        File file = new File("I:\\前端\\2019web\\【27】源码+课件+软件\\11-16 前后端交互\\15-16阿里百秀\\day02\\素材\\mongo\\mongodb-compass-1.16.3-win32-x64.exe");
        file.createNewFile();
        RandomAccessFile in = new RandomAccessFile(file, "rw");
        in.setLength(0);
        in.seek(0);
        byte[] bytes = new byte[1024];
        int len = -1;
        for(int i = 0; i < files.length; i++) {
            files[i] = new File(name + (i + 1));
            //System.out.println(files[i].exists());
            RandomAccessFile out = new RandomAccessFile(files[i], "rw");
            while((len = out.read(bytes)) != -1) {
                in.write(bytes, 0, len);
            }
            out.close();
        }
        in.close();
    }
}