package aspects;

import gradeAdministration.Course;
import gradeAdministration.Main;
import gradeAdministration.Student;

import larva.*;
public aspect _asp_GradeAdministration1 {

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_GradeAdministration1.initialize();
}
}

before ( double credits,Student s1) : (call(* Student.addCredits(..)) && target(s1) && args(credits) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){
Student s;
s =s1 ;

_cls_GradeAdministration1 _cls_inst = _cls_GradeAdministration1._get_cls_GradeAdministration1_inst( s);
_cls_inst.credits = credits;
_cls_inst.s1 = s1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*addCredits*/, 10/*changeCredits*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*addCredits*/, 10/*changeCredits*/);
}
}

before ( double credits,Student s1) : (call(* Student.setCredits(..)) && target(s1) && args(credits) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){
Student s;
s =s1 ;

_cls_GradeAdministration1 _cls_inst = _cls_GradeAdministration1._get_cls_GradeAdministration1_inst( s);
_cls_inst.credits = credits;
_cls_inst.s1 = s1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*setCredits*/, 10/*changeCredits*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*setCredits*/, 10/*changeCredits*/);
}
}
}