import scala.io._

def toInt(in: String): Option[Int] = 
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case e: NumberFormatException => None
  }

def sum(in: Seq[String]) = {
  val ints = in.flatMap(s => toInt(s))
  ints.foldLeft(0) ((a, b) => a + b)
}

println("Enter some numbers and press ctrl-D (Unix/Mac) ctrl-Z (Windows)")

val input = Source.fromInputStream(System.in)

// 2.8以上ではinput.getLines.collectは使用できない
// val lines = input.getLines.collect
val lines = input.getLines.toSeq

println("Sum "+sum(lines))
