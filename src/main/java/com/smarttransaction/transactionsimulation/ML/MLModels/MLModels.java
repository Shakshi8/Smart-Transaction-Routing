package com.smarttransaction.transactionsimulation.ML.MLModels;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;

import com.smarttransaction.transactionsimulation.model.PredictionObject;

import jsat.DataSet;
import jsat.classifiers.CategoricalResults;
import jsat.classifiers.ClassificationDataSet;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.FastVector;
import weka.core.Instances;

public interface MLModels {

	
//	public  BufferedReader readDataFile(String filename);
//	public DataSet readDataFile(String filename);
	
	public  Evaluation train(Classifier model,Instances trainingSet, Instances testingSet) throws Exception;
	public ArrayList<CategoricalResults> train(Classifier model, ClassificationDataSet TrainingDataset,ClassificationDataSet TestingDataset)throws Exception ;

	public  double calculateAccuracy(FastVector predictions);
	public double calculateAccuracy(ClassificationDataSet TrainingDataset,ArrayList<CategoricalResults> predictions);


	public  Instances[][] crossValidationSplit(Instances data, int numberOfFolds);
	
	
	public  Map<String, Double> getPredictions(FastVector finalPredictionVector,Instances Predictdata);
	public Map<String, Double> getPredictions(ArrayList<CategoricalResults> predictions,ClassificationDataSet TrainingDataset);
	
	
	public  Map<String, Double> findBestAcquirer(PredictionObject predictionAttributes , String Library) throws Exception;
	
}
