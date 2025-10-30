package tree

import (
	"errors"
	"slices"
	"sort"
)

type Record struct {
	ID     int
	Parent int
	// feel free to add fields as you see fit
}

type Node struct {
	ID       int
	Children []*Node
	// feel free to add fields as you see fit
}

func Build(records []Record) (*Node, error) {
	if len(records) == 0 {
		return nil, nil
	}

	// Collection to hold node references
	nodes := make(map[int]*Node, len(records))
	// Insert parent node ref
	nodes[0] = &Node{ID: 0}
	hasRoot := 0

	for _, r := range records {

		// Skip parent ref as its already been inserted
		if r.ID == 0 {
			if r.Parent != 0 {
				return nil, errors.New("root has parent")
			}
			hasRoot++
			continue
		}

		if r.ID < 0 || r.ID >= len(records) {
			return nil, errors.New("non continuous")
		}

		// Insert node ref if does not exist
		if _, ok := nodes[r.ID]; !ok {
			nodes[r.ID] = &Node{ID: r.ID}
		}

		// If parent does not exist instantiate and insert ref
		parent, ok := nodes[r.Parent]
		if !ok {
			nodes[r.Parent] = &Node{ID: r.Parent}
			parent = nodes[r.Parent]
		}

		if parent.ID >= r.ID && r.ID != 0 {
			return nil, errors.New("cyclic")
		}

		// Update parent's children slice
		if slices.Contains(parent.Children, nodes[r.ID]) {
			return nil, errors.New("duplicate node")
		}
		parent.Children = append(parent.Children, nodes[r.ID])
		sort.Slice(parent.Children, func(i, j int) bool {
			return parent.Children[i].ID < parent.Children[j].ID
		})
	}

	if hasRoot == 0 {
		return nil, errors.New("no root node")
	}

	if hasRoot > 1 {
		return nil, errors.New("duplicate root node")
	}

	return nodes[0], nil
}
