package com.kelompok4_PBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate_db {
    private static final String URL = "jdbc:mysql://localhost:3306/survey_smartcity_semarang";
    private static final String USER = "masyarakat";
    private static final String PASSWORD = "";

    public boolean validateInput(String NIK, String nama_lengkap) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Query untuk memeriksa apakah NIK dan Nama sesuai dengan data di database
            String query = "SELECT * FROM tabel_pengguna WHERE NIK = ? AND nama_lengkap = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, NIK);
                preparedStatement.setString(2, nama_lengkap);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // true jika data ditemukan, false jika tidak ditemukan
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}