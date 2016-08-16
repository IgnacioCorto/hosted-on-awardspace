def recursive(n):
    if(n<0):
        return
    print "  ",
    for x in range(n):
        print x,
    print
    recursive(n-1)
recursive(4)
