# SparkListnerSample

1.If we use spark.sparkContext.addSparkListener() we will not able to get any matrices related to onApplicationStart event.
2.If we use .config("spark.extraListeners","com.data.spark.SparkExecutionTrackingPlugin") are able to get all matrices related to onApplicationStart  and onApplicationEnd event. But till now I am unable to pass output path from external source.
3.If we use both configurations onApplicationEnd event called twice as a result we are getting null  matrices for  onApplicationEnd event.  


https://jaceklaskowski.gitbooks.io/mastering-spark-sql/content/spark-sql-SQLListener.html
https://databand.ai/blog/apache-spark-monitoring-using-listeners-and-data-quality-libraries/

https://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/util/QueryExecutionListener.html
https://github.com/apache/spark/blob/master/sql/core/src/main/scala/org/apache/spark/sql/execution/ui/SQLListener.scala
https://github.com/apache/spark/tree/master/sql/core/src/main/scala/org/apache/spark/sql/execution/ui

https://blog.nuna.com/user-query-monitoring-in-spark-c2156dd6d611
