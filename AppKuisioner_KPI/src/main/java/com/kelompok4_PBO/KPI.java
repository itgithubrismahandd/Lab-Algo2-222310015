package com.kelompok4_PBO;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class KPI extends JFrame {

	private JPanel contentPane;
	private JTextField textNIK;
	private JTextField textNama;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KPI frame = new KPI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KPI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textLogin = new JLabel("LOGIN");
		textLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		textLogin.setBounds(192, 51, 47, 14);
		contentPane.add(textLogin);
		
		JLabel lblNewLabel_1 = new JLabel("MASUKAN NIK");
		lblNewLabel_1.setBounds(48, 77, 265, 14);
		contentPane.add(lblNewLabel_1);
		
		textNIK = new JTextField();
		textNIK.setBounds(48, 102, 318, 20);
		contentPane.add(textNIK);
		textNIK.setColumns(10);
		
		JLabel textNamaLengkap = new JLabel("MASUKAN NAMA LENGKAP");
		textNamaLengkap.setBounds(48, 135, 297, 14);
		contentPane.add(textNamaLengkap);
		
		textNama = new JTextField();
		textNama.setBounds(48, 160, 318, 20);
		contentPane.add(textNama);
		textNama.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("APLIKASI PENILAIAN SMART CITY SEMARANG");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(79, 26, 315, 14);
		contentPane.add(lblNewLabel_3);
		
		
		JButton btn1 = new JButton("Submit");
		btn1.setBackground(new Color(128, 255, 0));
		btn1.setBounds(174, 203, 89, 23);
		btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String enteredNik = textNIK.getText();
			String enteredNama = textNama.getText();
	       
	        try {
	        	if (isValidLogin(enteredNik, enteredNama)) {
	        	    JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
	        	    APK apk = new APK();
	        	    apk.setVisible(true);// Menampilkan frame baru
	        	    dispose(); // Menutup frame login
	        	} else {
	        	    JOptionPane.showMessageDialog(null, "NIK dan username anda salah!");
	        	}
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Kesalahan saat login: " + ex.getMessage());
	            ex.printStackTrace();
	        }
	        
        
		}
        });
		
		contentPane.add(btn1);
		
		
		
	}
	
	private boolean isValidLogin(String enteredNik, String enteredNama) throws Exception{
	    // Retrieve user data from the database based on the entered username
	    masyarakatDao msyrktDao = new masyarakatDao();
	    masyarakat savedmasyarakat = msyrktDao.getByNik(enteredNik, enteredNama);
	    // Check if the user exists and the entered password matches the stored password
	    return savedmasyarakat != null;
	}
		
}
