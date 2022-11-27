
package com.smarttransaction.transactionsimulation.AcquirerIdentificationFunctions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.smarttransaction.transactionsimulation.model.PredictionObject;
import com.smarttransaction.transactionsimulation.model.AggregatedResponse_Object;public class Ranking {
Prediction predictionObject=new Prediction();
public static HashMap<String, Double> sortByValue(Map<String, Double> Unsorted_Map)
{
// Create a list from elements of HashMap
List<Map.Entry<String, Double> > Unsorted_list =
new LinkedList<Map.Entry<String, Double> >(Unsorted_Map.entrySet());
// Sort the list
Collections.sort(Unsorted_list, new Comparator<Map.Entry<String, Double> >() {
public int compare(Map.Entry<String, Double> item1,
Map.Entry<String, Double> item2)
{
return (item2.getValue()).compareTo(item1.getValue());
}
});
// put data from sorted list to hashmap
HashMap<String, Double> sorted_list = new LinkedHashMap<String, Double>();
for (Map.Entry<String, Double> item : Unsorted_list) {
sorted_list.put(item.getKey(), item.getValue());
}
return sorted_list ;
} 



public String ranking(PredictionObject Prediction_Req_Object, List<AggregatedResponse_Object> RealTimeDataList) throws Exception
{

	
//ml prediction
Map<String, Double> MlModelPredictionResponse=predictionObject.prediction(Prediction_Req_Object);
System.out.println("ML Model Predictions: ");
for (Map.Entry<String, Double> item : MlModelPredictionResponse.entrySet()) {
	
    System.out.print(item.getKey() + ":");
    System.out.println(item.getValue());
//	}
}


// Attributes a1= new Attributes();

//System.out.println(list.toString());
System.out.println("Realtime List Size= "+RealTimeDataList.size());

Double FinalScore=0.0;
double RealTimeScore=0;
double mlScore=0;
double LatencyScore=0;
Map<String,double[]> RealTimePerformance= new HashMap<String,double[]>();
Map<String,Double> Performances= new HashMap<String,Double>();

if(RealTimeDataList.isEmpty()) {
	System.out.println("******** REALTIME DATA NOT AVAILABLE******** \n");

System.out.println("***********"+"BEST Performing Acquirer according to ML Model is "+MlModelPredictionResponse.keySet().toArray()[0].toString()+"************");

return MlModelPredictionResponse.keySet().toArray()[0].toString();
}
	
else {
System.out.println("Realtime List Size= "+RealTimeDataList.size());
for(int i=0;i< RealTimeDataList.size()  ;i++) {

//	System.out.println(list.get(i).toString());
	AggregatedResponse_Object RealTimeDataObject=new AggregatedResponse_Object();
	RealTimeDataObject=RealTimeDataList.get(i);
	double[] RealtimePerformanceScores= {0,0};
	
	
	if(RealTimeDataObject.getCardNetwork().equalsIgnoreCase(Prediction_Req_Object.getNetwork()) && RealTimeDataObject.getCardType().equalsIgnoreCase(Prediction_Req_Object.getType())
			&& RealTimeDataObject.getIssuer().equalsIgnoreCase(Prediction_Req_Object.getIssuer())) {
		RealtimePerformanceScores[0]=RealTimeDataObject.getSUCCESS_RATE();
		RealtimePerformanceScores[1]=RealTimeDataObject.getAverage_Latency();
//		System.out.println("before ml model pred");
		mlScore=(double)MlModelPredictionResponse.get(RealTimeDataObject.getAcquirer());
		RealTimePerformance.put(RealTimeDataObject.getAcquirer(), RealtimePerformanceScores);
		 RealTimeScore=RealtimePerformanceScores[0];
		 LatencyScore=RealtimePerformanceScores[1];
		 FinalScore=(Double)(0.3*mlScore+0.7*RealTimeScore-0.2*(LatencyScore/1000));
		 Performances.put(RealTimeDataObject.getAcquirer(), FinalScore);


	}
	



//System.out.println("Acquirer "+at.getAcquirer()+" ml-score"+mlScore+" Realtime "+RealTimeScore+" Latency "+LatencyScore+" "+FinalScore);

}




for (Map.Entry<String, double[]> mee : RealTimePerformance.entrySet()) {
System.out.print(mee.getKey() + "--->");
System.out.println(" Realtime Success_Rate: "+mee.getValue()[0]+" Average_Latency: "+mee.getValue()[1]);
	}






HashMap<String, Double> FinalPerformances= new HashMap<String, Double>();
FinalPerformances=sortByValue(Performances);

System.out.println("******* Final Scores *******");

for (Map.Entry<String, Double> item : FinalPerformances.entrySet()) {

System.out.print(item.getKey() + " : ");
System.out.println(item.getValue());

}

System.out.println("***********"+"BEST Performing Acquirer is "+FinalPerformances.keySet().toArray()[0].toString()+"************");
return FinalPerformances.keySet().toArray()[0].toString();

//else {
//	System.out.println("******** REALTIME DATA NOT AVAILABLE********");
//	
//	System.out.println("***********"+"BEST Performing Acquirer according to ML Model is "+MlModelPredictionResponse.keySet().toArray()[0].toString()+"************");
//	
//	return MlModelPredictionResponse.keySet().toArray()[0].toString();
}

}

}

