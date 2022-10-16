#201251
import simpy
from random import *



class jog:
    def __init__(self,env):
        self.env = env
        self.running = env.process(self.run(env))

    def run(self, env):
        print('Start jogging at %d' % env.now)
        call_timing = randint(0, 20)            #time of the incomming call

        yield env.timeout(call_timing)

        run_time_left = 18      #only used if call time is greater than 15

        if call_timing < 15:      
            run_time_left = 18 - call_timing  
            print("\n\nCall incoming at %d" %env.now)
            print("Call Picked at %d" %env.now)
            print ("Continue jogging", end="\n\n")

        else:
            print("\n\nCall incoming at %d" %env.now)
            
        yield env.timeout(run_time_left)                   
        
        
        self.rest_notification = env.process(self.notification_rest(env, call_timing))


        
    
    def notification_rest(self, env, call_time):
        n=0
        while n < 2:
            print('Resting indication at %d' % env.now)
            n=n+1
            indication_duration = 1
            yield env.timeout(indication_duration)

        
        print('Start resting at %d' % env.now)

        if call_time>15:
            print("\n\nCall picked at %d" %env.now, end="\n\n")

        resting_duration = 5
        yield env.timeout(resting_duration)
        print("Resting time finished at %d" %env.now)

        self.running = env.process(self.run(env))

        


env = simpy.Environment()
person = jog(env)

env.run(until=120)
print("Jogging completed at 120")