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

## Fairness
In
order to force a given process to execute infinitely often, we can use a fairness constraint. A
fairness constraint restricts the attention of the model checker to only those execution paths
along which a given formula is true infinitely often.

## Liveness
Another desired property is that, if proc1 wants to enter its critical state, it eventually
does (this is an example of a “liveness” property). This property can be expressed by the
following CTL formula:
AG (proc1.state = entering -> AF proc1.state = critical)

## Part I
Write a set of properties that validates the correct behaviour 

### Signals and warnings work as expected
### Trains always make progress
### Cars always make progress
### The enviroment evolves as expected



## Part II
Expose and fix the error in crossing-enviroment

### Detected error I:
G (S2_red -> !T2_occupied)  is false  (Train is on T2 when S2 is red)  
NOTE: This change was removed and restructured as Error III  
```
This was fixed by changing next(S2_red):  
* T2_occupied | T3_occupied : TRUE;  
* T3_occupied : TRUE; 
```

### Detected error II:
specification  G (S2_green -> (((W2_active & W1_active) & B1_closed) & B2_closed))  is false

This was fixed by changing next(open) in BarrierModule:    
```
  next(open)		:= case  
    barrier_request : FALSE;  
    !barrier_request & !closed : TRUE;  
    TRUE : open;  
  esac;  
```  
  INTO THE FOLLOWING  
```  
  next(open)		:= case  
    barrier_request : FALSE;  
    !barrier_request & !closed : TRUE;  
    TRUE : TRUE;  
  esac;  
```
### Detected error III:

S2_green turns true if train is on track T4.  
```
LTLSPEC G (S2_green -> X T2_occupied);  
```
CHANGED  
```
next(S2_red)        := case  
    T2_occupied | T3_occupied : TRUE;  
    B1_open | B2_open : TRUE;  
    TRUE : FALSE;  
esac;  
```
INTO
```
next(S2_red)        := case  
    T2_occupied | T3_occupied : TRUE;  
    B1_open | B2_open : TRUE;   
T1_occupied & W_active & B1_closed & B2_closed : FALSE;  
TRUE : TRUE;  
    FALSE : TRUE;  
esac;  
``` 

### Detected error IV & Detected error V:
LTLSPEC G (S2_green -> (W2_active & W1_active & B1_closed & B2_closed));
LTLSPEC G(B1_closed & B2_closed & T2_occupied -> F S3_green);
FIXED

CHANGED  
```
next(T2_occupied)   := case
      T1_occupied & S2_green : TRUE;
      TRUE : FALSE;
    esac;
    next(T3_occupied)   := case
      T2_occupied : TRUE;
      TRUE : FALSE;
    esac; 
```
INTO
```
next(T2_occupied)   := case
		  T1_occupied & S2_green : TRUE;
		  T2_occupied & S3_red: TRUE;
		  TRUE : FALSE;
		esac;
		next(T3_occupied)   := case
		  T2_occupied & S3_green: TRUE;
		  TRUE : FALSE;
		esac;
``` 
AND CHANGED  
```
    next(S2_red)        := case
        T2_occupied | T3_occupied : TRUE;
        !B1_closed  : TRUE;
        TRUE : FALSE;
    esac;
    
    next(S3_red)        := case
        T1_occupied | T2_occupied : TRUE;
        !B1_closed  : TRUE;
        TRUE : FALSE;
    esac;
    
```
INTO
```
    next(S2_red)        := case
        T2_occupied | T3_occupied : TRUE;
        B1_open | B2_open : TRUE;
	T1_occupied & W_active & B1_closed & B2_closed : FALSE;
	TRUE : TRUE;
    esac;
    
    next(S3_red)        := case
        T1_occupied : TRUE;
        B1_open | B2_open: TRUE;
        (!B1_open & !B2_open) & T2_occupied: FALSE;
        TRUE: TRUE;
    esac;
    
``` 

## Part III:

NOTE: Teachers said cannot describe a liveness property without the "F" using LTL. So only the F porperties can be used in part III.  

### Detected error I:
specification  G ((W2_active | W1_active) ->  F (B1_closed & B2_closed))  is false

### Detected error II:
specification  G (T2_occupied ->  X T3_occupied)  is false

### Detected error III:
specification  G (T1_occupied ->  F T3_occupied)  is false

### Detected error IV:
specification  G (T1_occupied ->  F !T1_occupied)  is false

### Detected error V:
specification  G (S2_green ->  X T2_occupied)  is false

### Detected error VI:
specification  G (S2_green ->  F T2_occupied)  is false







