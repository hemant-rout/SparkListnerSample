# SparkListnerSample

1.If we use spark.sparkContext.addSparkListener() we will not able to get any matrices related to onApplicationStart event.
2.If we use .config("spark.extraListeners","com.data.spark.SparkExecutionTrackingPlugin") are able to get all matrices related to onApplicationStart  and onApplicationEnd event. But till now I am unable to pass output path from external source.
3.If we use both configurations onApplicationEnd event called twice as a result we are getting null  matrices for  onApplicationEnd event.  
