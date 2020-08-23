package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000119661942";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDIb7Clw1c6+nRCJNtHDeXLuboUyEMTaLOHD1Y/QtjEfkGR8EPe0Qu+yBk8ctsEv+VBZZ7VYh2aaWwqNViBPhKJrubL97Ur9yOMAP/kuPlMUUxJBeknvFS28iHJ932CtpBQHTuUUbVySjaJCLvaJsImA6wsYqUounAZ8XUhBkAAneLwIF/4PkjVJyYMZejRgF8GYyKk0k5N47gMnJgAusazpaEvfKJUwW/loxYvHlbNFBuwASZ74uJKdLj40i1CXBloGhTqTqza2G8O3/0+tVLr0xFOuvVDoX5AkC8j8JOBJlgkixlASsKEizwKXmwTLS6M3bAb3aXKxt4mIpkizYV5AgMBAAECggEBAJUxfd2FD5MZBhyN7qJvF9OTBY2emz8BOlCX++zOxydLi2cj3oEmPYXez9oM7DYW2IDbMWVHyR08x4SLfLuHBqlxhN3iHfsB1HXL8K3Bed9yzEO2oJwxNSWQCdKZ49S+K6FWgRif0V2nG/zYgWuaWf2N0kSfkKxGSlclQbg5PL63de8ccm2w5H9YFekWVDsDUhXAbrW/uROxsD2QHx6xMPANH9B/8YqgTbrzupVrC78wW2VL5K42AFSG1mieAwOMoh6bAVWgirSAxNVg/hpssxsisy9aBmFFwGG9TGwedzch+WzCaIYGytIrDnF2mHmYoillMv8+LAx2Tu+ZIHO6gQECgYEA6P9/2QkDdaIWEX0rQQnunr0r4+ZCrReLNWgZF8Mk03RS4e1N/G9+WFyA2xYLFOzx8sEfkpiMYghQZllM3P9e+CUXC+n6QFNO8MZfraAtYhONhGy+5cCsANcGxTCiC2o9ykwYaK+mOirXPC93y3s2m9vgKCYvvA9WypyI7kB2znECgYEA3DlD/+grdVXeCIPJntyYMz//dUoZSWM18sr3yhgoEqo1+qp///IJP5dQ8xTDcS2kuRfRahqtkf5H/h1kpyWtHNYqcl0yN3/zk5lhvWWGWRFWcllzVbiHNrHwB3upctktVv3C0URqjNEHcoSBavhe4Vs2amQb09MKaxp4w2h1O4kCgYEA3ilopPAkPVC8jBZ2XMB0pyUnKVmPr+2oDddhPbgTcBAVS1jzKETDCsvBDaVaEazQEjC0wxnzmTHmP4DcekiBLEhpTjHeLOGCfrAX4Ly/KSoNoPvzlax+FRryWKlDiXDW1AJ0r7Tz4bihm8CDECE+86PWe1HV6BIUJoLVSZ9r6PECgYEAg/xWQtN06FfUQKordmijV2PtyO/mA9PQC3mV1KtxqO4Wd+sj19PJszEPNQCmufgvFzetLLhcenk50JTxNDQicnvw6KXuaNDovPdaWta0FEGN2+68bw2vDBrMzs9QmSKMR+zCjAVDDq5glkPQBLpisxGlpVHmU6fSQKqW4haC3HECgYA2hJXE7/Qx8fUXv4SxxJ9g4QZlJ+YBZN/qKM8QTM/B3B9GIdFuxczKB9AQfBr89C2Q2MhKJCQBUOJRIgkxw1s+O+wK6O99pfTZ1243Q1R5m4B7vLey5AVWJPLu4EvF6f+v0po92vN6pt/ixMFtPHKd3K/w3Z3usvCzf051RWY5Yw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkanvSZcuoNIzIgx1HHqn9LmjX1xn6GVtIWtBt66g+2Ql+dHSFYldTXM2qPbJ12FbdnfZOxnZEZtwujY9Pom2VflzZ+n/jm96MWVVbJuL8A58P0BCWmU1U4V40+V0/LzCR3A+CypF7lm1wyL7LUpccJwOVOsvgGL4bF+V1CxyTadIt/mYrexDX6BYgmd5EUwik2gc1PoBCQfu3s1OhiZ1WGYDYZg0pPk8XjnltwPxwRrJiqEqnhSlxX5xqSO+9v0D2BGhtI8BxEEUXyG4OZFahCCiJ8H+cQxsaYeQJwOQztSdno0AyaSuHHFPWRdKs3X36cUYwhhFmDMsv/3uWpuzPwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/SportShopTest/index.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/SportShopTest/index.html";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";

	public static String FORMAT = "json";
//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

