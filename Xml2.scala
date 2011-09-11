// エラーになる・・・
import scala.xml._
val xml = XML.load("http://onjiro.blogspot.com/")
xml \\ "a"
(xml \\ "a").length
(xml \\ "a").map(_ \ "@href").map(_.text).filter(_ startsWith "http:")
(xml \\ "a").filter(n => (n \ "@href")).text.startsWith("http:")).length

// for式版
val refs = for {a <- xml \\ "a"}
ext <- a \ "@href" if ext.text startsWith "http:"}
yield ext.text

refs.length
val x2 = <x>{(1 to 3).map(i => <i>{i}</i>)}</x>
x2 \ "i"
(x2 \ "i").map(_.text)
(x2 \ "i").map(_.text.toInt)
(x2 \ "i").map(_.text.toInt).foldLeft(0)(_ + _)



