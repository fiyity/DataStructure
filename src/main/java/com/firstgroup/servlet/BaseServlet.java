package com.firstgroup.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet",urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
         request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("service.....");
        //获取客户端提交到服务端的method对应的值

        String methodname=request.getParameter("method");

        System.out.println("method:"+methodname);

        //定义变量,存放功能执行完毕之后要转发的路径
        String path=null;

        //获取到当前字节码对象(ServletDemo02.class在内存中对象)
        Class<? extends BaseServlet> clazz = this.getClass();

        //System.out.println("Class:"+clazz.toString());

        try {
            //获取clazz上名称为md方法
            Method method=clazz.getMethod(methodname, HttpServletRequest.class,HttpServletResponse.class);

            //System.out.println("method:"+method);

            if(null!=method){
                //调用找到的方法
                path=(String)method.invoke(this, request,response);
            }
            if(null!=path){
                //服务端的转发
                request.getRequestDispatcher(path).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
