package test;	
public class Person {
		private String name/*=null*/;
		private int age /*age=-1*/;
		
		public void setName(String name){
			this.name=name;
		}
		public void setAge(int age){
			this.age=age;
		}
		public String getName(){
			return name;
		}
		public int getAge(){
			return age;
		}
	} 