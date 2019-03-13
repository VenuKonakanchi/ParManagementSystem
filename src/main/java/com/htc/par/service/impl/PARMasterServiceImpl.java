/**
 * 
 */
package com.htc.par.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.PARMaster;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.PARMasterRepository;
import com.htc.par.service.EmailService;
import com.htc.par.service.PARMasterService;
import com.htc.par.service.RecruiterService;
import com.htc.par.to.PARMasterTO;
import com.htc.par.to.RecruiterTO;
import com.htc.par.utilities.EmailDetails;

/**
 * Service Implementation for PAR Master service
 *
 */

@Service
public class PARMasterServiceImpl implements PARMasterService {
	
	@Autowired
	PARMasterRepository parMasterRepository;
	
	@Autowired
	private RecruiterService recruieterService;
	
	@Autowired
	private EmailService emailService;
	

	@Override
	public PARMasterTO getParMasterById(Integer parId) throws ResourceNotFoundException {
		Optional<PARMaster> parMasterOptional = parMasterRepository.findById(parId);
		PARMasterTO parMasterTO = null;
		if(!parMasterOptional.isPresent())
			throw new ResourceNotFoundException(String.format("PAR ID : %s not found!", parId));
		
		PARMaster parMaster = parMasterOptional.get();
		parMasterTO = getParMasterTO(parMaster);
		return parMasterTO;
	}

