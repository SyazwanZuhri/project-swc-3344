
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;

public class Welcomeframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	JProgressBar progressBar = new JProgressBar();
	public Welcomeframe() {
		getContentPane().setBackground(new Color(0, 153, 255));
		setUndecorated(true);
		setResizable(false);
		setTitle("SPLASH PARK");
		setBounds(100, 100, 765, 387);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		//setIconImage(new ImageIcon(this.getClass().getResource("")).getImage());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 361, 766, 26);
		getContentPane().add(panel);

		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		progressBar.setVisible(false);
		progressBar.setForeground(new Color(204, 51, 255));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(0, 0, 766, 362);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/main/logo/logo.png")));

		JLabel lblNewLabel_2 = new JLabel("WELCOME TO MYJAHANE");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		
				JLabel lblNewLabel = new JLabel("MALAYSIAKU JAHANE");
				lblNewLabel.setForeground(new Color(25, 25, 112));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\myjahanam_100x100.png"));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(293)
					.addComponent(lblNewLabel_1)
					.addGap(35)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(335))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(183, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
					.addGap(174))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}

