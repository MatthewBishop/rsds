package dev.openrune.rsds.compression.bzip;

public class BZip2Block {

    byte[][] anByteArrayArray664;
    int[][] anIntArray660;
    int[][] anIntArrayArray668;
    int[][] anIntArrayArray677;
    boolean[] inUse;
    boolean[] aBooleanArray665;
    byte[] aByteArray671;
    byte[] outputBuffer;
    byte[] seqToUnseq;
    byte[] aByteArray679;
    byte[] aByteArray684 = new byte[4096];
    byte[] aByteArray688;
    int[] anIntArray666;
    int[] anInt670;
    int[] anIntArray680 = new int[6];
    int[] anIntArray682;
    byte stateOutCh;
    int nextBlockUsed;
    int decompressedSize;
    int nextBlockPP;
    int bsBuffer;
    int anInt662;
    int k0;
    int bsLive;
    int anInt674;
    int stateOutLength;
    int nextIn;
    int availableOut = 0;
    int anInt683;
    int nextOut;
    int nInUse;
    int anInt687;

    public BZip2Block() {
        seqToUnseq = new byte[256];
        aByteArray688 = new byte[18002];
        aByteArray679 = new byte[18002];
        anIntArray666 = new int[257];
        anIntArray660 = new int[6][258];
        aBooleanArray665 = new boolean[16];
        inUse = new boolean[256];
        nextIn = 0;
        anInt670 = new int[16];
        anIntArrayArray668 = new int[6][258];
        anByteArrayArray664 = new byte[6][258];
        anIntArrayArray677 = new int[6][258];
        anIntArray682 = new int[256];
    }

}