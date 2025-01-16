/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alvaro.gargon.4
 */
public class Vector2D {
    private float x;
    private float y;

    public Vector2D() {
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+ x + y + ")";
    }
    
    public float getMagnitud(){
        return (float) Math.sqrt(x*x+y*y);
    }
    
    public Vector2D normalizar(){
        if(getMagnitud()==0){
            return null;
        }else{
            float a,b;
            a=this.x/getMagnitud();
            b=this.x/getMagnitud();
            Vector2D vector= new Vector2D(a,b);
            return vector;
        }
    }
    
    public float getProductoEscalar(Vector2D v){
        return this.x*v.x+this.y*v.y;
    }
    
    public boolean esPerpendicular(Vector2D v){
        if(getProductoEscalar(v)==0){
            return true;
        }else{
            return false;
        }
    }
    
    public String printFormaPolar(){
        float r;
        double angulo;
        r=getMagnitud();
        angulo=Math.atan2(this.y, this.x);
        angulo=Math.toDegrees(angulo);
        return "("+r+","+angulo+")";
    }
}
