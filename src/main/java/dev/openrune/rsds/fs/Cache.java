package dev.openrune.rsds.fs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;

public class Cache {

    // Would CacheFile be a better name for this?

    private FileSystem[] fileSystems;
    private Index index;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Cache(String string) {
        HashMap hashmap = new HashMap();
        RandomAccessFile dat0 = null;
        RandomAccessFile dat2 = null;
        File[] files = new File(string).listFiles();
        int count = -1;
        File[] filesCopy;
        int length = (filesCopy = files).length;
        int fileIndex;
        int j = fileIndex = 0;
        while (j < length) {
            File file;
            if ((file = filesCopy[fileIndex]).length() != 0L) {
                if (file.getName().startsWith("main_file_cache.idx")) {
                    int key;
                    if ((key = Integer
                            .parseInt(file.getName().split(".idx")[1])) != 255) {
                        // if it isn't the reference table (idx255)...
                        try {
                            hashmap.put(Integer.valueOf(key),
                                    new RandomAccessFile(file, "rw"));
                            if (key > count) {
                                count = key;
                            }
                        } catch (FileNotFoundException filenotfoundexception) {
                            filenotfoundexception.printStackTrace();
                        }
                    } else {
                        try {
                            dat0 = new RandomAccessFile(file, "rw");
                        } catch (FileNotFoundException filenotfoundexception) {
                            filenotfoundexception.printStackTrace();
                        }
                    }
                } else if (file.getName().equals("main_file_cache.dat2")) {
                    try {
                        dat2 = new RandomAccessFile(file, "rw");
                    } catch (FileNotFoundException filenotfoundexception) {
                        filenotfoundexception.printStackTrace();
                    }
                }
            }
            j = ++fileIndex;
        }
        if (count == -1 || dat0 == null || dat2 == null) {
            throw new Error("Missing one or more cache files.");
        }
        byte[] buf = new byte[520];
        index = new Index(255, dat0, dat2, 10000000, buf);
        fileSystems = new FileSystem[count + 1];
        try {
            Iterator iterator = hashmap.keySet().iterator();
            while (iterator.hasNext()) {
                fileIndex = ((Integer) iterator.next()).intValue();
                fileSystems[fileIndex] = new FileSystem(this, new Index(
                        fileIndex, (RandomAccessFile) hashmap.get(Integer
                        .valueOf(fileIndex)), dat2, 100000000, buf),
                        true);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public FileSystem[] getFileSystems() {
        return fileSystems;
    }

    public Index getIndex() {
        return index;
    }

}