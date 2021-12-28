package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.contactForm;
import in.ashokit.entities.Contact;
import in.ashokit.repository.contactRepository;

@Service
public class contactServiceImpl implements contactService {

	@Autowired
	private contactRepository contactRepo;

	@Override
	public String saveContact(contactForm form) {
		System.out.println("service save ");
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);

		contactRepo.save(entity);
		if (entity.getContactId()!= null) {
			return "Contact Inserted Successfully";

		}
		return "Insertion Failed";
	}

	@Override
	public List<contactForm> viewContacts() {
		List<contactForm> datalist = new ArrayList<>();

		List<Contact> find = contactRepo.findAll();

		for (Contact entity : find) {

			contactForm form = new contactForm();
			BeanUtils.copyProperties(entity, form);
			datalist.add(form);

		}

		return datalist;
	}

	@Override
	public contactForm editContact(Integer contactId) {
		Optional<Contact> findbyId = contactRepo.findById(contactId);
		if (findbyId.isPresent()) {
			Contact entity = findbyId.get();
			contactForm form = new contactForm();
			BeanUtils.copyProperties(entity, form);
			return form;

		}

		return null;
	}

	@Override
	public List<contactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		return viewContacts();
	}

}
