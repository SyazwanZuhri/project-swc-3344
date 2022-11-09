import java.io.*;
import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainCitizen extends JFrame implements ActionListener{

	private Container cont;
	private JButton btnAdd, btnRemove, btnUpdate, btnContinue;
	private LinkedList<Citizen> CitizenList;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) throws IOException {
			Welcomeframe welcomeframe;

			try {
				welcomeframe = new Welcomeframe();
				welcomeframe.getContentPane().setBackground(new Color(14, 0, 141));
				welcomeframe.getContentPane().setForeground(new Color(14, 0, 141));
			

				welcomeframe.setVisible(true);
				Thread.sleep(2000);
				welcomeframe.progressBar.setVisible(true);
				try {
					for (int i = 0; i <= 100; i += 4) {
						Thread.sleep(20);
						welcomeframe.progressBar.setValue(i);
					}
					Thread.sleep(1000);
					welcomeframe.setVisible(false);
				} catch (Exception e) {
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		LinkedList<Citizen> citizenlist = new LinkedList<>();
		try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\vaxxrecepients.txt"));
            Citizen citizen;

            String line = br.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                String recepientName = st.hasMoreTokens() ? st.nextToken() : null;
                String recepientIC = st.hasMoreTokens() ? st.nextToken() : null;
                String recepientState = st.hasMoreTokens() ? st.nextToken() : null;
                int recepientAge = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                String recepientCategory = st.hasMoreTokens() ? st.nextToken() : null;
                String firstDoseStatus = st.hasMoreTokens() ? st.nextToken() : null;
                String secondDoseStatus = st.hasMoreTokens() ? st.nextToken() : null;
                String completionCert = st.hasMoreTokens() ? st.nextToken() : null;
				
                citizen = new Citizen(recepientName, recepientIC, recepientState, recepientAge, recepientCategory, firstDoseStatus, secondDoseStatus, completionCert);
                citizenlist.add(citizen);

                line = br.readLine();
            }

            br.close();
        } catch (EOFException ex) {
			System.out.println("End of file error");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Wrong input!!!");
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		MainCitizen frame = new MainCitizen(citizenlist);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainCitizen(LinkedList<Citizen> CitizenList) {
		super("Citizen");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\myjahanam_100x100.png"));
		setTitle("MYJAHANE - VACCINE APPLICATION");
		getContentPane().setBackground(Color.BLUE);

		this.CitizenList = CitizenList;

		cont = getContentPane();
        cont.setLayout(null);
        
        btnAdd = new JButton("ADD RECEPIENT");
        btnAdd.setBackground(Color.WHITE);
        btnAdd.setIcon(new ImageIcon("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\plus_icon_16x16.png"));
        btnAdd.setBounds(0, 0, 184, 26);
		btnAdd.addActionListener(this);
        cont.add(btnAdd);
        
        btnRemove = new JButton("REMOVE RECEPIENT");
        btnRemove.setBackground(Color.WHITE);
        btnRemove.setIcon(new ImageIcon("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\minnus icon_16x16.png"));
        btnRemove.setBounds(185, 0, 194, 26);
		btnRemove.addActionListener(this);
        cont.add(btnRemove);
        
        btnUpdate = new JButton("UPDATE  RECEPIENT'S DATA");
        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setIcon(new ImageIcon("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\update_16x16.png"));
        btnUpdate.setBounds(567, -3, 258, 26);
		btnUpdate.addActionListener(this);
        cont.add(btnUpdate);
        
        btnContinue = new JButton("NEXT");
        btnContinue.setBackground(Color.WHITE);
        btnContinue.setForeground(Color.BLACK);
        btnContinue.setIcon(new ImageIcon("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\next_icon_50x50.png"));
        btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnContinue.setBounds(289, 409, 234, 73);
		btnContinue.addActionListener(this);
        cont.add(btnContinue);
        
        lblNewLabel_1 = new JLabel("V 1.0");
        lblNewLabel_1.setFont(new Font("Footlight MT Light", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(793, 479, 45, 13);
        getContentPane().add(lblNewLabel_1);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(174, 136, 481, 263);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("WELCOME TO MYJAHANE");
        lblNewLabel.setBounds(32, 32, 463, 35);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 37));
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(184, 81, 101, 107);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\myjahanam_100x100.png"));
        
        lblNewLabel_3 = new JLabel("BY: QAYYUM, HAIQAL, NUAIM, SYAZWAN");
        lblNewLabel_3.setFont(new Font("Footlight MT Light", Font.PLAIN, 19));
        lblNewLabel_3.setBounds(58, 244, 375, 19);
        panel.add(lblNewLabel_3);

		setBounds(200, 200, 450, 300);
        setSize(839,529);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			registrationwindow frame = new registrationwindow("ADD", CitizenList, new Citizen());
			frame.setVisible(true);
			dispose();
			return;
		}
		else if(e.getSource() == btnContinue){
			Stack<Citizen> stCenter1, stCenter2, stCenter3;
			Queue<Citizen> qCenter1, qCenter2, qCenter3;
			
			stCenter1 = new Stack<>();
			stCenter2 = new Stack<>();
			stCenter3 = new Stack<>();
			
			qCenter1 = new LinkedList<>();
			qCenter2 = new LinkedList<>();
			qCenter3 = new LinkedList<>();

			System.out.println(CitizenList.getLast());
			LinkedList<Citizen> completedList =  new LinkedList<>();
			
			int size = CitizenList.size();
			for (int i = 0; i < size; i++) {
				Citizen person = CitizenList.removeLast();
				if(person.getrecepientAge() >= 18 && person.getrecepientAge() <= 30){
					if(person.getsecondDoseStatus() != null){
						completedList.add(person);
						continue;
					}
					else if(person.getfirstDoseStatus() != null){
						qCenter1.add(person);
						continue;
					}
					else{
						stCenter1.add(person);
						continue;
					}
				}
				else if(person.getrecepientAge() >= 31 & person.getrecepientAge() <=49){
					if(person.getsecondDoseStatus() != null){
						completedList.add(person);
						continue;
					}
					else if(person.getfirstDoseStatus() != null){
						qCenter2.add(person);
						continue;
					}
					else{
						stCenter2.add(person);
						continue;
					}
				}
				else if(person.getrecepientAge() >= 50){
					if(person.getsecondDoseStatus() != null){
						completedList.add(person);
						continue;
					}
					else if(person.getfirstDoseStatus() != null){
						qCenter3.add(person);
						continue;
					}
					else{
						stCenter3.add(person);
						continue;
					}
				}
			}

			listRecepients frame = new listRecepients(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3,completedList);
			frame.setVisible(true);
			dispose();
			return;
		}

		String recepientIC = JOptionPane.showInputDialog(null, "Please enter the recepient's IC", "IC NUMBER NEEDED", JOptionPane.QUESTION_MESSAGE);
		int Person_num = -1;
		for (int i = 0; i < CitizenList.size(); i++) {
			if(CitizenList.get(i).getrecepientIC().equalsIgnoreCase(recepientIC)) {
				Person_num = i;
				break;
			}
		}
		if(recepientIC == null)
			return;

		if(Person_num == -1){
			JOptionPane.showMessageDialog(null, "Recepient registered with IC Number:" + recepientIC + " does not exist.","Not Found", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(e.getSource() == btnRemove){
			int reply = JOptionPane.showConfirmDialog(null, CitizenList.get(Person_num), "Do you want to remove this recepient's data?", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				CitizenList.remove(Person_num);
			}
		}
		else if (e.getSource() == btnUpdate) {
			registrationwindow frame = new registrationwindow("UPDATE", CitizenList, CitizenList.get(Person_num));
			frame.setVisible(true);
			dispose();
		}
	}
}
