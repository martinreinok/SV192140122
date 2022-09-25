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
(CTL OPERATORS)[https://stackoverflow.com/questions/37516092/how-can-i-change-these-into-ctl-spec-in-nusmv-model]

## Part I
Write a set of properties that validates the correct behaviour 

## Part II
Expose and fix the error in crossing-enviroment

### Detected error I:
G (S2_red -> !T2_occupied)  is false  (Train is on T2 when S2 is red)  
This was fixed by changing next(S2_red):  
* T2_occupied | T3_occupied : TRUE;  
* T3_occupied : TRUE;  






