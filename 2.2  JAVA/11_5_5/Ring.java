class Ring{
  private double innerRadius;
  private double outerRadius;

  public String color;

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
