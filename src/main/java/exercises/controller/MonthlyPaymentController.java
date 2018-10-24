package exercises.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import exercises.LoanInfo;
import exercises.MonthlyPayment;
import exercises.service.IMonthlyPaymentService;

@RestController
public class MonthlyPaymentController {

	@Autowired
	IMonthlyPaymentService monthlyPaymentService;
	
	@CrossOrigin
	@GetMapping("allmonthlypayments")
	public ResponseEntity<List<MonthlyPayment>> getAllMonthlyPayments(LoanInfo aLoanInfo) {
		List<MonthlyPayment> list = monthlyPaymentService.getAllMonthlyPayments(aLoanInfo);
		return new ResponseEntity<List<MonthlyPayment>>(list, HttpStatus.OK);
	}

}
