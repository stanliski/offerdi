package cn.stanliski.offer51.array;

import java.util.ArrayList;

/**
 * 
 * Insert Interval
 * 
 * @author stanley_hwang
 *
 */
public class InsertInterval {

	/**
	 * Insert newInterval into intervals.
	 * @param intervals: Sorted interval list.
	 * @param newInterval: A new interval.
	 * @return: A new sorted interval list.
	 */
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		  if (newInterval == null || intervals == null) {
	            return intervals;
	        }
	        ArrayList<Interval> results = new ArrayList<Interval>();
	        int insertPos = 0;
	        for (Interval interval : intervals) {
	            if (interval.end < newInterval.start) {
	                results.add(interval);
	                insertPos++;
	            } else if (interval.start > newInterval.end) {
	                results.add(interval);
	            } else {
	                newInterval.start = Math.min(interval.start, newInterval.start);
	                newInterval.end = Math.max(interval.end, newInterval.end);
	            }
	        }
	        results.add(insertPos, newInterval);
	        return results;
	}

}
