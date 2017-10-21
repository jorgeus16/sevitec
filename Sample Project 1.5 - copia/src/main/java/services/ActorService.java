
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;

@Service
@Transactional
public class ActorService {

	//Managed Repository =============================================================================

	@Autowired
	private ActorRepository	actorRepository;


	//Supported Services =============================================================================

	//Constructor methods ============================================================================

	public ActorService() {
		super();
	}

	//Simple CRUD methods ============================================================================

	public Collection<Actor> findAll() {
		Collection<Actor> result;

		result = this.actorRepository.findAll();

		return result;
	}
	
	public Actor findOne(int actorId){
		Actor result;
		
		result = actorRepository.findOne(actorId);
		
		return result;
	}

	//Other Business Methods =========================================================================

	public Actor findByPrincipalUsuario() {
		Actor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipalUsuario();
	//	Assert.notNull(userAccount);
		result = this.findByUserAccount(userAccount);
	//	Assert.notNull(result);

		return result;
	}

	public Actor findByPrincipal() {
		Actor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = this.findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
	public Actor findByUserAccount(final UserAccount userAccount) {
		Actor result;

		result = this.actorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}
}
