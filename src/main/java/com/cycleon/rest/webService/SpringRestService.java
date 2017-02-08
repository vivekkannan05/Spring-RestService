/**
 * 
 */
package com.cycleon.rest.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cycleon.rest.service.ServiceExample;

/**
 * @author vivek
 *
 */
	@RestController
	@RequestMapping("/Rest")
	public class SpringRestService {
		
		@Autowired
		ServiceExample serviceExample;
		
		@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE, value="/test")
		@ResponseBody
		public ResponseEntity<String> testGet() {
			return ResponseEntity.ok(serviceExample.getValue("Cycleon"));
		}
		
		@RequestMapping(method=RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE,consumes=MediaType.TEXT_XML_VALUE, value="/shippingNumber/{accountNumber}")
		public String updateAndgetShippingNumber(@PathVariable String accountNumber){
			String shippingNumber =  serviceExample.updateUpsShippingNumber(accountNumber);
			return shippingNumber;
			
		}

	}

