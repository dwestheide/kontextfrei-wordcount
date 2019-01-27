package com.danielwestheide.ktxfr.wordcount

import com.danielwestheide.kontextfrei.DCollectionOps
import com.danielwestheide.kontextfrei.syntax.SyntaxSupport

trait WordCount extends SyntaxSupport {

  def counts[F[_]: DCollectionOps](text: F[String]): F[(String, Long)] =
    text
      .flatMap(line => line.split(" "))
      .map(word => (word, 1L))
      .reduceByKey(_ + _)
      .sortBy(_._2, ascending = false)

  def formatted[F[_]: DCollectionOps](counts: F[(String, Long)]): F[String] =
    counts.map {
      case (word, count) => s"$word,$count"
    }
}
