package higygfhg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class test {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setToolTipText("test2");
		frame.getContentPane().add(scrollBar, BorderLayout.EAST);
		
		JSlider slider = new JSlider();
		slider.setToolTipText("test1");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		frame.getContentPane().add(slider, BorderLayout.NORTH);
		
		JCheckBox chckbxTest = new JCheckBox("test3");
		frame.getContentPane().add(chckbxTest, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("test4");
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		JRadioButton rdbtnTest = new JRadioButton("test5");
		rdbtnTest.setToolTipText("test5");
		frame.getContentPane().add(rdbtnTest, BorderLayout.CENTER);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
