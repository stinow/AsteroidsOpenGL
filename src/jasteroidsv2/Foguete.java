package jasteroidsv2;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class Foguete {
    
    private float posX=0.0f;
    private float posY=0.0f;
    private float posZ=0.0f;
    private float vel=0.0f;
    
    public void desenhaFoguete(GL2 gl, GLUT glut){
        
        gl.glPushMatrix();
            gl.glScalef(1f, 1f, 1f);
            gl.glTranslatef( getPosX(), getPosY()-5, getPosZ());
            gl.glRotatef(0, 0.0f, 0.0f, 0.0f);
            
        //foguete
            //corpo
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, -3.0f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCylinder(1, 1, 8, 6);
            gl.glPopMatrix();
            //base superior
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, 0.0f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();
            //base inferior
            gl.glPushMatrix();
                gl.glScalef(1.0f, 1.0f, -0.01f);
                gl.glTranslatef(0.0f, 0.0f, 300.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();

        //bico foguete
            gl.glPushMatrix();
                gl.glColor4f(0f,1f,1f,1f);
                gl.glScalef(1.0f, 1.0f, 0.75f);
                gl.glTranslatef(0.0f, 0.0f, 0.0f);
                glut.glutWireCone(1, 3, 8, 8);
            gl.glPopMatrix();
            
            gl.glColor4f(1, 1, 1, 1);
        //turbinas foguete
            //direita superior
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (1.0f, 1.0f, 3.0f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            //esquerda superior
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (-1.0f, 1.0f, 3.0f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            //inferior
            gl.glPushMatrix();
                gl.glScalef(0.25f, 0.25f, -1.0f);
                gl.glTranslatef (0.0f, -1.0f, 3.0f);
                glut.glutWireCylinder(1, 0.25, 10, 1);
            gl.glPopMatrix();
            
        //flaps foguete
            //superior
            gl.glPushMatrix();
                gl.glScalef(0.1f, 0.35f, -1.0f);
                gl.glTranslatef (0.0f, 3.0f, 2.5f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
            //direita
            gl.glPushMatrix();
                gl.glScalef(0.35f, 0.1f, -1.0f);
                gl.glTranslatef(3.0f, 0.0f, 2.5f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
            //esquerda
            gl.glPushMatrix();
                gl.glScalef(0.35f, 0.1f, -1.0f);
                gl.glTranslatef(-3.0f, 0.0f, 2.5f);
                glut.glutWireCube(1.0f);
            gl.glPopMatrix();
          
        gl.glPopMatrix();
    }
    
    public float getPosX(){
        return posX;
    }
    
    public void setPosX(float posX){
        this.posX = posX;
    }
    
    public float getPosY(){
        return posY;
    }
    
    public void setPosY(float posY){
        this.posY = posY;
    }
    
    public float getPosZ(){
        return posZ;
    }
    
    public void setPosZ(float posZ){
        this.posZ = posZ;
    }
    
    public float getVel(){
        return vel;
    }
    
    public void setVel(float vel){
        this.vel = vel;
    }
    
}
