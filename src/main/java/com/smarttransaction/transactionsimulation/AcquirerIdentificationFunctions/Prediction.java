package com.smarttransaction.transactionsimulation.AcquirerIdentificationFunctions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.smarttransaction.transactionsimulation.ML.BPAFinder.BPAFinder;
import com.smarttransaction.transactionsimulation.ML.MLModels.TrainAndSaveWekaModel;
import com.smarttransaction.transactionsimulation.kafka.KafkaInitiation;


import jsat.linear.distancemetrics.TrainableDistanceMetric;

import com.smarttransaction.transactionsimulation.model.AggregationRequest_Object;
import com.smarttransaction.transactionsimulation.model.PredictionObject;

public class Prediction {

	private String predict;
	KafkaInitiation kafka=new KafkaInitiation();
	public static HashMap<String, Double> sortByValue(Map<String, Double> UnsortedMap)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list =
               new LinkedList<Map.Entry<String, Double> >(UnsortedMap.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> item1,
                               Map.Entry<String, Double> item2)
            {
                return (item2.getValue()).compareTo(item1.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Double> SortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> item : list) {
        	SortedMap.put(item.getKey(), item.getValue());
        }
        return SortedMap;
    }
	
	public Map<String, Double> prediction(PredictionObject predictionObject) throws Exception {
		
		Map<String, Double> AcquirerPerformancePredictions= new HashMap<String, Double>();
		BPAFinder bPAFinder=new BPAFinder();
		AcquirerPerformancePredictions=bPAFinder.findBestAcquirer(predictionObject,"weka" );
		
		AcquirerPerformancePredictions=sortByValue(AcquirerPerformancePredictions);

		
		
		return AcquirerPerformancePredictions;
		
		
		
		
		
	}	
		
}
