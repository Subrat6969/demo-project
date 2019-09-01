package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.customException.CustomerException;
import com.entity.CustomerEntity;
import com.repository.CustomerRepository;
import com.util.EncryptionClass;

@Component
@Service
public class RegLoginService {

	@Autowired
	private CustomerRepository customerRepository;

	List<CustomerEntity> customerList = new ArrayList<CustomerEntity>();

	private List<CustomerEntity> getCustomerList() {
		return customerRepository.findAll();
	}

	public void createCustomer(CustomerEntity customerEntity) throws CustomerException {
		customerList = getCustomerList();
		String value = new EncryptionClass().encrypt(customerEntity.getPassword());
		customerEntity.setPassword(value);
		if (customerList != null && !customerList.isEmpty()) {
			for (CustomerEntity customer : customerList) {
				if (!customerEntity.getUsername().equals(customer.getUsername())) {
					customerRepository.save(customerEntity);
				} else {
					throw new CustomerException("already exist");
				}
			}
		} else {
			customerRepository.save(customerEntity);
		}
	}

	private CustomerEntity findCustomerByUsernameAndPassword(String username, String password) {
		return customerRepository.findByUsernameAndPassword(username, password);
	}

	public boolean login(String username, String password) {
		String value = new EncryptionClass().encrypt(password);
		CustomerEntity customerEntity = findCustomerByUsernameAndPassword(username, value);
		if (customerEntity != null && username.equals(customerEntity.getUsername())
				&& value.equals(customerEntity.getPassword())) {
			return true;
		}
		return false;
	}

}
