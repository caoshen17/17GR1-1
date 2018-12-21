<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
                
	<script type="text/javascript" src="js/n_nav.js"></script>   
    
    <script type="text/javascript" src="js/num.js">
    	var jq = jQuery.noConflict();
    </script>     
    
    
    <script type="text/javascript" src="js/shade.js"></script>
    <script>
    function gouwu3(){
    	alert(jq("#zzzzz").text());
    	alert(jq(".add_ipt").val());
    	var zje=jq("#zzzzz").text();
    	var dizi=jq(".add_ipt").val();
    	jq.get("servlet/ProductServlet","pro=gouwu3&zje="+zje+"&dizi="+dizi,function(data){
    		if(data!=""&&data!=null){
    			jq(".mar_20").eq(0).empty();
    			jq(".mar_20").eq(1).empty();
    			jq(".mar_20").eq(0).append(
    					 "<table border='0' style='width:1000px; text-align:center;' cellspacing='0' cellpadding='0'>"+
    					  "<tr height='35'>"+
    		                "<td style='font-size:18px;'>"+
    		                	"感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color='#ff4e00'>"+data+"</font>"+
    		                "</td>"+
    		              "</tr>"+
    					"</table>"
    					);
    		}
    	});
    	
    }
    
    
    
    function gouwu2(){
    	var yhm=jq("#yonghuming").text();
    	alert(yhm);
    	var zje=jq(".fr b").html();
    	alert(zje);
    	var geshu=[];
    	jq(".car_ipt").each(function(i,v){
			geshu[i]=v.value;
    	});
    	
    	jq.getJSON("servlet/ProductServlet","pro=gouwu2",function(json){
    		alert(geshu);
    		alert(json);
    		var jn=jq(json);
    		jq(".mar_20").eq(0).empty();
    		jq(".mar_20").eq(0).append("<img src='images/img2.jpg' />");
    		jq(".mar_20").eq(1).empty();
    		jq(".mar_20").eq(1).append(
    				"<div class='two_bg'>"+
    	        	"<div class='two_t'>"+
    	            	"<span class='fr'><a href='#'>修改</a></span>商品列表"+
    	            "</div>"+
    	            "<table border='0' class='car_tab' style='width:1110px;' cellspacing='0' cellpadding='0'>"+
    	              "<tr>"+
    	                "<td class='car_th' width='550'>商品名称</td>"+
    	                "<td class='car_th' width='140'>属性</td>"+
    	                "<td class='car_th' width='150'>购买数量</td>"+
    	                "<td class='car_th' width='130'>小计</td>"+
    	                "<td class='car_th' width='140'>返还积分</td>"+
    	              "</tr>"+
    				"</table>"+
    				"</div>"
    				);
    		jn.each(function(i,v){
    			jq(".car_tab").append(
    					 "<tr>"+
    		                "<td>"+
    		                    "<div class='c_s_img'><img src='images/"+v.fileName+"' width='73' height='73' /></div>"+
    		                    ""+v.name+""+
    		                "</td>"+
    		                "<td align='center'>颜色：灰色</td>"+
    		                "<td align='center'>"+geshu[i]+"</td>"+
    		                "<td align='center' style='color:#ff4e00;'>￥"+v.price+"</td>"+
    		                "<td align='center'>26R</td>"+
    		              "</tr>"
    			);
    		});
    			jq(".mar_20").eq(1).append(
    					
    					"<div class='two_t'>"+
    	            	"<span class='fr'><a href='#'>修改</a></span>收货人信息"+
    	            "</div>"+
    	            "<table border='0' class='peo_tab' style='width:1110px;' cellspacing='0' cellpadding='0'>"+
    	              "<tr>"+
    	               "<td class='p_td' width='160'>收件人</td>"+
    	               "<td width='395'>"+yhm+"</td>"+
    	               "<td class='p_td' width='160'>电子邮件</td>"+
    	               "<td width='395'>12345678@qq.com</td>"+
    	              "</tr>"+
    	              "<tr>"+
    	                "<td class='p_td'>详细信息</td>"+
    	                "<td>四川省成都市武侯区</td>"+
    	                "<td class='p_td'>邮政编码</td>"+
    	                "<td>6011111</td>"+
    	              "</tr>"+
    	              "<tr>"+
    	                "<td class='p_td'>电话</td>"+
    	                "<td></td>"+
    	                "<td class='p_td'>手机</td>"+
    	                "<td>18600002222</td>"+
    	              "</tr>"+
    	              "<tr>"+
    	                "<td class='p_td'>标志建筑</td>"+
    	                "<td></td>"+
    	                "<td class='p_td'>最佳送货时间</td>"+
    	                "<td></td>"+
    	              "</tr>"+
    	            "</table>"+

    	            
    	            "<div class='two_t'>"+
    	            	"填写地址"+
    	            "</div>"+
    	            	"<table border='0' class='peo_tab' style='width:1110px;' cellspacing='0' cellpadding='0'>"+
    		            
    	                "<tbody>"+
    	            "<tr>"+
    	                "<td>"+
    	                    "地址&nbsp;<input type='text' value='' name='address' class='add_ipt'>&nbsp;"+
    	                "</td>"+
    	            "</tr>"+
    	       "</tbody></table>"+
    	       "<p align='right'><b style='font-size:14px;'>应付款金额：<span style='font-size:22px; color:#ff4e00;'>￥<span id='zzzzz'>"+zje+"</span></span></b></p>"+
    	       "<p align='right'><a href='#' onclick='gouwu3()'><img src='images/btn_sure.gif' /></a></p>"
    					);
    	});
    	
    	
    }
    
    function del(id){
    	jq.getJSON("servlet/ProductServlet","pro=sanchu&id="+id,function(data){
    		if(data="true"){
    			window.location.reload();
    		}
    	});
    	
    }
    
    
    jq(function(){
    	
    	
    	jq(".car_btn_1").click(function(){
    		//jian
    		var money=0;
    		var addjiage=[];
    		var addgeshu=[];
    		jq(".xxprice").each(function(i,v){
        		var ss=jq(this).text();
        		addjiage[i]=parseInt(ss);
        	});
    		jq(".car_ipt").each(function(i,v){
    			addgeshu[i]=v.value;
        	});
    		for(var i=0;i<addjiage.length;i++){
    			money+=parseInt(addjiage[i])*parseInt(addgeshu[i]);
    		}
    		jq(".fr b").html(money);
    		
    	});
    	jq(".car_btn_2").click(function(){
    		var money=0;
    		var addjiage=[];
    		var addgeshu=[];
    		jq(".xxprice").each(function(i,v){
        		var ss=jq(this).text();
        		addjiage[i]=parseInt(ss);
        	});
    		jq(".car_ipt").each(function(i,v){
    			addgeshu[i]=v.value;
        	});
    		for(var i=0;i<addjiage.length;i++){
    			money+=parseInt(addjiage[i])*parseInt(addgeshu[i]);
    		}
    		jq(".fr b").html(money);
    	});
    });
    
    
    
    </script>
