case class Stuff(name: String, age: Int)

val s = Stuff("David", 45)

s.toString

s == Stuff("David", 45)

s == Stuff("David", 43)

s.name

s.age
