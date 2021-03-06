package us.feliscat.util.uima

import org.apache.uima.jcas.cas._

import scala.collection.mutable.ListBuffer
import scala.reflect.ClassTag

/**
  * @author K. Sakamoto
  *         Created on 2017/05/25
  */
package object fsArray {
  /**
    * @author K.Sakamoto
    * @param repr
    */
  implicit class FSArrayUtils(repr: FSArray) {
    private lazy val size: Int = repr.size

    def toSeq[T <: TOP : ClassTag]: Seq[T] = {
      if (size == 0) {
        //return an empty seq
        return Nil
      }

      val buffer = ListBuffer.empty[T]
      for (i <- 0 until size) {
        buffer += repr.get(i).asInstanceOf[T]
      }
      buffer.result
    }

    def toArray[T <: TOP : ClassTag]: Array[T] = {
      val array = implicitly[ClassTag[T]].newArray(size)
      for (i <- 0 until size) {
        array(i) = repr.get(i).asInstanceOf[T]
      }
      array
    }
  }

  /**
    * @author K.Sakamoto
    * @param repr float array
    */
  implicit class FloatArrayUtils(repr: FloatArray) {
    def toSeq: Seq[Float] = {
      repr.toArray.toSeq
    }
  }

  /**
    * @author K.Sakamoto
    * @param repr integer array
    */
  implicit class IntegerArrayUtils(repr: IntegerArray) {
    def toSeq: Seq[Int] = {
      repr.toArray.toSeq
    }
  }

  /**
    * @author K.Sakamoto
    * @param repr string array
    */
  implicit class StringArrayUtils(repr: StringArray) {
    def toSeq: Seq[String] = {
      repr.toArray.toSeq
    }
  }
}
