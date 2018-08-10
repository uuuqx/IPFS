package com.zhixing.result;


/**
 * All rights Reserved, Designed By zxbit.cn
 *
 * @version V1.0
 * @Title: Result
 * @Package com.zhixing.result
 * @Description: 结果返回对象
 * @author: 致行科技
 * @date: 18-6-4
 * @Copyright: All rights Reserved, Designed By zxbit.cn
 * 注意：本内容仅限于北京中睿致行科技技术股份有限公司传阅，禁止外泄以及用于其他的商业目的
 */
public class Result {

    //返回码
    private int code;

    //返回的文件名称
    private String fileName;

    //返回上传成功之后的hash串
    private String fileHash;

    public Result(){
        this.code = ResultEnum.NOT_FOUND.resultCode();
        this.fileName = "";
        this.fileHash = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(ResultEnum resultEnum) {
        this.code = resultEnum.resultCode();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public String toJSONString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"code\":");
        stringBuffer.append(this.getCode());
        stringBuffer.append(",");
        stringBuffer.append("\"fileName\":");
        stringBuffer.append("\""+this.getFileName()+"\"");
        stringBuffer.append(",");
        stringBuffer.append("\"fileHash\":");
        stringBuffer.append("\""+this.getFileHash()+"\"");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
