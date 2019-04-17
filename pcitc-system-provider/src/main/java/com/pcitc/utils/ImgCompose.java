package com.pcitc.utils;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * @author:Administrator
 * @date:2019/4/12
 */
public class ImgCompose {
    //横向合成图片
    public static void transverseJointPic(List<File> files, String path) {
        try {
            Integer allWidth = 0;    // 图片总宽度
            Integer allHeight = 0;    // 图片总高度
            List<BufferedImage> imgs = new ArrayList<>();
            for (int i = 0; i < files.size(); i++) {
                imgs.add(ImageIO.read(files.get(i)));
                //横向
                if (i == 0) {
                    allHeight = imgs.get(0).getHeight();
                }
                allWidth += imgs.get(i).getWidth();
            }
            BufferedImage combined = new BufferedImage(allWidth, allHeight, BufferedImage.TYPE_INT_RGB);
            // paint both images, preserving the alpha channels
            Graphics g = combined.getGraphics();

            // 横向合成
            Integer width = 0;
            for (int i = 0; i < imgs.size(); i++) {
                g.drawImage(imgs.get(i), width, 0, null);
                width += imgs.get(i).getWidth();
            }

            ImageIO.write(combined, "jpg", new File(path));
            System.out.println("===合成成功====");
        } catch (Exception e) {
            System.out.println("===合成失败====");
            e.printStackTrace();
        }
    }

    //竖向合成图图片
    public static void verticalJointPic(List<File> files, String path) {
        try {
            Integer allWidth = 0;    // 图片总宽度
            Integer allHeight = 0;    // 图片总高度
            List<BufferedImage> imgs = new ArrayList<>();
            for (int i = 0; i < files.size(); i++) {
                imgs.add(ImageIO.read(files.get(i)));
                //竖向
                if (i == 0) {
                    allWidth = imgs.get(0).getWidth();
                }
                allHeight += imgs.get(i).getHeight();
            }
            BufferedImage combined = new BufferedImage(allWidth, allHeight, BufferedImage.TYPE_INT_RGB);
            // paint both images, preserving the alpha channels
            Graphics g = combined.getGraphics();
            // 竖向合成
            Integer height = 0;
            for (int i = 0; i < imgs.size(); i++) {
                g.drawImage(imgs.get(i), 0, height, null);
                height += imgs.get(i).getHeight();
            }
            ImageIO.write(combined, "jpg", new File(path));
            System.out.println("===合成成功====");
        } catch (Exception e) {
            System.out.println("===合成失败====");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        List<File> files = new ArrayList<>();
        File file1 = new File("D:/job/image/basetoimg1-2.jpg");
        File file2 = new File("D:/job/image/basetoimg2-2.jpg");
        File file3 = new File("D:/job/image/basetoimg3-2.jpg");
        files.add(file1);
        files.add(file2);
        files.add(file3);
        String path = "D:/job/image/down.jpg";
        //横向合成图片
        transverseJointPic(files, path);
        //竖向合成
        String allpath = "D:/job/image/alltest1.jpg";
        verticalJointPic(files, allpath);

    }
}
