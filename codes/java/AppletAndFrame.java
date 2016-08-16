/*
*  Thanks to DreamInCode.net
*   - http://www.dreamincode.net/code/snippet4467.htm
* 
*  I Added a WindowEventListener
*/

/*
	<applet
		codebase="."
		archive="AppletAndFrame.jar"
		code="AppletAndFrame.class"
		width="1100"
		height="400">
	</applet>
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
* A very simple example on how to write an Applet that can also be run as an Application
* You can javac it (its main() method will be called) or
* you can invoke it from a .html file in that case it will run as an Applet
*/



public class AppletAndFrame extends JApplet implements ActionListener {

	JButton[] button;
	JLabel[] label;
	int[] nbClick;
	
	// Applet init method that will init the JComponent
	// will be called automatically when running an Applet
	// will be "manually" called by main() when running as an application
	public void init() {
		/*
		* Here you must:
		*   1) choose your Layout using the 'setLayout(...)' method
		*   2) use 'add(new MyJPanelForm())' to assign your NetBeans JPanel Form
		*/
		
		// create the buttons and the labels that display how many
		// time the buttons were clicked
		button = new JButton[2];
		label = new JLabel[button.length];
		nbClick = new int[button.length];
		// as a gridLayout of number of buttons X 2 for their corresponding labels
		setLayout(new GridLayout(button.length,2));
		for(int i = 0; i < button.length; i++) {
			// create button
			button[i] = new JButton("Button #" + (i+1));
			button[i].addActionListener(this);
			add(button[i]);
			// and its corresponding label
			label[i] = new JLabel("     Nb click: 0");
			add(label[i]);
		}
	}
	
	// called when a button is clicked (does not matter if Applet or Application here)
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// found which button
		for(int i = 0; i < button.length; i++) {
			// button found
			if(o == button[i]) {
				nbClick[i]++;		// increment click count
				label[i].setText("     Nb click: " + nbClick[i]);
				break;
			}
		}
	}
	
	// when run as an application
	public static void main(String[] args) {
		JFrame frame = new JFrame("As an application");
		// an application has to determine its size (Applet done by .html page)
		frame.setSize(300, 100);
		// create the applet
		AppletAndFrame applet = new AppletAndFrame();
		// call the init method to initialize GUI
		applet.init();   
		// add the applet to the Frame
		frame.add(applet, BorderLayout.CENTER);
		
		// Adding a WindowLister to close the Application mode
		frame.addWindowListener(
		new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		

		//*UNDECORATE* JFrame and add a Close Button
		frame.setUndecorated(true);
		JButton exitButton = new JButton("Exit");
		JPanel exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		exitPanel.add(exitButton);
		frame.add(exitPanel, BorderLayout.SOUTH);

		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// and (finally) make it visible
		frame.setVisible(true);
	}
}
