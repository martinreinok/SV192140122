lines = [x.strip() for x in open(f"traces-x20.txt")]

lines_to_keep = [
"train.T0_occupied", 
"train.T1_occupied", 
"train.T2_occupied",
"train.T3_occupied", 
"train.T4_occupied", 
"cars.cars_crossing",
"barrier1.open", 
"barrier1.closed", 
" S1_red",
" S2_red",
" S3_red",
" S4_red", 
"interlocking.B_request", 
"interlocking.W_active",
"-> State: "]

new_file = []
for line in lines:
    for save_line in lines_to_keep:
        if save_line in line:
            new_file.append(line)

with open("formatted_traces.txt", 'w+') as formatted_file:
    for line in new_file:
        formatted_file.write(line + "\n")
