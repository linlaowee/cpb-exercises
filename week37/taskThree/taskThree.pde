int black = 0;
int red = color(224,88,88);
int yellow = color(242, 215, 139);
int green = color(124, 201, 118);
int grey = 150;

int time = 0;

//creating functions for the grey lights
void greyR() {
  fill(grey);
  ellipse(150, 100, 175, 175);
}

void greyY() {
  fill(grey);
  ellipse(150, 300, 175, 175);
}

void greyG() {
  fill(grey);
  ellipse(150, 500, 175, 175);
}


void setup() {
  frameRate(30);
  size(300, 600);
  background(black);
  ellipseMode(CENTER);
  time = millis();
  greyR();
  greyY();
  greyG();
}

/*
A traffic light goes through 4 phases before looping back: 
1. stop / only red
2. about to start/ red and yellow
3. start / only green
4. about to stop / only yellow
*/

void draw() {
  //Phase 1
  if (millis() > time + 1500) {
    fill(red);
    ellipse(150, 100, 175, 175);
    greyY();

    //Phase 2
    if (millis() > time + 3000) {
      fill(yellow);
      ellipse(150, 300, 175, 175);

      //Phase 3
      if (millis() > time + 4500) {
        fill(green);
        ellipse(150, 500, 175, 175);
        greyR();
        greyY();

        //Phase 4
        if (millis() > time + 6000) {
          fill(yellow);
          ellipse(150, 300, 175, 175);
          greyG();
          time = millis();
        }
      }
    }
  }
}