<title>尤洪</title>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr"> <c:if test="${not empty sessionScope.name}">
					<span class="fl"><a id="yonghuming" href="#">${sessionScope.name}</a>&nbsp;|</span>
				</c:if> <c:if test="${empty sessionScope.name}">
					<span class="fl"><a href="Login.jsp">您还未登录</a>&nbsp;|</span>
				</c:if> <span class="fl">&nbsp;<a href="#">我的订单</a>&nbsp;|
			</span> <span>&nbsp;<a href="servlet/UserServlet?&&pro=zx">注销</a></span>
			</span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="Index.jsp"><img src="images/logo.png" /></a></div>
    <div class="search">
    	<form>
        	<input type="text" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>                      
        <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
    </div>
    <div class="i_car">
    	<div class="car_t">购物车[ 
    	<span>
    	<c:set value="${fn:length(sessionScope.listgouwuche)}" var="qqq">
		</c:set>
				<c:forEach items="${sessionScope.listgouwuche}" var="q">
				<c:if test="${q.id=='999999999'}">
				<c:set value="${fn:length(sessionScope.listgouwuche)-1}" var="qqq">
				</c:set>
				</c:if>
				</c:forEach>
				${qqq}
				</span>
    	 ]</div>
        <div class="car_bg">
       		<!--Begin 购物车未登录 Begin-->
       		<c:if test="${empty sessionScope.name}">
        	<div class="un_login">还未登录！<a href="Login.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
       		</c:if>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
            <c:set value="0" var="num"></c:set>
            	<c:forEach items="${sessionScope.listgouwuche}" var="gwc">
			    <c:if test="${gwc.id!='999999999'}">
            	<c:set value="${num+gwc.price}" var="num" />  
            	<li>
            		<div class="img"><a href="#"><img src="images/${gwc.fileName}" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">${gwc.name}</a></div>
                    <div class="price"><font color="#ff4e00">￥${gwc.price}</font> X1</div>
            	 </li>
            	 </c:if>
            	</c:forEach>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>${num}</span></div>
            <div class="price_a"><a href="#">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">                                                                                                                                               
        	<li><a href="Index.html">首页</a></li>
            <li><a href="Food.html">美食</a></li>
            <li><a href="Fresh.html">生鲜</a></li>
            <li><a href="HomeDecoration.html">家居</a></li>
            <li><a href="SuitDress.html">女装</a></li>
            <li><a href="MakeUp.html">美妆</a></li>
            <li><a href="Digital.html">数码</a></li>
            <li><a href="GroupBuying.html">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 
