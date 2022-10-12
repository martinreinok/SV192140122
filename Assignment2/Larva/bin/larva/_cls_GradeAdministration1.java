package larva;


import gradeAdministration.Course;
import gradeAdministration.Main;
import gradeAdministration.Student;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_GradeAdministration1 implements _callable{

public static LinkedHashMap<_cls_GradeAdministration1,_cls_GradeAdministration1> _cls_GradeAdministration1_instances = new LinkedHashMap<_cls_GradeAdministration1,_cls_GradeAdministration1>();

_cls_GradeAdministration0 parent;
public static double credits;
public static Student s1;
public Student s;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_GradeAdministration1( Student s) {
parent = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
this.s = s;
}

public void initialisation() {

_cls_GradeAdministration0.pw .println ("Started creditsSystem");

}

public static _cls_GradeAdministration1 _get_cls_GradeAdministration1_inst( Student s) { synchronized(_cls_GradeAdministration1_instances){
_cls_GradeAdministration1 _inst = new _cls_GradeAdministration1( s);
if (_cls_GradeAdministration1_instances.containsKey(_inst))
{
_cls_GradeAdministration1 tmp = _cls_GradeAdministration1_instances.get(_inst);
 return _cls_GradeAdministration1_instances.get(_inst);
}
else
{
 _inst.initialisation();
 _cls_GradeAdministration1_instances.put(_inst,_inst);
 return _inst;
}
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_GradeAdministration1)
 && (s == null || s.equals(((_cls_GradeAdministration1)o).s))
 && (parent == null || parent.equals(((_cls_GradeAdministration1)o).parent)))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_GradeAdministration1_instances){
_performLogic_creditsSystem(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_GradeAdministration1[] a = new _cls_GradeAdministration1[1];
synchronized(_cls_GradeAdministration1_instances){
a = _cls_GradeAdministration1_instances.keySet().toArray(a);}
for (_cls_GradeAdministration1 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_GradeAdministration1_instances){
_cls_GradeAdministration1_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_creditsSystem = 8;

public void _performLogic_creditsSystem(String _info, int... _event) {

_cls_GradeAdministration0.pw.println("[creditsSystem]AUTOMATON::> creditsSystem("+s + " " + ") STATE::>"+ _string_creditsSystem(_state_id_creditsSystem, 0));
_cls_GradeAdministration0.pw.flush();

if (0==1){}
else if (_state_id_creditsSystem==8){
		if (1==0){}
		else if ((_occurredEvent(_event,10/*changeCredits*/)) && (credits <0 )){
		_cls_GradeAdministration0.pw .println ("Bad Credits! Credits less than 0. Amount: "+credits +" Student: "+s );

		_state_id_creditsSystem = 7;//moving to state badState
		_goto_creditsSystem(_info);
		}
		else if ((_occurredEvent(_event,10/*changeCredits*/)) && (credits >=0 )){
		_cls_GradeAdministration0.pw .println ("Credits amount: "+credits +" Student: "+s );

		_state_id_creditsSystem = 8;//moving to state okCredits
_cls_GradeAdministration0.pw .println ("Started creditsSystem");

		_goto_creditsSystem(_info);
		}
}
}

public void _goto_creditsSystem(String _info){
_cls_GradeAdministration0.pw.println("[creditsSystem]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_creditsSystem(_state_id_creditsSystem, 1));
_cls_GradeAdministration0.pw.flush();
}

public String _string_creditsSystem(int _state_id, int _mode){
switch(_state_id){
case 7: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionGradeAdministration().toString()+" ";
case 8: if (_mode == 0) return "okCredits"; else return "okCredits";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}