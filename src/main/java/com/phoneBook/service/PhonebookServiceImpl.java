package com.phoneBook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phoneBook.EmployeeRepository.PhonebookRepository;
import com.phoneBook.exceptions.ResourceNotFoundException;
import com.phoneBook.model.Phonebook;

@Service
public class PhonebookServiceImpl implements PhonebookService{

	private PhonebookRepository phonebookRepository;
	
	public PhonebookServiceImpl(PhonebookRepository phonebookRepository) {
		super();
		this.phonebookRepository = phonebookRepository;
	}

	@Override
	public Phonebook savePhonebook(Phonebook phonebook) {
		return phonebookRepository.save(phonebook);
	}

	@Override
	public List<Phonebook> getAllPhonebook() {
		return phonebookRepository.findAll();
	}

	@Override
	public Phonebook getPhonebookById(long id) {

		return phonebookRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Phonebook", "Id", id));
		
	}

	@Override
	public Phonebook updatePhonebook(Phonebook phonebook, long id) {
		
		// we need to check whether Phone book record with given id is exist in DB or not
		Phonebook existingphonebook = phonebookRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Phonebook", "Id", id)); 
		
		existingphonebook.setFirstName(phonebook.getFirstName());
		existingphonebook.setLastName(phonebook.getLastName());
		existingphonebook.setEmail(phonebook.getEmail());
		// save existing Phone book record to DB
		phonebookRepository.save(existingphonebook);
		return existingphonebook;
	}

	@Override
	public void deletePhonebook(long id) {
		
		// check whether a employee exist in a DB or not
		phonebookRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Phonebook", "Id", id));
		phonebookRepository.deleteById(id);
	}
	
}