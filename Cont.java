public class Cont implements Comparable<Cont> {
  //fields 
  private String  UUID ;
  private String  SHORT_NAME;
  private String LONG_NAME ; 
 // constructor
 public Cont(){
 }
 //function
 public String get_UUID(){
  return UUID;
 }
 public String get_LONG_NAME(){
  return LONG_NAME;
 }
 public String get_SHORT_NAME(){
  return SHORT_NAME;
 }
 public void set_UUID(String UUID){
  this.UUID =UUID;
 }
 public void set_SHORT_NAME(String SHORT_NAME){
  this.SHORT_NAME =SHORT_NAME;
 }
 public void set_LONG_NAME(String LONG_NAME){
  this.LONG_NAME =LONG_NAME;
 }
public String toString(){
  return "    <CONTAINER "+UUID+">\n"+
         "        <SHORT-NAME>"+SHORT_NAME+"</SHORT-NAME>\n"+
         "        <LONG-NAME>"+LONG_NAME+"</LONG-NAME>\n"+ 
         "    </CONTAINER>\n";
}
@ Override
public int compareTo(Cont c ){
  if(this.get_SHORT_NAME().charAt(9)>c.get_SHORT_NAME().charAt(9)){
   return 1;
  }
  else if(this.get_SHORT_NAME().charAt(9)<c.get_SHORT_NAME().charAt(9)){
   return -1;
  }
  else {
      return 0 ;
  }
} 


}