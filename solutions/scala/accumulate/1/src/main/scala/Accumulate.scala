class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A], acc: List[B] = List()): List[B] = {
  	accumulator(f, list, acc).reverse
  }

  def accumulator[A, B](f: (A) => B, list : List[A], acc: List[B]): List[B] = {
  	list match {
  		case Nil => acc
  		case head :: tail => accumulator(f, tail, f(head) :: acc)
  	}
  }
}