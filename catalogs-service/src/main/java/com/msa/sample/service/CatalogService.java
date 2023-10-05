package com.msa.sample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.msa.sample.domain.Catalog;
import com.msa.sample.repository.CatalogRepository;
import com.msa.sample.service.dto.CatalogRes;

@Service
public class CatalogService {

	private final CatalogRepository catalogRepository;
	
	public CatalogService(CatalogRepository catalogRepository) {
		this.catalogRepository = catalogRepository;
	}
	
	public List<CatalogRes> getCatalogs() {
		List<Catalog> catalogs = catalogRepository.findAll();
		return catalogs.stream().map(CatalogRes::new).collect(Collectors.toList());
	}
}
