package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entities.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
        entity.setActiveSw("Yes");
		contactRepo.save(entity);
		if (entity.getContactId()!= null) {
			return "Contact Inserted Successfully";

		}
		return "Insertion Failed";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> datalist = new ArrayList<>();

		List<Contact> find = contactRepo.findAll();

		for (Contact entity : find) {

			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			datalist.add(form);

		}

		return datalist;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> findbyId = contactRepo.findById(contactId);
		if (findbyId.isPresent()) {
			Contact entity = findbyId.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;

		}

		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		return viewContacts();
	}

}
