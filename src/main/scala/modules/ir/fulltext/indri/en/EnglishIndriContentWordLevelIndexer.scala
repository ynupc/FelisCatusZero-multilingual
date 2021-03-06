package modules.ir.fulltext.indri.en

import modules.ir.fulltext.indri.MultiLingualIndriIndexer
import modules.util.ModulesConfig
import us.feliscat.ir.fulltext.indri.en.EnglishTrecTextFileFormatReviser
import us.feliscat.m17n.English

/**
  * <pre>
  * Created on 2017/02/05.
  * </pre>
  *
  * @author K.Sakamoto
  */
object EnglishIndriContentWordLevelIndexer extends MultiLingualIndriIndexer with English {
  protected override val indices:       Array[String] = ModulesConfig.wordLevelIndriIndicesInEnglish.toArray
  protected override val segmentations: Array[String] = ModulesConfig.wordLevelIndriSegmentationsInEnglish.toArray
  protected override val resources:     Array[String] = ModulesConfig.trecTextFormatDataInEnglish.toArray
  protected override val reviser = new EnglishTrecTextFileFormatReviser(1, true)
}
