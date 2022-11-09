import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;



public class registrationwindow extends JFrame implements ActionListener{

	private Container cont;
	private JTextField txtName, txtAge, txtState, txtIc, txt1stdose, txt2nddose, txtCertificate, txtCategory;
	private JButton btnSubmit;
	private String option;
    private LinkedList<Citizen> CitizenList; 
    private Citizen person;

	/**
	 * Create the frame.
	 */
	public registrationwindow(String option, LinkedList<Citizen> citizen, Citizen person) {
		super("Input Form");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\myjahanam_100x100.png"));
		setTitle("Register A Recepient");
		getContentPane().setBackground(Color.BLUE);

		this.option = option;
        this.CitizenList = citizen;
        this.person = person;

		cont = getContentPane();
        cont.setLayout(null);
        
        JLabel lblName = new JLabel("Recepient Name :");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        lblName.setBounds(32, 26, 156, 19);
        cont.add(lblName);
        
        JLabel lblState = new JLabel("Recepient State :");
        lblState.setForeground(Color.WHITE);
        lblState.setBounds(32, 138, 156, 19);
		lblState.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        cont.add(lblState);
        
        JLabel lblIc = new JLabel("Recepient IC :");
        lblIc.setForeground(Color.WHITE);
        lblIc.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        lblIc.setBounds(32, 78, 156, 29);
        cont.add(lblIc);
        
        JLabel lblAge = new JLabel("Recepient Age :");
        lblAge.setForeground(Color.WHITE);
        lblAge.setBounds(32, 188, 156, 22);
		lblAge.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        cont.add(lblAge);
        
        JLabel lblCategory = new JLabel("Recepient Category :");
        lblCategory.setForeground(Color.WHITE);
        lblCategory.setBounds(32, 244, 156, 24);
		lblCategory.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        cont.add(lblCategory);
        
        JLabel lbl1stdose = new JLabel("First Dose Status :");
        lbl1stdose.setForeground(Color.WHITE);
        lbl1stdose.setBounds(32, 302, 156, 23);
		lbl1stdose.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        cont.add(lbl1stdose);
        
        JLabel lbl2nddose = new JLabel("Second dose Status :");
        lbl2nddose.setForeground(Color.WHITE);
        lbl2nddose.setBounds(32, 360, 191, 29);
		lbl2nddose.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        cont.add(lbl2nddose);
        
        JLabel lblCertificate = new JLabel("Completion Certificate :");
        lblCertificate.setForeground(Color.WHITE);
        lblCertificate.setBounds(32, 399, 191, 58);
		lblCertificate.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        cont.add(lblCertificate);
        
        txtName = new JTextField();
        txtName.setBackground(Color.CYAN);
        txtName.setBounds(32, 49, 631, 19);
        cont.add(txtName);
        txtName.setColumns(10);
        
        txtIc = new JTextField();
        txtIc.setBackground(Color.CYAN);
        txtIc.setColumns(10);
        txtIc.setBounds(32, 109, 631, 19);
        cont.add(txtIc);
        
        txtState = new JTextField();
        txtState.setBackground(Color.CYAN);
        txtState.setColumns(10);
        txtState.setBounds(32, 159, 631, 19);
        cont.add(txtState);
        
        txtAge = new JTextField();
        txtAge.setBackground(Color.CYAN);
        txtAge.setColumns(10);
        txtAge.setBounds(32, 215, 631, 19);
        cont.add(txtAge);
        
        txtCategory = new JTextField();
        txtCategory.setBackground(Color.CYAN);
        txtCategory.setColumns(10);
        txtCategory.setBounds(32, 273, 631, 19);
        cont.add(txtCategory);
        
        txt1stdose = new JTextField();
        txt1stdose.setHorizontalAlignment(SwingConstants.CENTER);
        txt1stdose.setBackground(Color.CYAN);
        txt1stdose.setColumns(10);
        txt1stdose.setBounds(32, 335, 631, 19);
        cont.add(txt1stdose);
        
        txt2nddose = new JTextField();
        txt2nddose.setHorizontalAlignment(SwingConstants.CENTER);
        txt2nddose.setBackground(Color.CYAN);
        txt2nddose.setColumns(10);
        txt2nddose.setBounds(32, 387, 631, 19);
        cont.add(txt2nddose);
        
        txtCertificate = new JTextField();
        txtCertificate.setBackground(Color.CYAN);
        txtCertificate.setColumns(10);
        txtCertificate.setBounds(32, 449, 631, 19);
        cont.add(txtCertificate);
        
        btnSubmit = new JButton("Register");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnSubmit.setBounds(247, 533, 175, 51);
		btnSubmit.addActionListener(this);
        cont.add(btnSubmit);

        if(option.equalsIgnoreCase("UPDATE")){ 
            txtName.setText(person.getRecepientName());
            txtIc.setText(person.getrecepientIC());
            txtIc.setEditable(false);
            txtState.setText(person.getrecepientState());
            txtAge.setText(person.getrecepientAge()+"");
            txtCategory.setText(person.getrecepientCategory());
            txt1stdose.setText(person.getfirstDoseStatus());
            txt2nddose.setText(person.getsecondDoseStatus());
            txtCertificate.setText(person.getcompletionCert());
        }
        
		setBounds(200, 200, 450, 300);
        setSize(704,631);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnSubmit){

            JTextField field[] = {txtName, txtAge, txtState, txtIc, txtCategory};
            boolean empty = false;
            for (int i = 0; i < field.length; i++) {
                if(field[i].getText().equalsIgnoreCase("")){
                    empty = true;
                    break;
                }
            }
            if(empty){
                JOptionPane.showMessageDialog(null, "Please dont leave input field empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(Integer.parseInt(txtAge.getText()) < 18){
                JOptionPane.showMessageDialog(null, "Age is not match", "Age", JOptionPane.ERROR_MESSAGE);
                return;
            }

			if(option.equalsIgnoreCase("ADD")){
                String dose1 = txt1stdose.getText().equalsIgnoreCase("") ? null : txt1stdose.getText();
                String dose2 = txt2nddose.getText().equalsIgnoreCase("") ? null : txt2nddose.getText();
                String Certificicate = txtCertificate.getText().equalsIgnoreCase("") ? null : txtCertificate.getText();

                Citizen citizen = new Citizen(txtName.getText(), txtIc.getText(), txtState.getText(), Integer.parseInt(txtAge.getText()), txtCategory.getText(), dose1, dose2, Certificicate);
                
                CitizenList.add(citizen);

				MainCitizen frame = new MainCitizen(CitizenList);
				frame.setVisible(true);
				dispose();
			}
            else if(option.equalsIgnoreCase("UPDATE")){
                for (int i = 0; i < CitizenList.size(); i++) {
                    if(CitizenList.get(i).getrecepientIC() == person.getrecepientIC()){
                        CitizenList.set(i, person);
                    }
                }
                
		
				MainCitizen frame = new MainCitizen(CitizenList);
				frame.setVisible(true);
				dispose();
			}
		}
		
	}
}
