class Solution {
    public boolean reachingPoints(int startX, int startY, int targetX, int targetY) {
        while (targetX > startX && targetY > startY && targetX != targetY) {
            if (targetX > targetY) {
                targetX %= targetY;
            } else {
                targetY %= targetX;
            }
        }
        if (targetX == startX && targetY == startY) {
            return true;
        }
        if (targetX == startX) {
            return targetY > startY && (targetY - startY) % startX == 0;
        }
        if (targetY == startY) {
            return targetX > startX && (targetX - startX) % targetY == 0;
        }
        return false;
    }
}
