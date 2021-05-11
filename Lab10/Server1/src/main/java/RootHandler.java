import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {

    private ChartUtils ChartUtilities;
    private Chart chart;

    public RootHandler(Chart chart) {
        this.chart = chart;
    }

    @Override
    public void handle(HttpExchange he) throws IOException {
        String port = "4000";
        String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + port + "</h1>";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int width = 0;
        int height = 0;
        //ChartUtilities.writeChartAsPNG(bos, (JFreeChart) chart, width, height);
        HttpServletResponse response1 = null;
        response1.setContentType("image/png");
        OutputStream out = new BufferedOutputStream(response1.getOutputStream());
        os.write(bos.toByteArray());

        os.close();
    }

}