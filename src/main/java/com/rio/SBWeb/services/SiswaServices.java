package com.rio.SBWeb.services;

import java.util.List;

import com.rio.SBWeb.model.Siswa;

public interface SiswaServices {

	List<Siswa> listSiswas();
	Siswa saveOrUpdate(Siswa siswa);
	Siswa getId(Integer id_siswa);
	void delete(Integer id_siswa);
}
