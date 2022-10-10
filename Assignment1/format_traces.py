import argparse

parser = argparse.ArgumentParser(description="Select file")

parser.add_argument("-f", "--file", default="traces.txt", dest="selected_file", help="File that contains unsorted traces")

args = parser.parse_args()

lines = [x.strip() for x in open(f"{args.selected_file}")]

lines_to_keep = [
"train.T0_occupied", 
"train.T1_occupied", 
"train.T2_occupied",
"train.T3_occupied", 
"train.T4_occupied", 
"cars.cars_crossing",
"barrier1.open", 
"barrier1.closed",
"environment.S1_red",
"interlocking.S2_red",
"interlocking.S3_red",
"environment.S4_red", 
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
