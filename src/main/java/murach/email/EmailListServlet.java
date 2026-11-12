package murach.email;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.Survey;
import murach.business.User;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String url = "/index.html";

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.html";    // the "join" page
        }
        else if (action.equals("add")) {
            // thông tin người dùng
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dob");

            // thông tin khảo sát (checkbox không tick thì getParameter trả về null)
            String source = request.getParameter("heardFrom");
            boolean receiveAnnouncements = request.getParameter("wantsAnnouncements") != null;
            boolean receiveOffers = request.getParameter("wantsEmail") != null;
            String contactMethod = request.getParameter("contactBy");

            User user = new User(firstName, lastName, email, dateOfBirth);
            Survey survey = new Survey(source, receiveAnnouncements, receiveOffers, contactMethod);
            // UserDB.insert(user);

            request.setAttribute("user", user);
            request.setAttribute("survey", survey);

            url = "/thanks.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}