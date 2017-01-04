package com.tinmegali.mylocation;

import android.location.Location;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by kongbhop.r on 12/21/2016.
 */

public class LogUtil {

    private static final String TAG = LogUtil.class.getSimpleName();

    private File logFile;
    private String fileName;
    private String fileContent;
    int numRow;

    private static LogUtil instance;
    public static LogUtil getInstance() {
        if(instance == null) instance = new LogUtil();
        return instance;
    }

    private LogUtil() {
        fileName = "indoor_answer_chidlom.csv";

        logFile = new File(Environment.getExternalStorageDirectory(), fileName);
        if(!logFile.exists()){
            Log.d(TAG, "log file not exists");
            fileContent = "";
            numRow = 0;
            writeFile();
        }else{
            Log.d(TAG, "log file exists");
            readFile();
        }
    }

    private void writeFile() {
        //TODO: Write new log file.
        try {
            FileOutputStream stream = new FileOutputStream(logFile);
            stream.write(fileContent.getBytes());
            stream.close();
            Log.d(TAG, "Create new log file");
        } catch (IOException e) {
            Log.e(TAG, "IOException: "+e.getMessage());
        }
    }

    private void readFile() {
        try {
            FileInputStream stream = new FileInputStream(logFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                numRow++;
            }
            reader.close();

            fileContent = sb.toString();
            Log.d(TAG, "Read log file: "+fileContent);
        } catch (IOException e) {
            Log.e(TAG, "IOException: "+e.getMessage());
        }
    }

//    public String addLog(String comment, MyLatLng latLng, List<Model> modelList) {
//        numRow++;
//        String newRow = numRow+","+comment+","+latLng.latitude()+","+latLng.longitude();
//        for(Model model: modelList) {
//            newRow += ","+model.deviceID+","+convertMACtoInteger(model.deviceID)+","+model.name+","+model.type+","+model.level;
//        }
//        newRow += "\n";
//
//        fileContent += newRow;
//        writeFile();
//
//        return newRow;
//    }
    public String addLog(String comment, Location currentLoc, String isInside){
        numRow++;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String strDate = sdf.format(c.getTime());

        String newRow = numRow+"," + strDate + ","+comment+","+currentLoc.getLatitude()+","+currentLoc.getLongitude()+","+isInside;
        newRow += "\n";

        fileContent += newRow;
        writeFile();

        return newRow;
    }
    public long convertMACtoInteger(String MAC){
        long sum = 0;
        MAC = MAC.replaceAll(":","").replaceAll("-","");

        for(int i=0;i<MAC.length();i++) {

            char currentChar = MAC.charAt(i);
            switch (currentChar) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    sum = (sum << 4) + (currentChar - '0');
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    sum = (sum << 4) + (currentChar - 'a' + 10);
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    sum = (sum << 4) + (currentChar - 'A' + 10);
                    break;
            }
        }
        Log.e("CONVERT MAC ",""+sum);
        return sum;

    }
}
