type FooBar struct {
	n int
    fooSent chan struct{}
    barSent chan struct{}
}

func NewFooBar(n int) *FooBar {
	return &FooBar{
        n: n,
        fooSent: make(chan struct{}),
        barSent: make(chan struct{}),
    }
}

func (fb *FooBar) Foo(printFoo func()) {
	for i := 0; i < fb.n; i++ {
        if i > 0 {
            <- fb.barSent
        }
		// printFoo() outputs "foo". Do not change or remove this line.
        printFoo()
        fb.fooSent <- struct {}{}
	}
}

func (fb *FooBar) Bar(printBar func()) {
	for i := 0; i < fb.n; i++ {
        <- fb.fooSent
		// printBar() outputs "bar". Do not change or remove this line.
        printBar()
        if i < fb.n - 1 {
            fb.barSent <- struct {}{}
        }

	}
}