package com.test.all.jdk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Dt {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        doCopyNIO("D:\\Miniconda3-latest-Linux-x86_64.sh","D:\\aa.sh");
        long end = System.currentTimeMillis();
        System.err.println("耗时"+(end-start));

    }
    private static void doCopyNIO(String inFile, String outFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel cis = null;
        FileChannel cos = null;
        long len = 0, pos = 0;
        try {
//            RandomAccessFile randomAccessFile =  new RandomAccessFile();
//            randomAccessFile.
//            randomAccessFile.getChannel()

            fis = new FileInputStream(inFile);
            cis = fis.getChannel();
            fos = new FileOutputStream(outFile);
            cos = fos.getChannel();
            len = cis.size();
            while (pos < len) {
                pos += cis.transferTo(pos, (1024 * 1024 * 1024), cos); // 10M
            }
            fos.flush();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cos != null) { try { cos.close(); } catch (Exception e) { } }

            if (fos != null) { try { fos.close(); } catch (Exception e) { } }

            if (cis != null) { try { cis.close(); } catch (Exception e) { } }

            if (fis != null) { try { fis.close(); } catch (Exception e) { } }

        }

    }
}
