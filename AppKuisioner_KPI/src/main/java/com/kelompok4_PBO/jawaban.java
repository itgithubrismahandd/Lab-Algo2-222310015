package com.kelompok4_PBO;

public class jawaban {
	private Integer id_jawaban;
	private String kategori_jawaban;
	private Integer skor;
	
	public Integer getId_jawaban () {
		return id_jawaban;
	}
	public void setId_jawaban (Integer id_jawaban) {
		this.id_jawaban = id_jawaban;
	}
	public String getKategori_jawaban () {
		return kategori_jawaban;
	}
	public void setKategori_jawaban (String kategori_jawaban) {
		this.kategori_jawaban = kategori_jawaban;
	}
	public Integer getSkor () {
		return skor;
	}
	public void setSkor (Integer skor) {
		this.skor = skor;
	}
}
