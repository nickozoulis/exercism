package flatten

func Flatten(nested interface{}) []interface{} {
	flattened := &[]interface{}{}

	switch v := nested.(type) {
	case []interface{}:
		for _, n := range v {
			switch t := n.(type) {
			case int:
				*flattened = append(*flattened, t)
			case []interface{}:
				flatten(t, flattened)
			default:
			}
		}
	default:
	}

	return *flattened
}

func flatten(nested interface{}, flattened *[]interface{}) {
	switch v := nested.(type) {
	case []interface{}:
		for _, n := range v {
			flatten(n, flattened)
		}
	case nil:
	default:
		*flattened = append(*flattened, v)
	}
	return
}
