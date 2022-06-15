package com.phoneBook.EmployeeRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.phoneBook.model.Phonebook;

public interface PhonebookRepository extends JpaRepository<Phonebook, Long>{

}


