package bean;

import net.sf.json.JSONObject;

public class Model {
    private Integer modelId;
    private Integer userId;
    private String modelName;
    private Double A, B;
    private String date;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getA() {
        return A;
    }

    public void setA(Double a) {
        A = a;
    }

    public Double getB() {
        return B;
    }

    public void setB(Double b) {
        B = b;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static Model fromJSON(JSONObject jsonObject) {
        Model model = new Model();
        model.setUserId((Integer) jsonObject.get("uid"));
        model.setModelName((String) jsonObject.get("modelName"));
        model.setDate((String) jsonObject.get("date"));
        model.setA((Double) jsonObject.get("A"));
        model.setB((Double) jsonObject.get("B"));
        System.out.println(jsonObject);
        return model;
    }
}
