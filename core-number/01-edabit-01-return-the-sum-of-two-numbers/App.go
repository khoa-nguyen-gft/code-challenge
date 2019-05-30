package main

import "fmt"

func addition(a int, b int) int {
	c := a + b
	fmt.Println(c)

	return c
}

func main() {
	addition(3, 2) // ➞ 5

	addition(-3, -6) // ➞ -9

	addition(7, 3) // ➞ 10
}
