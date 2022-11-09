import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.awt.event.*;
import java.util.Queue;
import java.util.Stack;

public class completedvaxx extends JFrame implements ActionListener{

	private Container cont;
	private JList<String> list;
	private Queue<Citizen> qCenter1,qCenter2, qCenter3;
	private Stack<Citizen> stCenter1, stCenter2, stCenter3;
	private LinkedList<Citizen> completedList;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public completedvaxx(Stack<Citizen> stCenter1, Stack<Citizen> stCenter2, Stack<Citizen> stCenter3, Queue<Citizen> qCenter1, Queue<Citizen> qCenter2, Queue<Citizen> qCenter3, LinkedList<Citizen> completedList) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\syazw\\eclipse-workspace\\vaccination project\\src\\myjahanam_100x100.png"));
		setTitle("COMPLETED");
		getContentPane().setBackground(Color.GREEN);
		
		cont = getContentPane();
		cont.setLayout(null);

		this.completedList = completedList;

		this.stCenter1 = stCenter1;
		this.stCenter2 = stCenter2;
		this.stCenter3 = stCenter3;

		this.qCenter1 = qCenter1;
		this.qCenter2 = qCenter2;
		this.qCenter3 = qCenter3;

		String[] List= new String[completedList.size()];
		for (int i = 0; i < List.length; i++) {
			List[i] = completedList.get(i).getRecepientName();
		}
		
		JLabel lblNewLabel = new JLabel("Recepient's that have been vaccinated twice");
		lblNewLabel.setBounds(238, 21, 301, 13);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		cont.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(10, 44, 783, 457);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 763, 442);
		panel.add(scrollPane);
		
		list = new JList(List);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(5);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < completedList.size(); i++) {
					if(completedList.get(i).getRecepientName().equalsIgnoreCase(list.getSelectedValue()))
						JOptionPane.showMessageDialog(null, completedList.get(i), "Certificate", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		cont.add(panel);
		
		btnBack = new JButton("[RETURN TO HOME]");
		btnBack.setBackground(Color.MAGENTA);
		btnBack.setFont(new Font("Footlight MT Light", Font.PLAIN, 24));
		btnBack.setBounds(10, 508, 783, 54);
		btnBack.addActionListener(this);
		cont.add(btnBack);
		
		setBounds(100, 100, 817, 599);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnBack){
			listRecepients frame = new listRecepients(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList);
			frame.setVisible(true);
			dispose();
		}
	}
}