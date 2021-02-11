int input = 20;
int count = input;

/* it does not print "six" when the value is -6, since I understood the task 
   as only printing "six" when it's counting the positive value 6 */

while (count != 0) {
  //if input is negative
  if (count < 0) {
    println(count);
    count ++;
    if (count == input / 2) {
      println("HALF!");
      count ++;
    }
  }
  //if input is positive
  if (count > 0) {
    println(count);
    count --;
    if (count == 6) {
      println("six");
      count --;
    }
    if (count == input / 2) {
      println("HALF!");
      count --;
    }
  }

  if (count == 0) {
    print(count);
  }
}
