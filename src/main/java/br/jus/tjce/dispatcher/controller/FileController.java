package br.jus.tjce.dispatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tjce.dispatcher.service.FileService;
import br.jus.tjce.dispatcher.vo.v1.FileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "FileEndpoint") 
@RestController
@RequestMapping("/api/file/v1")
public class FileController {

	@Autowired
	private FileService service;
		
	@ApiOperation(value = "Find and tranfer a specific file by your ID" )
	@GetMapping(value = "/{id}/{origem}/{destino}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<FileVO> create(@PathVariable("hash") String hash, @PathVariable("origem") String origem, @PathVariable("destino") String destino) {
		FileVO fileVO = service.findByHash(hash, origem);
		fileVO.setDest(destino);
		return service.create(fileVO);
		//return fileVO;
	}
	
}
