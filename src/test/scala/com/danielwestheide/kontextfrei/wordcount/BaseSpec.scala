package com.danielwestheide.kontextfrei.wordcount

import com.danielwestheide.kontextfrei.scalatest.KontextfreiSpec
import com.danielwestheide.kontextfrei.syntax.DistributionSyntaxSupport
import org.scalactic.anyvals.PosInt
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{MustMatchers, PropSpecLike}

trait BaseSpec[F[_]]
    extends KontextfreiSpec[F]
    with DistributionSyntaxSupport
    with PropSpecLike
    with GeneratorDrivenPropertyChecks
    with MustMatchers {

  implicit val config: PropertyCheckConfiguration =
    PropertyCheckConfiguration(minSuccessful = PosInt(100))
}
