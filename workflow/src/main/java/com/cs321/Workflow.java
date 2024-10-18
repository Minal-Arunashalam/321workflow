package com.cs321;

import java.util.*;

public class Workflow {
    private LinkedList<Record> queue;

    public Workflow() {
        // the FIFO queue
        queue = new LinkedList<>();
    }

    public int AddWFItem(int FormID, String NextStep) {
        int ReturnCode = 0;
        // Check that NextStep = "Review" or "Approve"
        if (!(NextStep.equals("Review") || NextStep.equals("Approve"))) {
            // If not set ReturnCode = -1
            return -1;
        } else {
            // Else FormID > 0 and not already in queue

            // checking if already in queue
            int exists = 0;
            for (Record record : queue) {
                if (record.getFormID() == FormID) {
                    exists = 1;
                }
            }
            // If pass, add to a FIFO queue with a unique WFID, FormID and NextStep
            if (FormID > 0 && exists == 0) {
                int HighestExistngWFID = queue.peekLast().getWFID();
                Record newRecord = new Record(HighestExistngWFID + 1, FormID, NextStep);
                queue.add(newRecord);
            } else {
                // Else set ReturnCode = -2
                ReturnCode = -2;
            }
        }
        // return the ReturnCode
        return ReturnCode;
    }

    public int GetNextWFItem(String NextStep) {
        int ReturnID = 0;
        // Check that NextStep = "Review" or "Approve"
        // If not set ReturnID = -1
        if (!(NextStep.equals("Review") || NextStep.equals("Approve"))) {
            ReturnID = -1;
        } else {
            // Check for record on queue. If none set ReturnID = -3
            if (queue.size() == 0) {
                ReturnID = -3;
            }
            // Get/pop first record on queue (FIFO)
            // Set ReturnID = record.FormID
            // Delete record from queue
            else {
                Record record = queue.getFirst();
                ReturnID = record.getFormID();
                queue.removeFirst();
            }
        }
        // Return ReturnID
        return ReturnID;
    }
}
