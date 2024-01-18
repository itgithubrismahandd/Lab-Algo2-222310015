package com.kelompok4_PBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kelompok4_PBO.connectionDB;
import com.kelompok4_PBO.daf_aplikasi;


public class daf_aplikasiDao {
	private String queryInsert = "insert into survey (id_apk, nama_apk)"+"(?,?)";
private String querySelectAll = "select * from daf_aplikasi"; 
	
	private String queryUpdate = "update daf_aplikasi set id_apk=?, nama_apk=?, where id_apk = ?";

	private String queryRemoveById = "delete from daf_aplikasi where id_apk = ?";
	
	private String queryFindById = "select * from daf_aplikasi where id_apk = ?";
	
	public void saved(daf_aplikasi daf_aplikasi) throws Exception  {
		Connection c = new connectionDB().connect();
		
		PreparedStatement psInsert = c.prepareStatement(queryInsert);
		psInsert.setString(1,daf_aplikasi.getId_apk());
		psInsert.setString(2, daf_aplikasi.getNama_apk());
		
		psInsert.executeUpdate();
		c.close();
}
	public List<daf_aplikasi> findAll() throws Exception {
		List<daf_aplikasi> hasil = new ArrayList<>();
		Connection c = new connectionDB().connect();
		PreparedStatement psCari = c.prepareStatement(querySelectAll);
		ResultSet rs = psCari.executeQuery();

	    while (rs.next()) {
	        daf_aplikasi daf_aplikasi = konversiResultSet(rs);
	        hasil.add(daf_aplikasi);
	    }

	    c.close();
	    return hasil;
		
		
	}
	private daf_aplikasi konversiResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		daf_aplikasi daf_aplikasi = new daf_aplikasi();
		daf_aplikasi.setNama_apk(rs.getString("id_apk"));
		daf_aplikasi.setId_jawaban(queryFindById);
		return daf_aplikasi;
	}
	
	public void updated(daf_aplikasi daf_aplikasi) throws Exception{
		Connection c = new connectionDB().connect();
		
		PreparedStatement psUpdate = c.prepareStatement(queryUpdate);
		psUpdate.setString(1, daf_aplikasi.getId_apk());
		psUpdate.setString(2, daf_aplikasi.getNama_apk());
		
		psUpdate.executeUpdate();
		
		c.close();
	}
	
	public void removed(String id_apk) throws Exception {
	    if (id_apk == null) {
	        return;
	    }
	    
	    Connection c = new connectionDB().connect();
	    PreparedStatement psHapusById = c.prepareStatement(queryRemoveById);
	    psHapusById.setString(1, id_apk);
	    
	    psHapusById.executeUpdate();
	    
	    c.close();
	}
	
	public daf_aplikasi findById(String id_apk) throws Exception {
        Connection c = new connectionDB().connect();
        PreparedStatement psFindById = c.prepareStatement(queryFindById);
        psFindById.setString(1, id_apk);

        ResultSet rs = psFindById.executeQuery();

        daf_aplikasi daf_aplikasi = null;
        if (rs.next()) {
            daf_aplikasi = konversiResultSet(rs);
        }

        c.close();
        return daf_aplikasi;
}
}
