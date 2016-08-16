#install py2exe first

from distutils.core import setup
import py2exe

setup( name="hello",           # parameter not needed     
       console=['hello.py'] )  # or windows=['...']
	   
#>python py2exe_setup.py py2exe
	   