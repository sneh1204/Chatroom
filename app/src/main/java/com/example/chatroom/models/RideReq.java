package com.example.chatroom.models;

import java.io.Serializable;
import java.util.ArrayList;

public class RideReq implements Serializable {

    public ArrayList<Double> pickup_location;
    public ArrayList<Double> drop_location;

    public String id, msg_id;
    public ArrayList<String> requester;
    public ArrayList<String> offer_msgs;

    public RideReq(ArrayList<Double> pickup, ArrayList<Double> drop, ArrayList<String> requester, ArrayList<String> offer_msgs) {
        this.pickup_location = pickup;
        this.drop_location = drop;
        this.requester = requester;
        this.offer_msgs = offer_msgs;
    }

    public RideReq() {
    }

    public ArrayList<String> getRequester() {
        return requester;
    }

    public void setRequester(ArrayList<String> requester) {
        this.requester = requester;
    }

    public String getRequesterId() {
        return requester.get(Utils.ID);
    }

    public String getRequesterRef() {
        return requester.get(Utils.PHOTO_REF);
    }

    public String getRequesterName() {
        return requester.get(Utils.NAME);
    }

    public ArrayList<String> getOffer_msgs() {
        return offer_msgs;
    }

    public void setOffer_msgs(ArrayList<String> offer_msgs) {
        this.offer_msgs = offer_msgs;
    }

    public void addOfferMsg(String uid) {
        this.offer_msgs.add(uid);
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public ArrayList<Double> getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(ArrayList<Double> pickup_location) {
        this.pickup_location = pickup_location;
    }

    public ArrayList<Double> getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(ArrayList<Double> drop_location) {
        this.drop_location = drop_location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
