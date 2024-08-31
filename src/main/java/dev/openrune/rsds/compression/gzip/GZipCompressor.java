package dev.openrune.rsds.compression.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZipCompressor {

    public static final byte[] compress(byte[] is) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer;
        try {
            GZIPOutputStream gzipOutputStream;
            (gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream))
                    .write(is);
            gzipOutputStream.finish();
            gzipOutputStream.close();
            buffer = byteArrayOutputStream.toByteArray();
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
        return buffer;
    }

}