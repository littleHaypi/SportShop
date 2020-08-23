package com.nll.Sport.Controller;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alipay.api.AlipayApiException;

import com.alipay.api.AlipayClient;

import com.alipay.api.DefaultAlipayClient;

import com.alipay.api.request.AlipayTradePagePayRequest;

import com.alipay.config.AlipayConfig;

 
@WebServlet("/payController")
public class payController extends HttpServlet {

	private static final long serialVersionUID = -3651501917721983601L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		//初始化

		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,

															AlipayConfig.app_id,

															AlipayConfig.merchant_private_key,

															AlipayConfig.FORMAT,

															AlipayConfig.charset,

															AlipayConfig.alipay_public_key,

															AlipayConfig.sign_type);

	        //创建API对应的request

	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

	        //在公共参数中设置回跳和通知地址

	        alipayRequest.setReturnUrl(AlipayConfig.return_url);

	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

	        

	        //填充业务参数

	        

	        //必填

	        //商户订单号，需保证在商户端不重复

	        String out_trade_no = "20181037"+new Date();

	        //销售产品码，与支付宝签约的产品码名称。目前仅支持FAST_INSTANT_TRADE_PAY 

	        String product_code = "FAST_INSTANT_TRADE_PAY";

	        //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。
	        HttpSession session=request.getSession();
	       
	        Object total_amount=session.getAttribute("totalPrice");

	        //订单标题

	        String subject = "支付宝测试";

	        

	        //选填

	        //商品描述，可空

	        String body = "商品描述";

	        

	        alipayRequest.setBizContent("{" +

	                "\"out_trade_no\":\"" + out_trade_no + "\"," +

	                "\"product_code\":\"" + product_code + "\"," +

	                "\"total_amount\":\"" + total_amount + "\"," +

	                "\"subject\":\"" + subject + "\"," +

	                "\"body\":\"" + body + "\"}" );

	        //请求

	        String form = "";

			try {

				form = alipayClient.pageExecute(alipayRequest).getBody();//调用SDK生成表单

				

			} catch (AlipayApiException e) {

				e.printStackTrace();

				response.getWriter().write("捕获异常出错");

		        response.getWriter().flush();

		        response.getWriter().close();

			}

			response.setContentType("text/html;charset=" + AlipayConfig.charset);

	        response.getWriter().write(form);//直接将完整的表单html输出到页面

	        response.getWriter().flush();

	        response.getWriter().close();

 

	}

 

	public void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		

	}

 

}
