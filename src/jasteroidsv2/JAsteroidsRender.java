package jasteroidsv2;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLAutoDrawable;


public class JAsteroidsRender implements GLEventListener{

    private GL2 gl;
    private GLUT glut = new GLUT();
    private GLU glu= new GLU();
    
    private int console = 0;
    
    private Foguete fog;
    
    public JAsteroidsRender(){
        fog = new Foguete();
    }
    
    @Override
    public void init(GLAutoDrawable glad) {}

    @Override
    public void dispose(GLAutoDrawable glad) {}

    @Override
    public void display(GLAutoDrawable glad) {
        console++;
        
        GL2 gl = glad.getGL().getGL2();
        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        
        gl.glMatrixMode(GL2.GL_PROJECTION);        	
        gl.glLoadIdentity();
        glu.gluPerspective(90.0, 1, 0.5, 200.0);
        
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); 
//        glu.gluLookAt(0, 1.5, fog.getPosZ()-10, 0, 0, fog.getPosZ(), 0, 1, 0);
        glu.gluLookAt(0, 0, -10,  0, 0, 0,  0, 1, 0);
        
        gl.glRotatef(0,0,1f,0);
        
        fog.desenhaFoguete(gl, glut);
        
        gl.glFlush();
        
        //para controlar a saída do console
        if(console % 30 == 0){
            System.out.println("X: " + fog.getPosX() + ", Y: " + fog.getPosY() + ", Z: " + fog.getPosZ() + ", Veloc " + fog.getVel());
            console = 0;
        }
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {}
    
    public Foguete getFog(){
        return fog;
    }
    
}
