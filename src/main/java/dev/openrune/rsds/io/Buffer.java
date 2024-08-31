package dev.openrune.rsds.io;

import dev.openrune.rsds.compression.CompressionUtils;

import java.math.BigInteger;

public class Buffer {

    public int offset;
    public byte[] payload;

    public Buffer(byte[] data) {
        offset = 0;
        payload = data;
    }

    public Buffer(int size) {
        payload = new byte[size];
        offset = 0;
    }

    public Buffer(int[] is) {
        offset = 0;
        payload = new byte[is.length];
        int i_15_;
        int i = i_15_ = 0;
        while (i < payload.length) {
            payload[i_15_] = (byte) is[i_15_];
            i = ++i_15_;
        }
    }

    public final byte readByte() {
        return payload[offset++];
    }

    final byte readByteA() {
        return (byte) (payload[offset++] - 128);
    }

    final byte readByteS() {
        return (byte) (-payload[offset++] + 128);
    }

    final byte readNegByte() {
        return (byte) -payload[offset++];
    }

    public byte readByte2() {
        return readByte();
    }

    public final byte readByteFromPos(int position) {
        return payload[position];
    }

    public int int_method138() {
        offset += 4;
        return ((payload[offset - 4] & 0xff) << 24)
                - (-(payload[offset - 3] << 48 & 0xff0000) - (((payload[offset - 2] & 0xff) << 8) + (payload[offset - 1] & 0xff)));
    }

    final int readUByteS() {
        return 128 - payload[offset++] & 0xff;
    }

    public final int readSmarts2() {
        if ((payload[offset] & 0xff) >= 128) {
            return readUShort() - 49152;
        }
        return readUByte() - 64;
    }

    public int readUShort4() {
        return readUShort();
    }

    public int readShort3() {
        offset += 2;
        int i;
        if ((i = ((payload[offset - 2] & 0xff) << 8)
                + (payload[offset - 1] & 0xff)) > 60000) {
            i -= 65535;
        }
        return i;
    }

    final int readUByteA() {
        return payload[offset++] - 128 & 0xff;
    }

    final int readSmart() {
        if ((payload[offset] & 0xff) >= 128) {
            return readUShort() - 32768;
        }
        return readUByte();
    }

    public int readMediumInt4() {
        offset += 3;
        return ((payload[offset - 3] & 0xff) << 16)
                + ((payload[offset - 2] & 0xff) << 8)
                + (payload[offset - 1] & 0xff);
    }

    public final int method229() {
        if (payload[offset] < 0) {
            return readInt3() & 0x7fffffff;
        }
        int i;
        if ((i = readUShort2()) == 32767) {
            return -1;
        }
        return i;
    }

    public final int readMediumInt3() {
        return readMediumInt();
    }

    public int readSmarts() {
        if ((payload[offset] & 0xff) < 128) {
            return readUByte2() - 64;
        }
        return readUShort4() - 49152;
    }

    final int readInt() {
        offset += 4;
        return ((payload[offset - 1] & 0xff) << 24)
                + (payload[offset - 2] << 16 & 0xff0000)
                + ((payload[offset - 3] & 0xff) << 8)
                + (payload[offset - 4] & 0xff);
    }

    public final int readUShort() {
        offset += 2;
        return (payload[offset - 2] << 8 & 0xff00)
                + (payload[offset - 1] & 0xff);
    }

    public int readUShort2() {
        return readUShort();
    }

    final int readLEShort() {
        offset += 2;
        int i;
        if ((i = (payload[offset - 2] & 0xff)
                + (payload[offset - 1] << 8 & 0xff00)) > 32767) {
            i -= 65536;
        }
        return i;
    }

    public int readUByte2() {
        return readUByte();
    }

    final int int_method243() {
        int i = 0;
        int i_25_;
        int i_24_ = i_25_ = readSmart();
        while (i_24_ == 32767) {
            i_25_ = readSmart();
            i += 32767;
            i_24_ = i_25_;
        }
        return i += i_25_;
    }

