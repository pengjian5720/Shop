package com.briup.web.servlet;

import com.briup.bean.Book;
import com.briup.bean.ShopCar;
import com.briup.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddToShopCartServlet")
public class AddToShopCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品id、商品数量
        request.setCharacterEncoding("utf-8");
        Integer num = Integer.parseInt(request.getParameter("num"));
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        //获取书籍信息
        BookServiceImpl bookService=new BookServiceImpl();
        Book book = bookService.findBookById(bookId);
        //如果是第一次则将购物车保存到session中，如果不是，则直接添加到session中
        HttpSession session = request.getSession();
        Object object = session.getAttribute("shopCar");
        ShopCar shopCar = null;
        if (object == null) {
            shopCar=new ShopCar();
            session.setAttribute("shopCar",shopCar);
        }else {
            shopCar=(ShopCar) object;
        }
        shopCar.add(book,num);
        //返回添加成功的信息
        response.sendRedirect("privatePage/shopCart.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
