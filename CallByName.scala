def nano() = {
  println("Getting nano")

  System.nanoTime
}

def delayed(t: => Long) = {
  println("In delayed method")
  println("Param: "+t)
  t
}

delayed(nano())

def notDelayed(t: Long) = {
  println("In not delayed method")
  println("Param: "+t)
  t
}

notDelayed(nano())
