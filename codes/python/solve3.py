def solve3(a,b,c):
    '''
    This functions solves this formula:
       c1*a + c2*b == c
    It retrieves values for c1 and c2
    in the range -100...100 inclusive
    '''
    counter=0
    for c2 in range(100,-100,-1):
        str_c1 = "%f"%((c-float(c2)*b)/a)
        str_c2 = "%f"%c2
        if (str_c1[-6:]==str_c2[-6:]):
            strout =  "c1=%s , c2=%s" %(str_c1,str_c2)
            print strout
            counter+=1
    print "solutions: %d"%counter
    
solve3(11,19,29)

solve3(91,98,97)   #solutions:0

help(solve3)

print solve3.__doc__

print dir(solve3)
