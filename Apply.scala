class Ap {
  def apply(in: Int) = in.toString
}

val a = new Ap
a(44)

class Up {
  def update(k: Int, v: String) = println("Hey: "+k+" "+v)
}

val u = new Up
u(33) = "Hello"

class Update {
  def update(what: String) = println("Singler: "+what)
  def update(a: Int, b: Int, what:String) = println("2d update")
}
val u = new Update
u() = "Foo"
u(3, 4) = "Howdy"
