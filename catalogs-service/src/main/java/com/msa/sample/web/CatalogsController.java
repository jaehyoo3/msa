package com.msa.sample.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.sample.service.CatalogService;
import com.msa.sample.service.dto.CatalogRes;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogsController {

	private final CatalogService catalogService;
	
    @GetMapping("/list")
    public List<CatalogRes> getList() {
    	return catalogService.getCatalogs();
    }

}
