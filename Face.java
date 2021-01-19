class Face {
    Piece[] pieces = new Piece[9];
    Color faceColor;

    Face(Color c, int j) {
        faceColor = c;
        for(int i = 0; i < 9; i++) {
            pieces[i] = new Piece(c, i);
        }
    }
    
    public String toString() {
        String s = "";
        for(int i = 0; i < 9; i++) {
            s += (pieces[i].toString());
            if(i % 3 == 2) {
                s += "\n";
            } else {
                s += "\t";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Face f = new Face(Color.R, 1);
        System.out.println(f);
    }
}
class Piece {
    Color itsColor, left, right, above, below;
    int num;

    Piece(Color c, int i) {
        itsColor = c;
        num = i;
        switch(c) {
            case W:
                left = Color.O;
                right = Color.R;
                above = Color.B;
                below = Color.G;
            case O:
                left = Color.B;
                right = Color.G;
                above = Color.W;
                below = Color.Y;
                break;
            case G:
                left = Color.O;
                right = Color.R;
                above = Color.W;
                below = Color.Y;
                break;
            case R:
                left = Color.G;
                right = Color.B;
                above = Color.W;
                below = Color.Y;
                break;
            case B:
                left = Color.R;
                right = Color.O;
                above = Color.W;
                below = Color.Y;
                break;
            case Y:
                left = Color.O;
                right = Color.R;
                above = Color.G;
                below = Color.B;
                break;
        }
    }

    public String toString() {
        return itsColor.toString() + num;
    }
}
enum Color {
    //White, Red, Green, Yellow, Orange, Blue;
    W, O, G, R, B, Y;

    int colorToInt() {
        switch(this) {
            case W:
                return 0;
            case O:
                return 1;
            case G:
                return 2;
            case R:
                return 3;
            case B:
                return 4;
            case Y:
                return 5;
        }
        return -1;
    }
}