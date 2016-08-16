// /***DOWNLOADS***/
// http://code.google.com/p/go-windows/
// http://code.google.com/p/go/wiki/WindowsPort


package main

import "fmt"

func main() {
    var u64 uint64 = 1<<64-1  //-999999999999999999999999999999
    s := "hello"
    s += "-"
	//fmt.Println("Hello, ??")
    fmt.Printf("hello %v,%v\n",u64,s)
    
    for i:=10;i>-1;i-- {println(i)}
}
