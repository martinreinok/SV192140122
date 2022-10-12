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

before ( int grade,Course course) : (call(* Course.addGrade(..)) && target(course) && args(*,grade) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst.grade = grade;
_cls_inst.course = course;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*addGrade*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*addGrade*/);
}
}

before () : (call(* *.updateStudentCredits(..)) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*addGradeUpdated*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*addGradeUpdated*/);
}
}

before ( Clock _c, long millis) : (call(* Clock.event(long)) && args(millis) && target(_c)  && (if (_c.name.equals("dataDelay"))) && (if (millis == 5000)) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

synchronized(_c){
 if (_c != null && _c._inst != null) {
_c._inst._call(thisJoinPoint.getSignature().toString(), 4/*dataDelayAt5*/);
_c._inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*dataDelayAt5*/);
}
}
}
}
}