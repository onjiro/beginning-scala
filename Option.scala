def findPerson(key: Int): Option[Person]
def ageFromKey(Key: Int): Option[Int] = findPerson(key).map(_.age)

import java.lang.{Boolean => JBool}
def tryo[T](f: => T): Option[T] = try {Some(f)} catch {case _ => None}
def toInt(s: String): Option[Int] = tryo(s.toInt)
def toBool(s: String) = tryo(JBool.parseBoolean(s))

// Map#filter
trait Person {
  def age: Int
  def first: String
  def valid: Boolean
}

// Map から Person へ変換する
def personFromParams(p: Map[String, String]): Option[Person] =
  for {name <- p.get("name")
       ageStr <- p.get("age")
       age <- toInt(ageStr)
       validStr <- p.get("valid")
       valid <- toBool(validStr)}
  yield new Person(name, age, valid)

Some(3).get
// None#get は例外を発生させる
None.get

Some(3).getOrElse(44)
None.getOrElse(44)
