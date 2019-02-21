/**
 * 
 */
package com.htc.par.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.service.SkillService;
import com.htc.par.to.SkillTO;

/**
 * Rest controller for Skill service
 *
 */

@RestController
@RequestMapping("/par")
public class SkillController {

	@Autowired
	private SkillService skillService;

	/**
	 * Request handler to get skill by id
	 * @param skillId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/skills/{skillId}")
	public ResponseEntity<SkillTO> getSkillById(@PathVariable("skillId") int skillId) throws ResourceNotFoundException {
		return ResponseEntity.ok(skillService.getSkillById(skillId));
	}

	/**
	 * Request handler to get all skills 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/skills")
	public ResponseEntity<List<SkillTO>> getSkills() throws ResourceNotFoundException {
		return ResponseEntity.ok(skillService.getAllSkills());
	}

	/**
	 * Request handler to new active skill
	 * @param skillTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/skills")
	public ResponseEntity<SkillTO> createSkill(@RequestBody SkillTO skillTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(skillService.createSkill(skillTO));
	}

	/**
	 * Request handler to update active skill
	 * @param skillTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/skills")
	public ResponseEntity<SkillTO> updateProduct(@RequestBody SkillTO skillTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(skillService.updateSkill(skillTO));
	}

	/**
	 * Request handler to delete skill
	 * @param skillId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/skills/{skillId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("skillId") int skillId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(skillService.deleteSkill(skillId));
	}
}
