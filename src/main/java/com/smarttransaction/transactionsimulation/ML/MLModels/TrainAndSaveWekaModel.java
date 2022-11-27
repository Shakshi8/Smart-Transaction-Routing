package com.smarttransaction.transactionsimulation.ML.MLModels;



import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

import weka.core.converters.ConverterUtils.DataSource;




public class TrainAndSaveWekaModel {
	
	public Instances[][] crossValidationSplit(Instances data, int numberOfFolds) {
		Instances[][] split = new Instances[2][numberOfFolds];

		for (int i = 0; i < numberOfFolds; i++) {
		split[0][i] = data.trainCV(numberOfFolds, i);
		split[1][i] = data.testCV(numberOfFolds, i);
		}
		return split;
		}





		public TrainAndSaveWekaModel(String TrainingData) throws Exception{
		DataSource source= new DataSource(TrainingData);
		Instances trainingData= source.getDataSet();
		trainingData.setClassIndex(trainingData.numAttributes()-1);

		Instances[][] split = crossValidationSplit(trainingData, 10);

		// Separate split into training and testing arrays
		Instances[] trainingSplits = split[0];
		Instances[] testingSplits = split[1];

		NaiveBayes NBClassifier= new NaiveBayes();

		for (int i = 0; i < trainingSplits.length; i++) {
		if(i<=trainingSplits.length-2) {
		// System.out.println("\n i:"+i);
//		 Evaluation validation = train(models[j], trainingSplits[i], testingSplits[i]);
		 NaiveBayes nb= (NaiveBayes) weka.core.SerializationHelper.read("WekaNBModel");
		NBClassifier.buildClassifier(trainingSplits[i]);
		weka.core.SerializationHelper.write("WekaNBModel",NBClassifier);



		}}




		}
}
