<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/5/25
  Time: 15:00
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
  <link rel="stylesheet" type="text/css" href="css/turn.css">

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
<%--  <div class="h3_right">--%>
<%--    <div class="myyy">--%>
<%--      个人信息--%>
<%--      <span class="sj_down"></span>--%>
<%--    </div>--%>
<%--    <div class="tsc">--%>
<%--      <a href="shopCart.html">去购物车结算</a>--%>
<%--      <span class="sj_right"></span>--%>
<%--    </div>--%>
<%--  </div>--%>
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

<div class="container3">
  <div class="c3_b1">
    <%--展示所有分类--%>
    <div class="c3_b1_left">
      <dl>
        <c:forEach var="category" items="${applicationScope.categoryList}">
          <dd>
            <h1>${category.name}</h1>
            <p>
              <c:forEach var="category1" items="${category.categories}">
                <a href="BookListServlet?categoryName0=${category.name}&categoryName=${category1.name}">${category1.name}</a>
              </c:forEach>
            </p>
          </dd>
        </c:forEach>
      </dl>
    </div>
    <div class="c3_b1_center">
      <div class="carousel" id="carousel">
        <div class="btns">
          <a href="javascript:;" class="leftBtn" id="leftBtn"></a>
          <a href="javascript:;" class="rightBtn" id="rightBtn"></a>
        </div>
        <div class="m_unit" id="m_unit">
          <ul>
            <li><a href="#"><img src="images/ad1.png" alt="" /></a></li>
            <li><a href="#"><img src="images/ad1.png" alt="" /></a></li>
            <li><a href="#"><img src="images/ad1.png" alt="" /></a></li>
            <li><a href="#"><img src="images/ad1.png" alt="" /></a></li>
            <li><a href="#"><img src="images/ad1.png" alt="" /></a></li>
          </ul>
        </div>
        <div class="circles" id="circles">
          <ol>
            <li class="cur"></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
          </ol>
        </div>
      </div>
      <div class="c3_b1_c_bottom">
        <ul>
          <li>
            <a href="viewBook.html"><img src="images/p01.png"/></a>
            <a href="viewBook.html">Java从入门到精通</a>
          </li>
          <li>
            <a href="viewBook.html"><img src="images/p01.png"/></a>
            <a href="viewBook.html">Java从入门到精通</a>
          </li>
          <li>
            <a href="viewBook.html"><img src="images/p01.png"/></a>
            <a href="viewBook.html">Java从入门到精通</a>
          </li>
        </ul>
      </div>
    </div>
    <div class="c3_b1_right">
      <h1>杰普快报<a href="#">更多</a></h1>
      <ul>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
        <li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
      </ul>
    </div>
    <div style="clear:both"></div>
  </div>
  <div class="c3_b2">
    <ul>
      <c:forEach var="book" items="${applicationScope.bookList}" end="5">
        <li>
          <div class="c3_b2_txt">
            <h1>${book.name}</h1>
            <p>${book.author}</p>
            <h2>${book.publisher}</h2>
            <h2>${book.description}</h2>
            <p><a href="FindBookServlet?bookId=${book.id}">更多精彩，点击进入</a></p>
          </div>
          <a href="FindBookServlet?bookId=${book.id}"><img class="img1" src="${book.image}"></a>
        </li>
      </c:forEach>
    </ul>
  </div>
</div>
<div class="c20"></div>

<!--脚部-->
<jsp:include page="include/footer.jsp" flush="true"></jsp:include>
<script type="text/javascript" src="js/animate-2.0.1.js"></script>
<script type="text/javascript" src="js/turn.js"></script>
</body>
</html>
