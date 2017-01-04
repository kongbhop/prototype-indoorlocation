package com.tinmegali.mylocation;

/**
 * Created by kongbhop.r on 12/20/2016.
 */

public class PolygonTest
{
    public static boolean PointIsInRegion(double x, double y, MyLatLng[] thePath)
    {
        int crossings = 0;

        MyLatLng point = new MyLatLng(x, y);
        int count = thePath.length;
        // for each edge
        for (int i=0; i < count; i++)
        {
            MyLatLng a = thePath[i];
            int j = i + 1;
            if (j >= count)
            {
                j = 0;
            }
            MyLatLng b = thePath[j];
            if (RayCrossesSegment(point, a, b))
            {
                crossings++;
            }
        }
        // odd number of crossings?
        return (crossings % 2 == 1);
    }

    public static boolean RayCrossesSegment(MyLatLng point, MyLatLng a, MyLatLng b)
    {
        double px = point.Longitude;
        double py = point.Latitude;
        double ax = a.Longitude;
        double ay = a.Latitude;
        double bx = b.Longitude;
        double by = b.Latitude;
        if (ay > by)
        {
            ax = b.Longitude;
            ay = b.Latitude;
            bx = a.Longitude;
            by = a.Latitude;
        }
        // alter longitude to cater for 180 degree crossings
        if (px < 0) { px += 360; };
        if (ax < 0) { ax += 360; };
        if (bx < 0) { bx += 360; };

        if (py == ay || py == by) py += 0.00000001;
        if ((py > by || py < ay) || (px > Math.max(ax, bx))) return false;
        if (px < Math.min(ax, bx)) return true;

        double red = (Math.abs(ax - bx) < 0.00000001)?((by - ay) / (bx - ax)) : Double.MAX_VALUE;
        double blue = (ax != px) ? ((py - ay) / (px - ax)) : Double.MAX_VALUE;
        return (blue >= red);
    }
}