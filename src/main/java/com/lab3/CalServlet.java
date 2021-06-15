package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {

    public double add(double firstVal,double secondVal){
        return firstVal+secondVal;
    }

    public double subtract(double firstVal,double secondVal){
        return firstVal-secondVal;
    }

    public double multiply(double firstVal,double secondVal){
        return firstVal*secondVal;
    }

    public double divide(double firstVal,double secondVal){
        return firstVal/secondVal;
    }

    public int computerLength(String name){
        return name.trim().length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstVal=request.getParameter("firstVal")!=null?Double.parseDouble(request.getParameter("firstVal")):0.0;
        double secondVal=request.getParameter("secondVal")!=null?Double.parseDouble(request.getParameter("secondVal")):0.0;
        String name=request.getParameter("name");
        String action=request.getParameter("action");
        if(action.equals("add")){
            double result=add(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("subtract")){
            double result=subtract(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("multiply")){
            double result=multiply(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("divide")){
            double result=divide(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }
        else if(action.equals("computeLength")){
            double result=computerLength(name);
            Cookie cName=new Cookie("cName",name);
            Cookie cLength=new Cookie("cLength",String.valueOf(result));
            response.addCookie(cName);
            response.addCookie(cLength);
        }

        response.sendRedirect("/2019211001000922LuoJing_war_exploded/lab3/cal.jsp");
    }
}