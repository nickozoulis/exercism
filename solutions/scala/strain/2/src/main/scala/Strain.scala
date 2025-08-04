object Strain {

	// def keep[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
	// 	list.foldLeft(Seq[A]()) { case (acc, x) =>
	// 		fun(x) match {
	// 			case true => acc ++ Seq(x)
	// 			case false => acc
	// 		}
	// 	}
	// }


	def keep[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
		def keep(list: Seq[A], fun: A => Boolean, acc: Seq[A]): Seq[A] = {
			list match {
				case head :: tail => keep(tail, fun, acc ++ fun(head))
				case _ => acc
			}
		}

		keep(list, fun, Seq())
	}

	def discard[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
		keep(list, (x: A) => !fun(x))
	}

}