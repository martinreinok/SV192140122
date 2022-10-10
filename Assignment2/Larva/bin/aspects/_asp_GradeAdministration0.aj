package aspects;

import gradeAdministration.Course;
import gradeAdministration.Main;
import gradeAdministration.Student;

import larva.*;
public aspect _asp_GradeAdministration0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_GradeAdministration0.initialize();
}
}

before ( Course a,int grade) : (call(* Course.addGrade(..)) && target(a) && args(*,grade) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst.a = a;
_cls_inst.grade = grade;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 4/*addGrade*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*addGrade*/);
}
}

before () : (call(* *.addCourse(..)) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*addCourse*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*addCourse*/);
}
}

before () : (call(* *.run(..)) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*programRun*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*programRun*/);
}
}
}