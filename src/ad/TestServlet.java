package ad;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.hotspot.DefaultExports;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ad.TestServlet")
public class TestServlet extends HttpServlet{

    public static final Counter req = Counter.build().name("hello_world_total").help("numbe rof hello world served").register();
    public static final Gauge GAUGE = Gauge.build().name("hello_gauge").help("help").register();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        req.inc();
        GAUGE.inc();
        response.setContentType("text/html");
        int a = Integer.parseInt(request.getParameter("fnn"));
        int b = Integer.parseInt(request.getParameter("snn"));
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1> " + (a+b) + "</h1>");
        DefaultExports.initialize();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
