package utilities.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import forms.UsuarioRegistrationForm;

public class MatchPasswordsValidator implements ConstraintValidator<MatchPasswords, UsuarioRegistrationForm> {

	@Override
	public void initialize(MatchPasswords constraintAnnotation) {

	}

	@Override
	public boolean isValid(UsuarioRegistrationForm urf, ConstraintValidatorContext cvc) {

		return urf.getPassword().equals(urf.getVerifyPassword());
	}

}