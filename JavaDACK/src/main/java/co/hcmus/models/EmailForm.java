package co.hcmus.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class EmailForm{
	@NotNull
	@Email
	public String reciver;

	@Size(min=1)
	@NotNull
	public String subject;

	@Size(min=1)
	@NotNull
	public String body;

	public EmailForm(){

	}
}