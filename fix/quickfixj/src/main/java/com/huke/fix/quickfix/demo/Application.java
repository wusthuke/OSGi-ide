package com.huke.fix.quickfix.demo;

import quickfix.*;
import quickfix.fix44.Message;

/**
 * @Author: huke10591
 * @Create: 2014/11/20
 */
public interface Application {
    void onCreate(SessionID sessionID);

    void onLogon(SessionID sessionID);

    void onLogout(SessionID sessionID);

    void toAdmin(Message message, SessionID sessionId);

    void toApp(Message message, SessionID sessionId) throws DoNotSend;

    void fromAdmin(Message message, SessionID sessionId)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon;

    void fromApp(Message message, SessionID sessionId)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType;

}