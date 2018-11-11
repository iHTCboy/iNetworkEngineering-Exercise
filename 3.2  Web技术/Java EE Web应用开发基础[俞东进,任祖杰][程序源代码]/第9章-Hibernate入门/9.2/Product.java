public class Product {
private int id;  //对应product表的Id字段
private int sortid;  //对应product表的sortId字段
private String name;  //对应product表的Name字段
private double price;  //对应product表的price字段
//下面为各属性对应的getter和setter方法
 public int getId() {   
return id;
}
 public void setId(int id) {         
this.id = id;
}
 public double getPrice() {              
return price;
}
public void setPrice(double price) {   
this.price = price;
}
public int getSortid() {              
return sortid;
}
public void setSortid(int sortid) {   
this.sortid = sortid;
}
public String getName() {            
return name;
}
public void setName(String name) {   
this.name = name;
}       
}
