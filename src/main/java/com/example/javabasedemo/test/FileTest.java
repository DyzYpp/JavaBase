package com.example.javabasedemo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class FileTest {
    public static void main(String[] args) throws IOException {

        // 从文件中读取内容  通过字节的方式
        File file = new File("test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        /*byte[] bt = new byte[1024];
        int len = 0;
        StringBuffer stringBuffer = new StringBuffer("");
        while ((len = inputStream.read(bt)) != -1){
            stringBuffer.append(new String(bt, 0, len));
        }
        System.out.println(stringBuffer);*/

        /*BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bt2 = new byte[1024];
        int len2 = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        while ((len2 = bufferedInputStream.read(bt2)) != -1) {
            stringBuilder.append(new String(bt2, 0, len2));
        }
        bufferedInputStream.close();
        inputStream.close();
        System.out.println(stringBuilder);
        File file1 = new File("E://text.txt");
        FileOutputStream fos = new FileOutputStream(file1);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(stringBuilder.toString().getBytes(), 0, stringBuilder.toString().getBytes().length);
        bos.flush();
        bos.close();
        fos.close();*/

        //字符流读写文件
        /*FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuilder stringBuffer = new StringBuilder("");
        int read = br.read();
        System.out.println(read);
        String res = "";
        while ((res = br.readLine()) != null) {
            stringBuffer.append(res).append("\n");
        }
        br.close();
        fileReader.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E://text.txt")));
        bw.write(stringBuffer.toString(), 0, stringBuffer.toString().length());
        bw.close();*/


        // 数组反转
        /*String[] arr = {"1","2","3","4","5"};
        String[] new_array = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            new_array[i] = arr[arr.length - i - 1];
        }
        System.out.println(Arrays.asList(new_array));*/

        Random random = new Random();
        String res = "";

        HashSet hashSet = new HashSet();
        while (true) {
            int j = random.nextInt(9) + 1;
            if (!res.contains(j + "")) {
                res += j + "";
            }
            if (res.length() == 5) {
                hashSet.add(Integer.parseInt(res));
                res = "";
            }
            if (hashSet.size() == 3) {
                break;
            }
        }
        System.out.println(hashSet);

    }
}
