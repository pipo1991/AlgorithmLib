class Fraction{
    int x;
    int y;

    public Fraction(int x, int y) {
        int val=GCD(x,y);
        this.x = x/val ;
        this.y = y/val;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void add(Fraction f) {
        this.x=this.x*f.getY()+this.y*f.getX();
        this.y =f.getY()*this.y;
        int val=GCD(this.x,this.y);
        this.x = this.x/val ;
        this.y = this.y/val;
    }
    
    public void sub(Fraction f) {
        this.x=this.x*f.getY()-this.y*f.getX();
        this.y =f.getY()*this.y;
        int val=GCD(this.x,this.y);
        this.x = this.x/val ;
        this.y = this.y/val;
    }

    public void mult(Fraction f) {
        this.x=this.x*f.getX();
        this.y =f.getY()*this.y;
        int val=GCD(this.x,this.y);
        this.x = this.x/val ;
        this.y = this.y/val;
    }
    
     public void div(Fraction f) {
        this.x=this.x*f.getY();
        this.y =f.getX()*this.y;
        int val=GCD(this.x,this.y);
        this.x = this.x/val ;
        this.y = this.y/val;
    }
     
     public boolean equals(Fraction f){
         return (this.x==f.getX())&&(this.y==f.getY());
     }
     
    public void prints(){
         System.out.println("Fraction="+this.x+"/"+this.y);
     }
    
    static public int GCD(int x1,int y1){
        if(y1==0)
            return x1;
        return GCD(y1,x1%y1);
    }
  }