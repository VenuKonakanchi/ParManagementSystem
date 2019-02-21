package com.htc.par.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.entity.PARRole;
import com.htc.par.repository.PARRoleRepository;
import com.htc.par.to.PARRoleTO;


@Service
public class PARRoleServiceImpl implements PARRoleService{

	@Autowired
	PARRoleRepository parRoleRepository;

	public PARRole getPARRole(PARRoleTO parRoleTO) {
		PARRole parRole = new PARRole(parRoleTO.getRoleId(), parRoleTO.getRoleName(), parRoleTO.isRoleActive());
		return parRole;
	}

	public PARRoleTO getPARRoleTO(PARRole parRole) {
		PARRoleTO parRoleTO = new PARRoleTO(parRole.getRoleId(), parRole.getRoleName(), parRole.isRoleActive());
		return parRoleTO;
	}

	public Integer newparRole(PARRoleTO parRoleTO) throws DataAccessException {

		Optional<PARRole> parRole = parRoleRepository.findById(parRoleTO.getRoleId());
		if (parRole.isPresent()) {
			return 0;
		} else {

			PARRole newparRole = getPARRole(parRoleTO);
			parRoleRepository.save(newparRole);
			return 1;
		}
	}

	public List<PARRoleTO> getAllPARRoles() throws DataAccessException {

		List<PARRole> foundparRoleList = parRoleRepository.findAll();
		List<PARRoleTO> parRoleList = foundparRoleList.stream().map(pr -> {
															return getPARRoleTO(pr);
														}).collect(Collectors.toList());
		return parRoleList;

	}

}
