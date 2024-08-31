package dev.openrune.rsds;

public class StringDecryption {

    public static String decryptString(String string) {
        String string_1 = new String();
        char[] chars = new char[string.length()];
        int i = 85;
        int i_1_ = chars.length - 1;
        int index = i_1_;
        char[] cs_3_ = chars;
        int i_4_ = i;
        while (i_1_ >= 0) {
            char[] cs_5_ = cs_3_;
            char c = (char) (string.charAt(index) ^ i_4_);
            int i_6_ = index;
            i_4_ = (char) ((char) (i_6_ ^ i_4_) & '?');
            cs_5_[i_6_] = c;
            if (--index < 0) {
                break;
            }
            char[] cs_7_ = cs_3_;
            char c_8_ = (char) (string.charAt(index) ^ i_4_);
            int i_9_ = index;
            i_4_ = (char) ((char) (i_9_ ^ i_4_) & '?');
            cs_7_[i_9_] = c_8_;
            i_1_ = --index;
        }
        string_1 = new String(cs_3_);
        return string_1;
    }

    @SuppressWarnings("unused")
    private static String decrypt2(String string) {
        String string_10_ = string;
        int i = 1;
        StackTraceElement[] elements = new Exception().getStackTrace();
        StackTraceElement element = elements[i];
        StringBuffer stringBuffer = new StringBuffer();
        String className = element.getClassName();
        String methodName = element.getMethodName();
        StringBuffer stringbuffer_2 = stringBuffer.append(className);
        String string_14_ = stringbuffer_2.append(methodName).toString();
        int i_15_ = string_14_.length();
        int i_16_ = i_15_ - i;
        int i_17_ = i_16_;
        String string_18_ = string_14_;
        int i_19_ = i_16_;
        int length = string_10_.length();
        char[] chars = new char[length];
        int i_21_ = 85;
        int i_22_ = length - i;
        for (; ; ) {
            char[] cs_23_ = chars;
            int i_24_ = i_22_;
            if (i_24_ < 0) {
                break;
            }
            int i_25_ = 63;
            int i_26_ = i_21_;
            char c = string_18_.charAt(i_19_);
            int i_27_ = i_22_;
            String string_28_ = string;
            cs_23_[i_27_] = (char) (c ^ string_28_.charAt(i_27_) ^ i_21_);
            i_21_ = (char) (i_25_ & (i_26_ ^ i_24_ ^ c));
            if (--i_19_ < 0) {
                i_19_ = i_17_;
            }
            i_22_--;
        }
        char[] cs_29_ = chars;
        String string_30_ = new String();
        string_30_ = new String(cs_29_);
        return string_30_;
    }

}