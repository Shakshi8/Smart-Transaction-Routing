package com.smarttransaction.transactionsimulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smarttransaction.transactionsimulation.ML.MLModels.TrainAndSaveWekaModel;

@SpringBootApplication
public class TransactionsimulationApplication {

	public static void main(String[] args) throws Exception {
		TrainAndSaveWekaModel saveweka=new TrainAndSaveWekaModel("./target/Transactions.arff");
		SpringApplication.run(TransactionsimulationApplication.class, args);
	}

}
