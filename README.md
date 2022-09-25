# system-validation
System Validation exercises

## Part I
Write a set of properties that validates the correct behaviour 

## Part II
Expose and fix the error in crossing-enviroment

### Potential error, albeit not a critical safety issue:
Train has to wait at T1 for a long time before barrier is put down>   

-> State: 1.5 <-  
train.T0_occupied = TRUE  
cars_crossing = FALSE (could be true still)  
barrier1.open = TRUE  
interlocking.S2_red = TRUE  
interlocking.W_active = FALSE  
interlocking.B1_request = FALSE  

-> State: 1.6 <-  
train.T1_occupied = TRUE  
cars_crossing = FALSE  
barrier1.open = TRUE  
interlocking.S2_red = TRUE  
interlocking.W_active = TRUE  
interlocking.B_request = FALSE  

-> State: 1.7 <-  
train.T1_occupied = TRUE  
cars_crossing = FALSE  
barrier1.open = TRUE  
interlocking.S2_red = TRUE  
interlocking.W_active = TRUE  
interlocking.B_request = TRUE  

-> State: 1.8 <-  
train.T1_occupied = TRUE  
cars_crossing = FALSE  
barrier1.open = FALSE  
interlocking.S2_red = FALSE  (train can pass now as the barrier is closed)  
interlocking.W_active = TRUE  
interlocking.B_request = TRUE  

-> State: 1.9 <-  
train.T2_occupied = TRUE  
cars_crossing = FALSE  
barrier1.open = FALSE  
interlocking.S2_red = TRUE  (Train has passed, now is red)  
interlocking.W_active = TRUE  
interlocking.B_request = TRUE  

-> State: 1.10 <-  
train.T3_occupied = TRUE  
cars_crossing = FALSE  
barrier1.open = FALSE  
interlocking.S2_red = TRUE  
interlocking.W_active = TRUE  
interlocking.B_request = TRUE

-> State: 1.11 <-  
train.T4_occupied = TRUE  
cars_crossing = FALSE  
barrier1.open = FALSE  
interlocking.S2_red = FALSE  (! should still be red at this point !)  
interlocking.W_active = TRUE  
interlocking.B_request = FALSE  

-> State: 1.12 <-  
train.T4_occupied = FALSE (train no loger on track nor visible)  
cars_crossing = FALSE  
barrier1.open = TRUE  
interlocking.S2_red = TRUE  (now it's true again, perhaps that is the error)
interlocking.W_active = FALSE  
interlocking.B_request = FALSE  






