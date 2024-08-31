package dev.openrune.rsds.fs;

import dev.openrune.rsds.compression.CompressionUtils;
import dev.openrune.rsds.io.Buffer;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Index {

    private byte[] buffer;
    private int storeId;
    private int maximumFileSize;
    private RandomAccessFile index;
    private RandomAccessFile data;

    public Index(int storeId, RandomAccessFile indexFile,
                 RandomAccessFile dataFile, int maxSize, byte[] buf) {
        buffer = buf;
        this.storeId = storeId;
        maximumFileSize = maxSize;
        index = indexFile;
        data = dataFile;
    }

    public final byte[] decompress(int pos) {
        byte[] is;
        try { // unwraps too?
            if (index.length() < (long) (pos * 6 + 6)) {
                return null;
            }
            index.seek((long) (pos * 6));
            index.read(buffer, 0, 6);
            int fileSize = (buffer[2] & 0xff) + ((buffer[0] & 0xff) << 16)
                    + (buffer[1] << 8 & 0xff00);
            int sector = ((buffer[3] & 0xff) << 16)
                    - (-(buffer[4] << 8 & 0xff00) - (buffer[5] & 0xff));
            if (fileSize < 0 || fileSize > maximumFileSize) {
                return null;
            }
            if (sector <= 0 || data.length() / 520L < (long) sector) {
                return null;
            }
            byte[] buf = new byte[fileSize];
            int read = 0;
            int i_6_ = 0;
            int sectorSize = pos <= 65535 ? 512 : 510;
            int i_8_ = pos <= 65535 ? 8 : 10;
            int fileSize2 = fileSize;
            while (fileSize2 > read) {
                if (sector == 0) {
                    return null;
                }
                int unread;
                if ((unread = fileSize - read) > sectorSize) {
                    unread = sectorSize;
                }
                data.seek((long) (sector * 520));
                data.read(buffer, 0, i_8_ + unread);
                int currentFile;
                int currentPart;
                int nextSector;
                int currentIndex;
                if (pos <= 65535) {
                    currentFile = (buffer[0] << 8 & 0xff00)
                            + (buffer[1] & 0xff);
                    currentPart = ((buffer[2] & 0xff) << 8)
                            + (buffer[3] & 0xff);
                    nextSector = (buffer[6] & 0xff) + (buffer[5] << 8 & 0xff00)
                            + ((buffer[4] & 0xff) << 16);
                    currentIndex = buffer[7] & 0xff;
                } else {
                    currentFile = ((buffer[1] & 0xff) << 16)
                            + ((buffer[0] & 0xff) << 24)
                            + ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);
                    currentPart = ((buffer[4] & 0xff) << 8)
                            + (buffer[5] & 0xff);
                    nextSector = (buffer[8] & 0xff) + (buffer[7] << 8 & 0xff00)
                            + ((buffer[6] & 0xff) << 16);
                    currentIndex = buffer[9] & 0xff;
                }
                if (pos != currentFile || currentPart != i_6_
                        || storeId != currentIndex) {
                    return null;
                }
                if (nextSector < 0 || data.length() / 520L < (long) nextSector) {
                    return null;
                }
                int i_15_ = 0;
                int i_16_ = unread;
                while (i_16_ > i_15_) {
                    buf[read++] = buffer[i_8_ + i_15_];
                    i_15_++;
                    i_16_ = unread;
                }
                i_6_++;
                sector = nextSector;
                fileSize2 = fileSize;
            }
            is = buf;
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
            return null;
        }
        return is;
    }

    public final byte[] getUncompressedData(int position, int[] keys) {
        byte[] bytes = decompress(position); // unwrap the data
        if (bytes == null) {
            return null;
        } // in the client this would be child buffer preparation.
        if (keys != null
                && (keys[0] != 0 || keys[1] != 0 || keys[2] != 0 || keys[3] != 0)) {
            Buffer buffer; // decode xtea
            (buffer = new Buffer(bytes)).decodeXTEA(keys, 5,
                    buffer.payload.length);
        }
        return CompressionUtils.readDecompressedData(bytes); // return the
        // uncompressed
        // data
    }

    public final byte[] getUncompressedData(int pos) { // poor naming
        return getUncompressedData(pos, null);
    }

    public int getStoreId() {
        return storeId;
    }

}