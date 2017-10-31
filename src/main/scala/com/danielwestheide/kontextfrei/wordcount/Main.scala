package com.danielwestheide.kontextfrei.wordcount

import com.danielwestheide.kontextfrei.rdd.RDDOpsSupport
import org.apache.spark.SparkContext

object Main extends App with WordCount with RDDOpsSupport {

  implicit val sparkContext: SparkContext = new SparkContext("local[1]", "word-count")

  val inputFilePath = args(0)
  val outputFilePath = args(1)

  try {

    val textFile   = sparkContext.textFile(inputFilePath, minPartitions = 2)
    val wordCounts = counts(textFile)
    formatted(wordCounts).saveAsTextFile(outputFilePath)

  } finally {
    sparkContext.stop()
  }
}
