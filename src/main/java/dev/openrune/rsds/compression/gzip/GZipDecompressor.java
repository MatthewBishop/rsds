package dev.openrune.rsds.compression.gzip;

import dev.openrune.rsds.io.Buffer;

import java.util.zip.Inflater;

public class GZipDecompressor {

    private static final Inflater inflater = new Inflater(true);

    public static final void decompress(Buffer buffer, byte[] compressed) {
        if (buffer.payload[buffer.offset] != 31
                || buffer.payload[buffer.offset + 1] != -117) {
            throw new RuntimeException("Invalid GZIP compressed data!");
        }
        try {
            inflater.setInput(buffer.payload, buffer.offset + 10,
                    -buffer.offset - 18 + buffer.payload.length);
            inflater.inflate(compressed);
        } catch (Exception exception) {
            inflater.reset();
            throw new RuntimeException("Invalid GZIP header!");
        }
        inflater.reset();
    }

}