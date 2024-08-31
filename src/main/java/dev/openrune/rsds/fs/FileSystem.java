package dev.openrune.rsds.fs;

import dev.openrune.rsds.io.Buffer;

public class FileSystem {

    private ReferenceTable referenceTable;
    private byte[][][] aByteArrayArrayArray_366;
    private boolean aBoolean367;
    private Index index;

    public FileSystem(Cache class_n, Index index, boolean bool) {
        this.index = index;
        aBoolean367 = bool;
        byte[] buf;
        if ((buf = class_n.getIndex().decompress(index.getStoreId())) == null) {
            class_n.getFileSystems()[index.getStoreId()] = null;
        } else {
            referenceTable = new ReferenceTable(buf);
            method65();
        }
    }

    public ReferenceTable getReferenceTable() {
        return referenceTable;
    }

    public byte[] method149(int parent, int child, int[] keys) {
        if (!boolean_method153(parent, child)) {
            return null;
        }
        if ((aByteArrayArrayArray_366[parent] == null || aByteArrayArrayArray_366[parent][child] == null)
                && !method146(parent, keys)) {
            return null;
        }
        byte[] is_20_ = aByteArrayArrayArray_366[parent][child];
        if (aBoolean367) {
            if (aByteArrayArrayArray_366[parent].length == 1) {
                aByteArrayArrayArray_366[parent] = null;
            } else {
                aByteArrayArrayArray_366[parent][child] = null;
            }
        }
        return is_20_;
    }

    public byte[] getFile(int parent, int child) {
        return method149(parent, child, null);
    }

    public boolean method146(int position, int[] keys) {
        byte[] buf;
        if ((buf = index.getUncompressedData(position, keys)) == null) {
            return false;
        }
        if (aByteArrayArrayArray_366[position] == null) {
            if (referenceTable.getArchiveSubs()[position] == null) {
                return false;
            }
            aByteArrayArrayArray_366[position] = new byte[referenceTable
                    .getArchiveSubs()[position].getArchives().length][];
        }
        if (referenceTable.getArchiveSubs()[position].method174().length == 1) {
            int i_1_ = referenceTable.getArchiveSubs()[position].method174()[0];
            aByteArrayArrayArray_366[position][i_1_] = buf;
        } else {
            int i_2_ = buf.length;
            int i_3_ = buf[--i_2_] & 0xff;
            i_2_ -= i_3_
                    * referenceTable.getArchiveSubs()[position].method174().length
                    * 4;
            Buffer class_k = new Buffer(buf);
            int[] is_4_ = new int[referenceTable.getArchiveSubs()[position]
                    .method174().length];
            class_k.offset = i_2_;
            int i_6_;
            int i_5_ = i_6_ = 0;
            while (i_5_ < i_3_) {
                int i_7_ = 0;
                int i_9_;
                int i_8_ = i_9_ = 0;
                while (i_8_ < referenceTable.getArchiveSubs()[position]
                        .method174().length) {
                    is_4_[i_9_] += i_7_ += class_k.readInt3();
                    i_8_ = ++i_9_;
                }
                i_5_ = ++i_6_;
            }
            byte[][] is_10_ = new byte[referenceTable.getArchiveSubs()[position]
                    .method174().length][];
            int i_12_;
            int i_11_ = i_12_ = 0;
            while (i_11_ < referenceTable.getArchiveSubs()[position]
                    .method174().length) {
                is_10_[i_12_] = new byte[is_4_[i_12_]];
                is_4_[i_12_] = 0;
                i_11_ = ++i_12_;
            }
            class_k.offset = i_2_;
            i_12_ = 0;
            int i_14_;
            int i_13_ = i_14_ = 0;
            while (i_13_ < i_3_) {
                int i_15_ = 0;
                int i_17_;
                int i_16_ = i_17_ = 0;
                while (i_16_ < referenceTable.getArchiveSubs()[position]
                        .method174().length) {
                    i_15_ += class_k.readInt3();
                    System.arraycopy(buf, i_12_, is_10_[i_17_], is_4_[i_17_],
                            i_15_);
                    i_12_ += i_15_;
                    is_4_[i_17_] += i_15_;
                    i_16_ = ++i_17_;
                }
                i_13_ = ++i_14_;
            }
            int i_18_ = i_14_ = 0;
            while (i_18_ < referenceTable.getArchiveSubs()[position]
                    .method174().length) {
                aByteArrayArrayArray_366[position][referenceTable
                        .getArchiveSubs()[position].method174()[i_14_]] = is_10_[i_14_];
                i_18_ = ++i_14_;
            }
        }
        return true;
    }

    public boolean validIndices(int file) {
        if (file < 0 || referenceTable.getArchiveSubs().length <= file) {
            return false;
        }
        return true;
    }

    public boolean boolean_method153(int file, int child) {
        if (!validIndices(file)) {
            return false;
        }
        if (child < 0
                || referenceTable.getArchiveSubs()[file].getArchives().length <= child) {
            return false;
        }
        return true;
    }

    public Index getIndex() {
        return index;
    }

    public int method139() {
        return referenceTable.getArchiveSubs().length;
    }

    public int getFileCount() {
        int i = method139();
        int count = 0;
        int i_25_;
        int i_24_ = i_25_ = 0;
        while (i_24_ < i) {
            count += getChildCount(i_25_);
            i_24_ = ++i_25_;
        }
        return count;
    }

    public int getChildCount(int file) {
        if (!validIndices(file)) {
            return -1;
        }
        return referenceTable.getArchiveSubs()[file].getArchives().length;
    }

    public void method65() {
        aByteArrayArrayArray_366 = new byte[referenceTable.getArchiveSubs().length][][];
    }

}