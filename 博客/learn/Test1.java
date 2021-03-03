package cn.learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File sourceFile = new File("I:\\前端\\2019web\\【27】源码+课件+软件\\11-16 前后端交互\\15-16阿里百秀\\day02\\素材\\mongodb-win32-x86_64-2012plus-4.1.6-signed.msi");
//        System.out.println(sourceFile.exists());
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = 1;        //默认文件切割的数量
        System.out.println("Enter:");        //提示输入
        numberOfPieces = scanner.nextInt();        //输入
        scanner.close();        //输入后就关闭 装完逼就跑一个道理
        long fileLength = sourceFile.length() / numberOfPieces;        //分一下每一个小文件的大小
        byte[] b = new byte[1024];        //这个不解释 如果看不懂 就去看IO流去吧
        RandomAccessFile raf1 = new RandomAccessFile(sourceFile, "r");
        int len = -1;
        for(int i = 0; i < numberOfPieces; i++) {
            String name = sourceFile.getName() + "." + (i+1);
            File file = new File(name);
            file.createNewFile();
            RandomAccessFile raf2 = new RandomAccessFile(file, "rw");
            while((len = raf1.read(b)) != -1) {
                raf2.write(b, 0, len);        //我觉的这样写比raf2.write(b);高明一些
                if(raf2.length() > fileLength)        //如果太大了就不在这个子文件写了 换下一个
                    break;
            }
            raf2.close();
        }
        raf1.close();
    }
}