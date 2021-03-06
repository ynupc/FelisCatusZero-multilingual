package us.feliscat.geography.ja

import us.feliscat.geography.MultiLingualGeographyExtractorForQuestion
import us.feliscat.m17n.Japanese
import us.feliscat.types.Sentence

/**
  * <pre>
  * Created on 2017/02/10.
  * </pre>
  *
  * @author K.Sakamoto
  */
object JapaneseGeographyExtractorForQuestion extends MultiLingualGeographyExtractorForQuestion with Japanese {
  override def extract(sentenceList: Seq[Sentence]): (Seq[String], Seq[String]) = {
    (Nil, Nil)
  }
}
