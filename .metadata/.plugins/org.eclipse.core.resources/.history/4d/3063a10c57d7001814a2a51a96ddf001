package exercises.service;

import java.util.List;

import org.springframework.stereotype.Service;

import exercises.LoanInfo;
import exercises.MonthlyPayment;
import exercises.MonthlyPaymentProducer;

@Service
public class MonthlyPaymentServiceImpl implements IMonthlyPaymentService{
	
	public List<MonthlyPayment> getAllMonthlyPayments(LoanInfo aLoanInfo){
		MonthlyPaymentProducer producer = new MonthlyPaymentProducer(aLoanInfo);
		List<MonthlyPayment> monthlyPaymentFullList = producer.generateAllMonthlyPayments();

		return monthlyPaymentFullList;
	}
	
}
