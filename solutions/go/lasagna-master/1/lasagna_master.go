package lasagna

func PreparationTime(layers []string, avgPrepTime int) int {
	if avgPrepTime == 0 {
		return len(layers) * 2
	}
	return len(layers) * avgPrepTime
}

func Quantities(layers []string) (numOfNoodles int, numOfSauces float64) {
	numOfNoodles = 0
	numOfSauces = 0.0
	for _, layer := range layers {
		if layer == "noodles" {
			numOfNoodles += 50
		}
		if layer == "sauce" {
			numOfSauces += 0.2
		}
	}
	return
}

func AddSecretIngredient(sliceA []string, sliceB []string) {
	sliceB[len(sliceB)-1] = sliceA[len(sliceA)-1]
}

func ScaleRecipe(quantities []float64, numOfPortions int) []float64 {
	scaledQuantities := make([]float64, len(quantities))

	for i, _ := range quantities {
		scaledQuantities[i] = quantities[i] * float64(numOfPortions) / 2
	}

	return scaledQuantities
}
