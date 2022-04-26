package com.data.spark

import java.io.File
import java.text.SimpleDateFormat
import org.apache.spark.scheduler._
import org.codehaus.jackson.map.ObjectMapper;


class SparkExecutionTrackingPlugin extends SparkListener {

  val builder:StringBuilder = StringBuilder.newBuilder
  val sdf: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
  var mp:MatricesProperties=new MatricesProperties()

  override def onApplicationStart(applicationStart: SparkListenerApplicationStart): Unit = {
    val startTime=sdf.format(applicationStart.time)
    mp.setAppId(applicationStart.appId.get)
    mp.setAppName(applicationStart.appName)
    mp.setAppStartTime(startTime)
  }

  override def onApplicationEnd(applicationEnd: SparkListenerApplicationEnd): Unit = {
    val endTime=sdf.format(applicationEnd.time)
    mp.setAppEndTime(endTime)
    val mapper:ObjectMapper = new ObjectMapper()
    mapper.writeValue(new File("C:\\testData\\test.json"), mp);
  }

  override def onJobStart(jobStart: SparkListenerJobStart): Unit = {
    println(s"Job properties : ${jobStart.properties} ")
  }

  override def onJobEnd(jobEnd: SparkListenerJobEnd): Unit = {
        println("+++++++++++++++++++++Job End Start+++++++++++++++++++++")
        println(s"Job id : ${jobEnd.jobId} ")
        println(s"Job end result: ${jobEnd.jobResult}")
        println("+++++++++++++++++++++Job End End+++++++++++++++++++++")
  }

  override def onStageCompleted(stageCompleted: SparkListenerStageCompleted): Unit = {
    println("+++++++++++++++++++++Stage Complete Start+++++++++++++++++++++")
    println("submissionTime :"+stageCompleted.stageInfo.submissionTime+" ms")
    println("Completion Time :"+stageCompleted.stageInfo.completionTime+" ms")
    println("Stage Failure reason "+stageCompleted.stageInfo.failureReason)
    println("Stage Num tasks "+stageCompleted.stageInfo.numTasks)
    println("Stage records read "+stageCompleted.stageInfo.taskMetrics.inputMetrics.recordsRead)
    println("Stage executor run time "+stageCompleted.stageInfo.taskMetrics.executorRunTime)
    println("Stage records written "+stageCompleted.stageInfo.taskMetrics.outputMetrics.bytesWritten)
    println("Stage Details:"+stageCompleted.stageInfo.details)
    println("Input Size :"+(stageCompleted.stageInfo.taskMetrics.inputMetrics.bytesRead).toInt/(1024*1024)+" MB")
    println("------------------------- STAGE COMPLETED---------------------------")
  }

}
