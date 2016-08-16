#bad='bad'
class bad:pass
try: raise bad
except bad: print 'got',bad
finally: 
    print
    raw_input()

   