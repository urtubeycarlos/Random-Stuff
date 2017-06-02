package librerias;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MainForm {

	private JFrame frame;
	private JFreeChart chart;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		DefaultPieDataset pieDataSet = new DefaultPieDataset();
//		pieDataSet.setValue("A", 123);
//		pieDataSet.setValue("B", 10);
//		pieDataSet.setValue("C", 150);
//		pieDataSet.setValue("D", 70);
//		
//		chart = ChartFactory.createPieChart("Distribucion de votos", pieDataSet, false, true, false);
//		
//		ChartPanel chartPanel = new ChartPanel(chart, true, true, true, true, true);
//		chartPanel.setBounds(10, 10, 413, 380);
//		frame.getContentPane().add(chartPanel);
//		
//		//Grafico XY
		
		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(new XYSeries ("x*x"));
		dataSet.addSeries(new XYSeries ("2*x"));
		
		//Los valores
		
		for (int i = -10; i<10; ++i){
			dataSet.getSeries(0).add(i, i*i);
			dataSet.getSeries(1).add(i, 2*i);
		}
		
		JFreeChart grafico = ChartFactory.createXYLineChart("Funciones", "X", "Y", dataSet, PlotOrientation.HORIZONTAL, true, true, false);		
	
		ChartPanel chartpanel = new ChartPanel (grafico, true, true, true, true, true); 
		chartpanel.setBounds(10,10,413,200);
		
		frame.getContentPane().add(chartpanel);
	}

}
