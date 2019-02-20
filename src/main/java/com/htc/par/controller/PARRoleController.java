package com.htc.par.controller;

/*@author - Fazlur Rahman
 * Controller to handle Role information
 */
public class PARRoleController {
	
	/*@PostMapping(value="/newPARRole", consumes="application/json", produces="application/json")
	@ResponseBody
	public ProductResponse newproduct(@RequestBody @Valid PARRoleTO pARRoleTO, BindingResult result){
		
		ProductResponse response = new ProductResponse();
		
		if(result.hasErrors()){
			System.out.println("Errors");
			Map<String, String> errors = result.getFieldErrors().stream()
		               .collect(
		                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
		                 );
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else{
			System.out.println("No errros");
			response.setValidated(true);
			boolean insertStatus = productservice.newproduct(productTO);
			if(insertStatus){
				response.setStatusMessage("Product added successfully");
			}
			else{
				response.setStatusMessage("Error while saving Product record");
			}
		}
		System.out.println(productTO);		
		return response;
	}*/
	
}