    public final int readMediumInt() {
        offset += 3;
        return (payload[offset - 1] & 0xff)
                + (payload[offset - 3] << 16 & 0xff0000)
                + (payload[offset - 2] << 8 & 0xff00);
    }

    final int readLEUShort() {
        offset += 2;
        return (payload[offset - 2] & 0xff)
                + ((payload[offset - 1] & 0xff) << 8);
    }

    public final int readShort() {
        offset += 2;
        int i;
        if ((i = ((payload[offset - 2] & 0xff) << 8)
                + (payload[offset - 1] & 0xff)) > 32767) {
            i -= 65536;
        }
        return i;
    }

    final int readMEInt() {
        offset += 4;
        return (payload[offset - 2] << 24 & ~0xffffff)
                + ((payload[offset - 1] & 0xff) << 16)
                + (payload[offset - 4] << 8 & 0xff00)
                + (payload[offset - 3] & 0xff);
    }

    final int readNegUByte() {
        return -payload[offset++] & 0xff;
    }

    public int readUShort3() {
        return readUShort();
    }

    final int readShortA() {
        offset += 2;
        int i;
        if ((i = (payload[offset - 1] - 128 & 0xff)
                + (payload[offset - 2] << 8 & 0xff00)) > 32767) {
            i -= 65536;
        }
        return i;
    }

    public final int readInt3() {
        offset += 4;
        return ((payload[offset - 3] & 0xff) << 16)
                + ((payload[offset - 4] & 0xff) << 24)
                + ((payload[offset - 2] & 0xff) << 8)
                + (payload[offset - 1] & 0xff);
    }

    public final int readUByte() {
        return payload[offset++] & 0xff;
    }

    final int method269() {
        int off = payload[offset++];
        int i = 0;
        int j = off;
        while (j < 0) {
            i = (off & 0x7f | i) << 7;
            j = off = payload[offset++];
        }
        return i | off;
    }

    final int readUShortA() {
        offset += 2;
        return (payload[offset - 1] - 128 & 0xff)
                + ((payload[offset - 2] & 0xff) << 8);
    }

    final int readMEInt2() {
        offset += 4;
        return ((payload[offset - 4] & 0xff) << 16)
                + (payload[offset - 3] << 24 & ~0xffffff)
                + ((payload[offset - 1] & 0xff) << 8)
                + (payload[offset - 2] & 0xff);
    }

    final int readLEUShortA() {
        offset += 2;
        return ((payload[offset - 1] & 0xff) << 8)
                + (payload[offset - 2] - 128 & 0xff);
    }

    final int readLEShortA() {
        offset += 2;
        int i;
        if ((i = (payload[offset - 2] - 128 & 0xff)
                + ((payload[offset - 1] & 0xff) << 8)) > 32767) {
            i -= 65536;
        }
        return i;
    }

    public int readMediumInt2() {
        offset += 3;
        return (payload[offset - 3] << 16 & 0xff0000)
                - (-(payload[offset - 2] << 40 & 0xff00) - (payload[offset - 1] & 0xff));
    }

    final long readLong() {
        long l = (long) readInt3() & 0xffffffffL;
        return ((long) readInt3() & 0xffffffffL) + (l << 32);
    }

    final long readShiftedLong(int i) {
        if (--i < 0 || i > 7) {
            throw new IllegalArgumentException();
        }
        int j = i * 8;
        long l = 0L;
        int k = j;
        while (k >= 0) {
            l |= ((long) payload[offset++] & 0xffL) << j;
            j -= 8;
            k = j;
        }
        return l;
    }

    final String getNewJString() { // only in later clients (500+?)
        if (payload[offset++] != 0) {
            throw new IllegalStateException("Bad version number in gjstr2");
        }
        int off = offset;
        Buffer buffer = this;
        while (buffer.payload[offset++] != 0) {
            ;
        }
        int length = offset - 1 - off;
        if (length == 0) {
            return "";
        }
        return CompressionUtils.getStringFromBytes(payload, off, length);
    }

