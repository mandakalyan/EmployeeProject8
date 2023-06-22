package com.spring.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.entity.Otl;
import com.spring.employee.entity.Timex;
import com.spring.employee.repository.OtlRepository;
import com.spring.employee.repository.TimexRepository;


@RestController
@RequestMapping("/api")
public class TimeSheetsController
{
	@Autowired
	TimexRepository timexRepo;
	
	@Autowired
	OtlRepository otlRepo;
	
	
	@PostMapping("/otls")
    public ResponseEntity<String> createOtl(@RequestBody Otl otlRequest) {
        try {
            Otl otl = new Otl();
            otl.setMonday(otlRequest.getMonday());
            otl.setTuesday(otlRequest.getTuesday());
            otl.setWednesday(otlRequest.getWednesday());
            otl.setThursday(otlRequest.getThursday());
            otl.setFriday(otlRequest.getFriday());
            otl.setSowd(otlRequest.getSowd());
            otl.setSowe(otlRequest.getSowe());
            otl.setCowd(otlRequest.getCowd());
            otl.setCowe(otlRequest.getCowe());
            otl.setSoph(otlRequest.getSoph());
            otl.setCoph(otlRequest.getCoph());

            Otl createdOtl = otlRepo.save(otl);
            return ResponseEntity.status(HttpStatus.CREATED).body("OTL created successfully with ID: " + createdOtl.getOtlId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create OTL: " + e.getMessage());
        }
    }
	
	@PostMapping("/timex")
	public ResponseEntity<String> createTimex(@RequestBody Timex tim)
	{
		Timex t= new Timex();
		t.setMonday(tim.getMonday());
		t.setTuesday(tim.getTuesday());
		t.setWednesday(tim.getWednesday());
		t.setThursday(tim.getThursday());
		t.setFriday(tim.getFriday());
		t.setOverTime(tim.getOverTime());
		
		Timex createTimex = timexRepo.save(tim);
		try {
			
		
		return ResponseEntity.status(HttpStatus.CREATED).body("timex created sucessfully with ID" + createTimex.getTimexId());
	}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to create Timex"+e.getMessage());
		}
		}
	
	
	@GetMapping("/validate")
	public ResponseEntity<String> validateOtlAndTimex() {
	    try {
	    	Otl otl1 =new Otl();
	    	Timex timex1 =new Timex();
	    	
	        Optional<Otl> optionalOtl = otlRepo.findById(otl1.getOtlId()); // Replace 1 with the desired ID
	        Optional<Timex> optionalTimex = timexRepo.findById(timex1.getTimexId()); // Replace 1 with the desired ID

	        if (optionalOtl.isPresent() && optionalTimex.isPresent()) {
	            Otl otl = optionalOtl.get();
	            Timex timex = optionalTimex.get();

	            // Calculate the sum of both entities and compare
	            float otlSum = otl.getMonday() + otl.getTuesday() + otl.getWednesday() + otl.getThursday() + otl.getFriday()+otl.getCowd()+otl.getCowe()+otl.getSowe()+otl.getSowd()+otl.getCoph()+otl.getSoph();
	            float timexSum = timex.getMonday() + timex.getTuesday() + timex.getWednesday() + timex.getThursday() + timex.getFriday()+timex.getOverTime();

	            if (otlSum == timexSum) {
	                return ResponseEntity.ok("Validated: The sums are equal.");
	            } else {
	                return ResponseEntity.ok("Validation failed: The sums are not equal.");
	            }
	        } else {
	            return ResponseEntity.ok("Validation failed: Otl or Timex not found.");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to validate: " + e.getMessage());
	    }
	}	
	
	
	@GetMapping("getotls")
	public List< Otl> getOtl()
	{
		
			
		
		List<Otl> otl =new ArrayList<Otl>();
		otlRepo.findAll().forEach(otl1 -> otl.add(otl1));
		return otl;
	}
    
	@GetMapping("getotl/{otlid}")
	public Otl getOtlById(@RequestParam int otlid) 
	{
		return otlRepo.findById(otlid).get();
	}
	
	@PutMapping("/updateotl")
	public Otl updateOtlById(@RequestBody
			Otl otl) {
		return otlRepo.save(otl);
	}
	@DeleteMapping("/deleteotl/{otlid}")
	public void deleteOtlById(@PathVariable int otlid) {
		
	    otlRepo.deleteById(otlid);
	}

}
