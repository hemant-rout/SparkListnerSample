package com.data.spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}
object CodeTest {
  def main(args: Array[String]): Unit = {

  val spark = SparkSession.builder().appName("SparkDataFrameExample").config("spark.extraListeners","com.data.spark.SparkExecutionTrackingPlugin").config("spark.tmp.warehouse", "file:///tmp").master("local").getOrCreate()
  import spark.implicits._
    val jsonDf=sparkSession.read.json("C:\\Input\\sample.json")
    jsonDf.show()
}
