package com.danielwestheide.ktxfr.wordcount

trait WordCountProperties[F[_]] extends BaseSpec[F] with WordCount {

  import collection.immutable._

  property("sums word counts across lines") {
    forAll { (wordA: String) =>
      whenever(wordA.nonEmpty) {
        val wordB = wordA.reverse + wordA
        val result =
          counts(Seq(s"$wordB $wordA $wordB", wordB).distributed)
            .collectAsMap()
        assert(result(wordB) === 3)
      }
    }
  }

  property("does not have duplicate keys") {
    forAll { (wordA: String) =>
      whenever(wordA.nonEmpty) {
        val wordB = wordA.reverse + wordA
        val result =
          counts(Seq(s"$wordA $wordB", s"$wordB $wordA").distributed)
        assert(
          result.keys.distinct().collect().toList === result.keys
            .collect()
            .toList)
      }
    }
  }

}
