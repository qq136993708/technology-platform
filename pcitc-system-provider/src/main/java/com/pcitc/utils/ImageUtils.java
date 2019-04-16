package com.pcitc.utils;

import com.pcitc.base.util.FileUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.*;

/**
 * @author:Administrator
 * @date:2018/10/17
 */
public class ImageUtils {

//    /*
//     *以下是图片缩放的方法
//     */
//
//    public Image img;
//    public File donefile;
//    public int width;
//    public int height;
//
//    public ImageUtils() {
//
//    }
//
//    public ImageUtils(int width, int height, File donefile) {
//        this.width = width;
//        this.height = height;
//        this.donefile = donefile;
//        try {
//            this.img = ImageIO.read(donefile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 按照宽度还是高度进行【压缩】
//     *
//     * @param w int 最大宽度
//     * @param h int 最大高度
//     */
//    public void compress(int w, int h, String newfileurl) throws IOException {
//        int h2 = 0, w2 = 0;
//        if (width > w) {
//            h2 = (int) (height * w / width);
//            if (h2 > h) {
//                w2 = (int) (w * h / h2);
//                //System.out.println(w2+"=="+h);
//                compressImgToSize(w2, h, newfileurl);
//            } else {
//                //System.out.println(w+"=="+h2);
//                compressImgToSize(w, h2, newfileurl);
//            }
//        } else if (height > h) {
//            w2 = (int) (width * h / height);
//            //System.out.println(w2+"=="+h);
//            compressImgToSize(w2, h, newfileurl);
//        } else {
//            //System.out.println(width+"=="+height);
//            compressImgToSize(width, height, newfileurl);
//        }
//    }
//
//    /**
//     * 按照宽度还是高度进行【裁剪 】
//     *
//     * @param w int 最大宽度
//     * @param h int 最大高度
//     */
//    public void cut(int w, int h, String newfileurl) throws IOException {
//        if (width > w && height > h) {
//            cutImage(donefile, new File(newfileurl), w, h);
//        } else if (width > w && height <= h) {
//            cutImage(donefile, new File(newfileurl), w, height);
//        } else if (width <= w && height > h) {
//            cutImage(donefile, new File(newfileurl), width, h);
//        } else {
//            cutImage(donefile, new File(newfileurl), width, height);
//        }
//    }
//
//    /**
//     * 强制压缩/放大图片到固定的大小
//     *
//     * @param w int 新宽度
//     * @param h int 新高度
//     */
//    public void compressImgToSize(int w, int h, String newfileurl) throws IOException {
//        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
//        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
//        File destFile = new File(newfileurl);
//        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
//        // 可以正常实现bmp、png、gif转jpg
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//        encoder.encode(image); // JPEG编码
//        out.close();
//    }
//
//    /**
//     * <p>Title: cutImage</p>
//     * <p>Description:  根据原图与裁切size截取局部图片</p>
//     *
//     * @param srcImg 源图片
//     * @param output 图片输出流
//     */
//    public void cutImage(File srcImg, File output, int w, int h) {
//        java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, w, h);
//        if (srcImg.exists()) {
//            FileInputStream fis = null;
//            ImageInputStream iis = null;
//            try {
//                fis = new FileInputStream(srcImg);
//                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
//                String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
//                String suffix = null;
//                // 获取图片后缀
//                if (srcImg.getName().indexOf(".") > -1) {
//                    suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
//                }// 类型和图片后缀全部小写，然后判断后缀是否合法
//                if (suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase() + ",") < 0) {
//                    return;
//                }
//                // 将FileInputStream 转换为ImageInputStream
//                iis = ImageIO.createImageInputStream(fis);
//                // 根据图片类型获取该种类型的ImageReader
//                ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
//                reader.setInput(iis, true);
//                ImageReadParam param = reader.getDefaultReadParam();
//                param.setSourceRegion(rect);
//                BufferedImage bi = reader.read(0, param);
//                ImageIO.write(bi, suffix, output);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (fis != null) fis.close();
//                    if (iis != null) iis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//        }
//    }

