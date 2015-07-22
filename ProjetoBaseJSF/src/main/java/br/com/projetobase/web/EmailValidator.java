package br.com.projetobase.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String enteredEmail = (String) value;
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(enteredEmail);

		boolean matchFound = m.matches();

		if (!matchFound) {
			FacesMessage message = new FacesMessage();
			message.setDetail("E-mail incorreto!");
			message.setSummary("E-mail incorreto!");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		} 	
	}

}
