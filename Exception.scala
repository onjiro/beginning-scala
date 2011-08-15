try {
  throw new Exception("Working...")
} finally {
  println("This will always be printed")
}

// try {
//   file.write(stuff)
// } catch {
//   case e: java.io.IOException => println(e.getClass.getName)
//   case n: NullPointerException => println(e.getClass.getName)
// }

// parseInt での例外発生時に 0 を返す
try {Integer.parseInt("dog")} catch {case _ => 0}
try {Integer.parseInt("44")} catch {case _ => 0}
