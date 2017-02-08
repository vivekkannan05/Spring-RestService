/**
 * 
 */
package com.cycleon.rest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;


/**
 * @author vivek
 *
 */
@Service
public class ServiceExample {
		
	public String getValue(String phrase){
		
		return "Hey !!"+phrase;
			
	}
	
	
	public String updateUpsShippingNumber(String value){
		
		
		Optional<String> stringOptional = Optional.of(value);
		if(stringOptional.isPresent()){
			return "the value is "+value+"and updated";
		}
		else {
			return "the value is null";
		}
			
		}
	

}
