package com.zhixing.result;

/**
 * All rights Reserved, Designed By zxbit.cn
 *
 * @version V1.0
 * @Title: ResultEnum
 * @Package com.zhixing.result
 * @Description: 结果集返回码的枚举类型
 * @author: 致行科技
 * @date: 18-6-4
 * @Copyright: All rights Reserved, Designed By zxbit.cn
 * 注意：本内容仅限于北京中睿致行科技技术股份有限公司传阅，禁止外泄以及用于其他的商业目的
 */
public enum ResultEnum {

    OK(200),
    ERROR(500),
    NOT_FOUND(404);

    private int codeValue;

    private ResultEnum(int codeValue){
        this.codeValue =codeValue;
    }

    public int resultCode(){
        return this.codeValue;
    }
}
