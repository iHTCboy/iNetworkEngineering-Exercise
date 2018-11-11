class Ring{
  private double innerRadius;
  private double outerRadius;

  public String color;
  
  public Ring()
  {}

  public Ring(double iRadius,double oRadius,String c){
    innerRadius=iRadius;
    outerRadius=oRadius;        //初始化外半径
    color=c;
      }

  public double getInnerRadius(){
    return innerRadius;     //返回内半径
            }
  
  public double getOuterRadius(){
     return outerRadius;
        }
 
  public void setInnerRadius(double iRadius){
      innerRadius=iRadius;
    }

  public void setOuterRadius(double oRadius){
      outerRadius=oRadius;
    }

  public void setColor(String c){
    color=c;    //设置颜色
       }
public double inlong()               //返回内周长
{
    return (innerRadius)*2*3.1415;
}

public double outlong()              //返回外周长
{
    return (outerRadius*2*3.1415);
}

  public double getArea(){
    return (outerRadius*outerRadius-innerRadius*innerRadius)*3.1415;
                  }

  public static void main(String[] args){
    Ring ring=new Ring(5,8,"red");
    Ring ring1=new Ring(5,8,"red");
    Ring ring2=new Ring(5,8,"red");

    System.out.println("圆环的内半径："+ring.getInnerRadius());
    System.out.println("圆环的外半径："+ring.getOuterRadius());
    System.out.println("圆环的颜色："+ring.color);
    System.out.println("圆环的面积："+ring.getArea());
    System.out.println("圆环的内周长："+ring1.inlong());
    System.out.println("圆环的外周长："+ring2.outlong()+"\n");
    
    ring.setInnerRadius(4);
    ring.setOuterRadius(6);    //设置圆环ring的外半径为6
    ring.setColor("blue");
   
    System.out.println("圆环的内半径："+ring.getInnerRadius());
    System.out.println("圆环的外半径："+ring.getOuterRadius());
    System.out.println("圆环的颜色："+ring.color);
    System.out.println("圆环的面积："+ring.getArea());
    System.out.println("圆环的内周长："+ring.inlong());
    System.out.println("圆环的外周长："+ring.outlong());

           }
      }
