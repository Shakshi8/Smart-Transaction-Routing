package com.smarttransaction.transactionsimulation.ML.BPAFinder;

import java.util.Map;

import com.smarttransaction.transactionsimulation.ML.MLModelBPA.MLModel;
import com.smarttransaction.transactionsimulation.ML.MLModelsAdapter.MLModelsAdapters;
import com.smarttransaction.transactionsimulation.model.PredictionObject;
import com.smarttransaction.transactionsimulation.ML.MLModels.MLModels;

public class BPAFinder implements MLModel {

	public Map<String, Double> findBestAcquirer(PredictionObject TestFileName, String Library) throws Exception {
		MLModelsAdapters MLModelAdapter= new MLModelsAdapters(Library);
		return MLModelAdapter.findBestAcquirer(TestFileName, Library);
		
	}
	
}
