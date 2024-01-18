package com.kelompok4_PBO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;

public class Pertanyaan extends JFrame {
    private JOptionPane jop = new JOptionPane();
    private JPanel contentPane;

    // Radio Buttons
    private JRadioButton[] radioButtons1 = new JRadioButton[5];
    private JRadioButton[] radioButtons2 = new JRadioButton[5];
    private JRadioButton[] radioButtons3 = new JRadioButton[5];
    private JRadioButton[] radioButtons4 = new JRadioButton[5];
    private JRadioButton[] radioButtons5 = new JRadioButton[5];

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pertanyaan frame = new Pertanyaan();
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
    public Pertanyaan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 664, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels
        JLabel lblNewLabel = new JLabel("APLIKASI PENILAIAN SMART CITY SEMARANG");
        lblNewLabel.setBounds(188, 25, 330, 14);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel);

        JLabel textsurvey = new JLabel("SURVEY");
        textsurvey.setBounds(292, 51, 60, 14);
        textsurvey.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(textsurvey);

        // Pertanyaan dan Radio Buttons
        createPertanyaan("1. Apakah aplikasi ini telah membantu anda dalam kebutuhan sehari-hari?", 94, radioButtons1);
        createPertanyaan("2. Apakah anda puas dengan kemudahan penggunaan aplikasi ini?", 146, radioButtons2);
        createPertanyaan("3. Apakah anda puas dengan keakuratan informasi yang disajikan oleh aplikasi ini?", 197, radioButtons3);
        createPertanyaan("4. Apakah anda puas dengan layanan kinerja aplikasi ini?", 248, radioButtons4);
        createPertanyaan("5. Bagaimana tanggapan anda terhadap efektivitas aplikasi ini dalam memberikan kemudahan?", 304, radioButtons5);

        // Submit Button
        JButton btnSubmitNilai = new JButton("Submit");
        btnSubmitNilai.setBackground(new Color(128, 255, 0));
        btnSubmitNilai.setBounds(336, 394, 89, 23);
        btnSubmitNilai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Memeriksa apakah semua radio button telah dipilih
                if (isAllRadioButtonsSelected()) {
                    int confirm = jop.showConfirmDialog(null, "Apakah anda ingin menilai apk lain?", "Konfirmasi", jop.YES_NO_OPTION);
                    if (confirm == 1) {
                        jop.showMessageDialog(null, "Terimakasih atas partisipasinya!");

                        KPI login = new KPI();
                        login.setVisible(true);
                        dispose();
                    } else {
                        APK daftar_apk = new APK();
                        daftar_apk.setVisible(true);
                        dispose();
                    }
                } else {
                    jop.showMessageDialog(null, "Harap isi semua pertanyaan sebelum menilai.");
                }
            }
        });
        getContentPane().add(btnSubmitNilai);

        // Back Button
        JButton btnBackDaftarApk = new JButton("Back");
        btnBackDaftarApk.setBackground(new Color(255, 0, 0));
        btnBackDaftarApk.setBounds(237, 394, 89, 23);
        btnBackDaftarApk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                APK daftar_apk = new APK();
                daftar_apk.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBackDaftarApk);

        // JList
        JList list = new JList();
        list.setBounds(20, 76, 602, 328);
        contentPane.add(list);
    }

    // Fungsi untuk membuat pertanyaan dan radio buttons
    private void createPertanyaan(String text, int yPosition, JRadioButton[] radioButtons) {
        JLabel pertanyaan = new JLabel(text);
        pertanyaan.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pertanyaan.setBounds(33, yPosition, 547, 14);
        contentPane.add(pertanyaan);

        for (int i = 0; i < 5; i++) {
            radioButtons[i] = new JRadioButton(getRadioButtonLabel(i));
            radioButtons[i].setBounds(33 + i * 113, yPosition + 22, 111, 23);
            contentPane.add(radioButtons[i]);
        }
    }

    // Fungsi untuk mendapatkan label radio button
    private String getRadioButtonLabel(int index) {
        switch (index) {
            case 0:
                return "Sangat Puas";
            case 1:
                return "Puas";
            case 2:
                return "Cukup Puas";
            case 3:
                return "Kurang Puas";
            case 4:
                return "Tidak Puas";
            default:
                return "";
        }
    }

    // Fungsi untuk memeriksa apakah semua radio button telah dipilih
    private boolean isAllRadioButtonsSelected() {
        for (JRadioButton[] radioButtons : new JRadioButton[][]{radioButtons1, radioButtons2, radioButtons3, radioButtons4, radioButtons5}) {
            boolean isSelected = false;
            for (JRadioButton radioButton : radioButtons) {
                isSelected = isSelected || radioButton.isSelected();
            }
            if (!isSelected) {
                return false; // Jika setidaknya satu grup radio button tidak dipilih, kembalikan false
            }
        }
        return true; // Semua radio button dipilih
    }
}
