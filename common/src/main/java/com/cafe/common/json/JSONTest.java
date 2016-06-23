package com.cafe.common.json;

import com.cafe.common.log.CafeLogger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author leishaobo
 * @version 2016年6月21日
 */
public class JSONTest {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        testJsonArray();
    }

    public static void testJsonObject() {
        // 创建JSONObject
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "lwc");
        jsonObject.put("password", "123");
        CafeLogger.log(jsonObject);
        // 增加属性
        jsonObject.element("sex", "男");
        CafeLogger.log(jsonObject);
        // 读取属性
        CafeLogger.log(jsonObject.get("sex"));

        CafeLogger.log(jsonObject.isArray());
        CafeLogger.log(jsonObject.isEmpty());
        CafeLogger.log(jsonObject.isEmpty());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "lsb");
        jsonArray.add(1, "25");
        jsonObject.put("detail", jsonArray);
        CafeLogger.log(jsonObject);
    }

    public static void testJsonArray() throws Exception {
        // 创建JSONArray
        JSONArray jsonArray = new JSONArray();
        jsonArray.element("lwc");
        jsonArray.element("nxj");
        jsonArray.element("mxj");
        // 打印:1
        CafeLogger.log(jsonArray);
        try {
            CafeLogger.log(jsonArray.get(1));
        } catch (Exception e) {
            throw new Exception(e);
        }

        // 根据下标设置新值,打印:3
        jsonArray.set(0, "itlwc");// 覆盖
        CafeLogger.log(jsonArray);

        // 把JSONObject放入到JSONArray中
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "lwc");
        jsonObject.put("password", "123");
        // 开始增加,打印:4
        jsonArray.add(jsonObject);
        CafeLogger.log(jsonArray);

    }

}
