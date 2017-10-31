package com.danielwestheide.kontextfrei.wordcount

import com.danielwestheide.kontextfrei.scalatest.RDDSpec
import org.apache.spark.rdd.RDD

class WordCountIntegrationSpec extends BaseSpec[RDD]
  with RDDSpec
  with WordCountProperties[RDD]