    public String readJString() {
        int i = offset;
        Buffer buffer = this;
        while (buffer.payload[offset++] != 0) {
            buffer = this;
        }
        return new String(payload, i, offset - i - 1);
    }

    final String readCheckedString() {
        if (payload[offset] == 0) {
            offset++;
            return null;
        }
        return method264();
    }

    public final String method264() {
        int i = offset;
        Buffer buffer = this;
        while (buffer.payload[offset++] != 0) {
            buffer = this;
        }
        int length;
        if ((length = offset - i - 1) == 0) {
            return "";
        }
        return CompressionUtils.getStringFromBytes(payload, i, length);
    }

    final void writeByteA(int i) {
        payload[offset++] = (byte) (i + 128);
    }

    public final void void_method171(int[] is) {
        int i = offset / 8;
        offset = 0;
        int i_17_;
        int i_16_ = i_17_ = 0;
        while (i_16_ < i) {
            int i_18_ = readInt3();
            int i_19_ = readInt3();
            int i_20_ = 0;
            int i_21_ = -1640531527;
            int i_23_;
            int i_22_ = i_23_ = 32;
            for (; ; ) {
                i_23_--;
                if (i_22_ <= 0) {
                    break;
                }
                i_18_ += i_20_ + is[i_20_ & 0x3] ^ i_19_
                        + (i_19_ >>> 5 ^ i_19_ << 4);
                i_20_ += i_21_;
                i_19_ += i_18_ + (i_18_ >>> 5 ^ i_18_ << 4)
                        ^ is[(i_20_ & 0x1eec) >>> 11] + i_20_;
                i_22_ = i_23_;
            }
            offset -= 8;
            writeInt(i_18_);
            writeInt(i_19_);
            i_16_ = ++i_17_;
        }
    }

    public final void writeByte(int i) {
        payload[offset++] = (byte) i;
    }

    final void readDataReverse(byte[] data, int length, int off) {
        int i_5_;
        int i_4_ = i_5_ = length + off - 1;
        while (i_4_ >= length) {
            data[i_5_] = payload[offset++];
            i_4_ = --i_5_;
        }
    }

    final void readDataReverseA(byte[] data, int off, int i_6_) {
        int i_7_ = i_6_ - 1 + off;
        int i_8_ = off;
        while (i_8_ <= i_7_) {
            data[i_7_] = (byte) (payload[offset++] - 128);
            i_7_--;
            i_8_ = off;
        }
    }

    final void writeByteS(int i) {
        payload[offset++] = (byte) (128 - i);
    }

    public final void readData(byte[] data, int off, int length) {
        int i_11_ = off;
        int i_10_ = off;
        while (i_10_ < length + off) {
            data[i_11_] = payload[offset++];
            i_10_ = ++i_11_;
        }
    }

