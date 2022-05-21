public class Cube {
    private int y;
    private int x;
    private int z;

    public Cube(){
        this(0, 0 , 0); // calls the other contstructor (must be the first line in the constructor)
        // Could've also done x, y, z = 0
    }
    public Cube(int x){
        this.x = x;
        this.y = 0;
        this.z = 0;
    }
    public Cube(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int area(){
        return this.x * this.y * this.z;
    }

    @Override
    public String toString(){
        return "Z: " + this.z + " Y: " + this.y + " X: " + this.x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