	@Override
	public List<PARMasterTO> getAllParMaster() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO updateParMaster(PARMasterTO parMasterTO)
			throws ResourceDuplicateException, ResourceNotUpdatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO createParMaster(PARMasterTO parMasterTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteParMaster(Integer parId) throws ResourceNotFoundException, ResourceNotDeletedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PARMasterTO getParMasterTO(PARMaster parMaster) {
		
		return new PARMasterTO(parMaster.getParId(), parMaster.getParNumber(), parMaster.getParDescriptionText(), parMaster.getParReceivedDate(),
			parMaster.getParStatus(), parMaster.getIntentToFillIndicator(),parMaster.getIntentToFillDate(), parMaster.getEmailSent(), parMaster.getParComment());
	}

	@Override
	public PARMaster getParMaster(PARMasterTO parMasterTO) {
		
		return new PARMaster(parMasterTO.getParId(),parMasterTO.getParNumber(), parMasterTO.getParDescriptionText(), parMasterTO.getParReceivedDate(),
				parMasterTO.getParStatus(), parMasterTO.getIntentToFillIndicator(), parMasterTO.getEmailSent(), parMasterTO.getParComment(),
				parMasterTO.getIntentToFillDate());
	}

	@Override
	public List<PARMasterTO> getAllParMasters() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO getParMasterByParNumber(String parNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PARMasterTO> getAllActiveOrReceivedPar() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PARMasterTO> getAllParByStatus() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO intentToFill(Integer parId, LocalDate intentToFillDate, Boolean intentToFillIndicator) throws ResourceNotFoundException, ResourceNotUpdatedException {
		
		PARMasterTO parMasterTO = null;
		try
		{
		Optional<PARMaster> parMasterOptional = parMasterRepository.findById(parId);
		if(!parMasterOptional.isPresent())
			throw new ResourceNotFoundException(String.format("PAR ID : %s not found!", parId));
		
		PARMaster parMaster = parMasterOptional.get();
		
		parMaster.setIntentToFillDate(intentToFillDate);
		parMaster.setIntentToFillIndicator(intentToFillIndicator);
		
		parMaster = parMasterRepository.save(parMaster);
		
		parMasterTO = getParMasterTO(parMaster);
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException("PAR Intent to fill  is not Updated!");
		}
		
		return parMasterTO;
	}

	@Override
	public boolean sendEmailToRecruiters(Integer parId) throws ResourceNotCreatedException,ResourceNotFoundException {
		
		EmailDetails emailDetail= null;
		PARMasterTO parMasterTO= getParMasterById(parId);
		
		if(parMasterTO!=null) {
		 emailDetail= new EmailDetails(fetchEmailTOList(), getSubject(parMasterTO.getParNumber()), getContent(parMasterTO));
		}else {
			throw new ResourceNotFoundException("Unable to fetch PAR Details for the par ID "+parId+"Contact PAR Support");
		}
		
		/*EmailDetails emailDetail= new EmailDetails();
		List<String> emailList=new ArrayList<>();
		emailList.add("rahman.shaik@htcinc.com");
		emailList.add("shyam.kandi@htcinc.com");
		String emailString =String.join(",", emailList);
		InternetAddress[] emailTOArray=null;
		try {
			 emailTOArray= InternetAddress.parse(emailString);
		} catch (AddressException e) {
			throw new ResourceNotFoundException("Invalid Recruiter Email"+emailString);
			
		}
		String emailSubject="Test subject";
		String description ="Hello TEST";
		emailDetail.setEmailTo(emailTOArray);
		emailDetail.setEmailBody(description);
		emailDetail.setEmailSubject(emailSubject);*/
		boolean mailStatus=emailService.sendEmail(emailDetail);
		//System.out.println("mailStatus--->"+mailStatus);
		return mailStatus;
	}

	
	@Override
	public List<PARMasterTO> getAllParsByStatusAndDateRange(String parStatus, LocalDate startDate, LocalDate endDate)
			throws ResourceNotFoundException {
		List<PARMaster> parMasters = parMasterRepository.findAllByParStatusAndParReceivedDateBetween(parStatus,startDate,endDate);
		
		if (CollectionUtils.isEmpty(parMasters))
			throw new ResourceNotFoundException(String.format("No PARs found between given dates %s and %s whith status %s", startDate,endDate, parStatus));
		List<PARMasterTO> parMasterTOs = parMasters.stream().map(PARMaster -> {
			return getParMasterTO(PARMaster);
		}).collect(Collectors.toList());
		return parMasterTOs;

	}

	@Override
	public List<PARMasterTO> getAllParsByDateRange(LocalDate startDate, LocalDate endDate)
			throws ResourceNotFoundException {
		List<PARMaster> parMasters = parMasterRepository.findAllByParReceivedDateBetween(startDate,endDate);
		
		if (CollectionUtils.isEmpty(parMasters))
			throw new ResourceNotFoundException(String.format("No PARs received between given dates %s and %s", startDate,endDate));
		List<PARMasterTO> parMasterTOs = parMasters.stream().map(PARMaster -> {
			return getParMasterTO(PARMaster);
		}).collect(Collectors.toList());
		return parMasterTOs;
	}
	
	private InternetAddress[] fetchEmailTOList() throws ResourceNotFoundException  {
		InternetAddress[] emailTOArray=null;
		List<RecruiterTO> recruiterTOList=recruieterService.getRecruiterByRecruiterEmailFlag(true);
		List<String> emailList=recruiterTOList.stream().map(recruiter->recruiter.getRecruiterEmail()).collect(Collectors.toList());
		
		
		String emailString =String.join(",", emailList);
		try {
			 emailTOArray= InternetAddress.parse(emailString);
		} catch (AddressException e) {
			throw new ResourceNotFoundException("Invalid Recruiter Email"+emailString);
			
		}
		return emailTOArray;
		
	}
	
	 private String getSubject(String parNumber) {
	        return "I/A: Request for Candiates for the PAR  "+parNumber;
	    }

	    public String getContent(PARMasterTO parMasterTO) {
	        return "<html>" +
	                    "<body>" +
	                        "<p>Hello ,</p> <br>" +
	                        "<p>PAR # <strong>"+parMasterTO.getParNumber()+" </strong> .</p><br>" +
	                        "<p> <strong>PAR Description : </strong> "+parMasterTO.getParDescriptionText()+"</p>" +
	                        "<br><p>  Provide Suitable Candidates for this PAR  </p>" +
	                        "<br> <br>" +
	                        "Thanks,<br> AMO Team<br>" +
	                  "</body>" +
	                "</html>";
	    }

}
