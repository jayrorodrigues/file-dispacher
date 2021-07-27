package br.jus.tjce.dispatcher.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.jus.tjce.dispatcher.converters.DozerConverter;
import br.jus.tjce.dispatcher.repository.FileRepository;
import br.jus.tjce.dispatcher.vo.v1.FileVO;

public class FileService extends RestBase {

	@Autowired
	FileRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<FileVO> create(FileVO file) {
		super.getUri();
		Map<String, String> params = new HashMap<String, String>();
		params.put("hash", file.getHash());
		
		ResponseEntity<FileVO>  ret = restTemplate.postForEntity(super.getUri(), file, FileVO.class);
		
		return ret;
	}

	public FileVO findByHash(String hash, String origem) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("hash", hash);

		ResponseEntity<FileVO> responseEntity = restTemplate.getForEntity(super.getUri(), FileVO.class, params);

		return DozerConverter.parseObject(responseEntity, FileVO.class);

	}
}
