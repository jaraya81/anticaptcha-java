package org.github.jaraya81.api;


import org.github.jaraya81.AnticaptchaBase;
import org.github.jaraya81.api.response.TaskResultResponse;
import org.github.jaraya81.helper.DebugHelper;
import org.github.jaraya81.IAnticaptchaTaskProtocol;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class GeeTestProxyless extends AnticaptchaBase implements IAnticaptchaTaskProtocol {
    private URL websiteUrl;
    private String websiteKey;
    private String websiteChallenge;
    private String geetestApiServerSubdomain;

    public URL getWebsiteUrl() {
        return websiteUrl;
    }

    public String getWebsiteKey() {
        return websiteKey;
    }

    public String getWebsiteChallenge() {
        return websiteChallenge;
    }

    public String getGeetestApiServerSubdomain() {
        return geetestApiServerSubdomain;
    }

    public void setGeetestApiServerSubdomain(String geetestApiServerSubdomain) {
        this.geetestApiServerSubdomain = geetestApiServerSubdomain;
    }

    public void setWebsiteUrl(URL websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setWebsiteKey(String websiteKey) {
        this.websiteKey = websiteKey;
    }

    public void setWebsiteChallenge(String websiteChallenge) {
        this.websiteChallenge = websiteChallenge;
    }

    @Override
    public JSONObject getPostData() {
        JSONObject postData = new JSONObject();

        try {
            postData.put("type", "GeeTestTaskProxyless");
            postData.put("websiteURL", websiteUrl.toString());
            postData.put("gt", websiteKey);
            postData.put("challenge", websiteChallenge);

            if (geetestApiServerSubdomain != null && geetestApiServerSubdomain.length() > 0) {
                postData.put("geetestApiServerSubdomain", geetestApiServerSubdomain);
            }
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
