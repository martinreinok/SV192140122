# system-validation
System Validation exercises

## Part I
Write a set of properties that validates the correct behaviour 

## Part II
Expose and fix the error in crossing-enviroment

### Detected error I:
G (S2_red -> !T2_occupied)  is false  (Train is on T2 when S2 is red)  
This was fixed by changing next(S2_red) from T2_occupied | T3_occupied : TRUE; to just T3_occupied : TRUE;  






