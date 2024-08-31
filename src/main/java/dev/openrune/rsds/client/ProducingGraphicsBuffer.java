package dev.openrune.rsds.client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class ProducingGraphicsBuffer implements ImageProducer, ImageObserver {

    public final int[] pixels;
    private int[] anIntArray_225;
    private final ColorModel colorModel = new DirectColorModel(32, 16711680,
            65280, 255);
    private final Image image;
    private ImageConsumer imageConsumer;
    private final int width;
    private final int height;

    public ProducingGraphicsBuffer(int width, int height, Component component) {
        Rasterizer3D.method50(0.8);
        Rasterizer3D.method64();
        Rasterizer3D.method55(width, height);
        anIntArray_225 = Rasterizer3D.anIntArray_134;
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        image = component.createImage(this);
        setPixels();
        component.prepareImage(image, this);
        setPixels();
        component.prepareImage(image, this);
        setPixels();
        component.prepareImage(image, this);
        initializeRasterizer();
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer) {
        imageConsumer = imageconsumer;
        imageconsumer.setDimensions(width, height);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(colorModel);
        imageconsumer.setHints(14);
    }

    public boolean imageUpdate(Image image, int i, int i_0_, int i_1_,
                               int i_2_, int i_3_) {
        return true;
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
        return imageConsumer == imageconsumer;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer) {
        if (imageConsumer == imageconsumer) {
            imageConsumer = null;
        }
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
        System.out.println("TDLR");
    }

    public void startProduction(ImageConsumer imageconsumer) {
        addConsumer(imageconsumer);
    }

    private void initializeRasterizer() {
        Rasterizer.init(height, width, pixels);
    }

    public void initToClear() {
        initializeRasterizer();
        Rasterizer.clearPixels();
    }

    private synchronized void setPixels() {
        if (imageConsumer != null) {
            imageConsumer.setPixels(0, 0, width, height, colorModel, pixels, 0,
                    width);
            imageConsumer.imageComplete(2);
        }
    }

    public void method88(int i) {
        Rasterizer3D.anInt_135 = height - i;
    }

    public void redrawImage(int x, int y, Graphics graphics) {
        setPixels();
        graphics.drawImage(image, x, y, this);
    }

    public void method90(Model model, int i, int i_5_, int i_6_, int i_7_,
                         int i_8_) {
        initializeRasterizer();
        Rasterizer3D.anIntArray_134 = anIntArray_225;
        int i_9_ = Rasterizer3D.anInt_132;
        int i_10_ = Rasterizer3D.anInt_135;
        int i_11_ = Rasterizer3D.anIntArray_137[i_5_] * i_8_ >> 16;
        int i_12_ = Rasterizer3D.anIntArray_121[i_5_] * i_8_ >> 16;
        if (model != null) {
            Rasterizer.method88(16053492);
            model.method60(i, i_7_, i_6_, i_5_, 0, i_11_, i_12_);
        }
        Rasterizer3D.anInt_132 = i_9_;
        Rasterizer3D.anInt_135 = i_10_;
    }

}