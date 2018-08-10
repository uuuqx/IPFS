package com.zhixing.file.impl;

import com.zhixing.file.IFileOperate;
import com.zhixing.utils.IPFSUtils;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By zxbit.cn
 *
 * @version V1.0
 * @Title: FileOperate
 * @Package com.zhixing.file.impl
 * @Description: IPFS分布式网络存储操作接口实现
 * @author: 致行科技
 * @date: 18-6-4
 * @Copyright: All rights Reserved, Designed By zxbit.cn
 * 注意：本内容仅限于北京中睿致行科技技术股份有限公司传阅，禁止外泄以及用于其他的商业目的
 */
public class FileOperate implements IFileOperate {

    //获取操作IPFS的操作对象
    IPFS ipfs = IPFSUtils.getInstance();

    //上传单个文件
    public MerkleNode uploadFile(File file) {
        MerkleNode merkleNode = null;
        if (null == file){
            return merkleNode;
        }
        NamedStreamable.FileWrapper fileWrapper = new NamedStreamable.FileWrapper(file);
        try{
            MerkleNode addResult = ipfs.add(fileWrapper).get(0);
            return addResult;
        }catch (IOException e){
            return merkleNode;
        }
    }

    public List<MerkleNode> uploadFileBitch(List<File> fileList) {
        List<MerkleNode> addResultList = null;

        if (fileList.size() < 0){
            return addResultList;
        }

        List<NamedStreamable> fileWrapperLIst = new ArrayList<NamedStreamable>();
        for (File file : fileList) {
            NamedStreamable.FileWrapper fileWrapper = new NamedStreamable.FileWrapper(file);
            fileWrapperLIst.add(fileWrapper);
        }

        try{
            addResultList = ipfs.add(fileWrapperLIst,false);
            return addResultList;
        }catch (IOException e){
            return addResultList;
        }
    }

    public String fileName(String filePath, String fileHash) {
        Multihash filePointer = Multihash.fromBase58(fileHash);
        byte[] fileContents = null;
        String resultStr=""; //返回集合
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try{
            ipfs.pin.add(filePointer);//把hash文件缓存到本地IPFS网络中
            fileContents = ipfs.cat(filePointer);
        }catch(IOException e){
            return resultStr;
        }
        if(fileContents.length <= 0){
            return resultStr;
        }
        File dir = new File(filePath); //保存路径
        if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
            dir.mkdirs();
        }
        resultStr = filePath+"/"+ fileHash; //文件路径以及文件名
        File file = new File(resultStr);
        try{    //文件输出到硬盘位置
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(fileContents);
            return resultStr;
        }catch (Exception e){
            resultStr = "";
            return resultStr;
        }finally {
            try{
                if (fos != null){
                    fos.flush();
                    fos.close();
                }
                if (bos != null){
                    bos.flush();
                    bos.close();
                }
            }catch (Exception e2){
                e2.getStackTrace();
            }
        }
    }
}
