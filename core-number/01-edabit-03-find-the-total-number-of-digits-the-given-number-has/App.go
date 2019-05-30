package main

import (
	"fmt"
	"strconv"
)

func findDigitAmount(a int) int {
	return len(strconv.Itoa(a))
}
func main() {
	fmt.Println(findDigitAmount(123))         // ➞ 3
	fmt.Println(findDigitAmount(56))          // ➞ 2
	fmt.Println(findDigitAmount(7154))        // ➞ 4
	fmt.Println(findDigitAmount(61217311514)) // ➞ 11
	fmt.Println(findDigitAmount(0))           // ➞
}
