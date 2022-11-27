package com.smarttransaction.transactionsimulation.ML.MLModels;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smarttransaction.transactionsimulation.model.PredictionObject;

import jsat.ARFFLoader;
import jsat.DataSet;
import jsat.classifiers.CategoricalResults;
import jsat.classifiers.ClassificationDataSet;
import jsat.classifiers.Classifier;
import jsat.classifiers.DataPoint;
import jsat.classifiers.bayesian.NaiveBayes;
import jsat.classifiers.trees.RandomForest;
import jsat.regression.LogisticRegression;
import weka.classifiers.Evaluation;
import weka.core.FastVector;
import weka.core.Instances;

public class MLModelsImplJsat implements MLModels {
	
	
	
	
	public void AttributeToArff(PredictionObject attr) throws Exception {

		System.out.println("hii"+attr);
		PrintWriter pw= new PrintWriter("testingData.arff");
		pw.println("@relation TrainData \n");
		pw.println("@attribute Acquirer {ICICI,PNB,SBI,Kotak,J&K ,IDFC,HDFC,AU,BOB,Yes }");
		pw.println("@attribute Issuer {ICICI,PNB,SBI,Kotak,J&K ,IDFC,HDFC,AU,BOB,Yes }");
		pw.println("@attribute Time {8AM-4PM,12AM-8AM,4PM-12AM}");

		pw.println("@attribute Transaction_Type {3ds,y3ds,Si}");
		pw.println("@attribute Network_Type {visa,mastercard,rupay}");
		pw.println("@attribute Card_Type {Debit,Credit}");
		pw.println("@attribute Auth_Status {success,failure}\n");
		pw.println("@data \n");
		String [] AcquirerList= {"ICICI","PNB","SBI","Kotak","J&K","IDFC","HDFC","AU","BOB","Yes"};
		String time= attr.getValid_date().substring(11, 13);
		int t=Integer.parseInt(time);
		String tt;
		if(t>=0 && t<8)
		tt="12AM-8AM";
		else if (t>=8 && t<4)
		tt="8AM-4PM";
		else tt="4PM-12AM";
		for(int i=0;i<AcquirerList.length;i++) {
		pw.println(AcquirerList[i]
		+","+attr.getIssuer()
		+","+tt+","+attr.getTxn_process_type()+","+attr.getNetwork()+","+attr.getType()+",?");}

		pw.flush();


		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public DataSet readDataFile(String filename) {
		   File file = new File(filename);
//	    	File file2 = new File("test.arff");
//	    	System.out.println(file);
	        DataSet dataSet = ARFFLoader.loadArffFile(file);
//	        DataSet dataSet2 = ARFFLoader.loadArffFile(file2);
	        return dataSet;
	}
	
	
	public ArrayList<CategoricalResults> train(Classifier model, ClassificationDataSet TrainingDataset,ClassificationDataSet TestingDataset)throws Exception {
		
		ArrayList<CategoricalResults> predictions=new ArrayList<CategoricalResults>();
//		Classifier classifier = new NaiveBayes();
		model.trainC(TrainingDataset);
		for(int i = 0; i < TestingDataset.getSampleSize(); i++)
		{
		
		DataPoint dataPoint = TestingDataset.getDataPoint(i);//It is important not to mix these up, the class has been removed from data points in 'cDataSet'

		//Categorical Results contains the probability estimates for each possible target class value.
		//Classifiers that do not support probability estimates will mark its prediction with total confidence.
		CategoricalResults predictionResults = model.classify(dataPoint);
		
		CategoricalResults predictionResultss = model.classify(dataPoint);
		predictions.add(predictionResultss);
	
		}
		return predictions;
		// System.out.println(errors + " errors were made, " + 100.0*errors/dataSet.getSampleSize() + "% error rate" );
//		
//		
		}
	
	public double calculateAccuracy(ClassificationDataSet TrainingDataset,ArrayList<CategoricalResults> predictions) {
		double errors = 0;
		 for(int i=0;i<predictions.size();i++) {
			 //It is important not to mix these up, the class has been removed from data points in 'cDataSet'
		 int truth = TrainingDataset.getDataPointCategory(i);
		 int predicted = predictions.get(i) .mostLikely();
      if(predicted != truth)
          errors++;}
		 return errors;
	}

	
	
	public Map<String, Double> getPredictions(ArrayList<CategoricalResults> predictions,ClassificationDataSet TrainingDataset) {
		Map<String, Double> hm= new HashMap<String, Double>();
		for(int i=0;i<predictions.size();i++) {
			int a=TrainingDataset.getDataPoint(i).toString().indexOf(",");
			String ans=(String) TrainingDataset.getDataPoint(i).toString().subSequence(13, a);
			//Categorical Results contains the probability estimates for each possible target class value.
			//Classifiers that do not support probability estimates will mark its prediction with total confidence.
			int predicted = predictions.get(i).mostLikely();
//			System.out.println(ans + ": " +  predictions.get(i).getProb(predicted)*100+"%\n");
			hm.put(ans, predictions.get(i).getProb(predicted)*100);
		}
		return hm;
	}


	public Map<String, Double> findBestAcquirer(PredictionObject TestFileName, String Library) throws Exception {

//		TransactionAttributes att= new TransactionAttributes();
		 AttributeToArff(TestFileName);

		DataSet dataset=readDataFile("Transactions.arff");
		DataSet TestDataset=readDataFile("testingData.arff");
//		ClassificationDataSet TrainDataset = new ClassificationDataSet(splits . get (0), 6);
//		ClassificationDataSet TestingDataset = new ClassificationDataSet(TestDataset, 6);
		List < ClassificationDataSet > splits = dataset . randomSplit (0.75 , 0.25) ;
		ClassificationDataSet train = new ClassificationDataSet(splits . get (0), 6); 
		ClassificationDataSet test = new ClassificationDataSet(splits . get (0), 6); 
		ClassificationDataSet TestingDataset = new ClassificationDataSet(TestDataset, 6);
		Classifier[] models = { 

				new NaiveBayes(),
				new RandomForest(),
				new LogisticRegression()//one-level decision tree
		};
		
		Map<String, Double> hmm= new HashMap<String, Double>();
		
		
		for(int i=0;i<models.length;i++) {
		 ArrayList<CategoricalResults> trainingResults= train(models[i], train, test);
		 double accuracy= calculateAccuracy(train,trainingResults);
		 ArrayList<CategoricalResults> testingResults= train(models[i], train, TestingDataset);
		 
		 
		 hmm=getPredictions(testingResults, TestingDataset)  ;
		 
		 System.out.println("Accuracy of "+models[i].getClass().getSimpleName()+" is "+accuracy+"\n");
		 System.out.println("------------------------------------------");
		}
		
		
		
		return hmm;
	}
	
	
	
	
	
	
	
	
	public Evaluation train(weka.classifiers.Classifier model, Instances trainingSet, Instances testingSet)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<CategoricalResults> train(weka.classifiers.Classifier model, ClassificationDataSet TrainingDataset,
			ClassificationDataSet TestingDataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public double calculateAccuracy(FastVector predictions) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Instances[][] crossValidationSplit(Instances data, int numberOfFolds) {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<String, Double> getPredictions(FastVector finalPredictionVector, Instances Predictdata) {
		// TODO Auto-generated method stub
		return null;
	}



	
	

}