<div class="i_bg">  
    <div class="content mar_20">
    	<img src="images/img1.jpg" />        
    </div>
    
    <!--Begin 第一步：查看购物车 Begin -->
    <div class="content mar_20">
    	<table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
          <tr>
            <td class="car_th" width="490">商品名称</td>
            <td class="car_th" width="140">属性</td>
            <td class="car_th" width="150">购买数量</td>
            <td class="car_th" width="130">小计</td>
            <td class="car_th" width="140">返还积分</td>
            <td class="car_th" width="150">操作</td>
          </tr>
         
           <c:forEach items="${sessionScope.listgouwuche}" var="gw" varStatus="vs">
          
             <c:if test="${gw.id!='999999999'}">
          <c:if test="${vs.index%2==0}">
          <tr>
          </c:if>
          <c:if test="${vs.index%2==1}">
          <tr class="car_tr">
          </c:if>
		  <td>
		     <div class="c_s_img"><img src="images/${gw.fileName}" width="73" height="73" /></div>
              ${gw.name}      
          </td>
          <td align="center">颜色：灰色</td>
           <td align="center">
            	<div class="c_num">
                    <input type="button" value="" onclick="jianUpdate1(jq(this));" class="car_btn_1" />
                    <input type="hidden" value="${gw.id}" class="sp">
                	<input type="text" value="1" name="" class="car_ipt" />  
                    <input type="button" value="" onclick="addUpdate1(jq(this));" class="car_btn_2" />
                </div>
            </td>
           <td align="center" class="xxprice" style="color:#ff4e00;">${gw.price}</td>
            <td align="center">26R</td>
            <td align="center"><a onclick="del(${gw.id})">删除</a>&nbsp; &nbsp;<a href="#">加入收藏</a></td>
          
          </tr>
          </c:if>
          </c:forEach>
         
          
          <tr height="70">
          	<td colspan="6" style="font-family:'Microsoft YaHei'; border-bottom:0;">
            	<label class="r_rad"><input type="checkbox" name="clear" checked="checked" /></label><label class="r_txt">清空购物车</label>
                <span class="fr">商品总价：<b style="font-size:22px; color:#ff4e00;">${num}</b></span>
            </td>
          </tr>
          <tr valign="top" height="150">
          	<td colspan="6" align="right">
            	<a href="Index.jsp"><img src="images/buy1.gif" /></a>&nbsp; &nbsp; <a onclick="gouwu2()" href="#"><img src="images/buy2.gif" /></a>
            </td>
          </tr>
        </table>
        
    </div>
	<!--End 第一步：查看购物车 End--> 
    
    
    <!--Begin 弹出层-删除商品 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">             
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="images/close.gif" /></span>
            </div>
            <div class="notice_c">
           		
                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td>您确定要把该商品移除购物车吗？</td>
                  </tr>
                  <tr height="50" valign="bottom">
                    <td><a href="#" class="b_sure">确定</a><a href="#" class="b_buy">取消</a></td>
                  </tr>
                </table>
                    
            </div>
        </div>
    </div>    
    <!--End 弹出层-删除商品 End-->
    
    
    <!--Begin Footer Begin -->
    <div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
        	<a href="#" class="b_sh1">新浪微博</a>            
        	<a href="#" class="b_sh2">腾讯微博</a>
            <p>
            服务热线：<br />
            <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118" /></div>
            <img src="images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
