package scalatips

object EightPMTricks {
  // 1 - switch on steroids
  val aNumber = 44
  val ordinal = aNumber match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => aNumber + "th"
  }

  // 2 - case class deconstruction
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 34)

  val bobGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Unknown Greeting"
  }

  // trick #1 - list extractors
  val numberList = List(1,2,3,42)

  val mustHaveThree = numberList match {
    case List(_,_,3,somethingElse) => s"List has 3rd element 3, followed by $somethingElse"
  }

  // trick #2 - Haskell-like prepending
  val startsWithOne = numberList match {
    case 1 :: tail => s"list starts with one, tail is $tail"
  }

  def process(aList: List[Int]) = aList match {
    case Nil => "list is empty"
    case head :: tail => s"list starts with $head, tail is $tail"
  }

  // trick #3 - vararg pattern
  val dontCareAboutTheRest = numberList match {
    case List(_, 2, _*) => "I only care about the second number being 2"
  }

  // trick #4 - other infix patterns
  val mustEndWithTheMeaningOfLife = numberList match {
    case List(1,2,_) :+ 42 => "that's right, I have a meaning"
  }

  val mustEndWithTheMeaningOfLife2 = numberList match {
    case List(1, _*) :+ 42 => "I don't care how long the list is, I just want it to end in 42"
  }

  // trick #5 - type specifiers
  def gimmeAValue(): Any = 45

  val gimmeTheType = gimmeAValue() match {
    case _: String => "I have a String"
    case _: Int => "I have an int"
    case _ => "Something else"
  }

  // trick #6 - name binding
  def requestMoreInfo(p: Person): String = s"The person ${p.name} is a good person."

  val bobsInfo = bob match {
    case p @ Person(n, a) => s"$n's info: ${requestMoreInfo(p)}"
  }

  // trick #7 - conditional guards

}
