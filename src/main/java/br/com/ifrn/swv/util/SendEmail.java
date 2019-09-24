package br.com.ifrn.swv.util;

import br.com.ifrn.swv.model.Email;

public interface SendEmail {
	public void sendEmailText(Email email, String texto);
}
