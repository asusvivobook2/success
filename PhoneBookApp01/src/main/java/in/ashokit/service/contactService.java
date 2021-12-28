package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.contactForm;

public interface contactService {
	
	
	public String saveContact(contactForm form);
	
	public List<contactForm> viewContacts();
	
	public contactForm editContact(Integer contactId);
	
	public List<contactForm> deleteContact(Integer contactId);
	
}
