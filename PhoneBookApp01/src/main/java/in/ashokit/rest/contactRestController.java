package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.contactForm;
import in.ashokit.service.contactService;

@RestController
public class contactRestController {

	@Autowired
	private contactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody contactForm form) {
      System.out.println("rest save ");
   
		return service.saveContact(form);
	}

	@GetMapping("/view")
	public List<contactForm> viewContacts() {
		return service.viewContacts();

	}

	@GetMapping("/edit/{contactId}")
	public contactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}

	@GetMapping("/delete/{contactId}")
	public List<contactForm> deleteContact(@PathVariable Integer contactId) {
		return service.deleteContact(contactId);

	}

}