    final void writeIMEInt(int i) {
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) i;
        payload[offset++] = (byte) (i >> 8);
    }

    final void void_encodeRSA(BigInteger exponent, BigInteger modulus) {
        int start = offset;
        offset = 0;
        byte[] buf = new byte[start];
        readData(buf, 0, start);
        BigInteger bigInt = new BigInteger(buf).modPow(exponent, modulus);
        byte[] rsaBuffer = bigInt.toByteArray();
        offset = 0;
        writeByte(rsaBuffer.length);
        void_method275(rsaBuffer, 0, rsaBuffer.length);
    }

    final void writeSizeShort(int i) {
        payload[offset - i - 2] = (byte) (i >> 8);
        payload[offset - 1 - i] = (byte) i;
    }

    public void writeInt2(int i) {
        writeInt(i);
    }

    final void writeLong(long l) {
        payload[offset++] = (byte) (int) (l >> 56);
        payload[offset++] = (byte) (int) (l >> 48);
        payload[offset++] = (byte) (int) (l >> 40);
        payload[offset++] = (byte) (int) (l >> 32);
        payload[offset++] = (byte) (int) (l >> 24);
        payload[offset++] = (byte) (int) (l >> 16);
        payload[offset++] = (byte) (int) (l >> 8);
        payload[offset++] = (byte) (int) l;
    }

    final void writeSizeByte(int i) {
        payload[offset - i - 1] = (byte) i;
    }

    public final void writeShort(int i) {
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

    final void void_method255(int i) {
        payload[offset - (i + 4)] = (byte) (i >> 24);
        payload[offset - i - 3] = (byte) (i >> 16);
        payload[offset - i - 2] = (byte) (i >> 8);
        payload[offset - i - 1] = (byte) i;
    }

    final void void_method257(int i, long l) {
        if (--i < 0 || i > 7) {
            throw new IllegalArgumentException();
        }
        int i_27_;
        int i_26_ = i_27_ = i * 8;
        while (i_26_ >= 0) {
            payload[offset++] = (byte) (int) (l >> i_27_);
            i_27_ -= 8;
            i_26_ = i_27_;
        }
    }

    final void void_method259(String string) {
        int index;
        if ((index = string.indexOf('\0')) >= 0) {
            throw new IllegalArgumentException(new StringBuilder()
                    .append("NUL character at ").append(index)
                    .append("-  cannot pjstr").toString());
        }
        offset += CompressionUtils.method134(string, 0, string.length(),
                payload, offset);
        payload[offset++] = (byte) 0;
    }

    final void writeLEShortA(int i) {
        payload[offset++] = (byte) (i + 128);
        payload[offset++] = (byte) (i >> 8);
    }

    final void writeShortA(int i) {
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) (i + 128);
    }

    final void writeNegByte(int i) {
        payload[offset++] = (byte) -i;
    }

    final void void_method266(int i) {
        if (i >= 0 && i < 128) {
            writeByte(i);
        } else if (i >= 0 && i < 32768) {
            writeShort(i + 32768);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void writeInt(int i) {
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

    final void void_method275(byte[] is, int i, int i_34_) {
        int i_35_ = i;
        int i_36_ = i;
        while (i_36_ + i_34_ > i_35_) {
            payload[offset++] = is[i_35_];
            i_35_++;
            i_36_ = i;
        }
    }

    final void writeMEInt(int i) {
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) (i >> 16);
    }

    public final void decodeXTEA(int[] keys, int start, int end) {
        int l = offset;
        offset = start;
        int i = (end - start) / 8;
        int j = 0;
        int k = 0;
        while (k < i) {
            int k1 = readInt3();
            int j1 = readInt3();
            int sum = -957401312;
            int delta = -1640531527;
            int l1 = 32;
            int i1 = 32;
            for (; ; ) {
                l1--;
                if (i1 <= 0) {
                    break;
                }
                j1 -= keys[(sum & 0x1c84) >>> 11] + sum ^ (k1 >>> 5 ^ k1 << 4)
                        + k1;
                sum -= delta;
                k1 -= (j1 >>> 5 ^ j1 << 4) + j1 ^ keys[sum & 0x3] + sum;
                i1 = l1;
            }
            offset -= 8;
            writeInt(k1);
            writeInt(j1);
            k = ++j;
        }
        offset = l;
    }

    public void writeString(String string) {
        System.arraycopy(string.getBytes(), 0, payload, offset, string.length());
        offset = offset + string.length();
        writeByte(0);
    }

    final void writeLEInt(int i) {
        payload[offset++] = (byte) i;
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 24);
    }

    final void putFlags(int i) {
        if ((i & ~0x7f) != 0) {
            if ((i & ~0x3fff) != 0) {
                if ((i & ~0x1fffff) != 0) {
                    if ((i & ~0xfffffff) != 0) {
                        writeByte(i >>> 28 | 0x80);
                    }
                    writeByte((i | 0x10039c30) >>> 21);
                }
                writeByte((i | 0x203a0e) >>> 14);
            }
            writeByte((i | 0x403d) >>> 7);
        }
        writeByte(i & 0x7f);
    }

    final void writeLEShort(int i) {
        payload[offset++] = (byte) i;
        payload[offset++] = (byte) (i >> 8);
    }

    public void writeShort2(int i) {
        writeShort(i);
    }

    public final void writeMediumInt(int i) {
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

}