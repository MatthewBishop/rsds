package dev.openrune.rsds.fs.def;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;

public class Class_n {

    public static boolean frameIsNull(int frame) {
        return frame == -1;
    }

    public Class_l[] aClass_l_Array_533;
    public Buffer buffer;

    public Class_y an_y_532;

    public void method183(Cache cache, int file, boolean bool) {
        int size = cache.getFileSystems()[0].getChildCount(file);
        if (bool) {
            buffer = new Buffer(new byte[(size + 1) * 6000]);
            buffer.writeShort2(size);
        }
        aClass_l_Array_533 = new Class_l[size];
        int[] children = cache.getFileSystems()[0].getReferenceTable()
                .getArchiveSubs()[file].method174();
        int child = 0;
        int[] is_3_ = children;
        while (is_3_.length > child) {
            byte[] data = cache.getFileSystems()[0].getFile(file,
                    children[child]);
            int nextFile = (data[0] & 0xff) << 40 | data[1] & 0xff;
            if (GUI.revision >= 605) {
                Buffer buffer;
                (buffer = new Buffer(data)).offset = 1;
                nextFile = buffer.readUShort();
            }
            byte[] is_6_ = cache.getFileSystems()[1].getFile(nextFile, 0);
            Class_y class_y = new Class_y(nextFile, is_6_);
            an_y_532 = class_y;
            if (bool) {
                buffer.writeShort2(children[child]);
            }
            aClass_l_Array_533[children[child]] = new Class_l(data, class_y,
                    file, bool, buffer);
            child++;
            is_3_ = children;
        }
    }

}