    /**
     * 指定大小进行缩放
     *
     * @param width
     * @param height
     * @param filePath
     * @param newFilePath
     */
    public static void getImgSize(int width, int height, String filePath, String newFilePath) {
        /*
         * 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变
         * 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        try {
            Thumbnails.of(filePath)
                    .size(width, height).outputQuality(1f)
                    .toFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 不按照比例，指定大小进行缩放
     *
     * @param width
     * @param height
     * @param filePath
     * @param newFilePath
     */
    public static void getImgSizeNoScale(int width, int height, String filePath, String newFilePath) {
        try {
            Thumbnails.of(filePath)
                    .size(width, height)
                    .keepAspectRatio(false)
                    .toFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照比例进行缩放
     *
     * @param scale
     * @param filePath
     * @param newFilePath
     */
    public static void getImgScale(double scale, String filePath, String newFilePath) {
        try {
            Thumbnails.of(filePath)
                    .scale(scale).outputQuality(1f)
                    .toFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 旋转:正数：顺时针负数：逆时针
     *
     * @param width
     * @param height
     * @param rotate
     * @param filePath
     * @param newFilePath
     */
    public static void getImgRotate(int width, int height, String filePath, String newFilePath, int rotate) {
        try {
            Thumbnails.of(filePath)
                    .size(width, height)
                    .rotate(rotate)
                    .toFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 水印:位置，水印图，透明度
     */
    public static void getImgWatermark(int width, int height, String filePath, String newFilePath, String waterMarkPath, float waterMarkSize, float outputQuality) {
        try {
            Thumbnails.of(filePath)
                    .size(width, height)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(waterMarkPath)), waterMarkSize)
                    .outputQuality(outputQuality)
                    .toFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void batImage(String path,String newpath) {
        if(!new File(newpath).exists()){
            FileUtil.mkdir(newpath);
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            String fileName = path + File.separator + tempList[i];
            System.out.println(fileName);
            if (FileUtil.isImage(fileName)) {
                temp = new File(fileName);
                getImgSizeNoScale(750,750,fileName,newpath + File.separator + "750_"+tempList[i]);
                getImgSizeNoScale(325,325,fileName,newpath + File.separator + "325_"+tempList[i]);
            }

        }
    }

    public static void batImagegetImgScale(String path,String newpath,String type) {
        if(!new File(newpath).exists()){
            FileUtil.mkdir(newpath);
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            String fileName = path + File.separator + tempList[i];
            System.out.println(fileName);
            if (FileUtil.isImage(fileName)) {
                temp = new File(fileName);
                if ("325".equals(type)){
                    getImgSize(310,310,fileName,newpath + File.separator + "325_"+tempList[i]);
                }else {
                    getImgSize(730,730,fileName,newpath + File.separator + "750_"+tempList[i]);
                }
//                getImgSize(750,750,fileName,newpath + File.separator + "750_"+tempList[i]);
//                getImgSize(325,325,fileName,newpath + File.separator + "325_"+tempList[i]);
            }
        }
    }

    public static void batgetImgScale(String path,String newpath) {
        if(!new File(newpath).exists()){
            FileUtil.mkdir(newpath);
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            String fileName = path + File.separator + tempList[i];
            System.out.println(fileName);
            if (FileUtil.isImage(fileName)) {
                temp = new File(fileName);
                getImgScale(0.8,fileName,newpath + File.separator + "750_"+tempList[i]);
                getImgScale(0.8,fileName,newpath + File.separator + "325_"+tempList[i]);
            }

        }
    }

    public static void batImagegetCompose(String path,String newpath,String modelPic,String modelPicName) {
        if(!new File(newpath).exists()){
            FileUtil.mkdir(newpath);
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            String fileName = path + File.separator + tempList[i];
            System.out.println(fileName);
            if (FileUtil.isImage(fileName)) {
                temp = new File(fileName);
                Pic.composePic(modelPic,fileName,newpath + File.separator + modelPicName+"_"+tempList[i]);
//                getImgSize(725,725,fileName,newpath + File.separator + "750_"+tempList[i]);
//                getImgSize(750,750,fileName,newpath + File.separator + "750_"+tempList[i]);
//                getImgSize(325,325,fileName,newpath + File.separator + "325_"+tempList[i]);
//                getImgSize(300,300,fileName,newpath + File.separator + "325_"+tempList[i]);
            }

        }
    }

    public static void main(String[] args) {

        String type = "750";
        String date = "20190414";
        String path = "E:\\doc\\书道\\图片\\"+date+"\\";

        String newpath = path+type;
        batImagegetImgScale(path,newpath,type);


        //图片合并
        String newpathCompose = "E:\\doc\\书道\\图片\\"+date+"-img";



//        String modelPic750="E:\\doc\\书道\\图片\\750.png";
//        batImagegetCompose(newpath,newpathCompose,modelPic750,type);



        type = "325";
        newpath = path+type;
        batImagegetImgScale(path,newpath,type);

        String modelPic325="E:\\doc\\书道\\图片\\325.png";
        batImagegetCompose(newpath,newpathCompose,modelPic325,"325");

//        Pic.composePic(modelPic,pic,newPic);

//        newpath = "C:\\Users\\Administrator\\Desktop\\20190122样式三";
//        batgetImgScale(path,newpath);
//
//        String strBefore = "D:\\files\\uploadPath\\file\\mobile.jpg";
//        String strback = "D:\\\\files\\\\uploadPath\\\\file\\\\getImgSize.jpg";
//        ImageUtils.getImgSize(200, 200, strBefore, strback);
//
//
//        strback = "D:\\files\\uploadPath\\file\\getImgScale.jpg";
//        ImageUtils.getImgScale(0.5f, strBefore, strback);
//
//        strback = "D:\\files\\uploadPath\\file\\getImgSizeNoScale.jpg";
//        ImageUtils.getImgSizeNoScale(200, 200, strBefore, strback);

//        int n = 32;
//        if ((n & (n - 1)) == 0) {
//            System.out.println("MMM");
//        }
    }
}
