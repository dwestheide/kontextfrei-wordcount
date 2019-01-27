package com.danielwestheide.ktxfr.wordcount

import com.danielwestheide.kontextfrei.scalatest.StreamSpec

class WordCountSpec extends BaseSpec[Stream]
  with StreamSpec
  with WordCountProperties[Stream]
