package bean;

import net.sf.json.JSONObject;

public class HistoryItem {
    private Integer itemId;
    private Integer userId;
    private String itemName;
    private String result;
    private String date;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public static HistoryItem fromJSON(JSONObject jsonObject){
        HistoryItem historyItem = new HistoryItem();
        historyItem.setUserId((Integer) jsonObject.get("uid"));
        historyItem.setItemName((String) jsonObject.get("itemName"));
        historyItem.setResult((String) jsonObject.get("result"));
        historyItem.setDate((String) jsonObject.get("date"));
        return historyItem;
    }


}
