class MyCalendar {
    private final TreeMap<Integer, Integer> tm = new TreeMap<>();

    public MyCalendar() {
    }

    public boolean book(int startTime, int endTime) {
        var e = tm.ceilingEntry(startTime + 1);
        if (e != null && e.getValue() < endTime) {
            return false;
        }
        tm.put(endTime, startTime);
        return true;
    }
}
