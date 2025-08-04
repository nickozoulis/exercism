import scala.annotation.tailrec

object Strain {

	def keep[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
		@tailrec
		def keep(list: Seq[A], fun: A => Boolean, acc: Seq[A]): Seq[A] = {
			list match {
				case head :: tail => keep(tail, fun, if (fun(head)) acc ++ Seq(head) else acc)
				case _ => acc
			}
		}

		keep(list, fun, Seq())
	}

	def discard[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
		keep(list, (x: A) => !fun(x))
	}

}