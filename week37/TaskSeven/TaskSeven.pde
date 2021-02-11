int input = 20;
int count = input;

/* updated it to print negative six */

while (count != 0) {
  //if input is negative
  if (count < 0) {
    println(count);
    count ++;
    if (count == -6) {
      println("negative six");
      count ++;
    }
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
