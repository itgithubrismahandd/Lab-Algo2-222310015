package com.kelompok4_PBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kelompok4_PBO.connectionDB;
import com.kelompok4_PBO.masyarakat;
public class masyarakatDao {
	private  String queryInsert = "insert into masyarakat(nik, nama_lengkap)"+"(?,?)";
	
private String querySelectAll = "select * from masyarakat"; 
	
	private String queryUpdate = "update masyarakat set nik=?, nama_lengkap=?, alamat=?, where nik = ?";

	private String queryRemoveById = "delete from masyarakat where nik = ?";
	
	private String queryFindById = "select * from masyrakat where nik = ?";
	
	private String queryByNik = "select * from masyarakat where nik = ?";
	
	
	public void saved(masyarakat masyarakat) throws Exception  {
		Connection c = new connectionDB().connect();
		
		PreparedStatement psInsert = c.prepareStatement(queryInsert);
		
		
		psInsert.setString(1, masyarakat.getNik());
		psInsert.setString(2, masyarakat.getNama_lengkap());
//		psInsert.setString(3, masyarakat.getAlamat());
		
		psInsert.executeUpdate();
		
		c.close();
		
}
	public List<masyarakat> findAll() throws Exception {
	    List<masyarakat> hasil = new ArrayList<>();
	    Connection c = new connectionDB().connect();
	    PreparedStatement psCariSemuaProduk = c.prepareStatement(querySelectAll);
	    ResultSet rs = psCariSemuaProduk.executeQuery();

	    while (rs.next()) {
	    	masyarakat students = konversiResultSet(rs);
	        hasil.add(students);
	    }
	    c.close();
	    return hasil;
}
	private masyarakat konversiResultSet(ResultSet rs)throws SQLException {
		masyarakat masyarakat = new masyarakat();
		masyarakat.setNik(rs.getString("nik"));
		masyarakat.setNama_lengkap(rs.getString("nama_lengkap"));
		masyarakat.setAlamat(rs.getString("alamat"));
		return masyarakat;
	}
	
	public masyarakat findById(String Nik) throws Exception {
        Connection c = new connectionDB().connect();
        PreparedStatement psFindById = c.prepareStatement(queryFindById);
        psFindById.setString(1, Nik);

        ResultSet rs = psFindById.executeQuery();

        masyarakat masyarakat = null;
        if (rs.next()) {
            masyarakat = konversiResultSet(rs);
        }

        c.close();
        return masyarakat;
    }
	
	public masyarakat getByNik(String nik, String nama_lengkap) throws Exception {
	    Connection c = new connectionDB().connect();
	    PreparedStatement psByNik = c.prepareStatement(queryByNik);
	    psByNik.setString(1, nik);

	    ResultSet rs = psByNik.executeQuery();

	    masyarakat msyrkt = null;
	    if (rs.next()) {
	        // Bandingkan password yang ditemukan di database dengan password yang diinputkan
	        String storednama = rs.getString("nama_lengkap");
	        if (storednama.equals(nama_lengkap)) {
	            msyrkt = konversiResultSet(rs);
	        }
	    }

	    c.close();
	    return msyrkt;
	}
}

