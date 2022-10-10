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
pw = new PrintWriter("./bin//output_GradeAdministration.txt");

root = new _cls_GradeAdministration0();
_cls_GradeAdministration0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_GradeAdministration0 parent; //to remain null - this class does not have a parent!
public static Course a;
public static int grade;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_GradeAdministration0() {
}

public void initialisation() {

_cls_GradeAdministration0.pw .println ("Started");

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
_performLogic_state(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
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
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_state = 2;

public void _performLogic_state(String _info, int... _event) {

_cls_GradeAdministration0.pw.println("[state]AUTOMATON::> state("+") STATE::>"+ _string_state(_state_id_state, 0));
_cls_GradeAdministration0.pw.flush();

if (0==1){}
else if (_state_id_state==1){
		if (1==0){}
		else if ((_occurredEvent(_event,2/*addCourse*/))){
		_cls_GradeAdministration0.pw .println ("Course Added!");

		_state_id_state = 1;//moving to state normal
		_goto_state(_info);
		}
		else if ((_occurredEvent(_event,4/*addGrade*/)) && (grade <=9 &&grade >=2 )){
		_cls_GradeAdministration0.pw .println ("Grade Added: "+grade +" Course: "+a );

		_state_id_state = 1;//moving to state normal
		_goto_state(_info);
		}
		else if ((_occurredEvent(_event,4/*addGrade*/)) && (grade >9 ||grade <2 )){
		_cls_GradeAdministration0.pw .println ("Grade error: "+grade +" Course: "+a );

		_state_id_state = 0;//moving to state grade_error

		_goto_state(_info);
		}
}
else if (_state_id_state==2){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*programRun*/))){
		_cls_GradeAdministration0.pw .println ("Normal operation");

		_state_id_state = 1;//moving to state normal
		_goto_state(_info);
		}
}
}

public void _goto_state(String _info){
_cls_GradeAdministration0.pw.println("[state]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_state(_state_id_state, 1));
_cls_GradeAdministration0.pw.flush();
}

public String _string_state(int _state_id, int _mode){
switch(_state_id){
case 1: if (_mode == 0) return "normal"; else return "normal";
case 0: if (_mode == 0) return "grade_error"; else return "!!!SYSTEM REACHED BAD STATE!!! grade_error "+new _BadStateExceptionGradeAdministration().toString()+" ";
case 2: if (_mode == 0) return "starting"; else return "starting";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}