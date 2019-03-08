package com.pcitc.service.system;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.FileResult;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileExample;
import com.pcitc.base.system.SysFileVo;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.IndexAccessorService;

/**
 * <p>接口类</p>
 * <p>Table: sys_file - </p>
 *
 * @since 2018-05-08 02:04:50
 */
public interface SysFileService {

    /**
     * 创建文件
     *
     * @param file
     * @return
     */
    public File createFile(MultipartFile file);


    /**
     * 保存头像信息
     *
     * @param userId   用户ID
     * @param fileName 文件名
     * @param filePath 文件路径(相对路径)
     * @param dirPath  系统路径(绝对路径)
     */
    public String saveAvatar(String userId, String fileName, String filePath, String dirPath);

    /**
     * 创建文件
     *
     * @param file    文件
     * @param dirPath 文件存储路径
     * @return
     */
    public File createFile(MultipartFile file, String dirPath);

    /**
     * 删除文件
     */
    public void deleteSysFileByIdReal();

    long countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFile record);

    SysFile insertObject(SysFile record);

    int insertSelective(SysFile record);

    List<SysFile> selectByExample(SysFileExample example);

    SysFile selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);

    /**
     * 删除菜单
     *
     * @param sysMenuId
     * @return
     */
    DataOperationStatusEnum deleteSysFile(java.io.Serializable sysMenuId);

    /**
     * @param jsonStr 分页组件传过来的参数列表
     * @return
     */
    PageInfo<SysFile> findSysFileByPage(String jsonStr);

    int deleteSysFileReal(String menuId);

    List<TreeNode> selectObjectByTree();

    /**
     * 条件查询模块列表
     *
     * @param vo
     * @return
     * @throws Exception
     */
    JSONObject selectSysFileList(SysFileVo vo) throws Exception;

    /**
     * ES查询
     *
     * @param vo
     * @return
     * @throws Exception
     */
    JSONObject selectSysFileListEs(SysFileVo vo) throws Exception;

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    public LayuiTableData selectSysFileByPage(LayuiTableParam param);

    /**
     * Layui文件上传
     *
     * @param filePart
     * @param request
     * @param response
     * @param filename
     * @param filepathconfig
     * @param userid
     * @param uuid
     * @return
     */
    public String uploadFileSaveLayui(@RequestParam(value = "file", required = false) MultipartFile filePart,
                                      HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid,String formId,String flag);

    /**
     * 文件内容到ES
     *
     * @param sysFile
     * @return
     */
    public byte[] fileToEs(SysFile sysFile);

    /**
     * 获取预览信息
     *
     * @param result
     * @param request
     * @return
     */
    public FileResult getPreivewSettingsByController(@RequestBody FileResult result, HttpServletRequest request);

    /**
     * 文件回填缩略图
     *
     * @param fileList
     * @param request
     * @return
     */
    public FileResult getPreivewSettings(List<SysFile> fileList, HttpServletRequest request);

    /**
     * 获取文件列表
     *
     * @param fileIds
     * @param request
     * @return
     */
    public FileResult getFilesLayui(String fileIds, HttpServletRequest request);

    /**
     * 根据表单ID获取文件列表
     *
     * @param fileIds
     * @param request
     * @return
     */
    public FileResult getFilesLayuiByFormId(String fileIds, HttpServletRequest request);

    /**
     * 根据文件IDS获取文件信息
     *
     * @param fileIds
     * @param request
     * @return
     */
    public FileResult getFiles(String fileIds, HttpServletRequest request);

    /**
     * 判断文件是存在
     *
     * @param id
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public Object getFileFlag(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 图片预览
     *
     * @param id
     * @param request
     * @param response
     * @throws IOException
     */
    public void previewImgagByByteBase64(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response);
    /**
     * 单文件下载
     *
     * @param id
     * @param request
     * @param response
     * @throws IOException
     */
    public void downloadFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 单文件下载缩略图
     * @param id
     * @param request
     * @param response
     * @throws IOException
     */
    public void downloadFileViewPicThumbnail(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 多文件下载
     *
     * @param id
     * @param request
     * @param response
     * @throws IOException
     */
    public void downloadFiles(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 根据文件ID删除文件信息
     *
     * @param id
     * @param request
     * @return
     */
    public Result delete(String id, HttpServletRequest request);

    /**
     * 多文件上传
     *
     * @param files
     * @param request
     * @param response
     * @param filename
     * @return
     * @throws IOException
     */
    public FileResult uploadMultipleFile(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response, String filename) throws IOException;

    /**
     * 单文件上传
     *
     * @param filePart
     * @param request
     * @param response
     * @param filename
     * @param filepathconfig
     * @param userid
     * @param uuid
     * @return
     * @throws IOException
     */
    public List<SysFile> uploadFileSave(@RequestParam(value = "file", required = false) MultipartFile filePart,
                                        HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid) throws IOException;

    /**
     * 多文件上传解析到ES
     *
     * @param filePart
     * @param request
     * @param response
     * @param filename
     * @param filepathconfig
     * @param userid
     * @param uuid
     * @return
     * @throws IOException
     */
    public String uploadFileSavetest(@RequestParam(value = "file", required = false) MultipartFile filePart,
                                     HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid) throws IOException;

    /**
     * 根据文件名称获取icon
     *
     * @param fileName
     * @return
     */
    public String getFileIcon(String fileName);

    /**
     * 根据MD5值查询文件信息
     *
     * @param strFileMd5
     * @return
     */
    public List<SysFile> getSysFileByMd5(String strFileMd5);

    /**
     * ES基础服务
     *
     * @return
     */
    public AccessorService getAccessorService();

    /**
     * 接口服务
     *
     * @param accessor
     * @return
     */
    public IndexAccessorService getIndexAccessorService(AccessorService accessor);

    /**
     * 获取最大数量
     * @return
     */
    public String selectMaxEsId();

    /**
     * 根据表单ID更新文件状态
     * @param dataId
     */
    public void updateSysFileFlag(String dataId);

    /**
     * 根据表单ID删除
     * @param dataId
     */
    public void deleteSysFileByDataId(String dataId);
    
    /**
     * 文档管理的查询方法，查询公共的和分享给自己文件
     */
    public LayuiTableData selectFileListForPublic(LayuiTableParam param) throws Exception;
    
    /**
     * 复制文件数据到sys_file_version中
     */
    public int copySysFile(SysFile sysFile);
    
    /**
     * 获取文件历史版本信息
     */
    public LayuiTableData selectFileHistoryList(LayuiTableParam param);
    
    /**
     * 文档收藏的查询方法
     */
    public LayuiTableData selectFileListForCollect(LayuiTableParam param);
}
