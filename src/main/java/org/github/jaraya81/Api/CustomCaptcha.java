package org.github.jaraya81.Api;


import org.github.jaraya81.AnticaptchaBase;
import org.github.jaraya81.ApiResponse.TaskResultResponse;
import org.github.jaraya81.Helper.DebugHelper;
import org.github.jaraya81.IAnticaptchaTaskProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomCaptcha extends AnticaptchaBase implements IAnticaptchaTaskProtocol {
    private String imageUrl;
    private String assignment;
    private JSONArray forms;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public void setForms(JSONArray forms) {
        this.forms = forms;
    }

    @Override
    public JSONObject getPostData() {
        JSONObject postData = new JSONObject();

        try {
            postData.put("type", "CustomCaptchaTask");
            postData.put("imageUrl", imageUrl);
            postData.put("assignment", assignment);
            postData.put("forms", forms);
        } catch (JSONException e) {
            DebugHelper.out("JSON compilation error: " + e.getMessage(), DebugHelper.Type.ERROR);

            return null;
        }

        return postData;
    }

    @Override
    public TaskResultResponse.SolutionData getTaskSolution() {
        return taskInfo.getSolution();
    }
}
