package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Usuario;
import domain.SearchTemplate;
import repositories.SearchTemplateRepository;

@Service
@Transactional
public class SearchTemplateService {

	@Autowired
	private SearchTemplateRepository searchTemplateRepository;

	@Autowired
	private UsuarioService usuarioService;

	public SearchTemplateService() {
		super();
	}

	public SearchTemplate create() {

		SearchTemplate s = new SearchTemplate();

		return s;
	}


	public SearchTemplate save(SearchTemplate s) {

		return searchTemplateRepository.saveAndFlush(s);
	}
	
	public SearchTemplate findByPrincipal() {
		SearchTemplate result;
		Usuario usuario;
		
		usuario = this.usuarioService.findByPrincipal();
		result = usuario.getSearchTemplate();
		
		return result;
	}
	
	public SearchTemplate findOne(Integer searchTemplateId) {
		SearchTemplate result;

		result = this.searchTemplateRepository.findOne(searchTemplateId);

		return result;
	}
}
