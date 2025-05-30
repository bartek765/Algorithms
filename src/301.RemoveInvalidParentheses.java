class Solution {
    private String inputString;
    private int stringLength;
    private Set<String> validParenthesesSet = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.inputString = s;
        this.stringLength = s.length();

        int leftCount = 0, rightCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++leftCount;
            } else if (ch == ')') {
                if (leftCount > 0) {
                    --leftCount;
                } else {
                    ++rightCount;
                }
            }
        }

        depthFirstSearch(0, leftCount, rightCount, 0, 0, "");

        return new ArrayList<>(validParenthesesSet);
    }

    private void depthFirstSearch(int currentIndex, int leftRemovals, int rightRemovals, int leftCount, int rightCount,
            String currentStr) {

        if (currentIndex == stringLength) {
            if (leftRemovals == 0 && rightRemovals == 0) {
                validParenthesesSet.add(currentStr);
            }
            return;
        }

        if (stringLength - currentIndex < leftRemovals + rightRemovals || leftCount < rightCount) {
            return;
        }

        char currentChar = inputString.charAt(currentIndex);

        if (currentChar == '(' && leftRemovals > 0) {
            depthFirstSearch(currentIndex + 1, leftRemovals - 1, rightRemovals, leftCount, rightCount, currentStr);
        }

        if (currentChar == ')' && rightRemovals > 0) {
            depthFirstSearch(currentIndex + 1, leftRemovals, rightRemovals - 1, leftCount, rightCount, currentStr);
        }

        int increaseLeft = currentChar == '(' ? 1 : 0;
        int increaseRight = currentChar == ')' ? 1 : 0;
        depthFirstSearch(currentIndex + 1, leftRemovals, rightRemovals, leftCount + increaseLeft,
                rightCount + increaseRight, currentStr + currentChar);
    }
}
