# system-validation
System Validation exercises

## Getting traces
```
NuSMV.exe -int file_name

go
pick_state -r
simulate -r -k 50
show_traces -v
```
## NuSMV CTL Spec sheet
[CTL OPERATORS](https://stackoverflow.com/questions/37516092/how-can-i-change-these-into-ctl-spec-in-nusmv-model)

## Part I
Write a set of properties that validates the correct behaviour 

### Signals and warnings work as expected
#### When train is on track 2, all warnings and barriers are active
LTLSPEC G (T2_occupied -> (W2_active & W1_active & B1_closed & B2_closed));
#### When Train is allowed to enter track 2, all warnings and barriers are active
LTLSPEC G (S2_green -> (W2_active & W1_active & B1_closed & B2_closed));
#### Warning lights can't be active and unactive at the same time
LTLSPEC G (S1_green -> !S1_red & S2_green -> !S2_red & S3_green -> !S3_red & S4_green -> !S4_red);
#### When barriers are closed, cars are not crossing
LTLSPEC G ((B1_closed | B2_closed) -> !cars_crossing);
#### Train is not on track 2 when signal doesn't allow
LTLSPEC G (S2_red -> !T2_occupied);
#### Care are not crossing when warnings are active
LTLSPEC !G (cars_crossing & (W2_active & W1_active));

### Trains always make progress
#### Ensure that the train progresses in the next state or eventually 
LTLSPEC G (T2_occupied -> X !T2_occupied);
LTLSPEC G (T2_occupied -> X T3_occupied);
LTLSPEC G (T1_occupied -> F T3_occupied)

### Cars always make progress
#### Ensure that the cars are not stuck in one state
LTLSPEC G ((cars_crossing -> F !cars_crossing) | (!cars_crossing -> F cars_crossing))

### The enviroment evolves as expected
#### There can not be multiple trains occupying multiple tracks
LTLSPEC !G (T0_occupied & T1_occupied & T2_occupied & T3_occupied & T4_occupied);
LTLSPEC !G (T1_occupied & T2_occupied);
#### It is possible that train is not on the track (track is free)
LTLSPEC F (!T0_occupied & !T1_occupied & !T2_occupied & !T3_occupied & !T4_occupied);


## Part II
Expose and fix the error in crossing-enviroment

### Detected error I:
G (S2_red -> !T2_occupied)  is false  (Train is on T2 when S2 is red)  
This was fixed by changing next(S2_red):  
* T2_occupied | T3_occupied : TRUE;  
* T3_occupied : TRUE;  






