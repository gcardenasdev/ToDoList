package ToDoFiles;
import java.util.List;
import entity.TodolistitemsEntity;
import ToDoFiles.ToDoApp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ToDoFiles.addItemServlet", value = "/ToDoFiles.addItemServlet")
public class addItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/ToDoUI.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String listItem = request.getParameter("toDoItem");
        ToDoApp.addListItem(listItem);

        getServletContext().getRequestDispatcher("/ToDoUI.jsp").forward(request, response);
    }
}