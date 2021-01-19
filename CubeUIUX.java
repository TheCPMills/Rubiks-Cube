import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class CubeUIUX extends JPanel {
    private static final long serialVersionUID = -2734208776498477205L;

    static Cube c = new Cube();

    // clockwise face turns
    static JLabel clockwise = new JLabel("Clockwise Moves");
    static JButton right = new JButton("R");
    static JButton left = new JButton("L");
    static JButton up = new JButton("U");
    static JButton down = new JButton("D");
    static JButton front = new JButton("F");
    static JButton back = new JButton("B");

    // counterclockwise face turns
    static JLabel counterclockwise = new JLabel("Counterclockwise Moves");
    static JButton rightPrime = new JButton("R'");
    static JButton leftPrime = new JButton("L'");
    static JButton upPrime = new JButton("U'");
    static JButton downPrime = new JButton("D'");
    static JButton frontPrime = new JButton("F'");
    static JButton backPrime = new JButton("B'");

    // double face turns
    static JLabel doubled = new JLabel("Double Moves");
    static JButton rightTwo = new JButton("R2");
    static JButton leftTwo = new JButton("L2");
    static JButton upTwo = new JButton("U2");
    static JButton downTwo = new JButton("D2");
    static JButton frontTwo = new JButton("F2");
    static JButton backTwo = new JButton("B2");

    // clockwise wide moves
    static JLabel wide = new JLabel("Clockwise Wide Moves");
    static JButton rightWide = new JButton("r");
    static JButton leftWide = new JButton("l");
    static JButton upWide= new JButton("u");
    static JButton downWide = new JButton("d");
    static JButton frontWide = new JButton("f");
    static JButton backWide = new JButton("b");

    // counterclockwise wide moves
    static JLabel widePrime = new JLabel("Counterclockwise Wide Moves");
    static JButton rightWidePrime = new JButton("r'");
    static JButton leftWidePrime = new JButton("l'");
    static JButton upWidePrime = new JButton("u'");
    static JButton downWidePrime = new JButton("d'");
    static JButton frontWidePrime = new JButton("f'");
    static JButton backWidePrime = new JButton("b'");

    // double wide moves
    static JLabel doubleWide = new JLabel("Double Wide Moves");
    static JButton rightWideTwo = new JButton("r2");
    static JButton leftWideTwo = new JButton("l2");
    static JButton upWideTwo = new JButton("u2");
    static JButton downWideTwo = new JButton("d2");
    static JButton frontWideTwo = new JButton("f2");
    static JButton backWideTwo = new JButton("b2");

    // clockwise slice moves
    static JLabel slice = new JLabel("Clockwise Slice Moves");
    static JButton middle = new JButton("M");
    static JButton equator = new JButton("E");
    static JButton standing = new JButton("S");

    // counterclockwise slice moves
    static JLabel slicePrime = new JLabel("Counterclockwise Slice Moves");
    static JButton middlePrime = new JButton("M'");
    static JButton equatorPrime = new JButton("E'");
    static JButton standingPrime = new JButton("S'");

    // double slice moves
    static JLabel doubleSlice = new JLabel("Double Slice Moves");
    static JButton middleTwo = new JButton("M2");
    static JButton equatorTwo = new JButton("E2");
    static JButton standingTwo = new JButton("S2");

    // clockwise cube rotations
    static JLabel rotationsClockwise = new JLabel("Clockwise Cube Rotations");
    static JButton x = new JButton("x");
    static JButton y = new JButton("y");
    static JButton z = new JButton("z");

    // counterclockwise cube rotations
    static JLabel rotationsCounterclockwise = new JLabel("Counterclockwise Cube Rotations");
    static JButton xPrime = new JButton("x'");
    static JButton yPrime = new JButton("y'");
    static JButton zPrime = new JButton("z'");

    // double cube rotations
    static JLabel doubleRotations = new JLabel("Double Cube Rotations");
    static JButton xTwo = new JButton("x2");
    static JButton yTwo = new JButton("y2");
    static JButton zTwo = new JButton("z2");

    // helpers
    static JButton resetButton = new JButton("Reset");
    static JButton scrambleButton = new JButton("Scramble");
    static JLabel scramble = new JLabel("");

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
        
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        fillGrid(130, 50, g2, c.faces[0].pieces);
        fillGrid(20, 160, g2, c.faces[1].pieces);
        fillGrid(130, 160, g2, c.faces[2].pieces);
        fillGrid(240, 160, g2, c.faces[3].pieces);
        fillGrid(350, 160, g2, c.faces[4].pieces);
        fillGrid(130, 270, g2, c.faces[5].pieces);

      g2.setColor(java.awt.Color.BLACK);
      g2.setStroke(new java.awt.BasicStroke(5));
      drawGrid(130, 50, g2);
      drawGrid(20, 160, g2);
      drawGrid(130, 160, g2);
      drawGrid(240, 160, g2);
      drawGrid(350, 160, g2);
      drawGrid(130, 270, g2);
   }

   @Override
   public Dimension getPreferredSize() {
      // so that our GUI is big enough
      return new Dimension(570, 750);
   }
   
   //helper functions
   public void fillGrid(int x, int y, java.awt.Graphics2D g2, Piece[] p) {
       for(int i = 0; i < 9; i++) {
           switch(p[i].itsColor.colorToInt()) {
               case 0:
                    g2.setColor(java.awt.Color.WHITE);
                    break;
               case 1:
                   g2.setColor(new java.awt.Color(255, 128, 0));
                   break;
               case 2:
                   g2.setColor(java.awt.Color.GREEN);
                   break;
               case 3:
                   g2.setColor(java.awt.Color.RED);
                   break;
               case 4:
                   g2.setColor(java.awt.Color.BLUE);
                   break;
               case 5:
                   g2.setColor(java.awt.Color.YELLOW);
                   break;
           }
           switch(i) {
               case 0:
                    g2.fillRect(x, y, 30, 30);
                    break;
               case 3:
                    g2.fillRect(x, y + 30, 30, 30);
                    break;
               case 6:
                    g2.fillRect(x, y + 60, 30, 30);
                    break;
               case 1:
                    g2.fillRect(x + 30, y, 30, 30);
                    break;
               case 4:
                    g2.fillRect(x + 30, y + 30, 30, 30);
                    break;
               case 7:
                    g2.fillRect(x + 30, y + 60, 30, 30);
                    break;
               case 2:
                    g2.fillRect(x + 60, y, 30, 30);
                    break;
               case 5:
                    g2.fillRect(x + 60, y + 30, 30, 30);
                    break;
               case 8:
                    g2.fillRect(x + 60, y + 60, 30, 30);
                    break;
           }
        }
   }

   public void drawGrid(int x, int y, java.awt.Graphics2D g2) {
       g2.drawRect(x, y, 30, 30); // 0
       g2.drawRect(x + 30, y, 30, 30); // 1
       g2.drawRect(x + 60, y, 30, 30); // 2
       g2.drawRect(x, y + 30, 30, 30); // 3
       g2.drawRect(x + 30, y + 30, 30, 30); // 4
       g2.drawRect(x + 60, y + 30, 30, 30); // 5
       g2.drawRect(x, y + 60, 30, 30); // 6
       g2.drawRect(x + 30, y + 60, 30, 30); // 7
       g2.drawRect(x + 60, y + 60, 30, 30); // 8
   }

   private static void scramble() {
       scramble.setText(c.scramble());
   }

   private static void reset() {
       c = new Cube();
       scramble.setText("");
   }
   // create the GUI explicitly on the Swing event thread
   private static void createAndShowGui() {
       // initialize cube
       CubeUIUX mainPanel = new CubeUIUX();
       
       // initialize frame
       JFrame frame = new JFrame("Rubik's Cube UI/UX");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // add labels
       scramble.setBounds(75, 10, 1000, 25);
       mainPanel.add(scramble);

       // add buttons
       clockwise.setBounds(57, 370, 150, 25);
       mainPanel.add(clockwise);

       right.setBounds(25, 400, 51, 25);
       mainPanel.add(right);

       left.setBounds(25, 430, 51, 25);
       mainPanel.add(left);

       up.setBounds(80, 400, 51, 25);
       mainPanel.add(up);

       down.setBounds(80, 430, 51, 25);
       mainPanel.add(down);

       front.setBounds(135, 400, 51, 25);
       mainPanel.add(front);

       back.setBounds(135, 430, 51, 25);
       mainPanel.add(back);

       //

       counterclockwise.setBounds(210, 370, 150, 25);
       mainPanel.add(counterclockwise);

       rightPrime.setBounds(205, 400, 51, 25);
       mainPanel.add(rightPrime);

       leftPrime.setBounds(205, 430, 51, 25);
       mainPanel.add(leftPrime);

       upPrime.setBounds(260, 400, 51, 25);
       mainPanel.add(upPrime);

       downPrime.setBounds(260, 430, 51, 25);
       mainPanel.add(downPrime);

       frontPrime.setBounds(315, 400, 51, 25);
       mainPanel.add(frontPrime);

       backPrime.setBounds(315, 430, 51, 25);
       mainPanel.add(backPrime);

       //

       doubled.setBounds(425, 370, 150, 25);
       mainPanel.add(doubled);

       rightTwo.setBounds(385, 400, 51, 25);
       mainPanel.add(rightTwo);

       leftTwo.setBounds(385, 430, 51, 25);
       mainPanel.add(leftTwo);

       upTwo.setBounds(440, 400, 51, 25);
       mainPanel.add(upTwo);

       downTwo.setBounds(440, 430, 51, 25);
       mainPanel.add(downTwo);

       frontTwo.setBounds(495, 400, 51, 25);
       mainPanel.add(frontTwo);

       backTwo.setBounds(495, 430, 51, 25);
       mainPanel.add(backTwo);

       //

       wide.setBounds(41, 480, 150, 25);
       mainPanel.add(wide);

       rightWide.setBounds(25, 510, 51, 25);
       mainPanel.add(rightWide);

       leftWide.setBounds(25, 540, 51, 25);
       mainPanel.add(leftWide);

       upWide.setBounds(80, 510, 51, 25);
       mainPanel.add(upWide);

       downWide.setBounds(80, 540, 51, 25);
       mainPanel.add(downWide);

       frontWide.setBounds(135, 510, 51, 25);
       mainPanel.add(frontWide);

       backWide.setBounds(135, 540, 51, 25);
       mainPanel.add(backWide);

       //

       widePrime.setBounds(197, 480, 200, 25);
       mainPanel.add(widePrime);

       rightWidePrime.setBounds(205, 510, 51, 25);
       mainPanel.add(rightWidePrime);

       leftWidePrime.setBounds(205, 540, 51, 25);
       mainPanel.add(leftWidePrime);

       upWidePrime.setBounds(260, 510, 51, 25);
       mainPanel.add(upWidePrime);

       downWidePrime.setBounds(260, 540, 51, 25);
       mainPanel.add(downWidePrime);

       frontWidePrime.setBounds(315, 510, 51, 25);
       mainPanel.add(frontWidePrime);

       backWidePrime.setBounds(315, 540, 51, 25);
       mainPanel.add(backWidePrime);
       
       // 

       doubleWide.setBounds(407, 480, 150, 25);
       mainPanel.add(doubleWide);

       rightWideTwo.setBounds(385, 510, 51, 25);
       mainPanel.add(rightWideTwo);

       leftWideTwo.setBounds(385, 540, 51, 25);
       mainPanel.add(leftWideTwo);

       upWideTwo.setBounds(440, 510, 51, 25);
       mainPanel.add(upWideTwo);

       downWideTwo.setBounds(440, 540, 51, 25);
       mainPanel.add(downWideTwo);

       frontWideTwo.setBounds(495, 510, 51, 25);
       mainPanel.add(frontWideTwo);      

       backWideTwo.setBounds(495, 540, 51, 25);
       mainPanel.add(backWideTwo);
       
       //

       slice.setBounds(40, 590, 150, 25);
       mainPanel.add(slice);

       middle.setBounds(25, 620, 51, 25);
       mainPanel.add(middle);

       equator.setBounds(80, 620, 51, 25);
       mainPanel.add(equator);

       standing.setBounds(135, 620, 51, 25);
       mainPanel.add(standing);
       
       //

       slicePrime.setBounds(196, 590, 200, 25);
       mainPanel.add(slicePrime);

       middlePrime.setBounds(205, 620, 51, 25);
       mainPanel.add(middlePrime);

       equatorPrime.setBounds(260, 620, 51, 25);
       mainPanel.add(equatorPrime);

       standingPrime.setBounds(315, 620, 51, 25);
       mainPanel.add(standingPrime);

       //

       doubleSlice.setBounds(411, 590, 150, 25);
       mainPanel.add(doubleSlice);

       middleTwo.setBounds(385, 620, 51, 25);
       mainPanel.add(middleTwo);

       equatorTwo.setBounds(440, 620, 51, 25);
       mainPanel.add(equatorTwo);

       standingTwo.setBounds(495, 620, 51, 25);
       mainPanel.add(standingTwo);

       //

       rotationsClockwise.setBounds(27, 675, 175, 25);
       mainPanel.add(rotationsClockwise);

       x.setBounds(25, 705, 51, 25);
       mainPanel.add(x);

       y.setBounds(80, 705, 51, 25);
       mainPanel.add(y);

       z.setBounds(135, 705, 51, 25);
       mainPanel.add(z);

       //

       rotationsCounterclockwise.setBounds(189, 675, 200, 25);
       mainPanel.add(rotationsCounterclockwise);

       xPrime.setBounds(205, 705, 51, 25);
       mainPanel.add(xPrime);
       
       yPrime.setBounds(260, 705, 51, 25);
       mainPanel.add(yPrime);

       zPrime.setBounds(315, 705, 51, 25);
       mainPanel.add(zPrime);

       //

       doubleRotations.setBounds(402, 675, 150, 25);
       mainPanel.add(doubleRotations);

       xTwo.setBounds(385, 705, 51, 25);
       mainPanel.add(xTwo);

       yTwo.setBounds(440, 705, 51, 25);
       mainPanel.add(yTwo);

       zTwo.setBounds(495, 705, 51, 25);
       mainPanel.add(zTwo);

       //

       scrambleButton.setBounds(240, 100, 90, 25);
       mainPanel.add(scrambleButton);

       resetButton.setBounds(350, 100, 90, 25);
       mainPanel.add(resetButton);

       // button functions
       right.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.right();
               mainPanel.repaint();
           }
       });

       left.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.left();
               mainPanel.repaint();
           }
       });

       up.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.up();
               mainPanel.repaint();
           }
       });

       down.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.down();
               mainPanel.repaint();
           }
       });

       front.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.front();
               mainPanel.repaint();
           }
       });

       back.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.back();
               mainPanel.repaint();
           }
       });

       //

       rightPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.rightPrime();
               mainPanel.repaint();
           }
       });

       leftPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.leftPrime();
               mainPanel.repaint();
           }
       });

       upPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.upPrime();
               mainPanel.repaint();
           }
       });

       downPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.downPrime();
               mainPanel.repaint();
           }
       });

       frontPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.frontPrime();
               mainPanel.repaint();
           }
       });

       backPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.backPrime();
               mainPanel.repaint();
           }
       });

       //

       rightTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.rightTwo();
               mainPanel.repaint();
           }
       });

       leftTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.leftTwo();
               mainPanel.repaint();
           }
       });

       upTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.upTwo();
               mainPanel.repaint();
           }
       });

       downTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.downTwo();
               mainPanel.repaint();
           }
       });

       frontTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.frontTwo();
               mainPanel.repaint();
           }
       });

       backTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.backTwo();
               mainPanel.repaint();
           }
       });

       //

       rightWide.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.rightWide();
               mainPanel.repaint();
           }
       });

       leftWide.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.leftWide();
               mainPanel.repaint();
           }
       });

       upWide.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.upWide();
               mainPanel.repaint();
           }
       });

       downWide.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.downWide();
               mainPanel.repaint();
           }
       });

       frontWide.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.frontWide();
               mainPanel.repaint();
           }
       });

       backWide.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.backWide();
               mainPanel.repaint();
           }
       });

       //

       rightWidePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.rightWidePrime();
               mainPanel.repaint();
           }
       });

       leftWidePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.leftWidePrime();
               mainPanel.repaint();
           }
       });

       upWidePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.upWidePrime();
               mainPanel.repaint();
           }
       });

       downWidePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.downWidePrime();
               mainPanel.repaint();
           }
       });

       frontWidePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.frontWidePrime();
               mainPanel.repaint();
           }
       });

       backWidePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.backWidePrime();
               mainPanel.repaint();
           }
       });

       //

       rightWideTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.rightWideTwo();
               mainPanel.repaint();
           }
       });

       leftWideTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.leftWideTwo();
               mainPanel.repaint();
           }
       });

       upWideTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.upWideTwo();
               mainPanel.repaint();
           }
       });

       downWideTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.downWideTwo();
               mainPanel.repaint();
           }
       });

       frontWideTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.frontWideTwo();
               mainPanel.repaint();
           }
       });

       backWideTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.backWideTwo();
               mainPanel.repaint();
           }
       });
       
       //

       middle.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.middle();
               mainPanel.repaint();
           }
       });

       equator.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.equator();
               mainPanel.repaint();
           }
       });

       standing.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.standing();
               mainPanel.repaint();
           }
       });

       //

       middlePrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.middlePrime();
               mainPanel.repaint();
           }
       });

       equatorPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.equatorPrime();
               mainPanel.repaint();
           }
       });

       standingPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.standingPrime();
               mainPanel.repaint();
           }
       });

       //

       middleTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.middleTwo();
               mainPanel.repaint();
           }
       });

       equatorTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.equatorTwo();
               mainPanel.repaint();
           }
       });

       standingTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.standingTwo();
               mainPanel.repaint();
           }
       });

       //

       x.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.x();
               mainPanel.repaint();
           }
       });

       y.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.y();
               mainPanel.repaint();
           }
       });

       z.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.z();
               mainPanel.repaint();
           }
       });

       //

       xPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.xPrime();
               mainPanel.repaint();
           }
       });

       yPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.yPrime();
               mainPanel.repaint();
           }
       });

       zPrime.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.zPrime();
               mainPanel.repaint();
           }
       });

       //

       xTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.xTwo();
               mainPanel.repaint();
           }
       });

       yTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.yTwo();
               mainPanel.repaint();
           }
       });

       zTwo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               c.zTwo();
               mainPanel.repaint();
           }
       });

       //

       scrambleButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               scramble();
               mainPanel.repaint();
           }
       });
       
       resetButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               reset();
               mainPanel.repaint();
           }
       });

       mainPanel.setLayout(null);
       mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       frame.getContentPane().add(mainPanel);
       frame.pack();
       frame.setLocationByPlatform(true);
       frame.setVisible(true);
   }
   
   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               createAndShowGui();
           }
       });
    }
}