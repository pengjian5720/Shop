<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/5/31
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--顶部-->
<div class="top">
    <div class="top_center">
        <ul class="top_bars">
            <li><a href="#">${sessionScope.customer.name}</a>|</li>
            <li><a href="${applicationScope.url}">${applicationScope.status}</a>|</li>
            <li><a href="/Shop_war_exploded/privatePage/shopCart.jsp">购物车<span class="jt_down"></span></a>|</li>
            <li><a href="/Shop_war_exploded/privatePage/confirm.jsp">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="/Shop_war_exploded/index.jsp">首页<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>

