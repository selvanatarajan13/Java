package Dev.util;

import Dev.Model.CGPStudent;

import java.util.Comparator;

public class StudentCGPAComparator implements Comparator<CGPStudent> {
    @Override
    public int compare(CGPStudent o1, CGPStudent o2) {
        return Double.valueOf(o1.getCgpa()).compareTo(Double.valueOf(o2.getCgpa()));
    }
}
