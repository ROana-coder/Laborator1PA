import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;


public class Chart extends JFrame {

    private ArrayList<ClientThread> names = new ArrayList<>();

    public Chart(ArrayList<ClientThread> names) {

        this.names = names;
        initUI();
    }

    private void initUI() {

        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Pie chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private DefaultPieDataset createDataset() {

        var dataset = new DefaultPieDataset();
        dataset.setValue("Oana",1);
        dataset.setValue("Ioana",1);
        dataset.setValue("Ana",1);
        dataset.setValue("Maria",2);

        return dataset;
    }

    private JFreeChart createChart(DefaultPieDataset dataset) {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "users",
                dataset,
                false, true, false);

        return pieChart;
    }


}