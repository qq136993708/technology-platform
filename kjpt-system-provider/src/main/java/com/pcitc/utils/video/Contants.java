package com.pcitc.utils.video;

/**
 * @author:Administrator
 * @date:2019/4/22
 */
public class Contants {

    /**
     * @Description:(3.工具类主类)设置转码工具的各个路径
     * @param:@param args
     * @version:V1.0
     */
    //通过读取配置文件赋值
    public static final String ffmpegpath = "F:/tools/s_video/ffmpeg/ffmpeg.exe";        // ffmpeg工具安装位置
    public static final String mencoderpath = "F:/tools/s_video/ffmpeg/mencoder";    // mencoder工具安装的位置

    //通过文件上传代码传入;需要创建文件夹
    public static final String videofolder = "F:/tools/s_video/temp/";    // 需要被转换格式的视频目录
//    public static final String videoRealPath = "F:/tools/s_video/temp/";    // 需要被截图的视频目录

    //通过文件上传代码传入
    public static final String targetfolder = "F:/tools/s_video/finshvideo/"; // 转码后视频保存的目录
    public static final String imageRealPath = "F:/tools/s_video/finshimg/"; // 截图的存放目录

}
