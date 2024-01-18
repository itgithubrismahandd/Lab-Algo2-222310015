package com.kelompok4_PBO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class APK extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APK frame = new APK();
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
	public APK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textDaftarApk = new JLabel("DAFTAR APLIKASI");
		textDaftarApk.setFont(new Font("Tahoma", Font.BOLD, 13));
		textDaftarApk.setBounds(145, 80, 134, 14);
		contentPane.add(textDaftarApk);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Web smartcity.semarangkota (Smart City)", "Lapor Hendi (Smart Governance)", "Tanggap darurat (Smart Governance)", "I-Jus Melon (Smart Governance)", "E-Kinerja (Smart Governance)", "Register online Dispendukcapil (Smart Governance)", "JAGA (Smart Living)", "Kartu Semarang (Smart Living)", "Kampung pelangi (Smart Living)"}));
		comboBox.setBounds(83, 110, 273, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("APLIKASI PENILAIAN SMART CITY SEMARANG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(74, 30, 320, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(122, 199, 89, 23);
		btnLogout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        
			KPI login = new KPI();
			login.setVisible(true);
			dispose();
		}
        });
		contentPane.add(btnLogout);
		
		JButton btnSubmit_Pertanyaan = new JButton("Submit");
		btnSubmit_Pertanyaan.setBackground(new Color(128, 255, 0));
		btnSubmit_Pertanyaan.setBounds(221, 199, 89, 23);
		btnSubmit_Pertanyaan.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        
			Pertanyaan pertanyaan = new Pertanyaan();
			pertanyaan.setVisible(true);
			dispose();
		}
        });
		contentPane.add(btnSubmit_Pertanyaan);
	}
};