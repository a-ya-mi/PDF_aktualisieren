/**
 * Created by Aksana on 10.04.2017.
 */

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.Date;

public class StartHier {

    public static void main (String[] args) throws Exception{

        //Name vom Benutzer einlesen
        System.out.println("Geben Sie Ihre Name ein: ");
        InputStream inpStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inpStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String name = bufferedReader.readLine();
        inpStream.close();
        System.out.println("Danke!");

        //Datum bekommen
        Date date = new Date();
        String dateInString= date.toString();

        //in .txt speichern
        try (FileOutputStream fileOutputStream = new FileOutputStream("dateien\\Neues_Textdokument.txt"))
        {
            String inputInDarei = name + " hat heute " + dateInString + " mit dieser Datei gearbeitet ";
            byte[] buffer = inputInDarei.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        }
        catch (FileNotFoundException e) {
            System.out.println("Fehler beim schreiben in Datei "+ name.toString());
        }


        //Datei von .txt in PDF
        //einPDFerstellen(file);


        //Datei archivieren
        ZipErstellen zipErstellen=new ZipErstellen();
    }

}
