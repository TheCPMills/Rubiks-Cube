public class Cube {
    Face[] faces = new Face[6];
    Cube() {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 9; j++) {
                faces[i] = new Face(Color.values()[i], j);
            }
        }
    }

    public String toString() {
        String s = "";
        s += " \t \t \t" + faces[0].pieces[0] + "\t" + faces[0].pieces[1] + "\t" + faces[0].pieces[2] + "\n"; 
        s += " \t \t \t" + faces[0].pieces[3] + "\t" + faces[0].pieces[4] + "\t" + faces[0].pieces[5] + "\n";
        s += " \t \t \t" + faces[0].pieces[6] + "\t" + faces[0].pieces[7] + "\t" + faces[0].pieces[8] + "\n";
        s += faces[1].pieces[0] + "\t" + faces[1].pieces[1] + "\t" + faces[1].pieces[2] + "\t" + faces[2].pieces[0] + "\t" + faces[2].pieces[1] + "\t" + faces[2].pieces[2] + "\t" + faces[3].pieces[0] + "\t" + faces[3].pieces[1] + "\t" + faces[3].pieces[2] + "\t" + faces[4].pieces[0] + "\t" + faces[4].pieces[1] + "\t" + faces[4].pieces[2] + "\n";
        s += faces[1].pieces[3] + "\t" + faces[1].pieces[4] + "\t" + faces[1].pieces[5] + "\t" + faces[2].pieces[3] + "\t" + faces[2].pieces[4] + "\t" + faces[2].pieces[5] + "\t" + faces[3].pieces[3] + "\t" + faces[3].pieces[4] + "\t" + faces[3].pieces[5] + "\t" + faces[4].pieces[3] + "\t" + faces[4].pieces[4] + "\t" + faces[4].pieces[5] + "\n";
        s += faces[1].pieces[6] + "\t" + faces[1].pieces[7] + "\t" + faces[1].pieces[8] + "\t" + faces[2].pieces[6] + "\t" + faces[2].pieces[7] + "\t" + faces[2].pieces[8] + "\t" + faces[3].pieces[6] + "\t" + faces[3].pieces[7] + "\t" + faces[3].pieces[8] + "\t" + faces[4].pieces[6] + "\t" + faces[4].pieces[7] + "\t" + faces[4].pieces[8] + "\n";

        s += " \t \t \t" + faces[5].pieces[0] + "\t" + faces[5].pieces[1] + "\t" + faces[5].pieces[2] + "\n";
        s += " \t \t \t" + faces[5].pieces[3] + "\t" + faces[5].pieces[4] + "\t" + faces[5].pieces[5] + "\n";
        s += " \t \t \t" + faces[5].pieces[6] + "\t" + faces[5].pieces[7] + "\t" + faces[5].pieces[8];     
        return s;
    }

    // helper functions
    void rotateClockwise(Face f) {
        int n = f.faceColor.colorToInt();
        Piece[] side = { faces[n].pieces[6], faces[n].pieces[3], faces[n].pieces[0], faces[n].pieces[7],
                faces[n].pieces[1], faces[n].pieces[8], faces[n].pieces[5], faces[n].pieces[2] };
        int count = 0;
        for (int i = 0; count < 8; i++) {
            if (i != 4) {
                faces[n].pieces[i] = side[count++];
            }
        }
    }

    void rotateCounterclockwise(Face f) {
        int n = f.faceColor.colorToInt();
        Piece[] side = { faces[n].pieces[2], faces[n].pieces[5], faces[n].pieces[8], faces[n].pieces[1],
                faces[n].pieces[7], faces[n].pieces[0], faces[n].pieces[3], faces[n].pieces[6] };
        int count = 0;
        for (int i = 0; count < 8; i++) {
            if (i != 4) {
                faces[n].pieces[i] = side[count++];
            }
        }
    }

    String scramble() {
        upPrime();
        rightPrime();
        frontTwo();
        right();
        front();
        leftPrime();
        right();
        back();
        front();
        rightPrime();
        backPrime();
        left();
        rightTwo();
        frontPrime();
        backTwo();
        upPrime();
        rightPrime();
        frontTwo();
        backPrime();
        down();
        leftPrime();
        rightPrime();
        downTwo();
        rightTwo();
        leftPrime();
        return "U' R' F2 R F L' R B F R' B' L R2 F' B2 U' R' F2 B' D L' R' D2 R2 L'";
    }

    // clockwise moves
    void right() {
        Piece[] right = {faces[2].pieces[2], faces[2].pieces[5], faces[2].pieces[8], faces[5].pieces[2], faces[5].pieces[5], faces[5].pieces[8], faces[0].pieces[8], faces[0].pieces[5], faces[0].pieces[2], faces[4].pieces[0], faces[4].pieces[3], faces[4].pieces[6]};
        int count = 0;
        for(int i = 0; count < 12; i++) {
            if(i == 4) {
                for(int j = 0; j < 9; j += 3) {
                    faces[i].pieces[j] = right[count++];
                }
            } else if (i == 0 || i == 2) {
                for(int j = 2; j < 9; j += 3) {
                    faces[i].pieces[j] = right[count++];
                }
            } else if (i == 5) {
                for (int j = 8; j > 1; j -= 3) {
                    faces[i].pieces[j] = right[count++];
                }
            }
        }
        rotateClockwise(faces[3]);
    }

    void left() {
        Piece[] left = {faces[4].pieces[8], faces[4].pieces[5], faces[4].pieces[2], faces[0].pieces[0], faces[0].pieces[3], faces[0].pieces[6], faces[5].pieces[6], faces[5].pieces[3], faces[5].pieces[0], faces[2].pieces[0], faces[2].pieces[3], faces[2].pieces[6]};
        int count = 0;
        for (int i = 0; count < 12; i++) {
            if (i == 4) {
                for (int j = 2; j < 9; j += 3) {
                    faces[i].pieces[j] = left[count++];
                }
            } else if (i == 0 || i == 2 || i == 5) {
                for (int j = 0; j < 9; j += 3) {
                    faces[i].pieces[j] = left[count++];
                }
            }
        }
        rotateClockwise(faces[1]);
    }

    void up() {
        Piece[] up = {faces[2].pieces[0], faces[2].pieces[1], faces[2].pieces[2], faces[3].pieces[0], faces[3].pieces[1], faces[3].pieces[2], faces[4].pieces[0], faces[4].pieces[1], faces[4].pieces[2], faces[1].pieces[0], faces[1].pieces[1], faces[1].pieces[2]};
        int count = 0;
        for (int i = 1; count < 12; i++) {
            for (int j = 0; j < 3; j++) {
                faces[i].pieces[j] = up[count++];
            }
        }
        rotateClockwise(faces[0]);
    }

    

    void down() {
        Piece[] down = {faces[4].pieces[6], faces[4].pieces[7], faces[4].pieces[8], faces[1].pieces[6], faces[1].pieces[7], faces[1].pieces[8], faces[2].pieces[6], faces[2].pieces[7], faces[2].pieces[8], faces[3].pieces[6], faces[3].pieces[7], faces[3].pieces[8]};
        int count = 0;
        for (int i = 1; count < 12; i++) {
            for (int j = 6; j < 9; j++) {
                faces[i].pieces[j] = down[count++];
            }
        }
        rotateClockwise(faces[5]);
    }

    void front() {
        Piece[] front = {faces[0].pieces[6], faces[0].pieces[7], faces[0].pieces[8], 
                         faces[1].pieces[2], faces[1].pieces[5], faces[1].pieces[8], 
                         faces[3].pieces[0], faces[3].pieces[3], faces[3].pieces[6],
                         faces[5].pieces[0], faces[5].pieces[1], faces[5].pieces[2]};

        faces[0].pieces[6] = front[5];
        faces[0].pieces[7] = front[4];
        faces[0].pieces[8] = front[3];

        faces[1].pieces[2] = front[9];
        faces[1].pieces[5] = front[10];
        faces[1].pieces[8] = front[11];

        faces[3].pieces[0] = front[0];
        faces[3].pieces[3] = front[1];
        faces[3].pieces[6] = front[2];

        faces[5].pieces[0] = front[8];
        faces[5].pieces[1] = front[7];
        faces[5].pieces[2] = front[6];

        rotateClockwise(faces[2]);
    }

    void back() {
        Piece[] back = {faces[0].pieces[0], faces[0].pieces[1], faces[0].pieces[2], 
                        faces[1].pieces[0], faces[1].pieces[3], faces[1].pieces[6], 
                        faces[3].pieces[2], faces[3].pieces[5], faces[3].pieces[8],
                        faces[5].pieces[6], faces[5].pieces[7], faces[5].pieces[8]};
        
        faces[0].pieces[0] = back[6];
        faces[0].pieces[1] = back[7];
        faces[0].pieces[2] = back[8];

        faces[1].pieces[0] = back[2];
        faces[1].pieces[3] = back[1];
        faces[1].pieces[6] = back[0];

        faces[3].pieces[2] = back[11];
        faces[3].pieces[5] = back[10];
        faces[3].pieces[8] = back[9];

        faces[5].pieces[6] = back[3];
        faces[5].pieces[7] = back[4];
        faces[5].pieces[8] = back[5];

        rotateClockwise(faces[4]);
    }

    // counterclockwise moves
    void rightPrime() {
        right();
        right();
        right();
    }

    void leftPrime() {
        left();
        left();
        left();
    }

    void upPrime() {
        up();
        up();
        up();
    }

    void downPrime() {
        down();
        down();
        down();
    }

    void frontPrime() {
        front();
        front();
        front();
    }

    void backPrime() {
        back();
        back();
        back();
    }

    // wide moves
    void rightTwo() {
        right();
        right();
    }

    void leftTwo() {
        left();
        left();
    }

    void upTwo() {
        up();
        up();
    }

    void downTwo() {
        down();
        down();
    }

    void frontTwo() {
        front();
        front();
    }

    void backTwo() {
        back();
        back();
    }

    // clockwise wide moves
    void rightWide() {
        x();
        left();
    }

    void leftWide() {
        x();
        rightPrime();
    }

    void upWide() {
        y();
        down();
    }

    void downWide() {
        yPrime();
        up();
    }

    void frontWide() {
        z();
        back();
    }

    void backWide() {
        zPrime();
        front();
    }

    // counterclockwise wide moves
    void rightWidePrime() {
        rightWide();
        rightWide();
        rightWide();
    }

    void leftWidePrime() {
        leftWide();
        leftWide();
        leftWide();
    }

    void upWidePrime() {
        upWide();
        upWide();
        upWide();
    }

    void downWidePrime() {
        downWide();
        downWide();
        downWide();
    }

    void frontWidePrime() {
        frontWide();
        frontWide();
        frontWide();
    }

    void backWidePrime() {
        backWide();
        backWide();
        backWide();
    }

    // double wide moves
    void rightWideTwo() {
        rightWide();
        rightWide();
    }

    void leftWideTwo() {
        leftWide();
        leftWide();
    }

    void upWideTwo() {
        upWide();
        upWide();
    }

    void downWideTwo() {
        downWide();
        downWide();
    }

    void frontWideTwo() {
        frontWide();
        frontWide();
    }

    void backWideTwo() {
        backWide();
        backWide();
    }

    // clockwise slice moves
    void middle() {
        xPrime();
        right();
        leftPrime();
    }

    void equator() {
        yPrime();
        up();
        downPrime();
    }

    void standing() {
        z();
        frontPrime();
        back();
    }

    // counterclockwise slice moves
    void middlePrime() {
        middle();
        middle();
        middle();
    }

    void equatorPrime() {
        equator();
        equator();
        equator();
    }

    void standingPrime() {
        standing();
        standing();
        standing();
    }

    // double slice moves
    void middleTwo() {
        middle();
        middle();
    }

    void equatorTwo() {
        equator();
        equator();
    }

    void standingTwo() {
        standing();
        standing();
    }

    // clockwise cube rotations
    void x() {
        Piece[] face0 = {faces[0].pieces[0], faces[0].pieces[1], faces[0].pieces[2], faces[0].pieces[3], faces[0].pieces[4], faces[0].pieces[5], faces[0].pieces[6], faces[0].pieces[7], faces[0].pieces[8]};
        Piece[] face2 = {faces[2].pieces[0], faces[2].pieces[1], faces[2].pieces[2], faces[2].pieces[3], faces[2].pieces[4], faces[2].pieces[5], faces[2].pieces[6], faces[2].pieces[7], faces[2].pieces[8]};
        Piece[] face4 = {faces[4].pieces[0], faces[4].pieces[1], faces[4].pieces[2], faces[4].pieces[3], faces[4].pieces[4], faces[4].pieces[5], faces[4].pieces[6], faces[4].pieces[7], faces[4].pieces[8]};
        Piece[] face5 = {faces[5].pieces[0], faces[5].pieces[1], faces[5].pieces[2], faces[5].pieces[3], faces[5].pieces[4], faces[5].pieces[5], faces[5].pieces[6], faces[5].pieces[7], faces[5].pieces[8]};

        for(int i = 0; i < 9; i++) {
            faces[0].pieces[i] = face2[i];
            faces[2].pieces[i] = face5[i];
            faces[4].pieces[8 - i] = face0[i];
            faces[5].pieces[8 - i] = face4[i];
        }
        rotateClockwise(faces[3]);
        rotateCounterclockwise(faces[1]);
    }

    void y() {
        Piece[] face1 = {faces[1].pieces[0], faces[1].pieces[1], faces[1].pieces[2], faces[1].pieces[3], faces[1].pieces[4], faces[1].pieces[5], faces[1].pieces[6], faces[1].pieces[7], faces[1].pieces[8]};
        Piece[] face2 = {faces[2].pieces[0], faces[2].pieces[1], faces[2].pieces[2], faces[2].pieces[3], faces[2].pieces[4], faces[2].pieces[5], faces[2].pieces[6], faces[2].pieces[7], faces[2].pieces[8]};
        Piece[] face3 = {faces[3].pieces[0], faces[3].pieces[1], faces[3].pieces[2], faces[3].pieces[3], faces[3].pieces[4], faces[3].pieces[5], faces[3].pieces[6], faces[3].pieces[7], faces[3].pieces[8] };
        Piece[] face4 = {faces[4].pieces[0], faces[4].pieces[1], faces[4].pieces[2], faces[4].pieces[3], faces[4].pieces[4], faces[4].pieces[5], faces[4].pieces[6], faces[4].pieces[7], faces[4].pieces[8]};

        for (int i = 0; i < 9; i++) {
            faces[4].pieces[i] = face1[i];
            faces[1].pieces[i] = face2[i];
            faces[2].pieces[i] = face3[i];
            faces[3].pieces[i] = face4[i];
        }
        rotateClockwise(faces[0]);
        rotateCounterclockwise(faces[5]);
    }

    void z() {
        Piece[] face0 = {faces[0].pieces[0], faces[0].pieces[1], faces[0].pieces[2], faces[0].pieces[3], faces[0].pieces[4], faces[0].pieces[5], faces[0].pieces[6], faces[0].pieces[7], faces[0].pieces[8]};
        Piece[] face1 = {faces[1].pieces[0], faces[1].pieces[1], faces[1].pieces[2], faces[1].pieces[3], faces[1].pieces[4], faces[1].pieces[5], faces[1].pieces[6], faces[1].pieces[7], faces[1].pieces[8]};
        Piece[] face3 = {faces[3].pieces[0], faces[3].pieces[1], faces[3].pieces[2], faces[3].pieces[3], faces[3].pieces[4], faces[3].pieces[5], faces[3].pieces[6], faces[3].pieces[7], faces[3].pieces[8]};
        Piece[] face5 = {faces[5].pieces[0], faces[5].pieces[1], faces[5].pieces[2], faces[5].pieces[3], faces[5].pieces[4], faces[5].pieces[5], faces[5].pieces[6], faces[5].pieces[7], faces[5].pieces[8]};

        for (int i = 0; i < 9; i++) {
            faces[0].pieces[i] = face1[(3 * (2 - (i % 3))) + i / 3];
            faces[1].pieces[i] = face5[(3 * (2 - (i % 3))) + i / 3];
            faces[3].pieces[i] = face0[(3 * (2 - (i % 3))) + i / 3];
            faces[5].pieces[i] = face3[(3 * (2 - (i % 3))) + i / 3];
        }
        
        rotateClockwise(faces[2]);
        rotateCounterclockwise(faces[4]);
    }

    // counterclockwise cube rotations
    void xPrime() {
        x();
        x();
        x();
    }

    void yPrime() {
        y();
        y();
        y();
    }

    void zPrime() {
        z();
        z();
        z();
    }

    // double cube rotations
    void xTwo() {
        x();
        x();
    }

    void yTwo() {
        y();
        y();
    }

    void zTwo() {
        z();
        z();
    }
}