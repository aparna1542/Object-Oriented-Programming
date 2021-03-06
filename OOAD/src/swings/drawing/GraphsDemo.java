package swings.drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphsDemo extends JFrame {
	
	public GraphsDemo(){
		super ("Bar Chart");
		
		setPreferredSize(new Dimension(800,800));
		setLocationRelativeTo(null);
		

		BarChart chart = new BarChart();
		
		// the data values are hardcoded
		chart.addBar(Color.red, 100);
		chart.addBar(Color.green, 8);
		chart.addBar(Color.blue, 54);
		chart.addBar(Color.black, 23);
		getContentPane().setBackground(Color.CYAN  ); 
		getContentPane().add(chart);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new GraphsDemo();	
		
	}	
}
class BarChart extends JPanel
{
	private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();

	public BarChart()
	{
		setPreferredSize(new Dimension(500,500));
		
	}
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(Color color, int value)
	{
		bars.put(color, value);
		
		// cannot call paintComponent() or paint() directly
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		// determine longest bar

		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values())
		{
			max = Math.max(max, value);
		}

		// paint bars

		int width = (getWidth() / bars.size()) - 100;
		int x = 1;
		for (Color color : bars.keySet())
		{
			int value = bars.get(color);
			int height = (int)
                            ((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(bars.size() * 10 + 2, 50);
	}
	
}
