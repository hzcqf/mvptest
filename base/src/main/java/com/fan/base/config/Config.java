package com.fan.base.config;

/**
 * Created by ganzhubing on 2017/9/6.
 * <p>
 * 应用配置信息
 */

public class Config {

    /**
     * 服务器地址
     */
    //水利APP接口
//    public static final String DAYU_BASE_URL = "http://test-shuili.dayuteam.cn";//测试环境
    public static final String DAYU_BASE_URL = "http://shuili.dayuteam.cn";//生产环境

    //标准化模块接口
    public static final String STAND_BASE_URL = "http://139.196.226.102:9958/api/";
    public static final String STAND_BASE_URL_LOGIN = " http://139.196.226.102:3235/";

    public static final String MAXTRI_BASE_URL = "http://115.238.35.228/api/";

    //山洪模块接口
    public static final String API_BASE_URL = "http://api.dayuteam.cn";
    public static final String SHANHONG_URL = API_BASE_URL + "/sh/";//山洪模块

    /**
     * 点击防抖动  单位毫秒
     */
    public static final int TIME_THROTTLE = 2000;
    /**
     * text改变响应 单位毫秒
     */
    public static final int TIME_DEBOUNCE = 500;

    public static final int SCAN_REQUEST_CODE = 0x00000001;
}
