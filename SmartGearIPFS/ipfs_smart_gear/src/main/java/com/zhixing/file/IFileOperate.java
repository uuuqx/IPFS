package com.zhixing.file;


import io.ipfs.api.MerkleNode;

import java.io.File;
import java.util.List;

/**
 * All rights Reserved, Designed By zxbit.cn
 * @Title:  IFileOperate
 * @Package com.zhixing.file
 * @Description:    IPFS分布式网络存储操作接口
 * @author: 致行科技
 * @date:   2018.6.4
 * @version V1.0
 * @Copyright: All rights Reserved, Designed By zxbit.cn
 * 注意：本内容仅限于北京中睿致行科技技术股份有限公司传阅，禁止外泄以及用于其他的商业目的
 */
public interface IFileOperate {

    //上传文件
    MerkleNode uploadFile(File file);

    //批量上传文件
    List<MerkleNode> uploadFileBitch(List<File> fileLIst);

    //下载文件
    String fileName(String filePath,String fileHash);

    
}
