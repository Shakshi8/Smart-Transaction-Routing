package com.smarttransaction.transactionsimulation.ML.MLModelBPA;

import java.util.Map;

import com.smarttransaction.transactionsimulation.model.PredictionObject;

public interface MLModel {
	
	 public Map<String, Double> findBestAcquirer(PredictionObject TestFileName , String Library) throws Exception;

}
