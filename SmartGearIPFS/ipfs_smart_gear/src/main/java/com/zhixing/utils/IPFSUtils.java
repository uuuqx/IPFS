package com.zhixing.utils;

import io.ipfs.api.IPFS;

/**
 * All rights Reserved, Designed By zxbit.cn
 * @Title:  IPFSUtils
 * @Package com.zhixing.utils
 * @Description:    获取IPFS的操作对象
 * @author: 致行科技
 * @date:   2018.6.4
 * @version V1.0
 * @Copyright: All rights Reserved, Designed By zxbit.cn
 * 注意：本内容仅限于北京中睿致行科技技术股份有限公司传阅，禁止外泄以及用于其他的商业目的
 */
public class IPFSUtils {

    private static IPFS ipfs;

    private IPFSUtils(){}

    public static synchronized IPFS getInstance(){
        if(ipfs == null){
            System.out.println("创建Car对象");
            ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        }
        return ipfs;
    }


}
