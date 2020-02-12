package com.rio.SBWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Siswa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_siswa;
	private String nama;
	private Integer kelas;
	private String jurusan;
	
	@Version
	@Column(name = "optVersion", columnDefinition = "integer DEFAULT 0")
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getId_siswa() {
		return id_siswa;
	}
	public void setId_siswa(Integer id_siswa) {
		this.id_siswa = id_siswa;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Integer getKelas() {
		return kelas;
	}
	public void setKelas(Integer kelas) {
		this.kelas = kelas;
	}
	public String getJurusan() {
		return jurusan;
	}
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	

	
	
}
