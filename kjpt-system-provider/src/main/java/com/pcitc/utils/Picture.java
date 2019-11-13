package com.pcitc.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 把两张图片合并
 *
 * @version 2018-2-27 上午11:12:09
 */
public class Picture {
    private Graphics2D g = null;

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {

        try {
            int w = 750;
//            int w = b.getWidth();
//            int h = b.getHeight();
            int h = 750;
            g = d.createGraphics();

            g.drawImage(b, 750, -750, w, h, Color.red, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Picture tt = new Picture();

        BufferedImage b = tt.loadImageLocal("E:\\750.png");
        BufferedImage d = tt.loadImageLocal("E:\\doc\\750.jpg");

        tt.writeImageLocal("C:\\Users\\Administrator\\Desktop\\d\\h.jpg", tt.modifyImagetogeter(b, d));
        //将多张图片合在一起
        System.out.println("success");
    }
}