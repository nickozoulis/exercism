class ReverseString {

    //robot -> tobor
    String reverse(String inputString) {
        var newString = "";

        for (int i = inputString.length() - 1; i >= 0; i--) {
            newString += inputString.charAt(i);
        }

        return newString;
    }
  
}
