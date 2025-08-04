object Strain {

	def keep[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
		list.foldLeft(Seq[A]()) { case (acc, x) =>
			fun(x) match {
				case true => acc ++ Seq(x)
				case false => acc
			}
		}
	}

	def discard[A](list: Seq[A], fun: A => Boolean): Seq[A] = {
		keep(list, (x: A) => !fun(x))
	}

}