object BookStore {

	val bookPrice = 8.0
	
	def total(list: List[Int]) = {
		if (list.size > 0) {
			list
			.zipWithIndex
			.flatMap { case (_, i) => computeDeals(list, i + 1) }
			.min
		} else 0.0
	}

	private def computeDeals(list: List[Int], i: Int) = {
		val combinations = list.combinations(i).map(_.toList).toList

		combinations.map { case subList: List[Int] =>
			price(subList) + price(list.diff(subList))
		}		
	}
	
	private def price(list: List[Int]) = {
		var tmp = list
		var price = 0.0

		do {
			val distinct = tmp.distinct

			price += catalogue(distinct.size)

			tmp = tmp.diff(distinct)
		} while (tmp.size > 0)

		price
	}

	val catalogue = Map(
		0 -> 0.0,
		1 -> 8.0,
		2 -> 2 * 8.0 * 0.95,
		3 -> 3 * 8.0 * 0.9,
		4 -> 4 * 8.0 * 0.8,
		5 -> 5 * 8.0 * 0.75
	)

}