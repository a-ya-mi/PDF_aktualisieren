/**
 * Created by Aksana on 11.04.2017.
 */
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipErstellen {

    public ZipErstellen () throws Exception{

        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("archive.zip"));
         File file = new File("dateien");
         doZip(file, out);
         out.close();

        System.out.println("1");
    }


    private static void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getPath()));
                write(new FileInputStream(f), out);
            }
        }
    }
    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }




}