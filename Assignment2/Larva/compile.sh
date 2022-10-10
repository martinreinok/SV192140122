#!/bin/bash
rm -r bin; mkdir bin

echo "compiling source files..."
javac -d bin/ src/gradeAdministration/*.java

echo "generating files..."
java -jar larva.jar GradeAdministration.lrv -o ./bin

echo "compiling files..."
ajc -1.5 -cp aspectjrt.jar:./bin -sourceroots ./bin

echo "compiling aspects..."
ajc -1.5 -cp aspectjrt.jar:./bin -outxmlfile bin/META-INF/aop.xml bin/aspects/*.aj
