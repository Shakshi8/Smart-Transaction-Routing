package com.smarttransaction.transactionsimulation.ML.MLModelsAdapter;

import java.util.HashMap;
import java.util.Map;

import com.smarttransaction.transactionsimulation.ML.MLModels.MLModels;

import com.smarttransaction.transactionsimulation.ML.MLModels.MLModelsImplJsat;
import com.smarttransaction.transactionsimulation.ML.MLModels.MLModelsImplWeka;
import com.smarttransaction.transactionsimulation.model.PredictionObject;

public class MLModelsAdapters implements com.smarttransaction.transactionsimulation.ML.MLModelBPA.MLModel {
	
	
	MLModels mlModel;
	public MLModelsAdapters(String Library){
		   
	      if(Library.equalsIgnoreCase("Weka") ){
	         mlModel = new MLModelsImplWeka();			
	         
	      }else if (Library.equalsIgnoreCase("Jsat")){
	         mlModel = new MLModelsImplJsat();
	      }	
	   }
	
	 public Map<String, Double> findBestAcquirer(PredictionObject TestFileName , String Library) throws Exception {
		 return mlModel.findBestAcquirer(TestFileName, Library);
	   }
	
}
