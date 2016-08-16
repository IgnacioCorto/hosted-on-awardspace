a = "01"

##for ... in a:
##    for c3 in a:
##        for c2 in a:
##            for c1 in a:
##                print ... + c3 + c2 + c1


def first(t,p=0,b=""):
    if(p>=len(t)): return ""
    return \
          str(t[0] + t[p] + "\n") \
        + str(first(t, p+1, t[0]))



#PRIMERAS RECURSIVAS
#print first(a)

###EXAMINANDO UN NIVEL
##out=""
##for c1 in a:
##    out+=c1+"\n"
##print out
##
###EXAMINANDO DOS NIVELES
##out=""
##for c2 in a:  #NUEVO FOR
##    for c1 in a:
##        out+=c2+c1+"\n"  #NUEVA VARIABLE
##print out

def infor(size,depth,counter=0):
    if(depth<0): return
    print (4-depth)*"   ", "depth=%d\n" % (depth)
    for x in range(size):
        temp=counter+size**depth*x
        #if(depth==0): print temp    #ONLY ONE PRINT
        print (4-depth)*"   ", "%d (%d)" % (x,temp)
        infor(size,depth-1,temp)
#infor(2,1)  #base, posicion (,acumulador)



def arraytrack(array,depth,counter=""):
    if(depth<0): return
    #print (4-depth)*"   ", "depth=%d\n" % (depth)
    for i,x in enumerate(array):
        #temp=counter+len(array)**depth*i
        #print (4-depth)*"   ", "%d (%d)" % (i,temp)
        #if(depth==0): print temp    #ONLY ONE PRINT

        temp=counter+x
        #print (4-depth)*"   ", "%d (%s)" % (i,temp)
        if(depth==0): print temp    #ONLY ONE PRINT
        arraytrack(array,depth-1,temp)
#arraytrack(a,1)  


nums = [0,1,2,4,8]
#nums.reverse()
def arraysum(array,depth,counter=0):
    if(depth<0): return
    print (4-depth)*"   ", "depth=%d\n" % (depth)
    for i,x in enumerate(array):
        temp=counter+x
        print (4-depth)*"   ", "%d (%d)" % (x,temp)
        #if(depth==0): print temp    #ONLY ONE PRINT
        arraysum(array,depth-1,temp)
print "arraysum(nums,1):"
#arraysum(nums,1)



def bringcounter(array,depth=0,counter=0,parentdepth=0):
    if(depth>=len(array)): return
    temp=counter+array[depth]
    print (4-parentdepth)*"   ", "%d (%d)" % (array[depth],temp)
    #if(depth==0): print temp    #ONLY ONE PRINT
    parentcounter(array,parentdepth-1,0);
    bringcounter(array,depth+1,counter);
#bringcounter(nums,0,10);

def parentcounter(array,depth,counter=0,childdepth=0):
    if(depth<0): return
    print (4-depth)*"   ", "depth = %d" % (depth)
    bringcounter(array,0,0,depth);
    parentcounter(array,depth-1,counter)
#parentcounter(nums,1)


def fi(n):
    if(n<0): return
    print 'i:',n
    fj(n)
    fi(n-1)
def fj(n):
    if(n<0): return
    print 'j:',n
    fj(n-1)
fi(2)

    
##import time
##def a():
##    print "in a"
##    time.sleep(1)
##    b()
##def b():
##    print "in b"
##    time.sleep(1)
##    a()
##a()

#binary positions -vs- binary counter


letters = "ABCD"
#### VERSION 1
##def showletters1(array,depth=0,counter=""):
##    if(depth>=len(array)): return
##    for i in range(depth,len(array)):
##        print counter+array[i]
##    showletters1(array,depth+1,counter+array[depth])
##showletters1(letters)

#### VERSION 2
##def showletters2(array,depth=0,counter=""):
##    if(depth>=len(array)): return
##    print "\t"*depth, "counter = -%s-" % (counter)
##    print "\t"*depth, counter+array[depth]
##    #print counter+array[depth]
##    showletters2(array,depth+1,counter)
##    showletters2(array,depth+1,counter+array[depth])
##showletters2(letters)


def printletters(array,depth=0):
    if(depth>=len(array)): return
    print array[depth]
    printletters(array,depth+1)
#printletters(letters)

