package com.firstgroup.interfaces;

import java.security.PublicKey;

public interface HomeworkInterface {
    public boolean UploadHomework(Object obj);
    public boolean ModifyHomework(Object obj);
    public boolean DeleteHomework(Object obj);
    public Object InquireHomework(Object obj);
    public boolean UploadHomeworkAnswer(Object obj);
}
