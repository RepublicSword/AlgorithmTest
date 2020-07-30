

import java.io.*;


public class FileReadTest {
    public static void main(String[] Args){
        byte[] b;
        b=FileReadTest.getFileToByte(new File("E:\\Test\\200.png"));
        toTxtFile(b);
        getFile(b,"E:\\Test\\","300.png");
        for(byte i:b)System.out.println(Integer.toBinaryString(i));

    }
//数组过大怎么办
    public static byte[] getFileToByte(File file) {
        byte[] by = new byte[(int) file.length()];//根据文件字节长度，生成一个数组，文件太大时需修改
        try {
            InputStream is = new FileInputStream(file);//根据file生成一个文件字节输入流，按字节将文件中的数据读入流
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();//新建一个字节数组输出流
            byte[] bb = new byte[2048];//新建一个2048字节长度的字节数组
            int ch;
            ch = is.read(bb);//is将读入的字节写bb字节数组中
            while (ch != -1) {
                bytestream.write(bb, 0, ch);//从bb的0-ch处的数据写入bytestream
                ch = is.read(bb);
            }
            by = bytestream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return by;
    }

    public static void toTxtFile(byte[] bfile){
        File file=new File("E:\\Test\\200.txt");
        try {
            OutputStream is=new FileOutputStream(file);
            is.write(bfile);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
