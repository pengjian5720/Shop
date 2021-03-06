<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/5/31
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>briup电子商务-首页</title>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/icons.css" />
    <link rel="stylesheet" href="css/table.css" />
    <script type="text/javascript">
        function reduceCount(){
            var numObj = document.getElementsByName("num")[0];
            if(parseInt(numObj.value)>1){
                numObj.value = parseInt(numObj.value)-1;
            }
        }
        function addCount(){
            var numObj = document.getElementsByName("num")[0];
            numObj.value = parseInt(numObj.value)+1;
        }
        function submitForm(){
            document.getElementById("addCar").submit();
        }
    </script>
</head>
<body>
<!--顶部-->
<jsp:include page="include/header.jsp" flush="true"/>
<!--头部-->
<div class="header3">
    <a href="#"><img src="images/logo.png"></a>
    <div class="h3_center">
        <div class="search_box">
            <input type="text"/>
            <span>搜索</span>
        </div>
        <p>
            <a href="#">文学类</a>|
            <a href="#">教育类</a>|
            <a href="#">计算机</a>|
            <a href="#">儿童类</a>|
            <a href="#">漫画类</a>|
        </p>
    </div>
    <div class="h3_right">
        <div class="myyy">
            个人信息
            <span class="sj_down"></span>
        </div>
        <div class="tsc">
            <a href="shopCart.html">去购物车结算</a>
            <span class="sj_right"></span>
        </div>
    </div>
</div>
<!--头部导航-->
<div class="nav_top">
    <div class="nav_top_center">
        <div>
            全部图书分类
        </div>
        <ul>
            <li><a href="#">文学类</a></li>
            <li><a href="#">教育类</a></li>
            <li><a href="#">计算机</a></li>
            <li><a href="#">儿童类</a></li>
            <li><a href="#">漫画类</a></li>
        </ul>
    </div>
</div>

<div class="container5">
    <div class="cn5_top">
        <div class="cn5_top_x center01">
            <a class="font20" href="#">书籍</a> >
            <a href="#">计算机类</a>
        </div>
        <div class="cn5_top_y center01">
            <div class="cn5topy_1">
                <div class="cn5topy_imgview">
                    <img src="${requestScope.book.image}"/>
                    <!-- <ul class="cn5topy_imglist">
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li class="current"><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                    </ul> -->
                </div>
            </div>
            <div class="cn5topy_2">
                <h1 class="pro_title font15">${requestScope.book.name}</h1>
                <div class="pro_price">
                    <div class="pro_price_x">
                        <p> briup价：<b>￥${requestScope.book.price}</b> <a href="#">(降价通知)</a></p>
                    </div>

                </div>
                <!-- <div>
                    <ul>
                        <li><span>作者：</span>托马斯</li>
                        <li></li>
                        <li></li>
                    </ul>
                </div> -->
                <div class="pro_selects">
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">作者：</div>
                        <ul class="pro_select_vals">
                            <li>${requestScope.book.author}</li>

                        </ul>
                    </div>
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">出版社：</div>
                        <ul class="pro_select_vals">
                            <li> ${requestScope.book.publisher}</li>

                        </ul>
                    </div>
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">书籍介绍：</div>
                        <ul class="pro_select_vals">
                            <li> 出版时间：${requestScope.book.pubDate}</li>
                            <li>包装：平装</li>
                            <li>正文语种：中文</li>
                        </ul>
                    </div>
                </div>
                <form action="AddToShopCartServlet" id="addCar" method="post">
                    <div class="pro_buy">
                        <div class="pro_buy_nums">
                            <input type="text" value="1" name="num"/>
                            <input type="hidden" name="bookId" value="${requestScope.book.id}">
                            <dl>
                                <dd onclick="addCount()">+</dd>
                                <dd onclick="reduceCount()">-</dd>
                            </dl>
                        </div>
                        <div class="pro_addshop" onclick="submitForm()">加入购物车</div>
                    </div>
                </form>
                <div class="pro_ship">
                    <div>
                        <div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
                        <ul class="pro_service f1">
                            <li class="service_fq">分期付款</li>
                            <li class="service_myf">免运费</li>
                            <li class="service_zt">自提</li>
                            <li class="service_th">7天无理由退换货</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="c5_b2">

        <div class="c5_b2_right">
            <!--选项卡-->
            <ul class="c5_b2_tabs">
                <li>商品介绍</li>
                <li class="current">规格参数</li>
                <li>包装清单</li>
                <li>商品评价</li>
            </ul>
            <!--内容-->
            <div class="c5_b2_right_1 box">
                <div class="introduce_item">
                    <ul>
                        <li>商品名称：${requestScope.book.name}</li>
                        <li>商品编号：${requestScope.book.id}</li>
                        <li class="fr"><a class="color_link1" href="#">更多参数>></a></li>
                    </ul>
                </div>
            </div>
            <div class="intro_pics">
                <img class="intro_pic" src="${requestScope.book.image}">
            </div>
        </div>


        <div class="c5_b2_right">
            <div class="c5_b2_right_2">
                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

            </div>
        </div>

        <!--左侧栏-->
        <div class="c5_b2_left_container">
            <div class="c5_b2_left box">
                <h1>服务时间 早9：00~凌晨1：00</h1>
                <p>
                    <a href="#">
                        <img class="callmebyqq" src="images/icon_qq_03.png"/>
                    </a>
                </p>
            </div>

            <div class="c5_b2_left box">
                <h1>其他种类</h1>
                <dl>
                    <dd>文学类</dd>
                    <dd>漫画类</dd>
                    <dd>通书类</dd>
                </dl>
                <dl>
                    <dd>文学类</dd>
                    <dd>漫画类</dd>
                    <dd>通书类</dd>
                </dl>
            </div>
        </div>
    </div>
</div>

<div class="c20"></div>
<!--脚部-->
<jsp:include page="include/footer.jsp" flush="true"></jsp:include>

</body>
</html>
