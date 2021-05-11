import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ChartServlet extends HttpServlet {
    private ChartUtils ChartUtilities;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        JFreeChart chart = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int width = 0;
        int height = 0;
        ChartUtilities.writeChartAsPNG(bos, chart, width, height);

        response.setContentType("image/png");
        OutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(bos.toByteArray());
        out.flush();
        out.close();
    }
}