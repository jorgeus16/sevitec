package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Usuario;
import forms.UsuarioRegistrationForm;
import repositories.UsuarioRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioService() {
		super();
	}

	public Usuario create() {

		Usuario u = new Usuario();
		UserAccount ua = new UserAccount();
		ua.setUsername("");
		ua.setPassword("");

		Authority auth = new Authority();
		auth.setAuthority("CLIENTES");

		ua.addAuthority(auth);
		u.setUserAccount(ua);

		return u;
	}

	public Usuario reconstruct(UsuarioRegistrationForm urf) {

		Usuario u = create();
		UserAccount ua = new UserAccount();
		Authority auth = new Authority();
		
		auth.setAuthority("CLIENTES");

		ua.setUsername(urf.getUsername());
		ua.setPassword(urf.getPassword());
		ua.addAuthority(auth);
		u.setUserAccount(ua);

		return u;
	}

	public void save(Usuario u) {
		
		UserAccount ua = u.getUserAccount();
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String pass = md5PasswordEncoder.encodePassword(ua.getPassword(), null);
		ua.setPassword(pass);
		u.setUserAccount(ua);
		
		usuarioRepository.save(u);
	}
	
	public Usuario findByPrincipal() {
		Usuario result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);

		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
	
	public Usuario findByUserAccount(final UserAccount userAccount) {
		Usuario result;

		result = this.usuarioRepository.findByUserAccountId(userAccount.getId());

		return result;
	}
}
