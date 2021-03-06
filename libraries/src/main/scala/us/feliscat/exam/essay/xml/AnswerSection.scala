package us.feliscat.exam.essay.xml

import java.util.StringJoiner

import us.feliscat.text.StringOption

/**
  * @param id id
  * @param instruction instruction
  * @param keywordSet keyword set
  * @param characterLimitText character limit
  * @param characterLimit character limit
  * @param answerSet us.feliscat.answer set
  * @author K. Sakamoto
  *         Created on 2016/10/28
  */
class AnswerSection(val id: Option[Int],
                    val instruction: StringOption,
                    val keywordSet: Seq[String],
                    val characterLimitText: StringOption,
                    val characterLimit: Range,
                    val answerSet: Seq[Answer]) {
  override def toString: String = {
    def printKeywordSet: String = {
      val joiner = new StringJoiner(", ")
      keywordSet.foreach(joiner.add)
      joiner.toString
    }
    def printAnswerSet: String = {
      val builder = new StringBuilder()
      answerSet foreach {
        answer: Answer =>
          answer.toString.split('\n') foreach {
            line: String =>
              builder.
                append('>').
                append(line)
          }
          builder.
            append('\n').
            append('\n')
      }
      builder.result
    }
    s"""---
       |ID:
       |$id
       |Instruction:
       |${instruction.getOrElse("")}
       |Keyword Set:
       |$printKeywordSet
       |Character Limit:
       |${characterLimitText.getOrElse("")}
       |from ${characterLimit.start} to ${characterLimit.end}
       |Answer Set:
       |$printAnswerSet
       |---
       |""".stripMargin
  }
}