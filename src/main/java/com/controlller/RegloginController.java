package com.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customException.CustomerException;
import com.entity.CustomerEntity;
import com.service.RegLoginService;

@RestController
public class RegloginController {

	@Autowired
	private RegLoginService regLoginService;

	@GetMapping("/login")
	public boolean login(@RequestParam String username, @RequestParam String password) {
		return regLoginService.login(username, password);
	}

	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity,HttpStatus statusCode)
			throws CustomerException {
		try {
			regLoginService.createCustomer(customerEntity);
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
		// return regLoginService.createCustomer(customerEntity);
		return new ResponseEntity<CustomerEntity>(customerEntity, HttpStatus.CREATED);

	}

}




