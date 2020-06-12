package org.github.jaraya81;


import org.github.jaraya81.api.response.TaskResultResponse;
import org.json.JSONObject;

public interface IAnticaptchaTaskProtocol {
    JSONObject getPostData();

    TaskResultResponse.SolutionData getTaskSolution();
}
