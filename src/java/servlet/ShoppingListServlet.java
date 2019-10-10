/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 759841
 */
public class ShoppingListServlet extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response); 
        doEverything(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doEverything(request,response);
    }

    private void doEverything(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        HttpSession session = request.getSession();
        
        String name = request.getParameter("userName");
        String action = request.getParameter("action");
        
        
        
        if(action.equals("Register"))
        {
            session.setAttribute("nameR", name);
            request.setAttribute("userName", name);
            
            ArrayList<String> itemList = new ArrayList<>();
            session.setAttribute("LIST", itemList);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
        
            
        }
        else if(action.equals("Logout"))
        {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response); 
        
            
        }
        else if (action.equals("Add"))
        {
            
            
            ArrayList<String> addList = (ArrayList) session.getAttribute("LIST");
            String item = request.getParameter("item");
            
            addList.add(item);
            session.setAttribute("LIST", addList);
            request.setAttribute("itemList", addList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
        
        }
        else if(action.equals("Delete"))
        {
            ArrayList<String> delList = (ArrayList) session.getAttribute("LIST");
            String selectItem = request.getParameter("selected");
            
            delList.remove(selectItem);
            
            session.setAttribute("LIST", delList);
            request.setAttribute("itemList", delList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
        
        }
        
       
        
        
        //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
        
        
        }

     

}
