class ReverseString {

    //robot -> tobor
    String reverse(String inputString) {
        StringBuilder newString = new StringBuilder();

        for (int i = inputString.length() - 1; i >= 0; i--) {
            newString.append(inputString.charAt(i));
        }

        return newString.toString();
    }
  
}
