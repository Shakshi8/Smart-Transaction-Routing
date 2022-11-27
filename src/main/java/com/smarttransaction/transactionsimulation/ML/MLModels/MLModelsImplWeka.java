package com.smarttransaction.transactionsimulation.ML.MLModels;

import java.io.BufferedReader;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.smarttransaction.transactionsimulation.model.PredictionObject;

import jsat.DataSet;
import jsat.classifiers.CategoricalResults;
import jsat.classifiers.ClassificationDataSet;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.functions.Logistic;
import weka.classifiers.trees.RandomForest;
import weka.core.FastVector;
import weka.core.Instances;

public class MLModelsImplWeka implements MLModels {
	
	
	
public void AttributeToArff(PredictionObject attr) throws Exception {
		
		PrintWriter pw= new PrintWriter("testingData.arff");
		pw.println("@relation TrainData \n");
		pw.println("@attribute Acquirer {ICICI,PNB,SBI,Kotak,J&K ,IDFC,HDFC,AU,BOB,Yes }");
		pw.println("@attribute Issuer {ICICI,PNB,SBI,Kotak,J&K ,IDFC,HDFC,AU,BOB,Yes }");
		pw.println("@attribute Time {8AM-4PM,12AM-8AM,4PM-12AM}");
		
		pw.println("@attribute Transaction_Type {3DS,y3ds,SI}");
		pw.println("@attribute Network_Type {visa,mastercard,rupay}");
		pw.println("@attribute Card_Type {debit,credit}");
		pw.println("@attribute Auth_Status {0300,0399}\n");
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
	
	
	
	
	
	
	
	
	public BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
		 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
		return inputReader;
	}

	
	
	public Evaluation train(Classifier model, Instances trainingSet, Instances testingSet)throws Exception {
		
		Evaluation evaluation = new Evaluation(trainingSet);
		model.buildClassifier(trainingSet);
//		double pred = evaluation.evaluateModelOnceAndRecordPrediction(model,testingSet.instance(0));
		evaluation.evaluateModel(model, testingSet);
		return evaluation;
		}
	
	
	

	public double calculateAccuracy(FastVector predictions) {
		double correct = 0;
		 
		for (int i = 0; i < predictions.size(); i++) {
			NominalPrediction np = (NominalPrediction) predictions.elementAt(i);
			if (np.predicted() == np.actual()) {
				correct++;
			}
		}
		return 100 * correct / predictions.size();
	}

	
	
	public Instances[][] crossValidationSplit(Instances data, int numberOfFolds) {
		Instances[][] split = new Instances[2][numberOfFolds];
		 
		for (int i = 0; i < numberOfFolds; i++) {
			split[0][i] = data.trainCV(numberOfFolds, i);
			split[1][i] = data.testCV(numberOfFolds, i);
		}
		return split;
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Double> getPredictions(FastVector finalPredictionVector, Instances Predictdata) {
		
		
		Enumeration Predict_Enum = finalPredictionVector.elements();
		ArrayList arr = new ArrayList(); 
		while( Predict_Enum.hasMoreElements()) {
			arr.add(Predict_Enum.nextElement().toString());
			}
		ArrayList Prediction_List = new ArrayList();
		for(int i=0;i<arr.size();i++) {
			Prediction_List.add(arr.get(i).toString().substring(19,21)+"."+arr.get(i).toString().substring(21,23));		
		}
		Map<String, Double> predictions= new HashMap<String, Double>();
		for(int i=0;i<arr.size();i++) {
			predictions.put(Predictdata.instance(i).stringValue(0),Double.valueOf(Prediction_List.get(i).toString()) );
		}
		
//		for (Map.Entry<String, Double> me : hm.entrySet()) {
//	            System.out.print(me.getKey() + ":");
//	            System.out.println(me.getValue());
//	        }
		return predictions;
	}



	public Map<String, Double> findBestAcquirer(PredictionObject predictionObject , String Library) throws Exception{
		
		AttributeToArff(predictionObject);
		DataSource source= new DataSource("testingData.arff");
		Instances Predictdata= source.getDataSet();
		Predictdata.setClassIndex(Predictdata.numAttributes()-1);
		NaiveBayes NaiveBayesModel= (NaiveBayes) weka.core.SerializationHelper.read("WekaNBModel");
		Evaluation evaluation = new Evaluation(Predictdata);
		evaluation.evaluateModel(NaiveBayesModel, Predictdata);
		FastVector prediction = new FastVector();
		prediction.appendElements(evaluation.predictions());
		Map<String, Double> AcquirerPredictions= new HashMap<String, Double>();
		
		AcquirerPredictions=getPredictions(prediction,Predictdata) ;
		return AcquirerPredictions;

		
	}


	public ArrayList<CategoricalResults> train(Classifier model, ClassificationDataSet TrainingDataset,
			ClassificationDataSet TestingDataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	public double calculateAccuracy(ClassificationDataSet TrainingDataset, ArrayList<CategoricalResults> predictions) {
		// TODO Auto-generated method stub
		return 0;
	}



	public Map<String, Double> getPredictions(ArrayList<CategoricalResults> predictions, ClassificationDataSet TrainingDataset) {
		// TODO Auto-generated method stub
		return null;
	}



}
