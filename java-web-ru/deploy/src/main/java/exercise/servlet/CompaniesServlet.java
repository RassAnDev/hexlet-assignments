package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> companiesList = getCompanies();
        List<String> resultList = new ArrayList<>();
        PrintWriter out = response.getWriter();

        if (request.getQueryString() == null || request.getParameter("search") == null) {
            out.println(String.join("\n", companiesList));
        } else if (request.getQueryString().contains("search")) {
            resultList = companiesList.stream()
                            .filter(elem -> elem.contains(request.getParameter("search")))
                                    .collect(Collectors.toList());

            if (resultList.isEmpty()) {
                out.println("Companies not found");
            } else {
                out.println(String.join("\n", resultList));
            }
        }

        // END
    }
}
