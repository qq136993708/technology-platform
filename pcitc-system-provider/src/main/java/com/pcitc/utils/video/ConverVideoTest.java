package com.pcitc.utils.video;

import com.pcitc.base.util.FileUtil;

import java.io.File;

/**
 * @author:Administrator
 * @date:2019/4/22
 */
public class ConverVideoTest {

    /**
     * @Description:(1.转码和截图功能调用)
     * @param:@param yuanPATH
     * @return:void
     */

    /*本地测试专用--zoutao*/
    public static void main(String[] args) {
//        ffmpegpath=F:/tools/s_video/ffmpeg/ffmpeg.exe
//        mencoderpath=F:/tools/s_video/ffmpeg/mencoder

        ConverVideoTest c = new ConverVideoTest();
        String yuanPATH = "F:\\tools\\s_video\\exaple\\MOVIE.AVI";  //本地源视频
//        String yuanPATH = "F:\\其他\\sdzc.rmvb";  //本地源视频
//        c.run(yuanPATH);
        c.run1(yuanPATH,"F:/tools/s_video/temp1/","F:/tools/s_video/finshvideo1/","F:/tools/s_video/finshimg1/");
    }

    /**
     *
     * @param yuanPATH 当前视频文件路径
     * @param videofolder 临时文件temp
     * @param targetfolder 转码之后的视频保存路径
     * @param imageRealPath 视频截图路径
     */
    public void run1(String yuanPATH,String videofolder,String targetfolder,String imageRealPath) {
        try {
            FileUtil.mkdir(videofolder);
            FileUtil.mkdir(targetfolder);
            FileUtil.mkdir(imageRealPath);
            // 转码和截图功能开始
            //String filePath = "D:/testfile/video/rmTest.rm";  //本地源视频测试
            String filePath = yuanPATH;                //web传入的源视频
            System.out.println("ConverVideoTest说:传入工具类的源视频为:" + filePath);



            ConverVideoUtils zout = new ConverVideoUtils(filePath,videofolder,targetfolder,imageRealPath);  //传入path
            String targetExtension = ".mp4";                //设置转换的格式
            boolean isDelSourseFile = true;

            //删除源文件
            boolean beginConver = zout.beginConver(targetExtension, isDelSourseFile);
            System.out.println(beginConver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //web调用
    public void run(String yuanPATH) {
        try {
            // 转码和截图功能开始
            //String filePath = "D:/testfile/video/rmTest.rm";  //本地源视频测试
            String filePath = yuanPATH;                //web传入的源视频
            System.out.println("ConverVideoTest说:传入工具类的源视频为:" + filePath);

            ConverVideoUtils zout = new ConverVideoUtils(filePath);  //传入path
            String targetExtension = ".mp4";                //设置转换的格式
            boolean isDelSourseFile = true;

            //删除源文件
            boolean beginConver = zout.beginConver(targetExtension, isDelSourseFile);
            System.out.println(beginConver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


