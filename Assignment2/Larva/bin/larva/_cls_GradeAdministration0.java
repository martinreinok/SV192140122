package larva;


import gradeAdministration.Course;
import gradeAdministration.Main;
import gradeAdministration.Student;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_GradeAdministration0 implements _callable{

public static PrintWriter pw; 
public static _cls_GradeAdministration0 root;

public static LinkedHashMap<_cls_GradeAdministration0,_cls_GradeAdministration0> _cls_GradeAdministration0_instances = new LinkedHashMap<_cls_GradeAdministration0,_cls_GradeAdministration0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("./bin//output_GradeAdministration.txt");

root = new _cls_GradeAdministration0();
_cls_GradeAdministration0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_GradeAdministration0 parent; //to remain null - this class does not have a parent!
public static int grade;
public static Course course;
int no_automata = 2;
public Clock dataDelay = new Clock(this,"dataDelay");

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_GradeAdministration0() {
dataDelay.register(5000l);
}

public void initialisation() {

_cls_GradeAdministration0.pw .println ("Started gradingSystem");


_cls_GradeAdministration0.pw .println ("Started delaySystem");

   dataDelay.reset();
}

public static _cls_GradeAdministration0 _get_cls_GradeAdministration0_inst() { synchronized(_cls_GradeAdministration0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_GradeAdministration0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_GradeAdministration0_instances){
_performLogic_gradingSystem(_info, _event);
_performLogic_delaySystem(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){

_cls_GradeAdministration1[] a1 = new _cls_GradeAdministration1[1];
synchronized(_cls_GradeAdministration1._cls_GradeAdministration1_instances){
a1 = _cls_GradeAdministration1._cls_GradeAdministration1_instances.keySet().toArray(a1);}
for (_cls_GradeAdministration1 _inst : a1)
if (_inst != null){
_inst._call(_info, _event); 
_inst._call_all_filtered(_info, _event);
}
}

public static void _call_all(String _info, int... _event){

_cls_GradeAdministration0[] a = new _cls_GradeAdministration0[1];
synchronized(_cls_GradeAdministration0_instances){
a = _cls_GradeAdministration0_instances.keySet().toArray(a);}
for (_cls_GradeAdministration0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_GradeAdministration0_instances){
_cls_GradeAdministration0_instances.remove(this);}
synchronized(dataDelay){
dataDelay.off();
dataDelay._inst = null;
dataDelay = null;}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_gradingSystem = 2;

public void _performLogic_gradingSystem(String _info, int... _event) {

_cls_GradeAdministration0.pw.println("[gradingSystem]AUTOMATON::> gradingSystem("+") STATE::>"+ _string_gradingSystem(_state_id_gradingSystem, 0));
_cls_GradeAdministration0.pw.flush();

if (0==1){}
else if (_state_id_gradingSystem==2){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*addGrade*/)) && (grade >10 ||grade <1 )){
		_cls_GradeAdministration0.pw .println ("Grade error: "+grade +" Course code: "+course .getCourseCode ());

		_state_id_gradingSystem = 0;//moving to state badGrade

		_goto_gradingSystem(_info);
		}
		else if ((_occurredEvent(_event,0/*addGrade*/))){
		_cls_GradeAdministration0.pw .println ("Grade Added: "+grade +" Course code: "+course .getCourseCode ());

		_state_id_gradingSystem = 1;//moving to state okGrade

		_goto_gradingSystem(_info);
		}
}
else if (_state_id_gradingSystem==1){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*addGrade*/)) && (grade >10 ||grade <1 )){
		_cls_GradeAdministration0.pw .println ("Grade error: "+grade +" Course code: "+course .getCourseCode ());

		_state_id_gradingSystem = 0;//moving to state badGrade

		_goto_gradingSystem(_info);
		}
		else if ((_occurredEvent(_event,0/*addGrade*/))){
		_cls_GradeAdministration0.pw .println ("Grade Added: "+grade +" Course code: "+course .getCourseCode ());

		_state_id_gradingSystem = 1;//moving to state okGrade

		_goto_gradingSystem(_info);
		}
}
}

public void _goto_gradingSystem(String _info){
_cls_GradeAdministration0.pw.println("[gradingSystem]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_gradingSystem(_state_id_gradingSystem, 1));
_cls_GradeAdministration0.pw.flush();
}

public String _string_gradingSystem(int _state_id, int _mode){
switch(_state_id){
case 0: if (_mode == 0) return "badGrade"; else return "!!!SYSTEM REACHED BAD STATE!!! badGrade "+new _BadStateExceptionGradeAdministration().toString()+" ";
case 1: if (_mode == 0) return "okGrade"; else return "okGrade";
case 2: if (_mode == 0) return "noGrade"; else return "noGrade";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_delaySystem = 6;

public void _performLogic_delaySystem(String _info, int... _event) {

_cls_GradeAdministration0.pw.println("[delaySystem]AUTOMATON::> delaySystem("+") STATE::>"+ _string_delaySystem(_state_id_delaySystem, 0));
_cls_GradeAdministration0.pw.flush();

if (0==1){}
else if (_state_id_delaySystem==5){
		if (1==0){}
		else if ((_occurredEvent(_event,4/*dataDelayAt5*/))){
		_cls_GradeAdministration0.pw .println ("Bad delay time! Time more than 5 seconds");

		_state_id_delaySystem = 3;//moving to state badDelay
		_goto_delaySystem(_info);
		}
		else if ((_occurredEvent(_event,2/*addGradeUpdated*/))){
		
		_state_id_delaySystem = 4;//moving to state okDelay
		_goto_delaySystem(_info);
		}
}
else if (_state_id_delaySystem==6){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*addGrade*/))){
		dataDelay .reset ();

		_state_id_delaySystem = 5;//moving to state delayCount
		_goto_delaySystem(_info);
		}
}
else if (_state_id_delaySystem==4){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*addGrade*/))){
		dataDelay .reset ();

		_state_id_delaySystem = 5;//moving to state delayCount
		_goto_delaySystem(_info);
		}
}
}

public void _goto_delaySystem(String _info){
_cls_GradeAdministration0.pw.println("[delaySystem]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_delaySystem(_state_id_delaySystem, 1));
_cls_GradeAdministration0.pw.flush();
}

public String _string_delaySystem(int _state_id, int _mode){
switch(_state_id){
case 5: if (_mode == 0) return "delayCount"; else return "delayCount";
case 6: if (_mode == 0) return "startDelay"; else return "startDelay";
case 3: if (_mode == 0) return "badDelay"; else return "!!!SYSTEM REACHED BAD STATE!!! badDelay "+new _BadStateExceptionGradeAdministration().toString()+" ";
case 4: if (_mode == 0) return "okDelay"; else return "okDelay";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}