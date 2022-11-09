import java.awt.*;
import javax.swing.*;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.*;

public class listRecepients extends JFrame implements ActionListener{

	private Container cont;
	private JButton btn1stdose, btn2nddose, btnComplete, btnBack;
	private Queue<Citizen> qCenter1,qCenter2, qCenter3;
	private Stack<Citizen> stCenter1, stCenter2, stCenter3;
	private LinkedList<Citizen> completedList;

	/**
	 * Create the frame.
	 */
	public listRecepients(Stack<Citizen> stCenter1, Stack<Citizen> stCenter2, Stack<Citizen> stCenter3, Queue<Citizen> qCenter1, Queue<Citizen> qCenter2, Queue<Citizen> qCenter3, LinkedList<Citizen> completedList) {
		super("listRecepients");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\myjahanam_100x100.png"));
		setTitle("");
		getContentPane().setBackground(new Color(128, 128, 128));

		this.completedList = completedList;

		this.stCenter1 = stCenter1;
		this.stCenter2 = stCenter2;
		this.stCenter3 = stCenter3;

		this.qCenter1 = qCenter1;
		this.qCenter2 = qCenter2;
		this.qCenter3 = qCenter3;

		cont = getContentPane();
        cont.setLayout(null);
        
        btn1stdose = new JButton("FIRST DOSE RECEPIENT");
        btn1stdose.setBackground(new Color(255, 250, 205));
        btn1stdose.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
        btn1stdose.setBounds(86, 104, 225, 90);
		btn1stdose.addActionListener(this);
		cont.add(btn1stdose);
        
        btn2nddose = new JButton("SECOND DOSE RECEPIENT");
        btn2nddose.setBackground(new Color(255, 248, 220));
        btn2nddose.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
        btn2nddose.setBounds(86, 204, 225, 90);
		btn2nddose.addActionListener(this);
		cont.add(btn2nddose);
        
        btnComplete = new JButton("[Completed]");
        btnComplete.setFont(new Font("Footlight MT Light", Font.PLAIN, 19));
        btnComplete.setBackground(new Color(50, 205, 50));
        btnComplete.setBounds(266, 423, 167, 53);
		btnComplete.addActionListener(this);
		cont.add(btnComplete);
		
		btnBack = new JButton("[Back]");
		btnBack.setFont(new Font("Footlight MT Light", Font.PLAIN, 19));
		btnBack.setBackground(new Color(220, 20, 60));
		btnBack.setBounds(0, 423, 136, 53);
		btnBack.addActionListener(this);
		cont.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("LIST OF RECEPIENTS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 81, 319, 13);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		cont.add(lblNewLabel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 510);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btn1stdose){
			Vaccine frame = new Vaccine(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList, "1stdose");
			frame.setVisible(true);
			dispose();
		}
		else if(e.getSource() == btn2nddose){
			Vaccine frame = new Vaccine(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList, "2nddose");
			frame.setVisible(true);
			dispose();
		}

		else if(e.getSource() == btnComplete){
			completedvaxx frame = new completedvaxx(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList);
			frame.setVisible(true);
			dispose();
		}

		else if(e.getSource() == btnBack){
			LinkedList<Citizen> CitizenList = new LinkedList<>();
			while(!stCenter1.isEmpty()){
				CitizenList.add(stCenter1.pop());
			}while(!stCenter2.isEmpty()){
				CitizenList.add(stCenter2.pop());
			}while(!stCenter3.isEmpty()){
				CitizenList.add(stCenter3.pop());
			}while(!qCenter1.isEmpty()){
				CitizenList.add(qCenter1.remove());
			}while(!qCenter2.isEmpty()){
				CitizenList.add(qCenter2.remove());
			}while(!qCenter3.isEmpty()){
				CitizenList.add(qCenter3.remove());
			}while(!completedList.isEmpty()){
				CitizenList.add(completedList.pop());
			}
			
			MainCitizen frame = new MainCitizen(CitizenList);
			frame.setVisible(true);
			dispose();
		}
	}
}
