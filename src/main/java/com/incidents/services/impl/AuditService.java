package com.incidents.services.impl;

import java.util.Date;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Audit;
import com.incidents.entities.MyUser;
import com.incidents.repositories.AuditDAO;

@Service("Audit")
public class AuditService {

	@Autowired
	AuditDAO dao;
	
	@Transactional
	public Audit create(MyUser user, String query, String params) {
		Audit audit = new Audit();
		audit.setUser(user);
		audit.setQuery(query);
		audit.setParams(params);
		audit.setCreatedAt(new Date());
		dao.save(audit);
		return audit;
	}
	
}
