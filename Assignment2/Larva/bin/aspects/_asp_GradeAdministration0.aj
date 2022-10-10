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

before ( int grade,Course courseInfo) : (call(* Course.addGrade(..)) && target(courseInfo) && args(*,grade) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst.grade = grade;
_cls_inst.courseInfo = courseInfo;
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

before ( double credits,Student studentInfo) : (call(* Student.addCredits(..)) && target(studentInfo) && args(credits) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst.credits = credits;
_cls_inst.studentInfo = studentInfo;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*addCredits*/, 10/*changeCredits*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*addCredits*/, 10/*changeCredits*/);
}
}

before ( double credits,Student studentInfo) : (call(* Student.setCredits(..)) && target(studentInfo) && args(credits) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst.credits = credits;
_cls_inst.studentInfo = studentInfo;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*setCredits*/, 10/*changeCredits*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*setCredits*/, 10/*changeCredits*/);
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