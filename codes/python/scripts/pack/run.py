from t1.pack import *
test()
#test()
from t2.pack import *
test()
test()

a=MyData()
b=MyData2()
a.i='ignacio'
b.i='cortorreal'
print a.i,b.i
# c.i='magick'
# print c.i

print a.__dict__.keys()
