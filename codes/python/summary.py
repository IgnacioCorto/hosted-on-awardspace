#Tkinter  http://www.pythonware.com/library/tkinter/introduction/hello-tkinter.htm

yes,no,empty = True,False,None

b=2
dir(b)             #methods
help(b.conjugate)  #help

2**100             #power
"acabado"[::2]     #from,to,step
"*"*80             #repeat
'gnaY-niY'[::-1]   #string reverse
"%s (%i)" % (a,l)  #formatting

#string as array of bytes
bytearray(raw_input(), 'ISO-8859-1')

5/2        #integer 
5.0/2.0    #double
5.0//2.0   #double + floor
5.0%2.0    #reminder


list=[3,2,1]
list.sort
sorted(list)

for i in range(0,20,3):    #for loop
    pass

try:
    pass
except ex1:
    pass
finally:
    pass


import decimal
#package: __init__.py
#import package.module.attribute as f
#from package.module import *

class example():
    def __init__():
        pass

### TERNARY IN PYTHON ###

Y = False
Z = True

X = Y or Z or 99

#X ? Y : Z        # C++
Y if X else Z     # Python
((X and Y) or Z)  # Ternary Hack #1
[Z,Y][X]          # Ternary Hack #2

while,True: if,break  # do-while 

#switch statements
{'option1': function1,
 'option2': function2,
 'option3': function3,
 'option4': function4,
}.get(value, defaultfunction)()


def f1(): return False

def f2(): return True

tmp1,tmp2=f1(),f2()
if tmp1 or tmp2: print 'Is True'

raw_input('Press [ENTER] to continue...')

