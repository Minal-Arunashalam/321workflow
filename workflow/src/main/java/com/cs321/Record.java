package com.cs321;

//Record (WFItem) class
public class Record {

    private int WFID;
    private int FormID;
    private String NextStep;

    public Record(int WFID, int FormID, String NextStep) {
        this.WFID = WFID;
        this.FormID = FormID;
        this.NextStep = NextStep;
    }

    public int getWFID() {
        return this.WFID;
    }

    public int getFormID() {
        return this.FormID;
    }

    public String getNextStep() {
        return this.NextStep;
    }

}
