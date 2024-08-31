/* Class_y - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {

    public static final byte[] read(String string) {
        byte[] is;
        try {
            int length = (int) new File(string).length();
            byte[] bytes = new byte[length];
            DataInputStream datainputstream = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(string)));
            datainputstream.readFully(bytes, 0, length);
            datainputstream.close();
            is = bytes;
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Read Error: ")
                    .append(string).toString());
            return null;
        }
        return is;
    }

    public static final void write(String file, byte[] bytes) {
        try {
            FileOutputStream fileoutputstream;
            (fileoutputstream = new FileOutputStream(file)).write(bytes, 0,
                    bytes.length);
            fileoutputstream.close();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(new StringBuilder().append("Write Error: ")
                    .append(file).toString());
        }
    }

}